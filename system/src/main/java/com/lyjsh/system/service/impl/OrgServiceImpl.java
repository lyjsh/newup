package com.lyjsh.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyjsh.Exception.BussException;
import com.lyjsh.common.ExecuteResult;
import com.lyjsh.entity.system.Organization;
import com.lyjsh.enumobj.DataStatus;
import com.lyjsh.system.dao.OrganizationDao;
import com.lyjsh.system.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author wl
 * @Date 2017/12/24 17:31
 * @Todo 组织机构service操作类
 */

@Service
public class OrgServiceImpl implements OrgService{

    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public boolean save(Organization organization) throws BussException{
        //判断是否有相同名称的数据
        Organization orgInDb = organizationDao.getByName(organization.getName());
        if (!ObjectUtils.isEmpty(orgInDb)) {
            throw new BussException(ExecuteResult.BUSSINESS_ERROR,"部门名称已存在");
        }
        //设置初始化参数
        organization.setCreateTime(new Timestamp(System.currentTimeMillis()));
        organization.setStatus(DataStatus.YES.value);
        organization.setUserTotal(0);
        return organizationDao.insert(organization)==1?true : false;
    }

    @Override
    public boolean update(Organization organization) throws BussException{
        //判断修改的名称是否有相同的数据
        Organization orgInDb = organizationDao.getByNameIdNot(organization.getName(),organization.getId());
        if (!ObjectUtils.isEmpty(orgInDb)) {
            throw new BussException(ExecuteResult.BUSSINESS_ERROR,"部门名称已存在");
        }
        return organizationDao.updateByPrimaryKeySelective(organization)==1 ? true : false;
    }

    @Override
    public PageInfo<Organization> pageOrg(Page page, Organization organization) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<Organization> organizationList = organizationDao.listAllOrg(organization);
        PageInfo<Organization> pageInfo = new PageInfo(organizationList);
        return pageInfo;
    }

    //查出所有状态为启用的部门
    @Override
    public List<Organization> listAllOrg(Organization organization) {
        return organizationDao.listAllOrg(organization);
    }

    @Override
    public List<Integer> listAllOrgIds(int rootId) {
        return organizationDao.listAllOrgIds(rootId);
    }
}
