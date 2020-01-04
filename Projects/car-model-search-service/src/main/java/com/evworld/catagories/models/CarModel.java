package com.evworld.catagories.models;

public class CarModel {

	private int id;
	private String brand;
	private String modelName;
	
	public CarModel() {
		
	}

	public CarModel(int id, String brand, String modelName) {
		super();
		this.id = id;
		this.brand = brand;
		this.modelName = modelName;
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
		return "CarModel [id=" + id + ", brand=" + brand + ", modelName=" + modelName + "]";
	}
	
}
