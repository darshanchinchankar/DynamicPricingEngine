package com.dynamicpricing.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dynamicpricing.dto.request.ProductRequestDTO;
import com.dynamicpricing.dto.response.ProductResponseDTO;
import com.dynamicpricing.service.interf.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public ResponseEntity<ProductResponseDTO> addProduct(
            @Valid @RequestBody ProductRequestDTO dto){

        return ResponseEntity.ok(service.addProduct(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
    	return ResponseEntity.ok(service.getProductById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody ProductRequestDTO dto){

        return ResponseEntity.ok(service.updateProduct(id,dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.deleteProduct(id);
        return ResponseEntity.ok("Product Deleted");
    }
}