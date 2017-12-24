package com.lyjsh.entity.system;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    //密码
    @NotNull(message = "用户密码不能为空")
    private String pwd;

    //年龄
    private Integer age;

    //性别
    @NotNull(message = "性别不能为空")
    private Integer gender;

    //所属部门id
    @NotNull(message = "所属部门不能为空")
    private Integer orgId;

    //数据创建时间
    private Timestamp createTime;

    //上次更新时间
    private Timestamp updateTime;

    //数据创建人
    private Integer createUid;

    //数据状态（启用、禁用）
    private Integer status;


    @Transient
    private List<String> roleStrlist;

    @Transient
    private List<String> perminsStrlist;
}
