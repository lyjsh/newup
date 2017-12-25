package com.lyjsh.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.Exception.BussException;
import com.lyjsh.entity.system.Organization;

import java.util.List;

public interface OrgService {

    boolean save(Organization organization) throws BussException;

    boolean update(Organization organization) throws BussException;

    /**
     * @Author wl
     * @Date 2017/12/25 21:52
     * @Todo 分页查询部门组织
     */
    PageInfo<Organization> pageOrg(Page page,Organization organization);

    /**
     * @Author wl
     * @Date 2017/12/25 21:52
     * @Todo 查询所有部门
     */
    List<Organization> listAllOrg(Organization organization);

    /**
     * @Author wl
     * @Date 2017/12/25 21:52
     * @Todo 查出根节点下的所有部门id
     */
    List<Integer> listAllOrgIds(int rootId);

}
