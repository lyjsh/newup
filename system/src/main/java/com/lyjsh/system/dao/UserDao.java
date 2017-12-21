package com.lyjsh.system.dao;

import com.lyjsh.entity.system.User;
import tk.mybatis.mapper.common.BaseMapper;

public interface UserDao extends BaseMapper<User> {

    User getByUserName(String userName);
}
