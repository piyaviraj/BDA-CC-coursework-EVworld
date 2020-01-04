package com.evworld.catagories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({
	@ComponentScan(basePackages = "com.evworld.catagories.repositories"),
	@ComponentScan(basePackages = "com.evworld.catagories.controllers")
})
public class CarModelSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarModelSearchServiceApplication.class, args);
	}

}
