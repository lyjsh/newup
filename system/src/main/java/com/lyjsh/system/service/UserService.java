package com.lyjsh.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.Exception.BussException;
import com.lyjsh.entity.system.User;

/**
 * @Author wl
 * @Date 2017/12/19 20:33
 * @Todo 用户操作接口
 */

public interface UserService {

    User getByUserName(String userName);

    boolean save(User user) throws BussException;

    boolean update(User user) throws BussException;

    /**
     * @Author wl
     * @Date 2017/12/25 21:51
     * @Todo 分页查询user
     */
    PageInfo<User> pageUser(Page page,User user);

}
