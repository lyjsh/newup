package com.lyjsh.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.entity.system.Role;

import java.util.List;

public interface RoleService {

    boolean save(Role role);

    boolean update(Role role);

    /**
     * @Author wl
     * @Date 2017/12/25 21:50
     * @Todo 角色分页查询（查询条件包含在role中）
     */
    PageInfo<Role> pageRole(Page page,Role role);

    /**
     * @Author wl
     * @Date 2017/12/25 21:51
     * @Todo 列出角色（条件包含在role参数中）
     */
    List<Role> listRole(Role role);
}
