package com.java.kunal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.kunal.services.CountryService;

@Controller
public class PaginationController {
	
	@Autowired private CountryService countryService;
	
	@GetMapping("/")
	public String showPage(Model model,@RequestParam(defaultValue="1") int page) {
		model.addAttribute("data", countryService.findall(page,4));
		model.addAttribute("totalPages", (countryService.findall().size()/4)+1);
		return "index";
	}
}
