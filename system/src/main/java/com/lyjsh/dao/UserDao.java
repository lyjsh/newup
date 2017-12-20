package com.lyjsh.dao;

import com.lyjsh.entity.User;
import tk.mybatis.mapper.common.BaseMapper;

public interface UserDao extends BaseMapper<User> {

    User getByUserName(String userName);
}
