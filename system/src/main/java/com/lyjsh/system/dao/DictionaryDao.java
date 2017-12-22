package com.lyjsh.system.dao;

import com.lyjsh.entity.system.Dictionary;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface DictionaryDao extends BaseMapper<Dictionary>{

    List<Dictionary> listDictionary(int id,int status);

    List<Dictionary> listAllByPid(Dictionary dictionary);
}
