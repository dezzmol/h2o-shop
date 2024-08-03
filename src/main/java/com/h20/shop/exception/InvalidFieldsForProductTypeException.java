package com.h20.shop.exception;

public class InvalidFieldsForProductTypeException extends RuntimeException {
    public InvalidFieldsForProductTypeException(String message) {
        super(message);
    }

    public InvalidFieldsForProductTypeException() {
    }
}
