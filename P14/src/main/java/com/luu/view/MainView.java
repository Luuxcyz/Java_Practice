package com.luu.view;

import com.luu.bean.User;

import java.util.Scanner;

public class MainView {

    private final Scanner scanner = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("欢迎使用系统！");
    }

    public int showMainMenuAndGetChoice() {
        System.out.println("1. 登录");
        System.out.println("2. 注册");
        System.out.println("3. 删除用户");
        System.out.println("请选择操作：");
        return scanner.nextInt();
    }

    public User getLoginDetails() {
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        return new User(username, password);
    }

    public User getRegistrationDetails() {
        System.out.println("注册新用户");
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        System.out.println("请输入昵称：");
        String nickname = scanner.next();
        System.out.println("请输入电话号码：");
        String phone = scanner.next();
        return new User(username, password, nickname, phone, 0);
    }


    public String getCaptcha() {
        System.out.println("请输入验证码（1234）：");
        return scanner.next();
    }
    public String[] getDeletionDetails() {
        System.out.println("请输入要删除的用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        System.out.println("请输入验证码（1234）：");
        String captcha = scanner.next();
        return new String[]{username, password, captcha};
    }

}
