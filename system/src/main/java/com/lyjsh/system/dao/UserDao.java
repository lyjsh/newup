package com.lyjsh.system.dao;

import com.lyjsh.entity.system.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface UserDao extends BaseMapper<User> {

    User getByUserName(String userName);

    List<User> listUser(@Param("user") User user, @Param("orgIds") List<Integer> orgIds);

}
