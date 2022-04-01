package com.gk.cookie.service;

import com.gk.cookie.entity.User;


/**
 * @author goodking
 * @data 2022-03-17 15:37
 */
public interface UserService {

    User checkUser(User user);
    User getUserById(Integer id);
}
