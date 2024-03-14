package com.luu.dao;

import com.luu.bean.User;

public interface UserDao {
    boolean register(User user);// 注册
    boolean checkUsernameExists(String username);// 检查用户名是否存在
    User login(String username, String password);// 登录
    boolean pseudoDeleteByUsername(String username);// 伪删除用户
}
