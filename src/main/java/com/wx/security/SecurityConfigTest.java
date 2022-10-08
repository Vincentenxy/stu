package com.wx.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Project: stu
 * Date: 2022/10/5 03:30
 * Author: vincentenxy
 * Description:
 */
@Configuration
public class SecurityConfigTest extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());

    }

    @Bean
    PasswordEncoder password(){
       return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");


        // 自定义自己便携的登陆页面
        http.formLogin()
                .loginPage("/login.html")   // 登陆页面设置
                .loginProcessingUrl("/user/login")  // 登陆页面访问路径
                .defaultSuccessUrl("/api/index").permitAll()   // 登陆成功之后，跳转路径
                .and().authorizeRequests()
                    .antMatchers("/", "/api/hello", "/user/login").permitAll() // 设置哪些路径可以直接访问，不需要认证
                    .antMatchers("/api/index")
//                        .hasAuthority("admins")   // 当前登陆用户，只有具有admins权限才可以访问这个路径，多个角色用都好分割开，表示与的关系
//                        .hasAnyAuthority("admins,manager") // 多个角色是或的关系
                .hasRole("sale")
                    .anyRequest().authenticated()
                .and().csrf().disable();    // 关闭csrf防护

    }
}
