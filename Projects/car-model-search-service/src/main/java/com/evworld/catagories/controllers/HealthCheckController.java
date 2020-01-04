package com.evworld.catagories.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping("/models/health_check")
	public boolean helthCheck() {
		return true;
	}
	
}
