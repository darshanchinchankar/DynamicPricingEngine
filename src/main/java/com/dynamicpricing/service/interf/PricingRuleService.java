package com.dynamicpricing.service.interf;

import java.util.List;

import com.dynamicpricing.dto.request.PricingRuleRequestDTO;
import com.dynamicpricing.dto.response.PricingRuleResponseDTO;

public interface PricingRuleService {

    PricingRuleResponseDTO addRule(PricingRuleRequestDTO dto);

    List<PricingRuleResponseDTO> getAllRules();

    PricingRuleResponseDTO getRuleById(Long id);

    PricingRuleResponseDTO updateRule(Long id, PricingRuleRequestDTO dto);

    String deleteRule(Long id);

    List<PricingRuleResponseDTO> getRulesByType(String ruleType);

    List<PricingRuleResponseDTO> getActiveRules(Boolean active);

    List<PricingRuleResponseDTO> getRulesGreaterThan(Double value);

}