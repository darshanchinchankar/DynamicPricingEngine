package com.dynamicpricing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dynamicpricing.model.DynamicPrice;

public interface DynamicPriceRepository extends JpaRepository<DynamicPrice, Long> {

    List<DynamicPrice> findByProductProductId(Long productId);

}