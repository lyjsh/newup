package com.lyjsh.system.service.impl;

import com.lyjsh.entity.system.RolePerm;
import com.lyjsh.entity.system.UserPerm;
import com.lyjsh.system.dao.PermDao;
import com.lyjsh.system.service.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermServiceImpl implements PermService{

    @Autowired
    private PermDao permDao;

    @Override
    public void dispachPermForUser(Integer userId, int[] permIds) {
        List<UserPerm> userPermList = creUserPerms(userId,permIds);
        permDao.saveUserPerm(userPermList);
    }

    @Override
    @Transactional
    public void updatePermForUser(Integer userId, int[] permIds) {
        List<UserPerm> userPermList = creUserPerms(userId,permIds);
        //先清除原有用户权限再插入
        permDao.deletePermByUserId(userId);
        permDao.saveUserPerm(userPermList);
    }

    @Override
    public void dispatchPermForRole(Integer roleId, int[] permIds) {
        List<RolePerm> rolePermList = creRolePerms(roleId,permIds);
        permDao.saveRolePerm(rolePermList);
    }

    @Override
    @Transactional
    public void updatePermForRole(Integer roleId, int[] permIds) {
        List<RolePerm> rolePermList = creRolePerms(roleId,permIds);
        //先清除角色所有权限再插入
        permDao.deletePermByRoleId(roleId);
        permDao.saveRolePerm(rolePermList);
    }

    /**
     * @Author wl
     * @Date 2017/12/25 21:55
     * @Todo 通过用户id与权限集合生成userPerm集合对象，便于dao层操作
     */
    private List<UserPerm> creUserPerms(Integer userId,int[] permIds) {
        List<UserPerm> userPermList = new ArrayList<>(permIds.length);
        for (int i = 0; i<userPermList.size();i++) {
            UserPerm userPerm = new UserPerm();
            userPerm.setUserId(userId);
            userPerm.setPermId(permIds[i]);
            userPermList.add(userPerm);
        }
        return userPermList;
    }

    /**
     * @Author wl
     * @Date 2017/12/25 22:11
     * @Todo 通过角色id与权限集合生成rolePerm集合对象，便于dao层操作
     */
    private List<RolePerm> creRolePerms(Integer roleId,int[] permIds) {
        List<RolePerm> rolePermList = new ArrayList<>(permIds.length);
        for (int i=0;i<rolePermList.size();i++) {
            RolePerm rolePerm = new RolePerm();
            rolePerm.setRoleId(roleId);
            rolePerm.setPermId(permIds[i]);
            rolePermList.add(rolePerm);
        }
        return rolePermList;
    }
}
