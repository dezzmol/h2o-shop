package com.h20.shop.service;

import com.h20.shop.entity.dto.ProductDTO;
import com.h20.shop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    List<Product> getProductsByType(String type);

    Product getProduct(Long id);

    Product addProduct(ProductDTO product);

    Product updateProduct(ProductDTO product, Long id);

    void deleteProduct(Long id);
}
