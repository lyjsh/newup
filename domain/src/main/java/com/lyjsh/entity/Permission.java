package com.lyjsh.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable{

    private Integer id;

    private String name;

    private String url;

    private String permSymbol;

    private Integer type;

    private Integer pId;

    private Integer createUid;

    private Integer updateUid;

    private Integer status;
}
