package com.lyjsh.system.dao;

import com.lyjsh.entity.system.Permission;
import com.lyjsh.entity.system.RolePerm;
import com.lyjsh.entity.system.UserPerm;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface PermDao extends BaseMapper<Permission> {

    /**
     * @Author wl
     * @Date 2017/12/25 21:38
     * @Todo 查询某个用户拥有的所有权限
     */
    List<Permission> listByUserId(Integer userId);

    void saveUserPerm(List<UserPerm> userPermList);

    void saveRolePerm(List<RolePerm> rolePermList);

    void deletePermByUserId(Integer userId);

    void deletePermByRoleId(Integer roleId);

}
