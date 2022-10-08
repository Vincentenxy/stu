package com.wx.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project: stu
 * Date: 2022/10/7 19:53
 * Author: vincentenxy
 * Description: 返回用户名和密码的认证
 *              理论上使用此种方式完成此种方式的用户登陆，通过查询数据库完成用户的用户验证以及权限验证
 */
@Service("userDetailsService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UsersMapper uSerMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 调用usersMapper方法，根据用户名查询数据库
        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.eq("username", username);
        Users user = uSerMapper.selectOne(queryWrapper);

        // 判断
        if(user == null){ // 数据库没有用户名密码，认证失败
            throw new UsernameNotFoundException("用户名不存在");
        }


        // 权限列表的集合，通常使用查询数据库得到
        // 使用role的时候必须要加上前缀ROLE_，会有这个校验
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_sale");

        // 查询数据库得到user对象的用户名和密码，返回认证后的用户
        return new User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), auths);
    }

}
