package com.microservicePractic.orderService.model.request;

import com.microservicePractic.orderService.model.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private long productId;
    private long quantity;
    private Instant orderDate;
    private String status;
    private long amount;
    private PaymentMode paymentMode;
}
