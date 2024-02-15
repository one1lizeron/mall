package com.one1.mall.rowmapper;

import com.one1.mall.constant.ProductCategory;
import com.one1.mall.model.Order;
import com.one1.mall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setUserId(resultSet.getInt("user_name"));
        order.setTotalAmount(resultSet.getInt("totalAmount"));
        return order;


    }
}
