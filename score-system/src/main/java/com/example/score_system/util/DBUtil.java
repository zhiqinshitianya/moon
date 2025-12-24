package com.example.score_system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 数据库连接工具类（封装连接逻辑）
public class DBUtil {
    // 替换成你的MySQL账号密码
    private static final String URL = "jdbc:mysql://localhost:3306/score_db?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // 获取数据库连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 加载MySQL驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败：" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("数据库连接失败：" + e.getMessage());
        }
        return conn;
    }

    // 关闭连接
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭连接失败：" + e.getMessage());
            }
        }
    }
}