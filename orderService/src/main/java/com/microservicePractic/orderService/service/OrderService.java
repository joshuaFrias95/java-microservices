package com.microservicePractic.orderService.service;

import com.microservicePractic.orderService.model.request.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
