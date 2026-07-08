package com.dynamicpricing.strategy;

import org.springframework.stereotype.Component;

import com.dynamicpricing.model.Product;
import com.dynamicpricing.model.PricingRule;

@Component("INVENTORY")
public class InventoryPricingStrategy implements PricingStrategy {

    @Override
    public Double calculatePrice(Product product, PricingRule rule) {

        if(product.getStockQuantity()<10)
            return product.getBasePrice()+rule.getRuleValue();

        return product.getBasePrice();

    }

}