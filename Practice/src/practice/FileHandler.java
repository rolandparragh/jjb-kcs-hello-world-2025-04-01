package practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FileHandler {
	private static String header="";
	private static String departmentsHeader ="";
	
	private List<Employees> readFile(String filePath){
		
		List<Employees> employees = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			header = br.readLine();
			String[] headerSplit = header.split(",");
			String line;
	
			while((line = br.readLine()) !=null) {
				String[] rowData = line.split(",");

				if(rowData.length == headerSplit.length) {
					employees.add(getEmployeeFromRow(rowData));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return employees;
	}
	
	
	public List<Employees> getEmployeesFromFile(String filePath){

		return readFile(filePath);
	}

	private Employees getEmployeeFromRow(String[] rowData) {
		Employees newEmployee = new Employees(Integer.parseInt(rowData[0]),rowData[1],rowData[2],Double.parseDouble(rowData[3]));
		return newEmployee;
	}
	
	
	
	private HashSet<String> readDepartmentsFile(String filePath){
		HashSet<String> departments = new HashSet<>();
		try(BufferedReader br = new BufferedReader( new FileReader(filePath))){
			departmentsHeader = br.readLine();
			String line;
			while((line=br.readLine())!=null) {
				departments.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departments;
	}
	
	public HashSet<String> getDepartmentsFromFile(String filePath){
		return readDepartmentsFile(filePath);
	}
}
