package com.javatpoint.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://walab.handong.edu:3306/23_Camp5","23_Camp5","CIkTVPOVMrQwhxr8");
        } catch(Exception e) {
            System.out.println(e);
        }
        return con;
    }
}

//
//        host: walab.handong.edu
//        user: 23_Camp5
//        pwd: CIkTVPOVMrQwhxr8