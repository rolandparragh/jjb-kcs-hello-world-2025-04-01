package hu.ruander.employeeManagementSystem.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Database {
	private Connection connection;
	
	private String user ="root";
	private String password ="root";
	private String url ="jdbc:mysql://localhost:3306/ems";

	public Connection createConnection() {

		try {
			
			connection = DriverManager.getConnection(url, user, password);
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
