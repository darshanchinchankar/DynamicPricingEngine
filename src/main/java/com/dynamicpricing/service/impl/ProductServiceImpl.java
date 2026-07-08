package com.dynamicpricing.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dynamicpricing.dto.request.ProductRequestDTO;
import com.dynamicpricing.dto.response.ProductResponseDTO;
import com.dynamicpricing.exception.ResourceNotFoundException;
import com.dynamicpricing.mapper.ProductMapper;
import com.dynamicpricing.model.Product;
import com.dynamicpricing.repository.DynamicPriceRepository;
import com.dynamicpricing.repository.ProductRepository;
import com.dynamicpricing.service.interf.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final DynamicPriceRepository dynamicPriceRepository;

    public ProductServiceImpl(ProductRepository repository,
                              ProductMapper mapper,
                              DynamicPriceRepository dynamicPriceRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.dynamicPriceRepository = dynamicPriceRepository;
    }

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO dto) {

        Product product = mapper.toEntity(dto);

        return mapper.toDTO(repository.save(product));
    }
    @Override
    public List<ProductResponseDTO> getAllProducts() {

        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id : " + id));

        return mapper.toDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id,
                                            ProductRequestDTO dto) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id : " + id));

        product.setProductName(dto.getProductName());
        product.setCategory(dto.getCategory());
        product.setBasePrice(dto.getBasePrice());
        product.setStockQuantity(dto.getStockQuantity());

        return mapper.toDTO(repository.save(product));
    }

    @Override
    public String deleteProduct(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id : " + id));

        // Delete all calculated prices for this product first
        dynamicPriceRepository.deleteAll(
                dynamicPriceRepository.findByProductProductId(id)
        );

        // Now delete the product
        repository.delete(product);

        return "Product deleted successfully";
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategory(String category) {

        return repository.findByCategory(category)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> getProductsAbovePrice(Double price) {

        return repository.findProductsAbovePrice(price)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> getLowStockProducts(Integer stock) {

        return repository.findByStockQuantityLessThan(stock)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}