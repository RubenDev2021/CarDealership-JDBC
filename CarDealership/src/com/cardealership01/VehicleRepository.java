package com.cardealership01;

import java.util.List;

public interface VehicleRepository {

	void insert(Vehicle vehicle);

	void update(Vehicle vehicle);

	void delete(Vehicle vehicle);

	List<Vehicle> allFields();

	Vehicle queryFindAField(int fk_brand);
}
