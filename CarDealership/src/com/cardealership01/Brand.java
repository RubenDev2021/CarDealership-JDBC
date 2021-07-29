package com.cardealership01;

public class Brand {
	private int brand;
	private String name;
	
	public int getBrand() {
		return brand;
	}
	public void setBrand(int brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Brand(int brand, String name) {
		super();
		this.brand = brand;
		this.name = name;
	}
	public Brand(int brand) {
		super();
		this.brand = brand;
	}
	
}
