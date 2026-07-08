package com.dynamicpricing.service.interf;

import java.util.List;

import com.dynamicpricing.dto.request.DynamicPriceRequestDTO;
import com.dynamicpricing.dto.response.DynamicPriceResponseDTO;

public interface DynamicPriceService {

    DynamicPriceResponseDTO calculatePrice(DynamicPriceRequestDTO dto);

    List<DynamicPriceResponseDTO> getAllCalculatedPrices();

    List<DynamicPriceResponseDTO> getByProduct(Long productId);

}