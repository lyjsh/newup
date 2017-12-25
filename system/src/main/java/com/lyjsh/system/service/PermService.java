package com.lyjsh.system.service;

public interface PermService {

    /**
     * @Author wl
     * @Date 2017/12/25 21:32
     * @Todo 给用户分配权限
     */
    void dispachPermForUser(Integer userId, int[] permIds);

    /**
     * @Author wl
     * @Date 2017/12/25 21:36
     * @Todo 修改用户权限
     */
    void updatePermForUser(Integer userId,int[] permIds);

    /**
     * @Author wl
     * @Date 2017/12/25 21:36
     * @Todo 分配角色权限
     */

    void dispatchPermForRole(Integer roleId,int[] permIds);

    /**
     * @Author wl
     * @Date 2017/12/25 21:37
     * @Todo 修改角色权限
     */

    void updatePermForRole(Integer roleId,int[] permIds);
}
