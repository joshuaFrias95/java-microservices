package com.microservicePractice.productService.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private long price;
    private long quantity;
}
