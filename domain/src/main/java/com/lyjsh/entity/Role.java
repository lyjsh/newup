package com.lyjsh.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Role {

    private Integer id;

    private String name;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Integer createUid;

    private Integer status;
}
