package com.gk.login.service.serviceimpl;


import com.gk.login.dao.UserDao;
import com.gk.login.dao.daoimpl.UserDaoImpl;
import com.gk.login.entity.User;
import com.gk.login.service.UserService;

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
