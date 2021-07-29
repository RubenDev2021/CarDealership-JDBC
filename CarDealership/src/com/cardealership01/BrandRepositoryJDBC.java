package com.cardealership01;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BrandRepositoryJDBC implements BrandRepository {
	private static DataBaseHelper helper = new DataBaseHelper();
	final static String QUERY_INSERT = "insert into marca (marca, nombre) values (?,?)";
	final static String QUERY_UPDATE = "update marca set nombre=? where marca=?";
	final static String QUERY_DELETE = "delete from marca where marca =?";
	final static String QUERY_FIND_A_FIELD = "select * from marca where nombre=?";
	final static String QUERY_ALL_FIELDS = "select * from marca";

	@Override
	public void insert(Brand brand) {
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_INSERT);) {

			sentencia.setInt(1, brand.getBrand());
			sentencia.setString(2, brand.getName());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Brand brand) {
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_UPDATE);) {

			sentencia.setString(1, brand.getName());
			sentencia.setInt(2, brand.getBrand());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Brand brand) {
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_DELETE);) {
			sentencia.setInt(1, brand.getBrand());
			sentencia.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Brand queryFindAField(String name) {
		Brand brand = null;

		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_FIND_A_FIELD);) {
			sentencia.setString(1, name);
			ResultSet rs = sentencia.executeQuery();
			rs.next();

			brand = new Brand(rs.getInt("marca"), rs.getString("nombre"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brand;
	}

	@Override
	public List<Brand> allFields() {

		List<Brand> listBrand = new ArrayList<Brand>();

		try (Connection conn = helper.getConexion();
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(QUERY_ALL_FIELDS);) {
			while (rs.next()) {
				Brand b = new Brand(rs.getInt("marca"), rs.getString("nombre"));
				listBrand.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBrand;
	}

}
