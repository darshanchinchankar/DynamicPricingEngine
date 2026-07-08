package com.dynamicpricing.strategy;

import org.springframework.stereotype.Component;

import com.dynamicpricing.model.PricingRule;
import com.dynamicpricing.model.Product;

@Component("DISCOUNT")
public class DiscountPricingStrategy implements PricingStrategy {

    @Override
    public Double calculatePrice(Product product, PricingRule rule) {

        return product.getBasePrice()
                - (product.getBasePrice() * rule.getRuleValue() / 100);
    }
}