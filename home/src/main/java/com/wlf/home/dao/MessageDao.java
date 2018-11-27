package com.wlf.home.dao;

import com.wlf.home.domain.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MessageDao {
	
	void insertSelective(Message message);
	
	void updateByPrimaryKeySelective(Message message);
	
	List<Message> selectByHouseId(Long houseId);
	
	

}
