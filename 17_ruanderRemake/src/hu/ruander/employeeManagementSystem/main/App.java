package hu.ruander.employeeManagementSystem.main;


import javax.swing.SwingUtilities;

import hu.ruander.employeeManagementSystem.manualCheck.EmsManualCheck;
import hu.ruander.employeeManagementSystem.model.dao.EmployeeDao;
import hu.ruander.employeeManagementSystem.model.dto.EmployeeDto;
import hu.ruander.employeeManagementSystem.presenter.EmployeePresenter;
import hu.ruander.employeeManagementSystem.utils.Database;
import hu.ruander.employeeManagementSystem.view.EmployeeListView;

public class App {

	/*- package szerkezet kialakítás
	- DB install futtatása
	- utils package -> Database
	- Entity (DTO) 
	- DAO (interface + dao osztályok)
	- View osztályok
	- Presenter osztály*/

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				EmsManualCheck emsManualCheck = new EmsManualCheck();
				emsManualCheck.doCheck();
				
				EmployeeListView employeeListView = new EmployeeListView();
				EmployeeDao employeeDao = new EmployeeDao();
				EmployeePresenter employeePresenter = new EmployeePresenter(employeeListView, employeeDao);
				employeePresenter.fillTableEmployee();
			}

		});

	}

}
