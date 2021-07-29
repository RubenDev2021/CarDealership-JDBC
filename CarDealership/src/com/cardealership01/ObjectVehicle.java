package com.cardealership01;

import java.util.List;

public class ObjectVehicle {
	public static void main(String[] args) {
		VehicleRepository repository = new VehicleRepositoryJDBC();
		Vehicle v1 = new Vehicle("0687KJP",new Brand(1),"A3",new Category(2),24598.65);
		//repository.insert(v1);
		v1 = new Vehicle("0687KJP",new Brand(1),"A1",new Category(2),21458.65);
		//repository.update(v1);
		//repository.delete(v1);
		Vehicle v2 = new Vehicle("0985HND",new Brand(1),"A5",new Category(2),41568.25);
		//repository.insert(v2);
		
		System.out.println("---------BÚSQUEDA POR ID DE MARCA---------");
		Vehicle v3 = repository.queryFindAField(4);
		System.out.println(v3.getNumberPlate());
		System.out.println(v3.getFk_Brand().getBrand());
		System.out.println(v3.getVehicleModel());
		System.out.println(v3.getFk_Category().getCategory());
		System.out.println(v3.getPrice());
		
		
		
		System.out.println("---------LISTA DE TODAS LAS CATEGORIAS---------");
		List<Vehicle> list = repository.allFields();
		
		for (Vehicle vehicle: list) {
			
			System.out.println("Matricula: " + vehicle.getNumberPlate());
			System.out.println("ID Marca: " + vehicle.getFk_Brand().getBrand());
			System.out.println("Modelo: " + vehicle.getVehicleModel());
			System.out.println("ID Categoria: " + vehicle.getFk_Category().getCategory());
			System.out.println("Precio: " + vehicle.getPrice());
			System.out.println("----------");
		}
	}
}
