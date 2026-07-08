package com.dynamicpricing.mapper;

import org.springframework.stereotype.Component;

import com.dynamicpricing.dto.response.DynamicPriceResponseDTO;
import com.dynamicpricing.model.DynamicPrice;

@Component
public class DynamicPriceMapper {

    public DynamicPriceResponseDTO toDTO(DynamicPrice dynamicPrice){

        DynamicPriceResponseDTO dto = new DynamicPriceResponseDTO();

        dto.setDynamicPriceId(dynamicPrice.getDynamicPriceId());

        dto.setProductId(dynamicPrice.getProduct().getProductId());

        dto.setProductName(dynamicPrice.getProduct().getProductName());

        dto.setRuleId(dynamicPrice.getPricingRule().getRuleId());

        dto.setRuleType(dynamicPrice.getPricingRule().getRuleType());

        dto.setOriginalPrice(dynamicPrice.getOriginalPrice());

        dto.setFinalPrice(dynamicPrice.getFinalPrice());

        dto.setCreatedDate(dynamicPrice.getCreatedDate());

        return dto;

    }

}