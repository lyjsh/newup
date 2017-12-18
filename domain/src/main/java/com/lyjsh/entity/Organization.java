package com.lyjsh.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Organization implements Serializable{

    private Integer id;

    private String name;

    private Integer pId;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Integer createUid;

    private Integer updateUid;

    private Integer status;
}
