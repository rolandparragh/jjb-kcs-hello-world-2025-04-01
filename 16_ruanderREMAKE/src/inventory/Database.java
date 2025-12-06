package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection connection;

	public Connection createConnection() {
		try {
			// ha xamppal kapcsolódsz nem kell a port ,de ha nem akkor igen. alap port 3306
			// parancssor kód: mysqld --initialize --console
			// --init-file=C:\temp_mysql\mysql-init.txt ---> inicializálás
			// mysqld --console --port=3307 --> kapcsolódás,
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventory_java", "root", "root");
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
			// A Statement object is used for general-purpose access to databases and is
			// useful for executing static SQL statements at runtime.
			statement = connection.createStatement();
			// lekérdezés: executeQuery, --> result set ( execute : boolean a visszatérés )
			// execute update: insert delete update (DML data manipulation language)

			/*
			 * execute(String sql): Executes any SQL (SELECT, INSERT, UPDATE, DELETE).
			 * Returns true if a ResultSet is returned. 
			 * 
			 * executeUpdate(String sql): Executes DML (INSERT, UPDATE, DELETE). Returns number of rows affected.
			 * 
			 * executeQuery(String sql): Executes SELECT queries. Returns a ResultSet.
			 */
			rs = statement.executeQuery(sql);
			//executeQuery --> select
			//executeUpdate --> insert update delete
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
