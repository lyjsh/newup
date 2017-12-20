package com.lyjsh.dao;

import com.lyjsh.entity.Permission;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface PermDao extends BaseMapper<Permission> {

    List<Permission> listByUserId(Integer userId);
}
