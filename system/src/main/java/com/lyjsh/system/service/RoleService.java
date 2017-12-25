package com.lyjsh.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.entity.system.Role;

import java.util.List;

public interface RoleService {

    boolean save(Role role);

    boolean update(Role role);

    PageInfo<Role> pageRole(Page page,Role role);

    List<Role> listRole(Role role);
}
