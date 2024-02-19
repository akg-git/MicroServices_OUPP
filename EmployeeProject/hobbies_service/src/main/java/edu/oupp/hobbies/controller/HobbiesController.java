package edu.oupp.hobbies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbiesController {
	

	@GetMapping("/hobbies")
	public String getHobies() {
		return "Hobbies: Snow skating, Dart Biking";
	}

}
