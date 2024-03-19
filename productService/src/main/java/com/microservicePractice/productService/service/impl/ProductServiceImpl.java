package com.microservicePractice.productService.service.impl;

import com.microservicePractice.productService.entity.ProductEntity;
import com.microservicePractice.productService.exceptions.ProductServiceExceptionHandler;
import com.microservicePractice.productService.model.request.ProductRequest;
import com.microservicePractice.productService.model.response.ProductResponse;
import com.microservicePractice.productService.repository.ProductRepository;
import com.microservicePractice.productService.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {

        log.info("Adding product...");

        ProductEntity product = ProductEntity.builder()
                .name(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product created!");

        return product.getId();
    }

    @Override
    public ProductResponse getProductById(long id) {

        log.info("Get the product for the id: {}", id);
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new ProductServiceExceptionHandler("Product with given id not found", "PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();

        copyProperties(product, productResponse);

        return productResponse;
    }

}
