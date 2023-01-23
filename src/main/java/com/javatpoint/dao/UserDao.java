package com.javatpoint.dao;

import com.javatpoint.bean.User;
import com.javatpoint.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String USER_INSERT = "insert into USER_KSK (name, password, email, sex, country) values (?,?,?,?,?)";
    private final String USER_UPDATE = "update USER_KSK set name=?, password=?, email=?, sex=?, country=? where id=?";
    private final String USER_DELETE = "delete from USER_KSK where id=?";
    private final String USER_GET = "select * from USER_KSK where id=?";
    private final String USER_LIST = "select * from USER_KSK order by id desc";

    public int save(User u) {
        try {
            con = JDBCUtil.getConnection();
            stmt = con.prepareStatement(USER_INSERT);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getSex());
            stmt.setString(5, u.getCountry());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(User u) {
        try {
            con = JDBCUtil.getConnection();
            stmt = con.prepareStatement(USER_UPDATE);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getSex());
            stmt.setString(5, u.getCountry());
            stmt.setInt(6, u.getId());
            stmt.executeUpdate();
            return 1;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void delete(User u) {
        try {
            con = JDBCUtil.getConnection();
            stmt = con.prepareStatement(USER_DELETE);
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(int id) {
        User one = new User();
        try {
            con = JDBCUtil.getConnection();
            stmt = con.prepareStatement(USER_GET);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one.setName(rs.getString("name"));
                one.setPassword(rs.getString("password"));
                one.setEmail(rs.getString("email"));
                one.setSex(rs.getString("sex"));
                one.setCountry(rs.getString("country"));
            }
            rs.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return one;
    }

    public List<User> getUserList() {
        List<User> list = new ArrayList<>();
        try {
            con = JDBCUtil.getConnection();
            stmt = con.prepareStatement(USER_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                User one = new User();
                one.setId(rs.getInt("id"));
                one.setName(rs.getString("name"));
                one.setPassword(rs.getString("password"));
                one.setEmail(rs.getString("email"));
                one.setSex(rs.getString("sex"));
                one.setCountry(rs.getString("country"));
                list.add(one);
            }
            rs.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}