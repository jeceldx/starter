package com.ldx.starter.model;/**
 * Created By lindx 创建于2020/11/2
 * Api
 */

import org.springframework.context.annotation.Configuration;

/**
 *@ClassName:BeanInject
 *@Description: TODO
 *@Author: lindaixun
 *@Date: 2020/11/2 16:26
 @Version 1.0
 */

public class ABean {
    String name="this is ABean";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
