package stringMethods;

public class StringMethodExample {

	public static void main(String[] args) {
		char[] charArray = {'j','a','v','a','I','s','C','o','o','l'};
		String javaStrObj = new String(charArray); //konstruktor szintaxis
		System.out.println(javaStrObj); //karaktertömbből szöveg jött létre
		
		String javaString2 = "javaIsCool"; 
		System.out.println(javaString2);
		
		// String létrehozásakor a JVM ellenőrzi a string constant poolt. 
		// Ha már van ilyen tartalommal lévő szöveg, akkor nem hozza újra létre.
		// Ugyanarra a referenciára mutat.
		String name1 = "John";
		String name2 = "John";
		System.out.print("name - John ellenőrzés ==:");
		System.out.println(name1==name2); //true
		
		String fruitName1 = "alma";
		String fruitName2 = "alma";
		if (fruitName1==fruitName2) {
			System.out.println("Azononos volt a gyümölcs neve."); //ide megy bele
		} else {
			System.out.println("Különböző volt a gyümölcsnév.");
		}
		
		String firstName1 = "Jane";
		String firstName2 = "jane";
		System.out.println("Keresztnév ellenőrzés: "+firstName1.toLowerCase() == firstName2); //false
		
		//összehasonlítás helyesen:
		if (firstName1.toLowerCase().equals(firstName2)) {
			System.out.println("A két név azonos..."); //ide megy bele jane -jane
		} else {
			System.out.println("A két név különböző...");
		}
		
		String lastName1 = new String("Doe"); //construct sythax: külön obj. lesz mindkettő, külön ref. címmel
		String lastName2 = new String("Doe");
		System.out.println(lastName1==lastName2); //false, mert nem azonos a ref. cím
		// == referencia címet ellenőriz (hashcode-ot)
		
		//charAt(int index) - Adott indexen lévő karakter elérése
		String cityName = "New York";
		System.out.println("2. karakter kiírása a városnévben: "+cityName.charAt(1));
		//System.out.println("2. karakter kiírása a városnévben: "+cityName[1]); //java-ban nem működik (más nyelvekben OK)
		
		// lenght() - szöveghossz lekérdezése 
		System.out.println("cityName hossza: "+cityName.length());
		
		//String.format() - formázott szöveg kiírása
		String piValue = String.format("%.3f%n",Math.PI);
		System.out.println("A pi értéke formázottan: "+piValue);
		
		// substring() - részszöveg képzés
		String meal = "káposztástészta";
		String subMeal = meal.substring(9);
		System.out.println(subMeal); //tészta
		System.out.println(meal.substring(10,13));// ész
		// beginIndex the beginning index, inclusive, endIndex the ending index, exclusive.
		
		//System.out.println(meal.substring(3, 2));//StringIndexOutOfBoundsException
		//System.out.println(meal.substring(2, 30));//StringIndexOutOfBoundsException
		System.out.println(meal.substring(3, 3)); //Nem dob hibát, de nem ír ki semmit
		
		//contains() - tartalmazás vizsgálat - logikai tipussal tér vissza - true vagy false
		System.out.println("Tartalmazás vizsgálat - contains()");
		String animal = "lódarázs";
		System.out.println(animal.contains("ló")); //true
		System.out.println(animal.contains("Ló")); //false, mert caseSensitive (kisbetű/nagybetű különböző) 
		
		if (animal.contains("ló")) {
			System.out.println("Tartalmazza a megadott szót...");
		} else {
			System.out.println("Nem tartalmazza a megadott szót...");
		}
		
		boolean containsResult = animal.contains("ló");
		System.out.println("containsResult: "+containsResult); //true
		
		// equals() - egyenlőség vizsgálat (nem a ==) 
		// logikai vizsgálat - true vagy false-al tér vissza
		// caseSensitive - kisbetű/nagybetű különböző
		String manufacturer = "BMW";
		if (manufacturer.equals("bmw")) {
			System.out.println("A két gyártó megegyezik...");
		} else {
			System.out.println("A két gyártó nem egyezik meg..."); //ide megy bele
		}
		System.out.println("equalsIgnoreCase - kis/nagybetű nem veszi figyelembe: ");
		String programLanguage = "java";
		System.out.println(programLanguage.equalsIgnoreCase("Java")); //true
		
		// Kisbetűssé / nagybetűssé alakítás
		String vegetable = "karaLábÉ";
		System.out.println(vegetable.toLowerCase()); // karalábé 
		System.out.println(vegetable); //karaLábÉ
		vegetable = vegetable.toLowerCase();
		System.out.println(vegetable);  //karalábé
		
		String fruit = "barack";
		System.out.println(fruit.toUpperCase());
		String fruitUpperCase = fruit.toUpperCase(); 
		System.out.println(fruitUpperCase);//BARACK
		
		//trim() - felesleges szóköz/tabulátor (whitespace-ek) eltávolítása elejéről, végéről
		String companyName = "    Apple      Co.   	 ";
		companyName = companyName.trim();
		System.out.println(companyName); //Apple      Co.
		
		//replace() - minden előfordulás cseréje
		String copyRight = "2024 - Copyright - 2024 year";
		copyRight = copyRight.replace("2024","2025");
		System.out.println(copyRight); //2025 - Copyright - 2025 year
		
		//replaceFirst() - első előfordulását cseréli ki
		String copyRight2 = "2024 - Copyright - 2024 year";
		copyRight2 = copyRight2.replaceFirst("2024","2025");
		System.out.println(copyRight2); //2025 - Copyright - 2024 year
		
		//replaceAll() - minden előfordulását kicseréli (ua. mint a sima replace()), viszont regex-et is elfogad paraméterként
		String copyRight3 = "2024 - Copyright - 2024 year";
		copyRight3 = copyRight3.replaceAll("2024","2025"); 
		//[a-zA-Z0-9]{4} regex: illeszkedik alma és a199 nem illeszkedik rá a körte, alm! későbbi anyagrészben
		System.out.println(copyRight3); //2025 - Copyright - 2025 year
		
		//isEmpty() vs. isBlank() - üresség vizságat
		System.out.println("isEmpty() vizsgálat: ");
		String txt = " ";
		System.out.println(txt.isEmpty()); //false //Ha a hossza 0 .lenght() 0-val tér vissza
		
		System.out.println("isBlank vizsgálat: "+txt.isBlank()); //true - teljesen üres vagy whitespace van benne
		
		System.out.println("valueOf(): "+String.valueOf(2)); //"2" átalakítja szöveggé
		
		//indexOf() - a paraméter első előfordulásával tér vissza
		System.out.print("indexOf(): ");
		String javaText = "Java is great, java is awesome...";
		System.out.println(javaText.indexOf("is")); //5
		
		//6-os indextől kezdve: 
		System.out.println("indexOf() két paraméterrel, 6-os idextől kezdve: "+javaText.indexOf("is",6)); //20
	
		//split() - szöveg darabolása elválasztó karakter mentén
		String javaTextToSplit = "Java is the best!!!";
		String[] data = javaTextToSplit.split(" "); 
		System.out.println(data[1]); //is
		for (String item : data) {
			System.out.println(item);
		}
		
		String dateInput = "2024-03-20"; //ISO szabvány szerinti dátum formátum - DB
		String[] dateInputData = dateInput.split("-");
		System.out.println("Év: "+dateInputData[0]); //2024
		System.out.println("Hónap: "+dateInputData[1]); //03
		System.out.println("Nap: "+dateInputData[2]); //20
		
		//join() - split() ellentéte - összefűzés elválasztó karakterrel
		String meal1 = "almás";
		String meal2 = "rétes";
		String mealJoin = String.join("-",meal1, meal2);
		System.out.println(mealJoin);//almás-rétes
	}
}
