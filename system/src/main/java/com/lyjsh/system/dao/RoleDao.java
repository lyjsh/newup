package com.lyjsh.system.dao;

import com.lyjsh.entity.system.Role;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface RoleDao extends BaseMapper<Role> {

    List<Role> listByUserId(Integer userId);

    List<Role> listRole(Role role);

}
