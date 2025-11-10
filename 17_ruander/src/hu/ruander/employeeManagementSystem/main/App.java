package hu.ruander.employeeManagementSystem.main;

import javax.swing.SwingUtilities;

import hu.ruander.employeeManagementSystem.utils.Database;

public class App {

	public static void main(String[] args) {

		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Database database = new Database();
				
				System.out.println(database.CreateConnection());
			}
		});

	}

}
