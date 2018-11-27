package com.wlf.home.dto;

import lombok.Data;

@Data
public class HouseDTO {
	private Long id;
    
    private String name;

    private String content;

    private String imgurl;

    private Long typeId;
    
    private String typeName;

    private Long cityId;
    
    private String cityName;

    private Long adminId;
    
    private String adminUsername;


}
