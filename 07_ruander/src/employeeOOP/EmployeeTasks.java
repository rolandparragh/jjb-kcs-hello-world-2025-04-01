package employeeOOP;

public class EmployeeTasks {

	// Feladat01: Kérjük be a felhasználótól, hány dolgozó adatait szeretné megadni,
	// majd
	// töltsünk fel egy megadott méretű tömböt a dolgozói adatokkal!
	ReadDataFromConsole readDataFromConsoleObj = new ReadDataFromConsole();
	Employee[] employees = readDataFromConsoleObj.fillEmployeesArrayByUserInput();

	// Feladat02: Írjuk ki az adatokat vesszővel elválasztva!
	public void printEmployees(char divider) {
		for (Employee employee : employees) {
			System.out.println(employee.getObjDataByDivider(divider));
		}
	}

	public void displayHighestEarningEmployee() {
		Employee highestEarner = findHighestEarningEmployee();
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getSalary() == highestEarner.getSalary()) {
				System.out.println("A legmagasabb keresettel rendelkező dolgozó: " + employees[i]);
			}

		}

	}

	public Employee findHighestEarningEmployee() {

		Employee employeeTemp = employees[0];

		for (int i = 0; i < employees.length; i++) {
			if (employeeTemp.getSalary() < employees[i].getSalary()) {
				employeeTemp = employees[i];
			}
		}
		return employeeTemp;

	}

	public int countActiveEmployeeBasedOnRole( String role) {
		int counter = 0;
		for (int i = 0; i < employees.length; i++) {
			if (role.equalsIgnoreCase(employees[i].getRole()) && employees[i].isActive()) {
				counter++;
			}
		}
		return counter;
	}

	public void hasRole( String role) {
		boolean hasRole = false;
		for (int i = 0; i < employees.length; i++) {
			if (role.equalsIgnoreCase(employees[i].getRole())) {
				hasRole = true;
			}
		}
		String result = hasRole ? "Igen van " + role + " a cégnél" : "Nincs " + role + " a cégnél";
		System.out.println(result);
	}

	public void getPercentageBelowLimit( int limit) {
		int counter = 0;
		double percentage = 0.0;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getSalary() < limit) {
				counter++;
			}
		}
		percentage = (double)(counter * 100) / employees.length;
		System.out.println("A dolgozók " + percentage + " százaléka keress " + limit + " alatt.");

	}

	public void displayAvgSalary(Employee[] employees) {

	}

}
