package employeeFileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	private static String header = "";

	private List<Employee> readFile(String filePath) {
		List<Employee> employees = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			header = br.readLine();
			String line;
			while ((line = br.readLine())!= null) {
				String[] rowData = line.split("\t");
				if (rowData.length == 6) {
					employees.add(getEmployeeFromRow(rowData));
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return employees;
	}

	private Employee getEmployeeFromRow(String[] rowData) {
		Employee newEmployee = new Employee(Integer.parseInt(rowData[0]), rowData[1], rowData[2], rowData[3],
				Integer.parseInt(rowData[4]), rowData[5].equals("1"));
		return newEmployee;
	}

	public List<Employee> getEmployeesFromFile(String filePath) {
		return readFile(filePath);
	}
	
	
	

}
