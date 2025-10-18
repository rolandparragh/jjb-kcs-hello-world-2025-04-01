package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EmployeeandDepartmentUtils {
	
	


	List<Employees> employees = new ArrayList<>();
	HashSet<String> departments = new HashSet<>();

	public void readFile() {
		FileHandler fileHandler = new FileHandler();
		employees = fileHandler.getEmployeesFromFile("practice_data/employees.csv");
		departments = fileHandler.getDepartmentsFromFile("practice_data/departments.txt");

	}

	public void outputEmployeesList(char divider) {

		for (Employees employees : employees) {
			System.out.println(employees.getEmployeesByDivider(divider));
		}
	}

	public void departmentsList() {

		System.out.println(departments);

	}

	public void informAdminIfDepartmentIsMissing() {
		for (int i = 0; i < employees.size(); i++) {
			if (!departments.contains(employees.get(i).getDepartment())) {
				System.out.println(
						"Hibás department" + employees.get(i).getName() + "-" + employees.get(i).getDepartment());
			}

		}

	}

	public Map<String, Double> calculateAvgSalaryByDepartment() {

		Map<String, Double> avgSalaryByDepartments = new HashMap<>();

		for(String i: departments) {
			int counter=0;
			double salary=0;
			for (int j = 0; j < employees.size(); j++) {
				if(i.equalsIgnoreCase(employees.get(j).getDepartment())) {
					counter ++;
					salary += employees.get(j).getSalary();
					
				}
				
			}
			if(salary != 0.00 || counter != 0) {
			avgSalaryByDepartments.put(i, salary/counter);
			}
			else {
				avgSalaryByDepartments.put(i, 0.00);
			}
			
		}
		return avgSalaryByDepartments;
	}
	
	public String highestPayingDepartment(Map<String, Double> departments) {
		
		double highestSalary = (Collections.max(departments.values()));
		System.out.println(highestSalary);
		String highestPayingDepartment ="";
		for(Entry<String, Double> i: departments.entrySet()) {
			if(i.getValue() == highestSalary) {
				highestPayingDepartment = i.getKey();
				
			}
		}
		
		return highestPayingDepartment;
		
	}
}
