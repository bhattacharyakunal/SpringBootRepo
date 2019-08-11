package net.kunal.java.spring.batch.handler;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import net.kunal.java.spring.batch.EmployeeUtil;
import net.kunal.java.spring.batch.model.Employee;
import net.kunal.java.spring.batch.model.Employees;

public class EmployeeWriter implements ItemWriter<Employee> {
//	@Autowired private EmployeeUtil empUtil; 
	@Override
	public void write(List<? extends Employee> items) throws Exception {
		Employees employees=new Employees();
		employees.getEmployee().addAll(items);
		marshallEmployeeData(employees);
	}
	
	private void marshallEmployeeData(Employees emps) throws JAXBException {
		System.out.println(emps);
	}

}
