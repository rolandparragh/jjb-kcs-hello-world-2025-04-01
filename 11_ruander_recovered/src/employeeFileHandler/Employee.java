package employeeFileHandler;

public class Employee {
	private int id;
	private String lastName;
	private String firstName;
	private String role;
	private int netSalary;
	private boolean active;

	public Employee(int id, String lastName, String firstName, String role, int netSalary, boolean isActive) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.role = role;
		this.netSalary = netSalary;
		this.active = isActive;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getRole() {
		return role;
	}

	public int getNetSalary() {
		return netSalary;
	}

	public boolean isActive() {
		return active;
	}

	public String getFullname() {
		return this.lastName + " " + this.firstName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", role=" + role
				+ ", netSalary=" + netSalary + ", isActive=" + active + "]";
	}

}
