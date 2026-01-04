package hu.ruander.employeeManagementSystem.model.dto;

import java.time.LocalDate;

/*Miért jó a DTO használata? 
 * Adatok tiszta szállítása : A DTO csak az adatokat tartalmazza,
 * és semmilyen üzleti logikát nem valósít meg.
 * Ez tisztán elkülöníti az adatstruktúrát az üzleti logikától,
 * Több réteg közötti adatkommunikáció:
 * DTO egyszerűsíté az adatok mozgatását különböző rétegek között (pl. adatbázis, szolgáltatások, felhasználói felület).
 * Rugalmas és bővíthető: Ha új mezőket kell hozzáadni az adatokhoz, ezt meg tudjuk tenni 
 * a belső logika vagy adatbázis kapcsolat módosítása nélkül 
 * az adatok szérializálása is leegyszerűsödik.
 */


public class EmployeeDto {
	
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private int salary;
	private String identityCard;
	private EmployeeCategoryDto employeeCategory;
	private boolean status;
	private boolean deleted;
	// itt a status és deleted mezők az alkalmazott állapotát jelölik (aktív/inaktív és törölt/nem törölt)
	//nem pedig a Category-hoz tartoznak
	// DI -- Dependency Injection 
	
	public EmployeeDto(int id, String firstName, String lastName, LocalDate dateOfBirth, 
			String identityCard,int salary, EmployeeCategoryDto employeeCategory, boolean status, boolean deleted) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.identityCard = identityCard;
		this.salary = salary;
		this.employeeCategory = employeeCategory;
		this.status = status;
		this.deleted = deleted;
	}

	
	public EmployeeDto( String firstName, String lastName, LocalDate dateOfBirth, 
			String identityCard, int salary, EmployeeCategoryDto employeeCategory, boolean status, boolean deleted) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;

		this.identityCard = identityCard;
		this.salary = salary;
		this.employeeCategory = employeeCategory;
		this.status = status;
		this.deleted = deleted;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public int getSalary() {
		return salary;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public EmployeeCategoryDto getEmployeeCategory() {
		return employeeCategory;
	}

	public boolean isStatus() {
		return status;
	}

	public boolean isDeleted() {
		return deleted;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	public String getStatusText() {
		return status ? "Aktív" : "Inaktív";
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", salary=" + salary + ", identityCard=" + identityCard + ", employeeCategory="
				+ employeeCategory + ", status=" + status + ", deleted=" + deleted + "]";
	}
	
	
}
