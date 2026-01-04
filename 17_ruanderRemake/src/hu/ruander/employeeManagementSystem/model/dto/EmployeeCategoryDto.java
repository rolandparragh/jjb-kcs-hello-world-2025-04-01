package hu.ruander.employeeManagementSystem.model.dto;

public class EmployeeCategoryDto {

	private int id;
	private String name;
	private boolean status;
	private boolean deleted;
	
	//category statusz és deleted, nem pedig employee

	public EmployeeCategoryDto(int id, String name, boolean status, boolean deleted) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.deleted = deleted;
	}

	public EmployeeCategoryDto( String name, boolean status, boolean deleted) {
		
		this.name = name;
		this.status = status;
		this.deleted = deleted;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isStatus() {
		return status;
	}

	public boolean isDeleted() {
		return deleted;
	}

	@Override
	public String toString() {
return name;
	}

}
