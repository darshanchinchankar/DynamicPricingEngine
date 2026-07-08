package com.dynamicpricing.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Base price is required")
    @DecimalMin(value = "0.0", inclusive = false)
    private Double basePrice;

    @NotNull(message = "Stock quantity is required")
    private Integer stockQuantity;
}