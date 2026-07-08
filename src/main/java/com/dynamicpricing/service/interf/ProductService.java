package com.dynamicpricing.service.interf;

import java.util.List;

import com.dynamicpricing.dto.request.ProductRequestDTO;
import com.dynamicpricing.dto.response.ProductResponseDTO;

public interface ProductService {

    ProductResponseDTO addProduct(ProductRequestDTO dto);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto);

    String deleteProduct(Long id);

    List<ProductResponseDTO> getProductsByCategory(String category);

    List<ProductResponseDTO> getProductsAbovePrice(Double price);

    List<ProductResponseDTO> getLowStockProducts(Integer stock);
}