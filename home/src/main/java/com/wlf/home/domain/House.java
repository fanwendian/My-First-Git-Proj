package com.wlf.home.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class House implements Serializable{
	// 主键
    private Long id;
    // 名称
    private String name;
    // 房子简介
    private String content;
    // 图片地址 以;隔开
    private String imgurl;
    // 房屋类型id
    private Long typeId;
    // 地点id
    private Long cityId;
    // 房东id
    private Long adminId;
   

}