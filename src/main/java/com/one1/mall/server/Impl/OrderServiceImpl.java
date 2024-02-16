package com.one1.mall.server.Impl;

import com.one1.mall.dao.OrderDao;
import com.one1.mall.dao.ProductDao;
import com.one1.mall.dto.BuyItem;
import com.one1.mall.dto.CreateOrderRequest;
import com.one1.mall.model.Order;
import com.one1.mall.model.OrderItem;
import com.one1.mall.model.Product;
import com.one1.mall.server.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();
        for (BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());
            int amount = buyItem.getQuantity()*product.getPrice();
            totalAmount = totalAmount + amount;

            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);
            orderItemList.add(orderItem);
        }
        Integer orderId = orderDao.createOrder(userId,totalAmount);
        orderDao.createOrderItems(orderId,orderItemList);
        return orderId;
    }

    @Override
    public Order getOrderById(Integer orderId) {
       Order order = orderDao.getOrderById(orderId);
       List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);
       order.setOrderItemList(orderItemList);
       return order;
    }

}
