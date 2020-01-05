package com.evworld.price.models;

import java.util.List;
import java.util.Map;

public class CarPriceSearchResponse {

private List<CarModelPrice> carModelsPrices;
	
	private Map<String, Object> metaData;
	
	public CarPriceSearchResponse() {
		
	}

	public CarPriceSearchResponse(List<CarModelPrice> carModelsPrices, Map<String, Object> metaData) {
		super();
		this.carModelsPrices = carModelsPrices;
		this.metaData = metaData;
	}

	public List<CarModelPrice> getCarModelsPrices() {
		return carModelsPrices;
	}

	public void setCarModelsPrices(List<CarModelPrice> carModelsPrices) {
		this.carModelsPrices = carModelsPrices;
	}

	public Map<String, Object> getMetaData() {
		return metaData;
	}

	public void setMetaData(Map<String, Object> metaData) {
		this.metaData = metaData;
	}
	
}
