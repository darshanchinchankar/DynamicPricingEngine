package com.dynamicpricing.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dynamicpricing.dto.request.PricingRuleRequestDTO;
import com.dynamicpricing.dto.response.PricingRuleResponseDTO;
import com.dynamicpricing.exception.ResourceNotFoundException;
import com.dynamicpricing.mapper.PricingRuleMapper;
import com.dynamicpricing.model.PricingRule;
import com.dynamicpricing.repository.PricingRuleRepository;
import com.dynamicpricing.service.interf.PricingRuleService;

@Service
public class PricingRuleServiceImpl implements PricingRuleService {

    private final PricingRuleRepository repository;
    private final PricingRuleMapper mapper;

    public PricingRuleServiceImpl(PricingRuleRepository repository,
                                  PricingRuleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PricingRuleResponseDTO addRule(PricingRuleRequestDTO dto) {

        PricingRule rule = mapper.toEntity(dto);

        return mapper.toDTO(repository.save(rule));
    }

    @Override
    public List<PricingRuleResponseDTO> getAllRules() {

        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PricingRuleResponseDTO getRuleById(Long id) {

        PricingRule rule = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found with id : " + id));

        return mapper.toDTO(rule);
    }

    @Override
    public PricingRuleResponseDTO updateRule(Long id,
                                             PricingRuleRequestDTO dto) {

        PricingRule rule = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found with id : " + id));

        rule.setRuleType(dto.getRuleType());
        rule.setRuleValue(dto.getRuleValue());
        rule.setConditionValue(dto.getConditionValue());
        rule.setActive(dto.getActive());

        return mapper.toDTO(repository.save(rule));
    }

    @Override
    public String deleteRule(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Rule not found with id : " + id);
        }

        repository.deleteById(id);

        return "Pricing Rule deleted successfully";
    }

    @Override
    public List<PricingRuleResponseDTO> getRulesByType(String ruleType) {

        return repository.findByRuleType(ruleType)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PricingRuleResponseDTO> getActiveRules(Boolean active) {

        return repository.findByActive(active)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PricingRuleResponseDTO> getRulesGreaterThan(Double value) {

        return repository.findRulesGreaterThan(value)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}