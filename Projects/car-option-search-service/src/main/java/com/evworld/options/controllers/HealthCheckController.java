package com.evworld.options.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping("/options/health_check")
	public boolean helthCheck() {
		return true;
	}
	
}
