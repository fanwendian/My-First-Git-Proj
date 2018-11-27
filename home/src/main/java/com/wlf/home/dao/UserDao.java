package com.wlf.home.dao;

import com.wlf.home.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface UserDao {

	User selectByPrimaryKey(Long id);

	void insertSelective(User user);

	void deleteByPrimaryKey(long id);

	void updateByPrimaryKeySelective(User user);

	List<User> selectByUsername(String username);

	List<User> selectByUsernameAndPassword(Map<String,Object> map);

}
