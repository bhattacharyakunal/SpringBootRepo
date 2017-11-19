package com.techworld.kunal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techworld.kunal.dao.user.UserDAO;
import com.techworld.kunal.model.user.LoginUser;
import com.techworld.kunal.util.Constants;

@Service
public class UserService {

	
	@Autowired
	UserDAO userDAO;
	
	public String addUser(LoginUser loginUser) {
		userDAO.save(loginUser);
		return Constants.USED_ADDED_SUCCESSFULLY;
	}
	
	public List<LoginUser> findAllUser() {
		List<LoginUser> userList=new ArrayList<>();
		userDAO.findAll().forEach(userList::add);
		return userList;
	}
	
	public LoginUser getUser(LoginUser user) {
		return userDAO.findOne(user.getUserId());
	}
	
}
