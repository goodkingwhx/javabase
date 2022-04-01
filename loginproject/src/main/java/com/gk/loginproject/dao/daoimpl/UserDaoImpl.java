package com.gk.loginproject.dao.daoimpl;

import com.gk.loginproject.dao.UserDao;
import com.gk.loginproject.entity.User;

import java.sql.*;

/**
 * @author goodking
 * @data 2022-03-17 15:38
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User checkUser(User user) {
        System.out.println("user:"+user);
        //定义连接对象
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User u = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","1234");
            //获取预处理快
            pstm = connection.prepareStatement("select  * from user where username=? and password=?");
            //给？赋值
            pstm.setString(1,user.getUsername());
            pstm.setString(2,user.getPassword());
            //执行语句
            rs = pstm.executeQuery();
            //从resultset中获取结果值
            while (rs.next()) {
                u = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"));
            }
            System.out.println("=============u:"+u);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return u;
    }
}
