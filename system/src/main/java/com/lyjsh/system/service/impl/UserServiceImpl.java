package com.lyjsh.system.service.impl;

import com.lyjsh.entity.system.User;
import com.lyjsh.system.dao.UserDao;
import com.lyjsh.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }
}
