package com.microservicePractic.orderService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "orders")
public class OrderEntity {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "order_date")
    private Instant orderDate;

    @Column(name = "status")
    private String status;

    @Column(name = "total_amount")
    private long amount;
}
