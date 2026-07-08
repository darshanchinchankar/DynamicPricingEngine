package com.dynamicpricing.strategy;

import org.springframework.stereotype.Component;

import com.dynamicpricing.model.Product;
import com.dynamicpricing.model.PricingRule;

@Component("DEMAND")
public class DemandPricingStrategy implements PricingStrategy {

    @Override
    public Double calculatePrice(Product product, PricingRule rule) {

        return product.getBasePrice() + rule.getRuleValue();

    }

}