package com.evworld.options.models;

import java.util.List;

public class CarModelOptions {

	private int id;
	private String brand;
	private String modelName;
	private List<CarOption> carOptions;
	
	public CarModelOptions() {
		
	}

	public CarModelOptions(int id, String brand, String modelName, List<CarOption> carOptions) {
		super();
		this.id = id;
		this.brand = brand;
		this.modelName = modelName;
		this.carOptions = carOptions;
	}

	public List<CarOption> getCarOptions() {
		return carOptions;
	}

	public void setCarOptions(List<CarOption> carOptions) {
		this.carOptions = carOptions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Override
	public String toString() {
		return "CarModelOptions [id=" + id + ", brand=" + brand + ", modelName=" + modelName + ", carOptions="
				+ carOptions + "]";
	}
	
}
