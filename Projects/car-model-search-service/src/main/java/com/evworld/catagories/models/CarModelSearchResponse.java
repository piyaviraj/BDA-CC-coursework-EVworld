package com.evworld.catagories.models;

import java.util.List;
import java.util.Map;

public class CarModelSearchResponse {

	private List<CarModel> carModels;
	
	private Map<String, Object> metaData;
	
	public CarModelSearchResponse() {
		
	}

	public CarModelSearchResponse(List<CarModel> carModels, Map<String, Object> metaData) {
		super();
		this.carModels = carModels;
		this.metaData = metaData;
	}

	public List<CarModel> getCarModels() {
		return carModels;
	}

	public void setCarModels(List<CarModel> carModels) {
		this.carModels = carModels;
	}

	public Map<String, Object> getMetaData() {
		return metaData;
	}

	public void setMetaData(Map<String, Object> metaData) {
		this.metaData = metaData;
	}
	
}
