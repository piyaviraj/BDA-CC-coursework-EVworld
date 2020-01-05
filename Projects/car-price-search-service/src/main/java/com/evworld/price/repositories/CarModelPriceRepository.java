package com.evworld.price.repositories;

import java.util.List;

import com.evworld.price.models.CarModelPrice;

public interface CarModelPriceRepository {

	public List<CarModelPrice> findByModelName(String name);
	
}
