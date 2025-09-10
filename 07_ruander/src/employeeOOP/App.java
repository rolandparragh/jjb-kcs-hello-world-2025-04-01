package employeeOOP;

public class App {

	public static void main(String[] args) {
		// Feladat01: Kérjük be a felhasználótól, hány dolgozó adatait szeretné megadni,
		// majd
		// töltsünk fel egy megadott méretű tömböt a dolgozói adatokkal!
		// Segítég az algoritmizálás lépéseiben:
		// 1. Egész szám beolvasása külön osztályban: ReadDataFromConsole
//		int arraySizeInput = 4; // a 4-es érték helyett beolvasás lesz, a felhasználótól érkezik
//		Employee[] employees = new Employee[arraySizeInput];
		// 2. for ciklussal employee-s tömb feltöltése: a beolvasásokra készítsünk külön
		// metódusokat tipusok szerint
		System.out.println("Feladat01 - Adatok bekérése");
		EmployeeTasks employeeTasks = new EmployeeTasks();
		// Feladat02: Írjuk ki az adatokat vesszővel elválasztva!
		employeeTasks.printEmployees(',');
		// Feladat04: Írjuk ki a legjobban kereső dolgozó adatait!
		employeeTasks.displayHighestEarningEmployee();

		// Feladat05: Mennyi az átlagbér a cégnél (kivéve igazgatók)?
		// Feladat06: Hány fő programozó van a cégnél, aki aktív?
		System.out.println("Az aktív programozók száma a cégnél: ");
		System.out.println(employeeTasks.countActiveEmployeeBasedOnRole("programozó"));
		// Feladat07: A dolgozók hány százaléka keres 500.000 alatt?
		employeeTasks.getPercentageBelowLimit( 500000);
		// Feladat08: Van -e programozó a cégnél? //Válaszban: Igen van programozó/Nincs
		// programozó
		System.out.println("Van e meghatározott pozició a cégnél?");
		employeeTasks.hasRole("programozó");
		// Feladat09: Kinek mennyi szabadsága maradt? (Employee bővíthető egy egyszerű
		// számítással)
		
	}

}
