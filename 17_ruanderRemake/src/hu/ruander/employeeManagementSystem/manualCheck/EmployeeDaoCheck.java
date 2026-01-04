package hu.ruander.employeeManagementSystem.manualCheck;

import java.time.LocalDate;
import java.util.List;

import hu.ruander.employeeManagementSystem.model.dao.EmployeeCategoryDao;
import hu.ruander.employeeManagementSystem.model.dao.EmployeeDao;
import hu.ruander.employeeManagementSystem.model.dto.EmployeeCategoryDto;
import hu.ruander.employeeManagementSystem.model.dto.EmployeeDto;

public class EmployeeDaoCheck {

	private EmployeeDao employeeDao = new EmployeeDao();
	private EmployeeCategoryDao employeeCategoryDao = new EmployeeCategoryDao();

	public void printGetAll() {
		List<EmployeeDto> employees = employeeDao.getAll();
		for (EmployeeDto employeeDto : employees) {
			System.out.println(employeeDto.toString());

		}
	}

	public void save() {

		// túlterheljük a konstruktorát, mert az id autoincrement
		EmployeeCategoryDto employeeCategoryDto = employeeCategoryDao.getById(1);
		EmployeeDto employeeDto = new EmployeeDto(
				"John",
				"Doe",
				LocalDate.of(1994, 02, 8),
				"123456AA",
				800000,
				employeeCategoryDto,
				true,
				false);
		employeeDao.save(employeeDto);

	}

	public void getById() {
		EmployeeDto employeeDto = employeeDao.getById(1);
		System.out.println(employeeDto.toString());

	}

	public void update() {
		EmployeeCategoryDto employeeCategoryDto = employeeCategoryDao.getById(3);
		EmployeeDto employeeDto = new EmployeeDto(
				1,
				"Elemér",
				"Teszt",
				LocalDate.of(2000, 1, 2),
				"123456AA",
				521000,
				employeeCategoryDto,
				false,
				false);
		employeeDao.update(employeeDto);
	}

	public void delete() {

		EmployeeDto employeeDto = employeeDao.getById(1);
		employeeDao.softDelete(employeeDto);

	}

}
