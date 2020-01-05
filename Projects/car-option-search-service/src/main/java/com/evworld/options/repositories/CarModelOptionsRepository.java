package com.evworld.options.repositories;

import java.util.List;

import com.evworld.options.models.CarModelOptions;

public interface CarModelOptionsRepository {

	public List<CarModelOptions> findByModelName(String modelName);
	
	public List<CarModelOptions> findByOptionName(String optionName);
	
	public List<CarModelOptions> findByModelAndOptionName(String modelName, String optionName);
	
}
