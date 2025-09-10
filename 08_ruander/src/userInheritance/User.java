package userInheritance;

public class User {

	
	private String userName;
	private String password;
	private String email;
	
	public User(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}
	// ős gyermek és packageben elérhető csak 
	
	protected void userLogin() {
		System.out.println(getUserName()+" logged in...");
	}
	protected void userLogout() {
		System.out.println(getUserName()+" logged out...");
	}
}
