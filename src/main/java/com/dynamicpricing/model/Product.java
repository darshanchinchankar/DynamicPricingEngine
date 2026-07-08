package com.dynamicpricing.model;

import com.dynamicpricing.audit.BaseEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message = "Product name is required")
    @Column(nullable = false)
    private String productName;

    
    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Base price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Base price must be greater than zero")
    private Double basePrice;

    @NotNull(message = "Stock quantity is required")
    private Integer stockQuantity;

    @Version
    private Integer version;
}