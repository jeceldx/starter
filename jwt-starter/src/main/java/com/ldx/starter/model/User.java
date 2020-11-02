package com.ldx.starter.model;/**
 * Created By lindx 创建于2020/11/2
 * Api
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@ClassName:User
 *@Description: TODO
 *@Author: lindaixun
 *@Date: 2020/11/2 10:15
 @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 昵称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
}