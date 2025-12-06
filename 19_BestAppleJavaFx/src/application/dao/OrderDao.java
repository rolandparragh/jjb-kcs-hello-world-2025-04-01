package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.model.Order;
import application.utils.Database;

public class OrderDao implements IOrder {
	
	private Connection connection = new Database().createConnection();
	private PreparedStatement pstmt = null;
	
	@Override
	public void save(Order obj) {
		String sql = "INSERT INTO `order` (`name`,`email`,`phone`,"
				+ "`postal_code`,`city`,`address`,`product_id`,`amount`,`reduced`) VALUES (?,?,?,?,?,?,?,?,?);";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, obj.getName());
			pstmt.setString(2, obj.getEmail());
			pstmt.setString(3, obj.getPhone());
			pstmt.setString(4, obj.getPostalCode());
			pstmt.setString(5, obj.getCity());
			pstmt.setString(6, obj.getAddress());
			pstmt.setInt(7, obj.getProductId());
			pstmt.setInt(8, obj.getAmount());
			pstmt.setInt(9, obj.getReduced() ? 1:0);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
