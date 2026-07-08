package com.dynamicpricing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dynamicpricing.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByStockQuantityLessThan(Integer stock);

    @Query("SELECT p FROM Product p WHERE p.basePrice >= ?1")
    List<Product> findProductsAbovePrice(Double price);

    @Query(value = "SELECT * FROM products WHERE category = ?1", nativeQuery = true)
    List<Product> getProductsByCategory(String category);
}