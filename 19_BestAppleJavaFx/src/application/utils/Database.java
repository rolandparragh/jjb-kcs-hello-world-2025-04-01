package application.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private Connection connection;

	public Connection createConnection() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/best_apple", "root", "password123");
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
}
