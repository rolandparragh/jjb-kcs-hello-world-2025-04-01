package hu.ruander.employeeManagementSystem.presenter;

import java.awt.event.ActionEvent;
import java.util.List;

import hu.ruander.employeeManagementSystem.model.dao.EmployeeCategoryDao;
import hu.ruander.employeeManagementSystem.model.dao.EmployeeDao;
import hu.ruander.employeeManagementSystem.model.dto.EmployeeDto;
import hu.ruander.employeeManagementSystem.view.EmployeeAddView;
import hu.ruander.employeeManagementSystem.view.EmployeeListView;
import hu.ruander.employeeManagementSystem.view.EmployeeUpdateView;


public class EmployeePresenter {
	
	private EmployeeListView employeeListView;
	private EmployeeDao employeeDao;
	private EmployeeAddView employeeAddView;
	private EmployeeUpdateView employeeUpdateView;
	
	public EmployeePresenter(EmployeeListView employeeListView, EmployeeDao employeeDao) {
		this.employeeListView = employeeListView;
		this.employeeDao = employeeDao;
		
		this.employeeListView.showEmployeeAddButtonListener(e -> showEmployeeAddView());
		this.employeeListView.setEditListener(e -> showEmployeeUpdateView(e));
		this.employeeListView.setDeleteListener(e-> deleteEmployee(e));
	}

	public void fillTableEmployee() {
		List<EmployeeDto> employees = employeeDao.getAll();
		employeeListView.setModelToTableEmployeeList(employees);
	}
	
	private void showEmployeeAddView() {
		EmployeeCategoryDao employeeCategoryDao = new EmployeeCategoryDao();
		employeeAddView = new EmployeeAddView(employeeCategoryDao.getAll());
		employeeAddView.saveEmployeeButtonListener(e->addEmployee());
		employeeAddView.cancelEmployeeButtonListener(e->cancelAddEmployee());
		employeeAddView.setVisible(true);
	}
	
	private void addEmployee() {
		employeeDao.save(employeeAddView.getEmployeeDtoByInputData());
		employeeAddView.dispose();
		fillTableEmployee();
	}
	
	private void cancelAddEmployee() {
		employeeAddView.dispose();
	}
	
	private void deleteEmployee(ActionEvent e) {
		int id = Integer.parseInt(e.getActionCommand());
		//System.out.println("Presenter - törlés, id: "+id);
		EmployeeDto employeeDto = employeeDao.getById(id);
		if (employeeDto != null) {
			employeeDao.softDelete(employeeDto);
			fillTableEmployee();
		}
	}
	
	private void showEmployeeUpdateView(ActionEvent e) {
		int id = Integer.parseInt(e.getActionCommand()); 
		//System.out.println("showEmployeeUpdateView(), id:"+id);
        EmployeeDto employeeDto = employeeDao.getById(id);
		
        if (employeeDto !=null) {
    		EmployeeCategoryDao employeeCategoryDaoObj = new EmployeeCategoryDao();
    		employeeUpdateView = new EmployeeUpdateView(employeeCategoryDaoObj.getAll(), id);
    		employeeUpdateView.setEmployeeData(employeeDto);
        
    		//Gombok eseménykezelése
    		employeeUpdateView.updateEmployeeButtonListener(ev->updateEmployee(id));
    		employeeUpdateView.cancelUpdateEmployeeButtonListener(ev->cancelUpdateEmployee());
        }    
	}
	
	private void updateEmployee(int id) {
		employeeDao.update(employeeUpdateView.getEmployeeInputData(id));
		employeeUpdateView.dispose();
		fillTableEmployee();
	}
	
	private void cancelUpdateEmployee() {
		employeeUpdateView.dispose();
	}
	
}
