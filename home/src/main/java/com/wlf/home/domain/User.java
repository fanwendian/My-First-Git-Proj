package com.wlf.home.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable{
	private static final long serialVersionUID = -9006155368424241775L;
	// 主键id
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
