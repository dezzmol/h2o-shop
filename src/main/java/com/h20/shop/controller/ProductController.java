package com.h20.shop.controller;

import com.h20.shop.entity.dto.*;
import com.h20.shop.entity.Product;
import com.h20.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(value = "type", required = false) String type) {
        if (type != null) {
            return productService.getProductsByType(type);
        } else {
            return productService.getAllProducts();
        }
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDTO product) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}