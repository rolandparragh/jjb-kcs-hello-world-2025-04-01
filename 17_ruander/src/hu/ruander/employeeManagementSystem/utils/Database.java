package hu.ruander.employeeManagementSystem.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

}