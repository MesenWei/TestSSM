package com.demo.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 使用JDBC方式连接数据库
 * Created by mesem on 2017/3/29.
 */
public class DBConUtil {
    // 获取数据库连接
    public static Connection getConnection() {
        Connection con = null;
        //定义连接相关属性
        final String DRIVER = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/wms?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
        final String USER = "root";
        final String PWD = "";

        return getConnection(DRIVER,URL,USER,PWD);
    }

    // 获取数据库连接
    public static Connection getConnection(String driver,String url,String user,String pwd) {
        Connection con = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, user,pwd);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
