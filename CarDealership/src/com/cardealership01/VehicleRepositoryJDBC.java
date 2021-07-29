package com.cardealership01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryJDBC implements VehicleRepository {

	private static DataBaseHelper helper = new DataBaseHelper();
	final static String QUERY_INSERT = "insert into vehiculo (matricula, fk_marca, modelo, fk_categoria, precio) values (?,?,?,?,?)";
	final static String QUERY_UPDATE = "update vehiculo set modelo=?, precio=? where matricula=?";
	final static String QUERY_DELETE = "delete from vehiculo where matricula =?";
	final static String QUERY_FIND_A_FIELD = "select * from vehiculo where fk_marca=?";
	final static String QUERY_ALL_FIELDS = "select * from vehiculo";

	@Override
	public void insert(Vehicle vehicle) {
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_INSERT);) {

			sentencia.setString(1, vehicle.getNumberPlate());
			sentencia.setInt(2, vehicle.getFk_Brand().getBrand());
			sentencia.setString(3, vehicle.getVehicleModel());
			sentencia.setInt(4, vehicle.getFk_Category().getCategory());
			sentencia.setDouble(5, vehicle.getPrice());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Vehicle vehicle) {
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_UPDATE);) {

			sentencia.setString(1, vehicle.getVehicleModel());
			sentencia.setDouble(2, vehicle.getPrice());
			sentencia.setString(3, vehicle.getNumberPlate());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Vehicle vehicle) {
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_DELETE);) {
			sentencia.setString(1, vehicle.getNumberPlate());
			sentencia.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Vehicle queryFindAField(int fk_brand) {
		Vehicle vehicle = null;

		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_FIND_A_FIELD);) {
			sentencia.setInt(1, fk_brand);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			vehicle = new Vehicle(rs.getString("matricula"), new Brand(rs.getInt("fk_marca")), rs.getString("modelo"), new Category(rs.getInt("fk_categoria")), rs.getDouble("precio"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicle;
	}

	@Override
	public List<Vehicle> allFields() {
		List<Vehicle> listVehicle = new ArrayList<Vehicle>();

		try (Connection conn = helper.getConexion();
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(QUERY_ALL_FIELDS);) {
			while (rs.next()) {
				Vehicle v = new Vehicle(rs.getString("matricula"), new Brand(rs.getInt("fk_marca")), rs.getString("modelo"), new Category(rs.getInt("fk_categoria")), rs.getDouble("precio"));
				
				listVehicle.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listVehicle;
	}

}
