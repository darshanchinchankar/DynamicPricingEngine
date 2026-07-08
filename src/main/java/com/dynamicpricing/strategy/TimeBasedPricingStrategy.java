package com.dynamicpricing.strategy;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.dynamicpricing.model.Product;
import com.dynamicpricing.model.PricingRule;

@Component("TIME")
public class TimeBasedPricingStrategy implements PricingStrategy {

    @Override
    public Double calculatePrice(Product product, PricingRule rule) {

        LocalTime now = LocalTime.now();

        if(now.isAfter(LocalTime.of(18,0))) {

            return product.getBasePrice()+rule.getRuleValue();

        }

        return product.getBasePrice();

    }

}