package com.lyjsh.dao;

import com.lyjsh.entity.Role;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface RoleDao extends BaseMapper<Role> {

    List<Role> listByUserId(Integer userId);
}
