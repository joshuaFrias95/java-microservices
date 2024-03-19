package com.microservicePractic.orderService.service.impl;

import com.microservicePractic.orderService.entity.OrderEntity;
import com.microservicePractic.orderService.model.request.OrderRequest;
import com.microservicePractic.orderService.repository.OrderRepository;
import com.microservicePractic.orderService.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public long placeOrder(OrderRequest orderRequest) {

        log.info("Placing order request # {}", orderRequest);

        OrderEntity order = OrderEntity.builder()
                .productId(orderRequest.getProductId())
                .amount(orderRequest.getAmount())
                .quantity(orderRequest.getQuantity())
                .orderDate(Instant.now())
                .status("CREATED")
                .build();

        order = orderRepository.save(order);

        log.info("Order placed with id: # {}", order.getId());

        return order.getId();
    }
}
