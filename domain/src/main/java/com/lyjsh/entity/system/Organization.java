package com.lyjsh.entity.system;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Organization implements Serializable{

    public static final String ROOT_ORG_NAME = "流水团公司";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "部门名称不能为空")
    private String name;

    private Integer pId;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Integer createUid;

    private Integer updateUid;

    //数据状态（启用、禁用）
    private Integer status;

    //部门总人数
    private Integer userTotal;
}
