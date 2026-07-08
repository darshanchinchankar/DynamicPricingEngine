package com.dynamicpricing.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private Long productId;

    private String productName;

    private String category;

    private Double basePrice;

    private Integer stockQuantity;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private Integer version;
}