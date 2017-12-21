package com.lyjsh.system.service;

import com.lyjsh.entity.system.User;

/**
 * @Author wl
 * @Date 2017/12/19 20:33
 * @Todo 用户操作接口
 */

public interface UserService {

    User getByUserName(String userName);

}
