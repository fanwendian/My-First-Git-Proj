package com.wlf.home.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class HouseType implements Serializable{
	// 主键
    private Long id;
    // 类型名称
    private String typename;

}