package com.dynamicpricing.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dynamicpricing.dto.request.PricingRuleRequestDTO;
import com.dynamicpricing.service.interf.PricingRuleService;

@RestController
@RequestMapping("/pricingrule")
public class PricingRuleController {

    @Autowired
    private PricingRuleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PricingRuleRequestDTO dto){
        return ResponseEntity.ok(service.addRule(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAllRules());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRule(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRuleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteRule(id);
        return ResponseEntity.ok("Rule Deleted");
    }
}