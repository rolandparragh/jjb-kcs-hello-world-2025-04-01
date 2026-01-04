package hu.ruander.employeeManagementSystem.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ruander.employeeManagementSystem.model.dto.EmployeeCategoryDto;
import hu.ruander.employeeManagementSystem.utils.Database;

public class EmployeeCategoryDao implements ICrudDao<EmployeeCategoryDto> {

	private Connection connection = new Database().createConnection();
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;

	@Override
	public List<EmployeeCategoryDto> getAll() {
		List<EmployeeCategoryDto> EmployeeCategories = new ArrayList<>();
		String sql = "SELECT * FROM employee_category WHERE deleted =0 ORDER BY id;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				EmployeeCategories.add(getObjectFromResultSet());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return EmployeeCategories;
	}

	@Override
	public void save(EmployeeCategoryDto entity) {
		String sql = "INSERT INTO employee_category (name, status, deleted) VALUES(?,?,?); ";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setBoolean(2, entity.isStatus());
			preparedStatement.setBoolean(3, entity.isDeleted());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public EmployeeCategoryDto getById(int id) {
		EmployeeCategoryDto employeeCategoryDto = null;
		String sql = "SELECT * FROM employee_category WHERE id = ?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employeeCategoryDto = getObjectFromResultSet();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeCategoryDto;
	}

	@Override
	public void update(EmployeeCategoryDto entity) {
		String sql = "UPDATE employee_category SET " + "name = ?, " + "status = ?," + " deleted = ? " + "WHERE id = ?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setBoolean(2, entity.isStatus());
			preparedStatement.setBoolean(3, entity.isDeleted());
			preparedStatement.setInt(4, entity.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void softDelete(EmployeeCategoryDto entity) {

		String sql = "UPDATE employee_category SET deleted = 1 where id = ?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, entity.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public EmployeeCategoryDto getObjectFromResultSet() {
		EmployeeCategoryDto employeeCategoryDto = null;
		try {
			employeeCategoryDto = new EmployeeCategoryDto(
					resultSet.getInt("id"),
					resultSet.getString("name"),
					resultSet.getBoolean("status"),
					resultSet.getBoolean("deleted"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeCategoryDto;
	}

}
