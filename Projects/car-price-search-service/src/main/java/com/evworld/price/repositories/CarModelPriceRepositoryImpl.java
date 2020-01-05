package com.evworld.price.repositories;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.evworld.price.models.CarModelPrice;

@Component
public class CarModelPriceRepositoryImpl implements CarModelPriceRepository {

	private final List<CarModelPrice> ALL_MODEL_PRICES = Arrays.asList(
			new CarModelPrice(1, "Toyota", "Allion", 7000000.0),
			new CarModelPrice(2, "Toyota", "Preimio", 8200000.0),
			new CarModelPrice(3, "Toyota", "Axio", 5500000.0),
			new CarModelPrice(4, "Toyota", "Belta", 3200000.0),
			new CarModelPrice(5, "Honda", "FIT GP-5", 3500000.0),
			new CarModelPrice(6, "Honda", "CIVIC", 7500000.0),
			new CarModelPrice(7, "Honda", "SHUTTLE", 4000000.0),
			new CarModelPrice(8, "Benz", "E200", 17000000.0),
			new CarModelPrice(9, "BMW", "520D", 15000000.0),
			new CarModelPrice(10, "RollsRoys", "Phantom", 55000000.0));
			
	@Override
	public List<CarModelPrice> findByModelName(String name) {
		if(name == null || name.isEmpty()) {
			return Arrays.asList();
		}
		return ALL_MODEL_PRICES.stream()
		.filter(model -> model.getModelName().toLowerCase().contains(name.toLowerCase()))
		.collect(Collectors.toList());
	}

}
