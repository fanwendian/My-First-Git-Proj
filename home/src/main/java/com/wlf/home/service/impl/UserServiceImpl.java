package com.wlf.home.service.impl;

import com.wlf.home.dao.UserDao;
import com.wlf.home.domain.User;
import com.wlf.home.dto.UserDTO;
import com.wlf.home.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public UserDTO selectByPrimaryKeyId(Long id) {
		UserDTO userDTO = new UserDTO();
		User user = userDao.selectByPrimaryKey(id);
		if(user == null) {
			return null;
		}else {
			BeanUtils.copyProperties(user, userDTO);
			return userDTO;
		}
	}

	@Transactional
	@Override
	public void insert(UserDTO user) {
		User userPojo = new User();
		BeanUtils.copyProperties(user, userPojo);
		userDao.insertSelective(userPojo);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		userDao.deleteByPrimaryKey(id);
	}

	@Override
	public void update(UserDTO user) {
		User userPojo = new User();
		BeanUtils.copyProperties(user, userPojo);
		userDao.updateByPrimaryKeySelective(userPojo);
	}

	@Override
	public UserDTO selectUsername(String username) {
		UserDTO userDTO = new UserDTO();
		List<User> users = userDao.selectByUsername(username);
		if(users != null && users.size()>0) {
			BeanUtils.copyProperties(users.get(0), userDTO);
			return userDTO;
		}else {
			return null;
		}
	}

	@Override
	public UserDTO selectUsernamePassword(String username, String password) {
		Map<String,Object> map = new HashMap<>();
		map.put("username",username);
		map.put("password",password);
		UserDTO userDTO = new UserDTO();
		List<User> user = userDao.selectByUsernameAndPassword(map);
		if(user != null && user.size() > 0) {
			BeanUtils.copyProperties(user.get(0), userDTO);
			return userDTO;
		}else {
			return null;
		}
	}
}
