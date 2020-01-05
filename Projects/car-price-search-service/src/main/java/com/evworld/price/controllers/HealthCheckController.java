package com.evworld.price.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping("/prices/health_check")
	public boolean helthCheck() {
		return true;
	}
	
}
