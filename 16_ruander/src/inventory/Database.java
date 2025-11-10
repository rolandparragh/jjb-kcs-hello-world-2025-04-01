package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {

	private Connection connection;

	public Connection CreateConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() {

		try {
			if (connection != null && connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet query(String sql) {
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			statement= connection.createStatement();
			rs = statement.executeQuery(sql);
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}

}
