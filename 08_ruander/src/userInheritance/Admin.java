package userInheritance;

public class Admin extends User {

	public Admin(String userName, String password, String email) {
		super(userName, password, email);
	}

	private boolean deletUser(User user) {
		boolean hasToBeDeleted = false;
		if (!user.getEmail().contains("@")) {
			hasToBeDeleted = true;
		}
		return hasToBeDeleted;
	}

	public void displayDeletUser(User user) {
		if (deletUser(user)) {
			System.out.println("A felhasználó: " + user.getUserName() + " email címe nem tartalmaz @ karaktert"
					+ " A felhasználó törlésre kerül");
		} else {
			System.out.println("Nem szükséges a törlés!");
		}
	}

	private boolean resetUserPassword(User user) {

		boolean haveToDelete = false;
		if (user.getPassword().equals("123456")) {
			haveToDelete = true;
		}
		return haveToDelete;
	}

	public void displayResetUserPasswordResult(User user) {
		if (this.resetUserPassword(user)) {
			System.out
					.println("Admin: Alaphelyzetbe állítja a jelszót a következő usernek:" + " " + user.getUserName());
		} else {
			System.out.println("Admin: Nem szükséges a jelszót alaphelyzetbe állítani...");
		}
	}
}
