package com.lyjsh.enumobj;

public enum DicGrade {

    DIC_TYPE(1,"字典分类"),DIC_VALUE(2,"字典值");

    public int value;

    public String key;

    DicGrade(int value,String key) {
        this.value =value;
        this.key = key;
    }
}
