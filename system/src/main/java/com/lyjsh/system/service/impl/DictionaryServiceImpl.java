package com.lyjsh.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.entity.system.Dictionary;
import com.lyjsh.system.dao.DictionaryDao;
import com.lyjsh.system.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    private DictionaryDao dictionaryDao;

    @Override
    public void save(Dictionary dictionary) {
        dictionaryDao.insert(dictionary);
    }

    @Override
    public void update(Dictionary dictionary) {

    }

    @Override
    public PageInfo<Dictionary> pageDictionary(Page page, Integer dicId) {
        return null;
    }

    @Override
    public List<Dictionary> listDictionary(Integer dicId) {
        return null;
    }
}
