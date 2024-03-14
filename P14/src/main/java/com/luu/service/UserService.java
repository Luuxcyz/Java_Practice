package com.luu.service;

import com.luu.bean.User;

public interface UserService {
    boolean register(User user, String captcha, String inputCaptcha);
    boolean validateUser(String username, String password);
    boolean pseudoDeleteByUsername(String username);

    User login(String username, String password, String captcha, String inputCaptcha);

}
