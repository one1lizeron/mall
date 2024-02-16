package com.one1.mall.server;

import com.one1.mall.dto.CreateOrderRequest;
import com.one1.mall.model.Order;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
