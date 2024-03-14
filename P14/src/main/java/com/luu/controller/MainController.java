package com.luu.controller;

import com.luu.bean.User;
import com.luu.service.UserService;
import com.luu.service.impl.UserServiceImpl;
import com.luu.view.MainView;

public class MainController {

    private final UserService userService = new UserServiceImpl();
    private final MainView view = new MainView();

    public void startApplication() {
        view.showWelcome();
        int choice = view.showMainMenuAndGetChoice();
        switch (choice) {
            case 1: // 登录
                login();
                break;

            case 2: // 注册
                register();
                break;

            case 3: // 删除用户
                deleteUser();
                break;

            default:
                System.out.println("无效选择。");
                startApplication();
                break;
        }
    }

    private void login() {
        User user = view.getLoginDetails();
        String captcha = "1234";
        String inputCaptcha = view.getCaptcha();
        User loggedInUser = userService.login(user.getUsername(), user.getPassword(), captcha, inputCaptcha);
        if (loggedInUser != null) {
            System.out.println("登录成功！");
            System.out.println("欢迎，" + loggedInUser.getNickname() + "！");
        } else {
            System.out.println("登录失败，请重试。");
            startApplication();
        }
    }

    private void register() {
        User user = view.getRegistrationDetails();
        String captcha = "1234";
        String inputCaptcha = view.getCaptcha();
        boolean success = userService.register(user, captcha, inputCaptcha);
        if (success) {
            System.out.println("注册成功！");
            startApplication();
        } else {
            System.out.println("注册失败，请重试。");
            startApplication();
        }
    }
    private void deleteUser() {
        String[] deletionDetails = view.getDeletionDetails();
        String username = deletionDetails[0];
        String password = deletionDetails[1];
        String inputCaptcha = deletionDetails[2];
        String correctCaptcha = "1234";

        // 验证验证码是否正确
        if (!inputCaptcha.equals(correctCaptcha)) {
            System.out.println("验证码错误！");
            return;
        }

        // 验证用户名和密码是否匹配
        if (!userService.validateUser(username, password)) {
            System.out.println("用户名或密码错误！");
            return;
        }

        // 执行伪删除操作
        if (!userService.pseudoDeleteByUsername(username)) {
            System.out.println("用户删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

}
