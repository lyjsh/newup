package com.lyjsh.service.impl;

import com.lyjsh.dao.UserDao;
import com.lyjsh.entity.User;
import com.lyjsh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }
}
