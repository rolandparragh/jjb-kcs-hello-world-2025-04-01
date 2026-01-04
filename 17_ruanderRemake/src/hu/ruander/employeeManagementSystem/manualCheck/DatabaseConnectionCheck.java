package hu.ruander.employeeManagementSystem.manualCheck;

import hu.ruander.employeeManagementSystem.utils.Database;

public class DatabaseConnectionCheck {

	public void printIsDatabaseConnectEstablished() {
		Database database = new Database();
		System.out.println(database.createConnection());
	}

	public Boolean isDatabaseConnectionEstablished() {
		Database database = new Database();
		return database.createConnection() != null;
	}
}
