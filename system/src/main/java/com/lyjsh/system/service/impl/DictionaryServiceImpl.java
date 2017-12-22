package com.lyjsh.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyjsh.Exception.BussException;
import com.lyjsh.common.ExecuteResult;
import com.lyjsh.entity.system.Dictionary;
import com.lyjsh.enumobj.DataStatus;
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
    public boolean save(Dictionary dictionary) throws BussException{
        Integer pid = dictionary.getPId();
        if (null!=pid && Dictionary.VALUE == pid) {
            throw new BussException(ExecuteResult.BUSSINESS_ERROR,"数据字典上级数据必须为字典分类");
        }
        int result = dictionaryDao.insert(dictionary);
        if (1==result) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Dictionary dictionary) {
        int result = dictionaryDao.updateByPrimaryKeySelective(dictionary);
        if (1==result) {
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<Dictionary> pageDictionary(Page page, Dictionary dictionary) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<Dictionary> dictionaryList = dictionaryDao.listAllByPid(dictionary);
        PageInfo<Dictionary> pageInfo = new PageInfo<>(dictionaryList);
        return pageInfo;
    }


    //通过上级id获取启用状态的字典数据
    @Override
    public List<Dictionary> listDictionary(Integer dicId) {
        return dictionaryDao.listDictionary(dicId, DataStatus.YES.value);
    }
}
