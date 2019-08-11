package net.kunal.java.spring.batch.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Employee")
public class Employee {
	@XmlElement(name = "Employee_ID")
	private Long employeeId;
	@XmlElement(name = "Employee_Name")
	private String employeeName;
	@XmlElement(name = "Employee_Salary")
	private Double employeeSalary;
	@XmlElement(name = "Employee_IS_Active")
	private String isActive;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + ", isActive=" + isActive + "]";
	}
}
