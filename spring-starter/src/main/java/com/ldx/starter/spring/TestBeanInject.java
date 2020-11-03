package com.ldx.starter.spring;/**
 * Created By lindx 创建于2020/11/2
 * Api
 */

import com.ldx.starter.model.ABean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@ClassName:TestBeanInject
 *@Description: TODO
 *@Author: lindaixun
 *@Date: 2020/11/2 16:24
 @Version 1.0
 */
@Configuration
public class TestBeanInject {
    @Bean
    public ABean aBean(){
        return new ABean();
    }

}
