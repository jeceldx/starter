package com.ldx.starter.controller;/**
 * Created By lindx 创建于2020/11/2
 * Api
 */

import com.ldx.starter.model.ABean;
import com.ldx.starter.model.BBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName:TestController
 *@Description: TODO
 *@Author: lindaixun
 *@Date: 2020/11/2 16:29
 @Version 1.0
 */
@RestController
@RequestMapping("/spring")
public class TestController {
    @Autowired
    ABean aBean;
    @Autowired
    BBean bBean;

    @PostMapping("testGetABeanByBeanInject")
    private String getABeanByBeanInject(){
        return aBean.getName();
    }
    @PostMapping("testGetBBeanByBeanInject")
    private String getBBeanByBeanInject(){
        return bBean.getName();
    }
    @PostMapping("test")
    private String test(){
        return "test";
    }
}
