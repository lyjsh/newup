package com.lyjsh.system.service.impl;

import com.lyjsh.Exception.BussException;
import com.lyjsh.common.ExecuteResult;
import com.lyjsh.entity.system.Organization;
import com.lyjsh.entity.system.User;
import com.lyjsh.enumobj.DataStatus;
import com.lyjsh.system.dao.OrganizationDao;
import com.lyjsh.system.dao.UserDao;
import com.lyjsh.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }

    @Override
    @Transactional
    public boolean save(User user) throws BussException {
        User userInDb = userDao.getByUserName(user.getUserName());
        if (!ObjectUtils.isEmpty(userInDb)) {
            throw new BussException(ExecuteResult.BUSSINESS_ERROR,"用户名已存在");
        }
        user.setStatus(DataStatus.YES.value);
        //同时对应部门的人员总数增加
        int userTotalInDb = organizationDao.getUserTotal(user.getOrgId());
        userTotalInDb = userTotalInDb + 1;
        Organization orgInDb = organizationDao.getById(user.getOrgId());
        orgInDb.setUserTotal(userTotalInDb);
        organizationDao.updateByPrimaryKeySelective(orgInDb);
        return userDao.insert(user)==1 ? true : false;
    }

    @Override
    public boolean update(User user) throws BussException {
        return userDao.updateByPrimaryKeySelective(user)==1 ? true : false;
    }
}
