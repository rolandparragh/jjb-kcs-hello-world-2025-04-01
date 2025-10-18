package employeePredicate;

import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Employee> employees = List.of(
			    new Employee(1,  "Elek",    "Teszt",   23, "M"),
			    new Employee(2,  "Jakab",   "Gipsz",   13, "M"),
			    new Employee(3,  "Pali",    "Nap",     43, "M"),
			    new Employee(4,  "John",    "Doe",     26, "M"),
			    new Employee(5,  "Jane",    "Doe",     19, "F"),
			    new Employee(6,  "Jonnie",  "Doe",     18, "M"),
			    new Employee(7,  "Ica",     "Kukor",   68, "F"),
			    new Employee(8,  "Iván",    "Kovács",  79, "M"),
			    new Employee(9,  "Natasa",  "Szabó",   15, "F"),
			    new Employee(10, "Tibor",   "Lakatos", 23, "M")
			);
		
		EmployeePredicate employeePredicateObj = new EmployeePredicate();
		List<Employee> maleAdultEmployees= employeePredicateObj.getAdultMaleEmployee(employees);

		App appObj = new App();
		System.out.println("Felnőtt férifiak - hagyományos módon lekérdezve");
		appObj.printEmployees(maleAdultEmployees);
		System.out.println();
		
		
		System.out.println("Felnőtt férfiak - predicate - streamAPI");
		List<Employee> maleAdultEmployeesPredicate= employeePredicateObj.filterEmployees(employees, employeePredicateObj.isAdultMale());
		appObj.printEmployees(maleAdultEmployeesPredicate);
		System.out.println();
		
		System.out.println("Felnőtt nők - predicate - streamAPI");
		List<Employee> femaleAdultEmployeesPredicate= employeePredicateObj.filterEmployees(employees, employeePredicateObj.isAdultFemale());
		appObj.printEmployees(femaleAdultEmployeesPredicate);
		System.out.println();
		
		

		System.out.println("Idősebbek mint megadott érték  - predicate - streamAPI");
		List<Employee> olderEmployeesPredicate= employeePredicateObj.filterEmployees(employees, employeePredicateObj.isOlderThan(67));
		appObj.printEmployees(olderEmployeesPredicate);
		System.out.println();
		
		System.out.println("Nem Doe a vezetékneve  - predicate - streamAPI");
		List<Employee> notDoePredicate= employeePredicateObj.filterEmployees(employees, employeePredicateObj.lastNameIsDoe().negate().and(employeePredicateObj.isFemale().negate()));
		appObj.printEmployees(notDoePredicate);
		System.out.println();
		
		
		
		System.out.println("Nő vagy idősebb mint 65  - predicate - streamAPI");
		List<Employee> femaleOrOlderThan65Predicate= employeePredicateObj.filterEmployees(employees, employeePredicateObj.isFemale().or(employeePredicateObj.olderThanNumber(65)));
		appObj.printEmployees(femaleOrOlderThan65Predicate);
		System.out.println();
		
	}
	
	private void printEmployees(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee.getDataByDiver(';'));
		}
	}

}