package com.wlf.home.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable{
    private static final long serialVersionUID = 8885472543330539053L;
    // 主键
    private Long id;
    // 城市名称
    private String cityname;


}