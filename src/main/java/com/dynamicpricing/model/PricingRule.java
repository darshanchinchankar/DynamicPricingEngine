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
@Table(name = "pricing_rules")
@Getter
@Setter
@NoArgsConstructor
public class PricingRule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruleId;

    @NotBlank(message = "Rule type is required")
    private String ruleType;

    @NotNull(message = "Rule value is required")
    @DecimalMin(value = "0.0", inclusive = false)
    private Double ruleValue;

    @NotBlank(message = "Condition is required")
    private String conditionValue;

    @NotNull(message = "Status is required")
    private Boolean active;

    @Version
    private Integer version;
}