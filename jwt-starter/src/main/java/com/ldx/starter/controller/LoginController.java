package com.ldx.starter.controller;/**
 * Created By lindx 创建于2020/11/2
 * Api
 */

import com.alibaba.fastjson.JSONObject;
import com.ldx.starter.model.User;
import com.ldx.starter.service.IUserService;
import com.ldx.starter.util.AjaxResult;
import com.ldx.starter.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName:LoginController
 *@Description: TODO
 *@Author: lindaixun
 *@Date: 2020/11/2 10:18
 @Version 1.0
 */
@Controller
@RequestMapping
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;


    @PostMapping("login")
    @ResponseBody
    public AjaxResult login (@RequestBody Map<String,String> map){
        String loginName = map.get("loginName");
        String passWord = map.get("passWord");
        //身份验证
        boolean isSuccess =  userService.checkUser(loginName,passWord);
        if (isSuccess) {
            //模拟数据库查询
            User user = userService.getUser(loginName);
            if (user != null) {
                //返回token
                String token = JwtUtil.sign(loginName, passWord);
                if (token != null) {
                    return AjaxResult.success("成功",token);
                }
            }
        }
        return AjaxResult.fail();
    }

    @PostMapping("getUser")
    @ResponseBody
    public AjaxResult getUserInfo(HttpServletRequest request){
        String token = request.getHeader("token");
        Map<String,Object> result=JwtUtil.verity(token);
        boolean verity = (boolean) result.get("verify");
        if (verity) {
            User user = new User();
            user.setName(result.get("loginName").toString());
            user.setPassword(result.get("passWord").toString());
            if (user != null) {
                return AjaxResult.success("成功", JSONObject.toJSONString(user));
            }
        }
        return AjaxResult.fail();
    }
}
