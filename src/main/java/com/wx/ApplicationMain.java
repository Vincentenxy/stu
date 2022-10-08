package com.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Project: stu
 * Date: 2022/10/3 01:53
 * Author: vincentenxy
 * Description:
 */
@SpringBootApplication
@MapperScan("com.wx.security")
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
