package net.kunal.java.spring.service;

import org.springframework.stereotype.Service;

import net.kunal.java.spring.model.Customer;

@Service
public class DemoService {
	
	public String sayHelloService() {
		return "Hello World";
	}
	
	public String saveCustomerService(Customer customer) {
		System.out.println("Sevice Invoked");
		return customer.toString()+" saved Success fully";
	}
}
