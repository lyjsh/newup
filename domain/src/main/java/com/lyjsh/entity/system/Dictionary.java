package com.lyjsh.entity.system;

import lombok.Data;

@Data
public class Dictionary {

    public static String ROOT_NAME = "数据字典";

    private Integer id;

    private String name;

    private Integer pId;

    private Integer dicStatus;

    //层级
    private Integer dicGrade;

    //排序
    private Integer dicOrder;

}
