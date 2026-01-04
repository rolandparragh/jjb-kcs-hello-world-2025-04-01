package hu.ruander.employeeManagementSystem.manualCheck;

import java.util.List;

import hu.ruander.employeeManagementSystem.model.dao.EmployeeCategoryDao;
import hu.ruander.employeeManagementSystem.model.dto.EmployeeCategoryDto;

public class EmployeeCategoryCheck {
	EmployeeCategoryDao employeeCategoryDao = new EmployeeCategoryDao();

	public void printGetAll() {

		List<EmployeeCategoryDto> employeeCategories = employeeCategoryDao.getAll();

		for (EmployeeCategoryDto employeeCategory : employeeCategories) {
			System.out.println(employeeCategory.toString());

		}
	}

	public void save() {
		EmployeeCategoryDto employeeCategoryDto = new EmployeeCategoryDto("egyéb3", false, false);
		employeeCategoryDao.save(employeeCategoryDto);
	}
	
	public void update() {
		EmployeeCategoryDto employeeCategoryDto = new EmployeeCategoryDto(6, "egyéb", false, false);
	employeeCategoryDao.update(employeeCategoryDto);
	}

	public void delete() {
		EmployeeCategoryDto employeeCategoryDto = employeeCategoryDao.getById(6);
		employeeCategoryDao.softDelete(employeeCategoryDto);
	}
	
	public void getByid() {
		EmployeeCategoryDto employeeCategoryDto = employeeCategoryDao.getById(1);
		System.out.println(employeeCategoryDto.toString());
	}

	

}
