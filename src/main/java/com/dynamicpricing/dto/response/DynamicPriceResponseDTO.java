package com.dynamicpricing.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DynamicPriceResponseDTO {

    private Long dynamicPriceId;

    private Long productId;

    private String productName;

    private Long ruleId;

    private String ruleType;

    private Double originalPrice;

    private Double finalPrice;

    private LocalDateTime createdDate;

}