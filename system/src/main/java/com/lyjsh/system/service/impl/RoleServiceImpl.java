package com.lyjsh.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyjsh.entity.system.Role;
import com.lyjsh.system.dao.RoleDao;
import com.lyjsh.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public boolean save(Role role) {
        return roleDao.insert(role)==1? true : false;
    }

    @Override
    public boolean update(Role role) {
        return roleDao.updateByPrimaryKeySelective(role)==1 ? true:false;
    }

    @Override
    public PageInfo<Role> pageRole(Page page, Role role) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<Role> roleList = roleDao.listRole(role);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Role> listRole(Role role) {
        return roleDao.listRole(role);
    }
}
