package com.lyjsh.service;

import com.lyjsh.entity.User;

/**
 * @Author wl
 * @Date 2017/12/19 20:33
 * @Todo 用户操作接口
 */

public interface UserService {

    User getByUserName(String userName);

}
