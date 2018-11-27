package com.wlf.home.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable{
    private static final long serialVersionUID = -9075005301139416613L;
    // 主键
    private Long id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 真实姓名
    private String name;
    // 性别
    private String sex;
    // 身份证
    private String idcard;
    // 电话号
    private String telephone;


}