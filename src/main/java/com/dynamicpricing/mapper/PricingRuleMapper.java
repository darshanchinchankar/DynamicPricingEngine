package com.dynamicpricing.mapper;

import org.springframework.stereotype.Component;

import com.dynamicpricing.dto.request.PricingRuleRequestDTO;
import com.dynamicpricing.dto.response.PricingRuleResponseDTO;
import com.dynamicpricing.model.PricingRule;

@Component
public class PricingRuleMapper {

    public PricingRule toEntity(PricingRuleRequestDTO dto){

        PricingRule rule = new PricingRule();

        rule.setRuleType(dto.getRuleType());
        rule.setRuleValue(dto.getRuleValue());
        rule.setConditionValue(dto.getConditionValue());
        rule.setActive(dto.getActive());

        return rule;
    }

    public PricingRuleResponseDTO toDTO(PricingRule rule){

        PricingRuleResponseDTO dto = new PricingRuleResponseDTO();

        dto.setRuleId(rule.getRuleId());
        dto.setRuleType(rule.getRuleType());
        dto.setRuleValue(rule.getRuleValue());
        dto.setConditionValue(rule.getConditionValue());
        dto.setActive(rule.getActive());
        dto.setCreatedDate(rule.getCreatedDate());
        dto.setModifiedDate(rule.getModifiedDate());
        dto.setVersion(rule.getVersion());

        return dto;
    }

}