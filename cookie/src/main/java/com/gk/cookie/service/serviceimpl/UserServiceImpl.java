package com.gk.cookie.service.serviceimpl;


import com.gk.cookie.dao.UserDao;
import com.gk.cookie.dao.daoimpl.UserDaoImpl;
import com.gk.cookie.entity.User;
import com.gk.cookie.service.UserService;

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

    @Override
    public User getUserById(Integer id) {

        return userDao.getUserById(id);
    }
}
