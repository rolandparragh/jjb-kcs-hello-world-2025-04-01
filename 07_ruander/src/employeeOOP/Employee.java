package employeeOOP;

public class Employee {

	private String firstName;
	private String lastName;
	private String role; // beosztás: magyarázó megjegyzés nem CC
	private int salary;
	private int maxHoliday; // max. kivehető szabadság
	private int holidayTaken; // kivett szabadság
	private boolean active = true; // alapérték, defaulvalue megadása
	private int remainingHoliday;

	// kotlin: innentől boilerplate
	public Employee(String firstName, String lastName, String role, int salary, int maxHoliday, int holidayTaken,
			boolean active) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.salary = salary;
		this.maxHoliday = maxHoliday;
		this.holidayTaken = holidayTaken;
		this.active = active;
		this.remainingHoliday = maxHoliday - holidayTaken;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRole() {
		return role;
	}

	public int getSalary() {
		return salary;
	}

	public int getMaxHoliday() {
		return maxHoliday;
	}

	public int getHolidayTaken() {
		return holidayTaken;
	}

	public boolean isActive() {
		return active;
	}

	public String getFullName() {
		return lastName + " " + firstName;
	}

	public String getActiveText() {
		return isActive() ? "aktív" : "inaktív";
	}

	public int getRemainingHoliday() {
		return remainingHoliday;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", salary=" + salary
				+ ", maxHoliday=" + maxHoliday + ", holidayTaken=" + holidayTaken + ", active=" + active
				+ ", remaining holiday: " + remainingHoliday + "]";
	}

	public String getObjDataByDivider(char divider) {
		String result = "";
		result += "Teljes név: " + getFullName();
		result += divider;
		result += "beosztás: " + getFullName();
		result += divider;
		result += "fizetés: " + getFullName();
		result += divider;
		result += "maximális szabadság: " + getFullName();
		result += divider;
		result += "kivett szabadság: " + getFullName();
		result += divider;
		result += "aktív: " + getActiveText();
		result += "fennmaradó szabadság: " + getRemainingHoliday();
		return result;
	}
}
