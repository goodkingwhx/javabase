package com.gk.loginproject.service.serviceimpl;

import com.gk.loginproject.dao.UserDao;
import com.gk.loginproject.dao.daoimpl.UserDaoImpl;
import com.gk.loginproject.entity.User;
import com.gk.loginproject.service.UserService;

/**
 * @author goodking
 * @data 2022-03-17 15:38
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUser(User user) {
        User user1 = userDao.checkUser(user);
        return user1;
    }
}
