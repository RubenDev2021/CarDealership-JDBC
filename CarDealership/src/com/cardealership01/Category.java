package com.cardealership01;

public class Category {
	private int category;
	private String name;
	private int carSeats;
	public int getCategory() {
		return category;
	}
	public void setCategory(int categoria) {
		this.category = categoria;
	}
	public String getName() {
		return name;
	}
	public void setName(String nombre) {
		this.name = nombre;
	}
	public int getCarSeats() {
		return carSeats;
	}
	public void setCarSeats(int plazas) {
		this.carSeats = plazas;
	}
	public Category(int category, String name, int carSeats) {
		super();
		this.category = category;
		this.name = name;
		this.carSeats = carSeats;
	}
	public Category(int category) {
		super();
		this.category = category;
	}
}
