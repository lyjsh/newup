package com.lyjsh.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.entity.system.Dictionary;

import java.util.List;

public interface DictionaryService {

    boolean save(Dictionary dictionary) throws Exception;

    boolean update(Dictionary dictionary);

    /**
     * @Author wl
     * @Date 2017/12/25 21:53
     * @Todo 分页查询数据字典的值数据
     */
    PageInfo<Dictionary> pageDictionary(Page page,Dictionary dictionary);

    /**
     * @Author wl
     * @Date 2017/12/25 21:53
     * @Todo 列出字典数据选项
     */
    List<Dictionary> listDictionary(Integer dicId);
}
