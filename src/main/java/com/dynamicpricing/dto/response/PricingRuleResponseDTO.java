package com.dynamicpricing.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricingRuleResponseDTO {

    private Long ruleId;

    private String ruleType;

    private Double ruleValue;

    private String conditionValue;

    private Boolean active;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private Integer version;

}