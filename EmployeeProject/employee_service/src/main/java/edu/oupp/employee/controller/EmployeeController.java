package edu.oupp.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/employee")
	public String getEmployee() {
		String address = restTemplate.getForObject("http://localhost:8081/address", String.class);
		String hobbies = restTemplate.getForObject("http://localhost:8083/hobbies", String.class);
		return "I am Tenzing <Email: tenzig.sackleja@gmail.com> from "+address+".\n I enjoy doing "+hobbies;
	}

}
