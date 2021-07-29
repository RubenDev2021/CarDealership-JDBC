package com.cardealership01;

import java.util.List;

public interface CategoryRepository {

	void insert(Category category);

	void update(Category category);

	void delete(Category category);

	List<Category> allFields();

	Category queryFindAField(String name);
}
