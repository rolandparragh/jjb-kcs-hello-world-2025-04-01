package setInterface;

public class Employee {
	private String name;
	private String role;
	
	public Employee(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}
	
	@Override
    public String toString() {
        return "Employee [name=" + name + ", role=" + role + "]";
    }	
}
