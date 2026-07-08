package com.dynamicpricing.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dynamicpricing.dto.request.DynamicPriceRequestDTO;
import com.dynamicpricing.service.interf.DynamicPriceService;

@RestController
@RequestMapping("/dynamicprice")
public class DynamicPriceController {

    @Autowired
    private DynamicPriceService service;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestBody DynamicPriceRequestDTO dto) {
        return ResponseEntity.ok(service.calculatePrice(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAllCalculatedPrices());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(service.getByProduct(productId));
    }
    
}
