package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ConfigurationProperties;
import com.example.demo.model.PropertyKeyValue;

@RestController
public class InMemoryController {
	
	@Autowired ConfigurationProperties configurationProperties;
	
	@RequestMapping("/printall")
	public void printall() {
		configurationProperties.printall();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/updateProperty")
	public String updateProperty(@RequestBody PropertyKeyValue propertyKeyValue) {
		return configurationProperties.setProperty(propertyKeyValue.getPropertyKey(), propertyKeyValue.getPropertyValue());
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getProperty")
	public String getProperty(@RequestBody PropertyKeyValue propertyKeyValue) {
		return configurationProperties.getProperty(propertyKeyValue.getPropertyKey());
	}
}
