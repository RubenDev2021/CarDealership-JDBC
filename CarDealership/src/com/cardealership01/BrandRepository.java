package com.cardealership01;

import java.util.List;

public interface BrandRepository {

	void insert(Brand brand);

	void update(Brand brand);

	void delete(Brand brand);

	List<Brand> allFields();

	Brand queryFindAField(String name);
}
