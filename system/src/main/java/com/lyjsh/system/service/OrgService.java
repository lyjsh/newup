package com.lyjsh.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.Exception.BussException;
import com.lyjsh.entity.system.Organization;

import java.util.List;

public interface OrgService {

    boolean save(Organization organization) throws BussException;

    boolean update(Organization organization) throws BussException;

    PageInfo<Organization> pageOrg(Page page,Organization organization);

    List<Organization> listAllOrg(Organization organization);

}
