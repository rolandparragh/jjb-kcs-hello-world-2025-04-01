package employeeFileHandler;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtils {

	// Feladat02: Írjuk ki az adatokat ; határolóval elválasztva!
	// Feladat03: Milyen beosztások vannak a cégnél (aktív)?
	// Feladat04: Programozók minden adatát írjuk egy külön fájlba: programmers.txt
	// Azonos legyen a szerkezete az eredeti fájllal!
	// Feladat05: A 2-es id-val rendelkező adatot töröljük, mert elmegy a cégtől.
	// Ugyanez a feladat tömmbel? Gondolatébresztő.
	// Feladat06: Mentsük az aktuális dolgozó adatokat (törlés után)
	// employee_data_save_2025_09_23.csv (aktuális dátummal),

	public String getEmployeesAsFormattedString(Employee employee, String limiter) {

		return employee.getId() + limiter + employee.getLastName() + limiter + employee.getFirstName() + limiter
				+ employee.getRole() + limiter + employee.getNetSalary() + limiter + employee.isActive();

	}
	
	public String getEmployeesAsFormattedString(Employee employee, char limiter) {

		return employee.getId() + limiter + employee.getLastName() + limiter + employee.getFirstName() + limiter
				+ employee.getRole() + limiter + employee.getNetSalary() + limiter + employee.isActive();

	}

	public void outputEmployeeList(List<Employee> employees) {
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(getEmployeesAsFormattedString(employees.get(i), " ; "));
		}
		
	}
	
	
	public List<String> activeRoles(List<Employee> employees){
		List<String> activeRoles = new ArrayList<>();
		for (int i = 0; i < employees.size(); i++) {
			if(employees.get(i).isActive() && !activeRoles.contains(employees.get(i).getRole())) {

				activeRoles.add(employees.get(i).getRole());
			}
		}
		return activeRoles;
		
	}
}
