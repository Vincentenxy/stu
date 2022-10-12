package com.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Project: stu
 * Date: 2022/10/3 01:53
 * Author: vincentenxy
 * Description:
 */
@SpringBootApplication
@MapperScan("com.wx.security")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
