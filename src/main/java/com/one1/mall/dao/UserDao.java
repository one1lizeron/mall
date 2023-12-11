package com.one1.mall.dao;

import com.one1.mall.dto.UserRegisterRequest;
import com.one1.mall.model.User;

public interface UserDao {
    public Integer createUser(UserRegisterRequest userRequest);
    public User getUserById(Integer userId) ;
    User getUserByEmail(String email);
    void  updateUser(Integer userId);
}
