package com.demo.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC的预编译功能在mysql中，可以看做是没有效果的，
 * 因为mysql对sql语句是进行整句话的编译和缓存，即便是查询条件不同也会进行二次编译和缓存，
 * 不会像Oracle一样可以对不同查询条件的sql语句进行一次编译和缓存。
 * Created by mesen on 2017/3/29.
 */
public class PreparedTest {

    public static void selectTest() {
        String sql = "select * from my_student where id = ?;";
        Connection con = DBConUtil.getConnection();
        try {
            // 预编译
            PreparedStatement ps = con.prepareStatement(sql);
            /**
             * 通过预编译的方式可以防止sql注入
             * 使用预编译后的sql：select * from user_account where 1 = 1 and user_name = 'a' and password = 'or 1 = 1'
             * 未使用预编译的sql：select * from user_account where 1 = 1 and user_name = 'a' and password =   or 1 = 1
             */
            ps.setString(1,"a");
            // 执行
            ResultSet rs = ps.executeQuery();
            // 遍历结果集
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String classId = rs.getString(3);
                String yuWen = rs.getString(4);
                String shuXue = rs.getString(5);
                System.out.println(id + ";"+ name + ";" + classId + ";" + yuWen + ";" + shuXue + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg0){
        PreparedTest.selectTest();

    }
}
