package com.dynamicpricing.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dynamicpricing.dto.request.DynamicPriceRequestDTO;
import com.dynamicpricing.dto.response.DynamicPriceResponseDTO;
import com.dynamicpricing.exception.ResourceNotFoundException;
import com.dynamicpricing.mapper.DynamicPriceMapper;
import com.dynamicpricing.model.DynamicPrice;
import com.dynamicpricing.model.PricingRule;
import com.dynamicpricing.model.Product;
import com.dynamicpricing.repository.DynamicPriceRepository;
import com.dynamicpricing.repository.PricingRuleRepository;
import com.dynamicpricing.repository.ProductRepository;
import com.dynamicpricing.service.interf.DynamicPriceService;
import com.dynamicpricing.strategy.PricingStrategy;
import com.dynamicpricing.strategy.PricingStrategyFactory;

@Service
public class DynamicPriceServiceImpl implements DynamicPriceService {

    private final ProductRepository productRepository;
    private final PricingRuleRepository ruleRepository;
    private final DynamicPriceRepository dynamicRepository;
    private final DynamicPriceMapper mapper;
    private final PricingStrategyFactory factory;

    public DynamicPriceServiceImpl(ProductRepository productRepository,
                                   PricingRuleRepository ruleRepository,
                                   DynamicPriceRepository dynamicRepository,
                                   DynamicPriceMapper mapper,
                                   PricingStrategyFactory factory) {

        this.productRepository = productRepository;
        this.ruleRepository = ruleRepository;
        this.dynamicRepository = dynamicRepository;
        this.mapper = mapper;
        this.factory = factory;
    }

    @Override
    public DynamicPriceResponseDTO calculatePrice(DynamicPriceRequestDTO dto) {

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        PricingRule rule = ruleRepository.findById(dto.getRuleId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Pricing Rule not found"));

        PricingStrategy strategy = factory.getStrategy(rule.getRuleType());

        Double finalPrice = strategy.calculatePrice(product, rule);

        DynamicPrice dynamicPrice = new DynamicPrice();

        dynamicPrice.setProduct(product);
        dynamicPrice.setPricingRule(rule);
        dynamicPrice.setOriginalPrice(product.getBasePrice());
        dynamicPrice.setFinalPrice(finalPrice);

        return mapper.toDTO(dynamicRepository.save(dynamicPrice));
    }

    @Override
    public List<DynamicPriceResponseDTO> getAllCalculatedPrices() {

        return dynamicRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DynamicPriceResponseDTO> getByProduct(Long productId) {

        return dynamicRepository.findByProductProductId(productId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}