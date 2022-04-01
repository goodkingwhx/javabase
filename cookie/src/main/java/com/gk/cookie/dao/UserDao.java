package com.gk.cookie.dao;

import com.gk.cookie.entity.User;


/**
 * @author goodking
 * @data 2022-03-17 15:38
 */
public interface UserDao {

    public User checkUser(User user);
    User getUserById(Integer id);
}
