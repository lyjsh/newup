package com.lyjsh.entity.system;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Organization implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer pId;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Integer createUid;

    private Integer updateUid;

    private Integer status;
}
