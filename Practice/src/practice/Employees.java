package practice;

public class Employees {
	
	private int id;
	private String name;
	private String department;
	private double salary;
	public Employees(int id, String name, String department, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public double getSalary() {
		return salary;
	}

	public String getEmployeesByDivider(char divider) {
		String result = "";
		result += this.id;
		result += divider;
		result += this.name;
		result += divider;
		result += this.department;
		result += divider;
		result += this.salary;
		
		return result;
	}
	
	

	

}
