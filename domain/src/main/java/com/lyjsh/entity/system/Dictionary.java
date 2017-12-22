package com.lyjsh.entity.system;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "sys_dic")
public class Dictionary {

    public static final String ROOT_NAME = "数据字典";

    public static final int ROOT_ID = 0;

    //数据字典分类
    public static final int TYPE = 1;

    public static final int VALUE = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "名称不能为空")
    @Length(min = 1, max = 10, message = "名称长度必须位于1到10之间")
    private String name;

    private Integer pId;

    private Integer dicStatus;

    //层级
    private Integer dicGrade;

    //排序
    private Integer dicOrder;

}
