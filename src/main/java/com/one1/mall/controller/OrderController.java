package com.one1.mall.controller;

import com.one1.mall.dto.CreateOrderRequest;
import com.one1.mall.server.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/user/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid  CreateOrderRequest createOrderRequest){
       Integer orderId = orderService.createOrder(userId,createOrderRequest);
       return  ResponseEntity.status(HttpStatus.CREATED).body(orderId);

    }
}
