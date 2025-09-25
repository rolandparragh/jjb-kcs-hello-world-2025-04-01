package employeeFileHandler;
import java.util.List;

public class App {

	public static void main(String[] args) {
		FileHandler fileHandler = new FileHandler();
		EmployeeUtils employeeUtils = new EmployeeUtils();
		// ezt órán beletettük egy task solutionbe 
		List<Employee> employees = fileHandler.getEmployeesFromFile("data_employee/employees.txt");
		System.out.println(employees.size());
		employeeUtils.outputEmployeeList(employees);
		List<String> activeRoles = employeeUtils.activeRoles(employees);
		System.out.println(activeRoles);
		
		fileHandler.writeEmployeesFile(employees);
	}
}
//Feladat02: Írjuk ki az adatokat ; határolóval elválasztva! --kész 
// Feladat03: Milyen beosztások vannak a cégnél (aktív)?
// Feladat04: Programozók minden adatát írjuk egy külön fájlba: programmers.txt
// Azonos legyen a szerkezete az eredeti fájllal!
// Feladat05: A 2-es id-val rendelkező adatot töröljük, mert elmegy a cégtől.
// Ugyanez a feladat tömmbel? Gondolatébresztő.
// Feladat06: Mentsük az aktuális dolgozó adatokat (törlés után)
// employee_data_save_2025_09_23.csv (aktuális dátummal),
// Elválasztó karakter a ; legyen!