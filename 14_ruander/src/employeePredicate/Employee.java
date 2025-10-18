package employeePredicate;

public class Employee {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	public Employee(Integer id, String firstName, String lastName, Integer age, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
	public String getDataByDiver(char divider) {
		return id +""+ divider + firstName + divider + lastName + divider + age + divider + gender;
		}

}
