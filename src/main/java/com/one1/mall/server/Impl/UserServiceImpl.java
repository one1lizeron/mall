package com.one1.mall.server.Impl;

import com.one1.mall.dao.UserDao;
import com.one1.mall.dto.UserLoginRequest;
import com.one1.mall.dto.UserRegisterRequest;
import com.one1.mall.model.User;
import com.one1.mall.server.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

@Component
public class UserServiceImpl implements UserService {

    //private final static Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;


    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest){
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        if (user != null) {
            //log.warning("email has" + userRegisterRequest.getEmail() +"been registered");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassword);
       return  userDao.createUser(userRegisterRequest);
   }

   public User login(UserLoginRequest userLoginRequest){

       User user = userDao.getUserByEmail(userLoginRequest.getEmail());
       //檢查user是否存在
       if (user == null){

           //log.warn("email {} is not register",userLoginRequest.setEmail());
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
       }
       // 使用MD5生成密碼
       String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());
       if (user.getPassword().equals(hashedPassword)){

           return user;
       }
       else {
           //log.warn("password is not valid")
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
       }
   }



}
