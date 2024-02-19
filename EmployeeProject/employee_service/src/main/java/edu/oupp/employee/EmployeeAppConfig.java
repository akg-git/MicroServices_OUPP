package edu.oupp.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeAppConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();			
	}
	

}