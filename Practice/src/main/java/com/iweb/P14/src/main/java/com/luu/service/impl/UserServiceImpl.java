package com.luu.service.impl;

import com.luu.bean.User;
import com.luu.dao.UserDao;
import com.luu.dao.impl.UserDaoImpl;
import com.luu.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override// 注册
    public boolean register(User user, String captcha, String inputCaptcha) {
        if (!captcha.equalsIgnoreCase(inputCaptcha)) {
            System.out.println("验证码错误！");
            return false;
        }
        if (userDao.checkUsernameExists(user.getUsername())) {
            System.out.println("用户名已存在！");
            return false;
        }
        return userDao.register(user);
    }

    @Override// 登录
    public boolean validateUser(String username, String password) {
        User user = userDao.login(username, password);
        return user != null;

    }

    @Override// 伪删除用户
    public boolean pseudoDeleteByUsername(String username) {
        return userDao.pseudoDeleteByUsername(username);

    }

    @Override
    public User login(String username, String password, String captcha, String inputCaptcha) {
        if (!captcha.equalsIgnoreCase(inputCaptcha)) {
            System.out.println("验证码错误！");
            return null;
        }
        return userDao.login(username, password);
    }
}
