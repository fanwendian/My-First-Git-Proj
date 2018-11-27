package com.wlf.home.dao;


import com.wlf.home.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminDao {
	
	void insertSelective(Admin admin);
	
	void deleteByPrimaryKey(Long id);
	
	void updateByPrimaryKeySelective(Admin admin);
	
	Admin selectByPrimaryKey(Long id);
	
	List<Admin> selectByUsername(String username);
	
	List<Admin> selectByUsernameAndPassword(String username, String password);

}
