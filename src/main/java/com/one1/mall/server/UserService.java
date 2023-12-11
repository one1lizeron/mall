package com.one1.mall.server;

import com.one1.mall.dto.UserRegisterRequest;
import com.one1.mall.model.User;

public interface UserService {

    public User getUserById(Integer userId);


    public Integer register(UserRegisterRequest userRegisterRequest);
}
