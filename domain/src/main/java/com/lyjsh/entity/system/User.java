package com.lyjsh.entity.system;

import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class User implements Serializable{

    private Integer id;

    private String name;

    private String userName;

    private String pwd;

    private Integer age;

    private Integer gender;

    private Integer orgId;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Integer createUid;

    private Integer status;

    @Transient
    private List<String> roleStrlist;

    @Transient
    private List<String> perminsStrlist;
}
