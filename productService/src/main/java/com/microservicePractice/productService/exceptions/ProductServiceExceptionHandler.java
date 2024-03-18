package com.microservicePractice.productService.exceptions;

import lombok.Data;

@Data
public class ProductServiceExceptionHandler extends RuntimeException{

    private String errorCode;

    public ProductServiceExceptionHandler(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
