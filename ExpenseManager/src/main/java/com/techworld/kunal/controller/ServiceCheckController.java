package com.techworld.kunal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceCheckController {
	
	@RequestMapping("/serviceCheck")
	public String serviceCheck() {
		return "Service is Up and Running";
	}
}
