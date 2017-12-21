package com.lyjsh.enumobj;

public enum DataStatus {

    YES(1,"启用"),NO(0,"禁用");

    private Integer value;

    private String name;

    DataStatus(Integer value,String name) {
        this.value = value;
        this.name = name;
    }
}
