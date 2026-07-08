package com.dynamicpricing.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricingRuleRequestDTO {

    @NotBlank(message = "Rule type is required")
    private String ruleType;

    @NotNull(message = "Rule value is required")
    @DecimalMin(value = "0.0", inclusive = false)
    private Double ruleValue;

    @NotBlank(message = "Condition is required")
    private String conditionValue;

    @NotNull(message = "Status is required")
    private Boolean active;

}