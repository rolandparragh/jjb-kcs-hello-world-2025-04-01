package zooinheritance;

public class App {

	public static void main(String[] args) {
		/************* Animal osztály példányosítása ****************/
		// Abstract osztállyá alakítjuk át, mert nagyon elvont fogalom
		// Elvont fogalomak: Animal - Élőlény, Ember - Person, Jármű - Vehicle, House - Ház
		// Process - Folyamat 
		// Abstract osztály nem példányosítható, akkor mi értelme van?
		// Absztakt osztálynál minden mukodést a gyermek osztály valósít meg. 
		// Értelmét és mukodését a gyermek osztály adja meg.
		// Ha tartalmaz abstract metódust (nincsen metódus törzse, a működést a gyermek határozza meg), 
		// akkor kötelezően abstractnak kell lennie az osztálynak
		
//		Animal animalObj = new Animal(true, "Zoo Park London");
//		System.out.println("Animal osztály");
//		animalObj.eat();
//		animalObj.sleep(5);
//		animalObj.setBirthInPlace(false);
//		System.out.println(animalObj.getBirthInPlaceText());
//		System.out.println(animalObj.toString());
//		System.out.println();

		/************* Wolf példányosítása ***********************/
		System.out.println("Wolf osztály");
		Wolf wolf = new Wolf(true, "Zoo Park Rome","Akela", 50.0, 60.0);
		System.out.println(wolf.getNameOfZooFormatted()); //Wolf-ban lévő metódust hívja meg
		wolf.eat(); //Wolf-on belülit eat() metódust hívja meg
		wolf.sleep(9); // Animal-on belülit hívja meg, mert a Wolf-ban nincsen ilyen nevű
		System.out.println(wolf.isBirthInPlace()); //true - Animal gettere
		//dangerZone - engedélyezve van a a setter a setBirthInPlace-nél
		wolf.setBirthInPlace(false);
		System.out.println(wolf.isBirthInPlace()); //false
		System.out.println();
		System.out.println("A package-en belüli protected elérése: "+wolf.nameOfZoo);
		// Hol érhető el a protected tagváltozó, tagmetódus?
		// Az osztályon belül ahol létrehozzuk
		// A gyermek osztályban
		// a package-en belül
		System.out.println();
		
		/************* Crocodile példányosítása ***********************/
		//System.out.println("Crocodile osztály");
		// OOP szabályai szerint legtöbbször kerülendő a static használata
		// static is evil?
		// https://stackoverflow.com/questions/7026507/why-are-static-variables-considered-evil
		// Nem OOP-s, a legtöbb OOP-s elvnek nem felel meg.
		// Global state - általános állapot
		// Nem tesztelhető, ezért több hibát tartalmaz.
		// Nem szálbiztos.
		// Serialization - szerializáció nem működik: objektum megjelenítése, mentése, ábrázolás 
		// memóriában, DB, Fájlban - nem lehet menteni az objektum állapotát
		// Nem skálázható.
		// Viszont: 
		// Ha biztosan tudjuk, hogy egy osztályból garantáltan 1 példány jöhetne csak létre, akkor használható:
		// Singleton Pattern: 
		// App osztály - egy gépen 1 példányban fusson az alkalmazás
		// One App - One Config: Configuration Class - Static
		// java is használja Math osztály
				
		System.out.println(Crocodile.getCrocodileDetailsHeaders());
		Crocodile crocodile = new Crocodile("Zoo Park Rome",200.0);
		crocodile.eat();
		crocodile.sleep(10);
		System.out.println("A krokodil súlya: "+crocodile.getWeight());
		System.out.println(crocodile.toString());
		System.out.println();
		System.out.println("A krokodil súlya - no modifier változó elérése (OOP danger): "+crocodile.weight);
		System.out.println();
		
		/************* Bird példányosítása ***********************/
		System.out.println("Bird osztály");
		Bird bird = new Bird(false, "Zoo Park London", "green", 26);
		bird.eat();
		System.out.println("Költési napok száma: "+bird.getPeriodOfBreeding());
		bird.setPeriodBreedingMinusDay();
		bird.sleep(3);
		System.out.println(bird.toString());
		System.out.println();
		System.out.println();
		

		/************* Parrot (gyermek osztály - 3.szint) példányosítása ***********************/
		System.out.println("Parrot osztály");
		Parrot parrot = new Parrot(false, "Zoo Park Budapest", "red-green-yellow", 30,true);
		parrot.eat(); // Bird-ből hívta meg
		parrot.sleep(4); // Animalból hívta meg
		System.out.println("Költési napok száma: "+parrot.getPeriodOfBreeding()); //Bird
		parrot.setPeriodBreedingMinusDay(); // Bird
		parrot.setPeriodBreedingMinusDay();  //Bird
		System.out.println("Költési napok száma (2 nap eltelt): "+parrot.getPeriodOfBreeding()); // Bird
		System.out.println("Képes -e emberi hangot utánozni: "+parrot.isAbleToSimulateHumanVoice()); //Parrot
		System.out.println(parrot.toString()); // Parrot
		
		// Öröklődési láncolat: Animal -> Bird -> Parrot
		// származtatás: extends kulcsszóval történik
				// Fontos szabály és kötöttség: egy gyermeknek egy őse van
				// Gyermekosztály: childClass, subClass, alosztály
				// Szülőosztály: rootClass, ősosztály, parentClass
				
				// Hány szintű lehet az öröklődési láncolat? Nincs korlátja, de 4-5 szintnél nem szokás többet használni
				// Öröklődés előnyei:
				// 1. rövidebb kód
				// 2. DRY elv nem sérül
				// 3. specializálás - általánosítás
				// 4. kód újfelhasználásának eszköze - komponens alapú programozásnál pld. Button öröklődés
				// 5. Struktúráltabb kód
				
				// Öröklődés hátrányai:
				// 1. Kötelező, hogy kapcsolat legyen az ős és gyermek között.
				// 2. Az alá-fölé rendeltségi viszonyt jól kell meghatározni.
				// 3. Nehézkes előre látni és átgondolni, hogy a specializálás/általánosítás része
				// hogyan működjön! UML Class diagrammokkal tervezhető (hasonló, mint a ETK a DB-nél)
				// 4. Öröklődésben sok a kötöttség az osztályok miatti kapcsolatrendszerek miatt!
				// Példa: whisle() - papagáj vagy ember
				// whisle() - fütyülés hangkiadás
				// interface-ek használata a megoldás - iparban jobban elterjed, mint az öröklődés
				// Mindkét technika jelen van: származtatás és az interface-ek is.
		
	}

}
