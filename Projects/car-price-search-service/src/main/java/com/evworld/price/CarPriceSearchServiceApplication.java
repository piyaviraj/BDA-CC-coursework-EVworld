package com.evworld.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({
	@ComponentScan(basePackages = "com.evworld.price.repositories"),
	@ComponentScan(basePackages = "com.evworld.price.controllers")
})
public class CarPriceSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarPriceSearchServiceApplication.class, args);
	}

}
