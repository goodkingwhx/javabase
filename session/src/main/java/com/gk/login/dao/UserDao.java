package com.gk.login.dao;


import com.gk.login.entity.User;

/**
 * @author goodking
 * @data 2022-03-17 15:38
 */
public interface UserDao {

    public User checkUser(User user);
}
