package com.luu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // 数据库驱动类名
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // 数据库连接URL
    private static final String URL = "jdbc:mysql://localhost:3306/project1?characterEncoding=utf8";
    // 数据库用户
    private static final String USERNAME = "root";
    // 数据库密码
    private static final String PASSWORD = "33251144";

    static {
        try {
            // 加载数据库驱动
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return 数据库连接对象
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {

            throw new RuntimeException("数据库连接失败", e);
        }
    }

    /**
     * 关闭数据库连接
     *
     * @param conn 数据库连接对象
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
