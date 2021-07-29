package com.cardealership01;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryJDBC implements CategoryRepository {
	
	private static DataBaseHelper helper = new DataBaseHelper();
	final static String QUERY_INSERT = "insert into Categoria (categoria,nombre,plazas) values (?,?,?)";
	final static String QUERY_UPDATE = "update Categoria set plazas=? where nombre=?";
	final static String QUERY_DELETE = "delete from Categoria where categoria =?";
	final static String QUERY_FIND_A_FIELD = "select * from Categoria where nombre=?";
	final static String QUERY_ALL_FIELDS = "select * from Categoria";
	//final static String CONSULTA_BUSCAR_UNO_TITULO = "select * from Capitulos where titulo=?";

	@Override
	public void insert(Category category) {
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_INSERT);) {

			sentencia.setInt(1, category.getCategory());
			sentencia.setString(2, category.getName());
			sentencia.setInt(3, category.getCarSeats());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Category category) {
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_UPDATE);) {

			sentencia.setInt(1, category.getCarSeats());
			sentencia.setString(2, category.getName());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Category category) {
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_DELETE);) {
			sentencia.setInt(1, category.getCategory());
			sentencia.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Category queryFindAField(String name) {

		Category category = null;
		
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERY_FIND_A_FIELD);){
				sentencia.setString(1, name);
				ResultSet rs = sentencia.executeQuery();
				rs.next();

				category = new Category(rs.getInt("categoria"), rs.getString("nombre"), rs.getInt("plazas"));
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public List<Category> allFields() {
		List<Category> listCategory = new ArrayList<Category>();

		try (Connection conn = helper.getConexion();
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(QUERY_ALL_FIELDS);) {
			while (rs.next()) {

				Category c = new Category(rs.getInt("categoria"), rs.getString("nombre"), rs.getInt("plazas"));
				listCategory.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCategory;
	}
	
}
