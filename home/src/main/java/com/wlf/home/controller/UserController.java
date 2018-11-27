package com.wlf.home.controller;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wlf.home.dto.LoginReturn;
import com.wlf.home.dto.UserDTO;
import com.wlf.home.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/showUser",produces = "application/json; charset=UTF-8")
	@ResponseBody
	public UserDTO selectById(HttpServletRequest request){
		String idStr = request.getParameter("id");
		Long id = 0L;
		if(idStr != null){
			id = Long.parseLong(idStr);
		}
		UserDTO userDTO = userService.selectByPrimaryKeyId(id);
		return userDTO;
	}

	@RequestMapping(value = "/login",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public LoginReturn login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginReturn loginReturn = new LoginReturn();
		if(username==null|password==null){
			loginReturn.setCode(500);
			loginReturn.setMessage("用户名或密码为空");
			return loginReturn;
		}
		UserDTO userDTO = userService.selectUsername(username);
		if(userDTO == null){
			loginReturn.setMessage("无此用户");
		}else{
			UserDTO user = userService.selectUsernamePassword(username, password);
			if(user==null){
				loginReturn.setMessage("密码错误");
			}else{
				loginReturn.setMessage(user);
			}
		}
		loginReturn.setCode(200);
		return loginReturn;
	}

	@RequestMapping(value = "/hello")
	public String indexServlet(HttpServletRequest request, Model model){
		String idStr = request.getParameter("id");
		Long id = 0L;
		if(idStr != null){
			id = Long.parseLong(idStr);
		}
		UserDTO userDTO = userService.selectByPrimaryKeyId(1L);
		model.addAttribute("user",userDTO);
		return "index";
	}
}
