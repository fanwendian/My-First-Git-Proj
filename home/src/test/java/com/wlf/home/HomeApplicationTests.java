package com.wlf.home;

import com.wlf.home.dto.UserDTO;
import com.wlf.home.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Resource
	private UserService userService;
	@Test
	public void test(){
		UserDTO user = userService.selectByPrimaryKeyId(1L);
		if(user!=null){
			System.err.println(user.getName());
		}
	}

	@Test
	public void insert(){
		UserDTO user = new UserDTO();
		user.setName("王丽芳");
		user.setIdcard("210826836273528292");
		user.setPassword("123456");
		user.setSex("女");
		user.setTelephone("17609854626");
		user.setUsername("wanglifang");
		userService.insert(user);
	}

	@Test
	public void delete(){
		userService.delete(2L);
	}

	@Test
	public void update(){
		UserDTO user = new UserDTO();
		user.setId(1L);
		user.setUsername("xiaodian");
		userService.update(user);
	}

	@Test
	public void selectUsername(){
		UserDTO userDTO = userService.selectUsername("xiaodian");
		if(userDTO!=null){
			System.err.println(userDTO.getPassword());
		}
	}

	@Test
	public void selectUsernamePassword(){
		UserDTO xiaodian = userService.selectUsernamePassword("xiaodian", "745210");
		if(xiaodian!=null){
			System.err.println(xiaodian.getIdcard());
		}
	}
}
