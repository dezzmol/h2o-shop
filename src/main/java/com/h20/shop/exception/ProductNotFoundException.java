package com.h20.shop.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String reason) {
        super(reason);
    }

    public ProductNotFoundException(Long id) {
        super("Product with id " + id + " not found");
    }

    public ProductNotFoundException() {
        super("Product not found");
    }
}
