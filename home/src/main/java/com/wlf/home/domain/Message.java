package com.wlf.home.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Message implements Serializable{
	// 主键
    private Long id;
    // 用户留言内容
    private String userContent;
    // 用户留言时间
    private Date userTime;
    // 留言用户id
    private Long userId;
    // 房东回复内容
    private String adminContent;
    // 房东id
    private Long adminId;
    // 房东回复留言时间
    private Date adminTime;
    // 房子id
    private Long houseId;

}