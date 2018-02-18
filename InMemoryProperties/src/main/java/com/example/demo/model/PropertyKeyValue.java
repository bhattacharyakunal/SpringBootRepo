package com.example.demo.model;

public class PropertyKeyValue {
	private String propertyKey;
	private String propertyValue;
	public String getPropertyKey() {
		return propertyKey;
	}
	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	@Override
	public String toString() {
		return "PropertyKeyValue [propertyKey=" + propertyKey + ", propertyValue=" + propertyValue + "]";
	}
}
