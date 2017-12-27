package com.lyjsh.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

import java.util.ArrayList;
import java.util.List;

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
        //最上级部门人员总数也增加
        int userRootTotal = organizationDao.getUserTotal(Organization.ROOT_ORG_ID);
        userRootTotal = userRootTotal + 1;
        Organization orgInDb = organizationDao.getById(user.getOrgId());
        Organization orgRootInDb = organizationDao.getById(Organization.ROOT_ORG_ID);
        orgRootInDb.setUserTotal(userRootTotal);
        orgInDb.setUserTotal(userTotalInDb);
        organizationDao.updateByPrimaryKeySelective(orgRootInDb);
        organizationDao.updateByPrimaryKeySelective(orgInDb);
        return userDao.insert(user)==1 ? true : false;
    }

    @Override
    public boolean update(User user) throws BussException {
        return userDao.updateByPrimaryKeySelective(user)==1 ? true : false;
    }

    @Override
    public PageInfo<User> pageUser(Page page, User user) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<Integer> orgIds = null;
        if (null==user.getOrgId() || Organization.ROOT_ORG_ID==user.getOrgId()) {
            orgIds = organizationDao.listAllOrgIds(Organization.ROOT_ORG_ID);
        }else {
            orgIds = new ArrayList<>(new Integer(user.getOrgId()));
        }
        List<User> userList = userDao.listUser(user,orgIds);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
}
