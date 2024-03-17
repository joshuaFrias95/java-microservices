package com.microservicePractice.productService.service;

import com.microservicePractice.productService.model.request.ProductRequest;
import com.microservicePractice.productService.model.response.ProductResponse;

public interface ProductService {

    long addProduct(ProductRequest productRequest);


    ProductResponse getProductById(long id);
}
