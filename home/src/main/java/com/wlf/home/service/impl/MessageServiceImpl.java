package com.wlf.home.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wlf.home.dao.AdminDao;
import com.wlf.home.dao.HouseDao;
import com.wlf.home.dao.MessageDao;
import com.wlf.home.dao.UserDao;
import com.wlf.home.domain.Message;
import com.wlf.home.dto.MessageDTO;
import com.wlf.home.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageDao messageDao;
	@Resource
	private UserDao userDao;
	@Resource
	private AdminDao adminDao;
	@Resource
	private HouseDao houseDao;


	@Override
	public void addMessage(MessageDTO message) {
		Message messagePojo = new Message();
		BeanUtils.copyProperties(message, messagePojo);
		messagePojo.setUserTime(new Date());
		messageDao.insertSelective(messagePojo);
		
	}

	@Override
	public void updateMessage(MessageDTO message) {
		Message messagePojo = new Message();
		BeanUtils.copyProperties(message, messagePojo);
		messagePojo.setAdminTime(new Date());
		messageDao.updateByPrimaryKeySelective(messagePojo);
	}

	@Override
	public List<MessageDTO> selectMessageByHouseId(long houseId) {
		List<MessageDTO> messageDTOs = new ArrayList<>();
		List<Message> selectMessageByHouseId = messageDao.selectByHouseId(houseId);
		if(selectMessageByHouseId!=null&&selectMessageByHouseId.size()>0) {
			for (Message message : selectMessageByHouseId) {
				MessageDTO messageDTO = new MessageDTO();
				BeanUtils.copyProperties(message, messageDTO);
				messageDTO.setUserUsername(userDao.selectByPrimaryKey(message.getUserId()).getUsername());
				messageDTO.setAdminUserName(adminDao.selectByPrimaryKey(message.getAdminId()).getUsername());
				messageDTO.setHouseName(houseDao.selectByPrimaryKey(houseId).getName());
				messageDTOs.add(messageDTO);
			}
		}
		return messageDTOs;
	}

}
