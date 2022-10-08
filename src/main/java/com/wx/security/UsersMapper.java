package com.wx.security;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Project: stu
 * Date: 2022/10/7 23:28
 * Author: vincentenxy
 * Description:
 */
@Repository   // 使用这个注解来标注接口进行注入
@TableName("users")
public interface UsersMapper extends BaseMapper<Users> {
}
