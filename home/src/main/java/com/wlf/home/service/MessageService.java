package com.wlf.home.service;

import com.wlf.home.dto.MessageDTO;

import java.util.List;


public interface MessageService {
	
	void addMessage(MessageDTO message);
	
	void updateMessage(MessageDTO message);
	
	List<MessageDTO> selectMessageByHouseId(long houseId);
}	
