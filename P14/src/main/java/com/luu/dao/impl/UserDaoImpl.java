package com.luu.dao.impl;

import com.luu.bean.User;
import com.luu.dao.UserDao;
import com.luu.util.DBUtil;
import com.luu.util.MD5Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean register(User user) {// 注册
        String sql = "INSERT INTO User (username, password, nickname, phone, membership_days, isDelete) VALUES (?, ?, ?, ?, ?, 0)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, MD5Util.encrypt(user.getPassword()));// 加密密码
            ps.setString(3, user.getNickname());
            ps.setString(4, user.getPhone());
            ps.setInt(5, user.getMembershipDays());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkUsernameExists(String username) {// 检查用户名是否存在
        String sql = "SELECT user_id FROM User WHERE username = ? AND isDelete = 0";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User login(String username, String password) {// 登录
        String sql = "SELECT * FROM User WHERE username = ? AND password = ? AND isDelete = 0";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, MD5Util.encrypt(password));// 加密密码
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("user_id"), rs.getString("username"), null, rs.getString("nickname"), rs.getString("phone"), rs.getInt("membership_days"));
                }
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean pseudoDeleteByUsername(String username) {// 伪删除用户
        String sql = "UPDATE User SET isDelete = 1 WHERE username = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
