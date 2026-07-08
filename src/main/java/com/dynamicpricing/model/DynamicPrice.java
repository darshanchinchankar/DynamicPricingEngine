package com.dynamicpricing.model;

import com.dynamicpricing.audit.BaseEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "dynamic_prices")
public class DynamicPrice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dynamicPriceId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private PricingRule pricingRule;

    private Double originalPrice;

    private Double finalPrice;

    @Version
    private Integer version;

    public DynamicPrice() {
    }

    public Long getDynamicPriceId() {
        return dynamicPriceId;
    }

    public void setDynamicPriceId(Long dynamicPriceId) {
        this.dynamicPriceId = dynamicPriceId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PricingRule getPricingRule() {
        return pricingRule;
    }

    public void setPricingRule(PricingRule pricingRule) {
        this.pricingRule = pricingRule;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}