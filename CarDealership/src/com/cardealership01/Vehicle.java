package com.cardealership01;

public class Vehicle {
	private String numberPlate;
	private Brand fk_brand;
	private String vehicleModel;
	private Category fk_category;
	private double price;
	
	public Vehicle(String numberPlate, Brand fk_brand, String vehicleModel, Category fk_category, double price) {
		super();
		this.numberPlate = numberPlate;
		this.fk_brand = fk_brand;
		this.vehicleModel = vehicleModel;
		this.fk_category = fk_category;
		this.price = price;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public Brand getFk_Brand() {
		return fk_brand;
	}
	public void setFk_Brand(Brand fk_brand) {
		this.fk_brand = fk_brand;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public Category getFk_Category() {
		return fk_category;
	}
	public void setFK_Category(Category fk_category) {
		this.fk_category = fk_category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
