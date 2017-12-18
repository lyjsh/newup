package com.lyjsh.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class User implements Serializable{

    private Integer id;

    private String name;

    private String pwd;

    private Integer age;

    private Integer gender;

    private Integer orgId;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Integer createUid;

    private Integer status;
}
