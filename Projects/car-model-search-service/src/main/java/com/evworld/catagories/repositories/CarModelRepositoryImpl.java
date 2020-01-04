package com.evworld.catagories.repositories;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.evworld.catagories.models.CarModel;

@Component
public class CarModelRepositoryImpl implements CarModelRepository {

	private final List<CarModel> ALL_MODELS = Arrays.asList(
			new CarModel(1, "Toyota", "Allion"),
			new CarModel(2, "Toyota", "Preimio"),
			new CarModel(3, "Toyota", "Axio"),
			new CarModel(4, "Toyota", "Belta"),
			new CarModel(5, "Honda", "FIT GP-5"),
			new CarModel(6, "Honda", "CIVIC"),
			new CarModel(7, "Honda", "SHUTTLE"),
			new CarModel(8, "Benz", "E200"),
			new CarModel(9, "BMW", "520D"),
			new CarModel(10, "RollsRoys", "Phantom")
	);
	
	@Override
	public List<CarModel> findByModelName(String name) {
		if(name == null || name.isEmpty()) {
			return Arrays.asList();
		}
		return ALL_MODELS.stream()
		.filter(model -> model.getModelName().toLowerCase().contains(name.toLowerCase()))
		.collect(Collectors.toList());
	}

}
