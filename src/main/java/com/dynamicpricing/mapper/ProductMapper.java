package com.dynamicpricing.mapper;

import org.springframework.stereotype.Component;

import com.dynamicpricing.dto.request.ProductRequestDTO;
import com.dynamicpricing.dto.response.ProductResponseDTO;
import com.dynamicpricing.model.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {

        Product product = new Product();

        product.setProductName(dto.getProductName());
        product.setCategory(dto.getCategory());
        product.setBasePrice(dto.getBasePrice());
        product.setStockQuantity(dto.getStockQuantity());

        return product;
    }

    public ProductResponseDTO toDTO(Product product) {

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setCategory(product.getCategory());
        dto.setBasePrice(product.getBasePrice());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setCreatedDate(product.getCreatedDate());
        dto.setModifiedDate(product.getModifiedDate());
        dto.setVersion(product.getVersion());

        return dto;
    }
}