package com.evworld.catagories.repositories;

import java.util.List;

import com.evworld.catagories.models.CarModel;

public interface CarModelRepository {

	public List<CarModel> findByModelName(String name);
	
}
