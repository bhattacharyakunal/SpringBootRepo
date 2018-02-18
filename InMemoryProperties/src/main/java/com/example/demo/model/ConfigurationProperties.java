package com.example.demo.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigurationProperties {
	
	private Map<String,String> propertyMap;
	public Map<String, String> getPropertyMap() {
		if(propertyMap==null) {
			propertyMap=new LinkedHashMap<>();
		}
		return propertyMap;
	}
	
	public void printall() {
		if(this.propertyMap!=null) {
			this.propertyMap.forEach((k,v) -> System.out.println(k+"::::::::::::"+v));
		}
	}
	
	public String getProperty(String propertyKey) {
		String propertyKeyValue=getPropertyKeyValue(propertyKey);
		return propertyKeyValue.split("`")[1];
	}
	
	public String setProperty(String propertyKey,String propertyValue) {
		String propertyKeyValue=getPropertyKeyValue(propertyKey);
		this.propertyMap.put(propertyKeyValue.split("`")[0], propertyValue);
		return "SUCCESS";
	}
	
	private String getPropertyKeyValue(String propertyKey) {
		boolean flag=true;
		String propertyValue="";
		do {
			if(this.propertyMap.containsKey(propertyKey)) {
				propertyValue=this.propertyMap.get(propertyKey);
				if(propertyValue.contains("${") && propertyValue.contains("}")) {
					propertyKey=propertyValue.substring(propertyValue.indexOf("{")+1,propertyValue.lastIndexOf("}"));
				}
				else {
					flag=false;
				}
			}else {
				flag=false;
			}
		}while(flag);
		return propertyKey+"`"+propertyValue;
	}
	
}
