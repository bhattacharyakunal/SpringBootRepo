package com.techworld.kunal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techworld.kunal.model.user.LoginUser;
import com.techworld.kunal.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.POST,value="/addUser")
	public String addUser(@RequestBody LoginUser loginUser) {
		return userService.addUser(loginUser);
	}
	
	public List<LoginUser> findAllUser() {
		return userService.findAllUser();
	}
	
	public LoginUser getUser(LoginUser user) {
		return userService.getUser(user);
	}
}
