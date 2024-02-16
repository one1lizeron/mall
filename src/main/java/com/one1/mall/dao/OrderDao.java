package com.one1.mall.dao;

import com.one1.mall.model.Order;
import com.one1.mall.model.OrderItem;

import java.util.List;

public interface OrderDao {
   Integer createOrder(int userId, int totalAmount);
   void  createOrderItems(Integer orderId, List<OrderItem> orderItemList);


   Order getOrderById(Integer orderId);

   List<OrderItem> getOrderItemsByOrderId(Integer orderId);
}
