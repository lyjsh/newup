package com.lyjsh.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.entity.system.Dictionary;

import java.util.List;

public interface DictionaryService {

    void save(Dictionary dictionary);

    void update(Dictionary dictionary);

    PageInfo<Dictionary> pageDictionary(Page page,Integer dicId);

    List<Dictionary> listDictionary(Integer dicId);
}
