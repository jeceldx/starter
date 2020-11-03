package com.ldx.starter.model;/**
 * Created By lindx 创建于2020/11/2
 * Api
 */

import org.springframework.stereotype.Component;

/**
 *@ClassName:BBean
 *@Description: TODO
 *@Author: lindaixun
 *@Date: 2020/11/2 17:03
 @Version 1.0
 */
@Component
public class BBean {
    String name="this is BBean";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
