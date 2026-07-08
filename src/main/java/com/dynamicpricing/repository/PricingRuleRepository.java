package com.dynamicpricing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dynamicpricing.model.PricingRule;

public interface PricingRuleRepository extends JpaRepository<PricingRule, Long> {

    List<PricingRule> findByRuleType(String ruleType);

    List<PricingRule> findByActive(Boolean active);

    @Query("SELECT p FROM PricingRule p WHERE p.ruleValue >= ?1")
    List<PricingRule> findRulesGreaterThan(Double value);

    @Query(value = "SELECT * FROM pricing_rules WHERE active = ?1", nativeQuery = true)
    List<PricingRule> getActiveRules(Boolean active);

}