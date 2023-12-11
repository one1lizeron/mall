package com.one1.mall.dao.Impl;

import com.one1.mall.dao.UserDao;
import com.one1.mall.dto.UserRegisterRequest;
import com.one1.mall.model.User;
import com.one1.mall.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createUser(UserRegisterRequest userRequest){
        String sql = "INSERT INTO user(email,password)" +
                "VALUES (:email, :password)";
        Map<String, Object> map = new HashMap<>();
        map.put("email", userRequest.getEmail());
        map.put("password", userRequest.getPassword());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int userId = keyHolder.getKey().intValue();
        return userId;
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT user_id, email,password from user WHERE email = :email ";
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        List<User> userList = namedParameterJdbcTemplate.query(sql,map,new UserRowMapper());
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getUserById(Integer user_id) {
        String sql = "SELECT user_id, email,password from user WHERE user_id = :user_id ";
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", user_id);
        List<User> userList = namedParameterJdbcTemplate.query(sql,map,new UserRowMapper());
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void updateUser(Integer userId) {

    }
}
