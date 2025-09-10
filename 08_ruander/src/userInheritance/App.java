package userInheritance;

public class App {

	public static void main(String[] args) {
		// Code Challange:  
				// 1. Hozzunk létre egy User osztályt (ős osztály)
				// userName, password és email tulajdonságokkal
				// saját metódusai: belép, kilép (csak az ősben és a gyermek osztályban valamint a package-ben
				// legyen elérhető)
				
				// 2. Hozzunk létre egy Admin osztályt, amit a Userből származtatunk
				// Egészítsük ki az osztály működését: felhasználó törléssel, jelszó
				// alaphelyzetbe állítással - mindkettőnél a paraméter a User objektum legyen
				// Mindkét metódus legyen private! Viszont az eredményét, azt lássuk az app-on belül!
				// Felhasználó törlése, akkor szükséges, ha az email cím nem tartalmaz @-ot
				// A felhasználó jelszavát, akkor állítjuk alaphelyzetbe, ha a jelszó 123456


		
		User normalUser = new User("normalUser","5879641","user@user.com");
		Admin admin = new Admin("AdminUser","password","admin@user.com");
		User passwordUser = new User("passwordUser","123456","user@user.com");
		User emailUser = new User("emailUser","5555","useruser.com");
		normalUser.userLogin();
		normalUser.userLogout();
		
		admin.displayDeletUser(emailUser);
		admin.displayResetUserPasswordResult(passwordUser);
		
	}

}
