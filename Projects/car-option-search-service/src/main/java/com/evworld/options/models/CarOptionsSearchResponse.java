package com.evworld.options.models;

import java.util.List;
import java.util.Map;

public class CarOptionsSearchResponse {

	private List<CarModelOptions> carModelsOptions;
	
	private Map<String, Object> metaData;
	
	public CarOptionsSearchResponse() {
		
	}

	public CarOptionsSearchResponse(List<CarModelOptions> carModelsOptions, Map<String, Object> metaData) {
		super();
		this.carModelsOptions = carModelsOptions;
		this.metaData = metaData;
	}

	public List<CarModelOptions> getCarModelsOptions() {
		return carModelsOptions;
	}

	public void setCarModelsOptions(List<CarModelOptions> carModelsOptions) {
		this.carModelsOptions = carModelsOptions;
	}

	public Map<String, Object> getMetaData() {
		return metaData;
	}

	public void setMetaData(Map<String, Object> metaData) {
		this.metaData = metaData;
	}
	
}
