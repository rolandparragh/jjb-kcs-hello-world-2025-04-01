package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.model.Product;
import application.utils.Database;

public class ProductDao implements ICrud<Product>{

	private Connection connection = new Database().createConnection();
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;
	
	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE status = 1;";
		try {
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				products.add(getObjectFromRs(resultSet));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return products;
	}

	@Override
	public Product getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getObjectFromRs(ResultSet rs) {
		Product product = null;
		try {
			product = new Product(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("price"),
					rs.getBoolean("status")
			);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return product;
	}

}
