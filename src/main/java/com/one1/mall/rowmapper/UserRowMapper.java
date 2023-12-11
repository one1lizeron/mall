package com.one1.mall.rowmapper;

import com.one1.mall.constant.ProductCategory;
import com.one1.mall.model.Product;
import org.springframework.jdbc.core.RowMapper;
import com.one1.mall.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("user_id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        return user;

    }
}
