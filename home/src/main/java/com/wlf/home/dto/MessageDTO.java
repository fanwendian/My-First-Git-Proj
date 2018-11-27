package com.wlf.home.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO {
	private Long id;

    private String userContent;

    private Date userTime;

    private Long userId;
    
    private String userUsername;

    private String adminContent;

    private Long adminId;
    
    private String adminUserName;

    private Date adminTime;

    private Long houseId;
    
    private String houseName;

}
