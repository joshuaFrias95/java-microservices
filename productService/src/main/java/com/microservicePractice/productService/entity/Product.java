package com.microservicePractice.productService.entity;

import jakarta.persistence.*;
import lombok.*;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "products")
public class Product {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long price;
    private long quantity;
}
