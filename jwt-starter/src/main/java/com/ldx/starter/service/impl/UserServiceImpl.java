package com.ldx.starter.service.impl;/**
 * Created By lindx 创建于2020/11/2
 * Api
 */

import com.ldx.starter.model.User;
import com.ldx.starter.service.IUserService;
import org.springframework.stereotype.Service;

/**
 *@ClassName:UserServiceImpl
 *@Description: TODO
 *@Author: lindaixun
 *@Date: 2020/11/2 10:28
 @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public boolean checkUser(String loginName, String passWord) {
        return true;
    }

    @Override
    public User getUser(String loginName) {
        User user = new User();
        user.setName("李四");
        user.setPassword("123");
        return user;
    }
}