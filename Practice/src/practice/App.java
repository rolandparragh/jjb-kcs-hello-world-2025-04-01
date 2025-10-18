package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeandDepartmentUtils empDepUtil = new EmployeeandDepartmentUtils();
	//	List<Employees> employees = new ArrayList<>();
		empDepUtil.readFile();
		empDepUtil.outputEmployeesList(',');
		empDepUtil.departmentsList();
		empDepUtil.informAdminIfDepartmentIsMissing();
		//Map<String, Double> avgSalaryByDepartments = 
		Map<String, Double> avgSalaryByDepartments =empDepUtil.calculateAvgSalaryByDepartment();
		System.out.println(avgSalaryByDepartments);
		String highestSalary = empDepUtil.highestPayingDepartment(avgSalaryByDepartments);
		System.out.println(highestSalary);
	}

}
