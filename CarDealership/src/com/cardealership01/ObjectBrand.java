package com.cardealership01;

import java.util.List;

public class ObjectBrand {

	public static void main(String[] args) {
		BrandRepository repository = new BrandRepositoryJDBC();
		Brand b1 = new Brand(5, "Mercedes");
		// repository.insert(b1);
		// repository.update(b1);
		// repository.delete(b1);
		
		System.out.println("---------BÚSQUEDA POR MARCA---------");
		Brand b2 = repository.queryFindAField("Dacia");
		System.out.println(b2.getBrand());
		System.out.println(b2.getName());

		System.out.println("---------LISTA DE TODAS LAS MARCAS---------");
		List<Brand> list = repository.allFields();
		for (Brand brand : list) {
			System.out.println("ID Marca: " + brand.getBrand());
			System.out.println("Nombre: " + brand.getName());
		}

	}

}
