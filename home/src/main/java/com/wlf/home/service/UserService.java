package com.wlf.home.service;

import com.wlf.home.dto.UserDTO;

public interface UserService {

	UserDTO selectByPrimaryKeyId(Long id);

	void insert(UserDTO user);

	void delete(Long id);

	void update(UserDTO user);

	UserDTO selectUsername(String username);

	UserDTO selectUsernamePassword(String username,String password);
}
