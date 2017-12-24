package com.lyjsh.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyjsh.Exception.BussException;
import com.lyjsh.common.ExecuteResult;
import com.lyjsh.entity.system.Dictionary;
import com.lyjsh.enumobj.DataStatus;
import com.lyjsh.enumobj.DicGrade;
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
        Integer pid = dictionary.getPId() == null ? Dictionary.ROOT_ID : dictionary.getPId();
        if (null!=pid && Dictionary.VALUE == pid) {
            throw new BussException(ExecuteResult.BUSSINESS_ERROR,"数据字典上级数据必须为字典分类");
        }
        //获取当前pid下的所有数据，取得顺序order序号
        List<Dictionary> dictionaryListInDb = dictionaryDao.listByPid(pid);
        int dicOrder = 1;
        if (null!=dictionaryListInDb && dictionaryListInDb.size()>0) {
            dicOrder = dictionaryListInDb.get(dictionaryListInDb.size()).getDicOrder();
        }
        if (0==pid) {
            dictionary.setDicGrade(DicGrade.DIC_TYPE.value);
        }else {
            dictionary.setDicGrade(DicGrade.DIC_VALUE.value);
        }
        dictionary.setPId(pid);
        dictionary.setDicStatus(DataStatus.YES.value);
        dictionary.setDicOrder(dicOrder);
        return dictionaryDao.insert(dictionary) == 1;
    }

    @Override
    public boolean update(Dictionary dictionary) {
        return dictionaryDao.updateByPrimaryKeySelective(dictionary) == 1;
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
