package net.kunal.java.spring.batch.handler;

import org.springframework.batch.item.ItemProcessor;

import net.kunal.java.spring.batch.model.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		item.setEmployeeName(item.getEmployeeName().toUpperCase());
		System.out.println(item);
		return item;
	}

}
