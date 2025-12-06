package application.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//snake_case vs.camelCase
	// Hibernate itt nem találja meg automatikusan a user_name oszlopot
	// Megjegyzés: SpringBoot - Hibernate megtalálja
	@Column(name="user_name")
	private String userName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	// adattag neve ua. a táblában, nincs szükség @Column-ra
	private String password;

	public UserDto(Long id, String userName, String firstName, String lastName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + "]";
	}
}
