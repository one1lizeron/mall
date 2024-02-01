package com.one1.mall.server.Impl;

import com.one1.mall.dao.OrderDao;
import com.one1.mall.dto.BuyItem;
import com.one1.mall.dto.CreateOrderRequest;
import com.one1.mall.model.Product;
import com.one1.mall.server.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        for (BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());
            int amount = buyItem.getQuantity()*product.getPrice();
            totalAmount = totalAmount + amount;
        }
        Integer orderId = orderDao.createOrder(userId,totalAmount);
        orderDao.createOrderItem();
        return orderId;
    }
}
