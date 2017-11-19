package com.techworld.kunal.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techworld.kunal.model.user.LoginUser;
import com.techworld.kunal.services.UserService;

@Controller
public class UserWebController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET,value="/")
	public String index(ModelMap modelMap) {
		modelMap.put("userAccount", new LoginUser());
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/signup")
	public String signUp(ModelMap modelMap) {
		modelMap.put("userAccount", new LoginUser()); 
		return "signup";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/signup")
	public String signUp(@ModelAttribute("userAccount") LoginUser loginUser,ModelMap modelMap) {
		userService.addUser(loginUser);
		modelMap.put("message", "Sign Up Successfull login now!!");
		return "login";
	}
}
