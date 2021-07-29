package com.cardealership01;

import java.util.List;


public class ObjectCategory {

	public static void main(String[] args) {
		CategoryRepository repository = new CategoryRepositoryJDBC();
		Category c1 = new Category(7,"SUV",5);
		//repository.insert(c1);
		//repository.delete(c1);
		//repository.update(c1);
		
		System.out.println("---------BÚSQUEDA POR NOMBRE---------");
		Category c2 = repository.queryFindAField("Berlina");
		System.out.println(c2.getCategory());
		System.out.println(c2.getName());
		System.out.println(c2.getCarSeats());
		
		
		System.out.println("---------LISTA DE TODAS LAS CATEGORIAS---------");
		List<Category> list = repository.allFields();
		
		for (Category category: list) {
			
			System.out.println(category.getCategory());
			System.out.println(category.getName());
			System.out.println(category.getCarSeats());
			
		}
	}

}
