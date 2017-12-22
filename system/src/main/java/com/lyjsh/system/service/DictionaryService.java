package com.lyjsh.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.entity.system.Dictionary;

import java.util.List;

public interface DictionaryService {

    boolean save(Dictionary dictionary) throws Exception;

    boolean update(Dictionary dictionary);

    PageInfo<Dictionary> pageDictionary(Page page,Dictionary dictionary);

    List<Dictionary> listDictionary(Integer dicId);
}
