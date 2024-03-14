package com.luu.bean;

public class User {
    private int userId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int membershipDays;
    private boolean isDelete;

    // 默认构造函数
    public User() {
    }

    // 用于登录情况的构造函数
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 用于注册情况的构造函数
    public User(String username, String password, String nickname, String phone, int membershipDays) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.membershipDays = membershipDays;
    }

    // 用于从数据库查询时使用的构造函数
    public User(int userId, String username, String password, String nickname, String phone, int membershipDays) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.membershipDays = membershipDays;
    }

    // Getter 和 Setter 方法
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMembershipDays() {
        return membershipDays;
    }

    public void setMembershipDays(int membershipDays) {
        this.membershipDays = membershipDays;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
