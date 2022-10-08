package com.wx.security;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Project: stu
 * Date: 2022/10/5 09:32
 * Author: vincentenxy
 * Description:
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class LoginController {


    @RequestMapping("/security")
    public JSONObject login(@RequestBody JSONObject reqData){


        JSONObject resp = new JSONObject();
        resp.put("retCode", "111111");
        resp.put("retMsg", "login success");
        return resp;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/index")
    public String helloIndex(){
        return "hello index";
    }


}
