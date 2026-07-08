package com.dynamicpricing.strategy;

import com.dynamicpricing.model.Product;
import com.dynamicpricing.model.PricingRule;

public interface PricingStrategy {

    Double calculatePrice(Product product, PricingRule rule);

}