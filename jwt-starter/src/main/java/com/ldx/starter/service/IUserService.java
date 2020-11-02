package com.ldx.starter.service;/**
 * Created By lindx 创建于2020/11/2
 * Api
 */

import com.ldx.starter.model.User;

/**
 *@ClassName:IUserService
 *@Description: TODO
 *@Author: lindaixun
 *@Date: 2020/11/2 10:23
 @Version 1.0
 */
public interface IUserService {

    /**
     * 校验用户信息
     * @param loginName
     * @param passWord
     * @return
     */
    boolean checkUser(String loginName, String passWord);

    /**
     * 查询用户信息
     * @param loginName
     * @return
     */
    User getUser(String loginName);
}
