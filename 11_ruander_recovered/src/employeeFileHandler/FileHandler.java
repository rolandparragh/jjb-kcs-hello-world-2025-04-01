package employeeFileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	private static String header = "";
	EmployeeUtils employeeUtils = new EmployeeUtils();

	private List<Employee> readFile(String filePath) {
		List<Employee> employees = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			header = br.readLine();
			String line;
			while ((line = br.readLine()) != null) {
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

	// Feladat04: Programozók minden adatát írjuk egy külön fájlba: programmers.txt
	//nem a programozókat írtad bele nézd át
	public void writeEmployeesFile(List<Employee> employees) {
		File filePath = new File("data_employee/programmers.txt");

		try {
			FileWriter fw = new FileWriter(filePath, Charset.forName("UTF-8"), false);
			for (int i = 0; i < employees.size(); i++) {

				fw.write(employeeUtils.getEmployeesAsFormattedString(employees.get(i), " ; ")+"\r\n");
			}
			System.out.println(" A fájl létrejött..");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
