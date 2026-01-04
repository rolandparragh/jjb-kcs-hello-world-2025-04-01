package hu.ruander.employeeManagementSystem.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ruander.employeeManagementSystem.model.dto.EmployeeCategoryDto;
import hu.ruander.employeeManagementSystem.model.dto.EmployeeDto;
import hu.ruander.employeeManagementSystem.utils.Database;

public class EmployeeDao implements ICrudDao<EmployeeDto> {

	private Connection connection = new Database().createConnection();
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;

	@Override
	public List<EmployeeDto> getAll() {

		List<EmployeeDto> employees = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE deleted  = 0;";
		EmployeeDto employeeDto = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employeeDto = getObjectFromResultSet();
				employees.add(employeeDto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public void save(EmployeeDto employeeDto) {

		String sql = "INSERT INTO employee (first_name, last_name, date_of_birth,"
				+ "  salary, identity_card, employee_category_id, status, deleted) VALUES (?,?,?,?,?,?,?,?);";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employeeDto.getFirstName());
			preparedStatement.setString(2, employeeDto.getLastName());
			preparedStatement.setString(3, employeeDto.getDateOfBirth().toString());
			preparedStatement.setInt(4, employeeDto.getSalary());
			preparedStatement.setString(5, employeeDto.getIdentityCard());
			preparedStatement.setInt(6, employeeDto.getEmployeeCategory().getId());
			preparedStatement.setBoolean(7, employeeDto.isStatus());
			preparedStatement.setBoolean(8, employeeDto.isDeleted());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public EmployeeDto getById(int id) {

		EmployeeDto employeeDto = null;
		String sql = "SELECT * FROM employee WHERE id = ?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employeeDto = getObjectFromResultSet();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeDto;
	}

	@Override
	public void update(EmployeeDto employeeDto) {
		String sql = "UPDATE employee SET first_name = ?, " + "last_name = ?, " + "date_of_birth = ?, " 
				+ "identity_card = ?, " + "salary = ?, "+ "employee_category_id = ?, " + "status = ?," + "deleted = ?"
				+ " WHERE id = ?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employeeDto.getFirstName());
			preparedStatement.setString(2, employeeDto.getLastName());
			preparedStatement.setString(3, employeeDto.getDateOfBirth().toString());
			preparedStatement.setString(4, employeeDto.getIdentityCard());
			preparedStatement.setInt(5, employeeDto.getSalary());
			preparedStatement.setInt(6, employeeDto.getEmployeeCategory().getId());
			preparedStatement.setBoolean(7, employeeDto.isStatus());
			preparedStatement.setBoolean(8, employeeDto.isDeleted());
			preparedStatement.setInt(9, employeeDto.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void softDelete(EmployeeDto employeeDto) {

		String sql = "UPDATE employee SET deleted = 1 WHERE id =?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeDto.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public EmployeeDto getObjectFromResultSet() {
		EmployeeDto employeeDto = null;
		EmployeeCategoryDao employeeCategoryDao = new EmployeeCategoryDao();
		EmployeeCategoryDto employeeCategoryDto;

		try {
			// itt csak megszerezzük az employee category-t a category daóból az employee
			// category id alapján
			employeeCategoryDto = employeeCategoryDao.getById(resultSet.getInt("employee_category_id"));
			employeeDto = new EmployeeDto(
					resultSet.getInt("id"),
					resultSet.getString("first_name"),
					resultSet.getString("last_name"),
					resultSet.getDate("date_of_birth").toLocalDate(),
					resultSet.getString("identity_card"),
					resultSet.getInt("salary"),
					employeeCategoryDto,
					resultSet.getBoolean("status"),
					resultSet.getBoolean("deleted"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeDto;
	}

}
