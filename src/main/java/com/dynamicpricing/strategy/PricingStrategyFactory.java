package com.dynamicpricing.strategy;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PricingStrategyFactory {

    private final Map<String, PricingStrategy> strategies;

    public PricingStrategyFactory(Map<String, PricingStrategy> strategies) {

        this.strategies = strategies;

    }

    public PricingStrategy getStrategy(String ruleType) {

        PricingStrategy strategy = strategies.get(ruleType.toUpperCase());

        if(strategy == null) {

            throw new IllegalArgumentException("Invalid Pricing Strategy");

        }

        return strategy;

    }

}