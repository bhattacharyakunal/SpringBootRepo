package net.kunal.java.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.kunal.java.spring.model.Customer;
import net.kunal.java.spring.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired DemoService demoService;
	
	@GetMapping("/hello/application")
	public String sayHello() {
		return demoService.sayHelloService();
	}
	@PostMapping("/customer/save")
	public String saveCustomer(@RequestBody Customer customer) {
		System.out.println("Controller Invoked"+customer);
		return demoService.saveCustomerService(customer);
	}
}
