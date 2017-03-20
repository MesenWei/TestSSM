package com.demo.java.mysql;

import java.sql.*;

/**
 * Created by user on 2017/3/2.
 */
public class JDBC1 {
    private String mysqlUrl = "jdbc:mysql://localhost:3306/wms";
    private String userName = "root";
    private String passWord = "";

    private Connection con;

    public JDBC1(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(mysqlUrl,userName,passWord);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon(){
        return this.con;
    }

    public void a() throws SQLException {
        String sqlPrefix = "insert into test_big_data (name, age, mobile_phone,address_self, native_place, company_address,email, phone, fax,birthday, postcode, order,sex, create_date_time, update_date_time,aaaaaa, bbbbbb, cccccc,textarea)";
        String sqlSuffix = "";

        JDBC1 jdbc1 = new JDBC1();
        Connection connection = jdbc1.getCon();
        for(int i=0,l=1;i<l;i++){
            sqlSuffix = "values('','','','','','','','','','','','','','','','','','','','','','','')";
        }
        String sql = sqlPrefix + sqlSuffix;
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();


    }
}
