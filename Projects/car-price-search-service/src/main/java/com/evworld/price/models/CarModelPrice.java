package com.evworld.price.models;

public class CarModelPrice {

	private int id;
	private String brand;
	private String modelName;
	private double price;
	
	public CarModelPrice() {
		
	}

	public CarModelPrice(int id, String brand, String modelName, double price) {
		super();
		this.id = id;
		this.brand = brand;
		this.modelName = modelName;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
		return "CarModel [id=" + id + ", brand=" + brand + ", modelName=" + modelName + ", price=" + price + "]";
	}
	
}
