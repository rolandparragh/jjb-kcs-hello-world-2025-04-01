package employeePredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicate {

	// Feladat01: Készítsünk szűrőt, amely visszatér a felnőtt férfiakkal! kész

	// Code Challange:
	// Feladat02: Készítsünk szűrőt, amely visszatér a felnőtt nőkkel! kész
	// Feladat03: Térjünk vissza azokkal, akik adott évnél idősebbek!
	// Feladat04: Listázzunk minden férfit, aki nem "Doe" vezetéknevű!
	// Feladat05: Listázzuk a nőket, vagy 65 évnél idősebbeket!
	public List<Employee> getAdultMaleEmployee(List<Employee> employees) {
		List<Employee> employeeResult = new ArrayList<Employee>();
		for (Employee employee : employees) {
			if (employee.getAge() >= 18 && employee.getGender().equalsIgnoreCase("M")) {
				employeeResult.add(employee);
			}
		}
		return employeeResult;
	}

	// DRY sérül
	public Predicate<Employee> isAdultMale() {
		return e -> e.getAge() >= 18 && e.getGender().equalsIgnoreCase("M");
	}

	public Predicate<Employee> isAdultFemale() {
		return e -> e.getAge() >= 18 && e.getGender().equalsIgnoreCase("F");
	}

	public Predicate<Employee> isOlderThan(int age) {
		return e -> e.getAge() > age;
	}

	public Predicate<Employee> isFemale() {
		return e -> e.getGender().equalsIgnoreCase("F");
	}

	public Predicate<Employee> lastNameIsDoe() {
		return e -> e.getLastName().equalsIgnoreCase("Doe");
	}

	public Predicate<Employee> olderThanNumber(int number) {
		return e -> e.getAge() > number;
	}

	// a dolgozók szűrésére, generikus metódus
	public List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {

		return employees.stream().filter(predicate).collect(Collectors.toList());
	}

}
