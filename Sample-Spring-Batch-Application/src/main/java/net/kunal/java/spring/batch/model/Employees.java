package net.kunal.java.spring.batch.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Employees")
public class Employees {
	private List<Employee> employee;
	public List<Employee> getEmployee() {
		if(this.employee==null) {
			this.employee=new ArrayList<>();
		}
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
}
