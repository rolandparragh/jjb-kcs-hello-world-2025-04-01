package flyInterfaceExample;

public class App {

	public static void main(String[] args) {
		System.out.println("Madár példányosítása: ");
		Bird bird = new Bird("Csőrike");
		System.out.println("A " + bird.getName() + " éhes -e? " + bird.isHungry());
		if (bird.isHungry()) {
			bird.eat();
		}
		System.out.println("A " + bird.getName() + " éhes -e evés után? " + bird.isHungry());
		bird.takeOff();
		bird.fly();
		bird.land();
		System.out.println("A " + bird.getName() + " éhes -e repülés után? " + bird.isHungry());
		System.out.println();

		System.out.println("Airplane példányosítása: ");
		System.out.println("Airplane1 ...");
		Airplane airPlane1 = new Airplane("W2278", 10);
		System.out.println("A(z) " + airPlane1.getIdentifier() + " azonositójú repülőgép üzemanyagmennyisége: "
				+ airPlane1.getFuelLevel());
		airPlane1.fillFuel(50);
		airPlane1.fillFuel(30);
		airPlane1.takeOff();
		airPlane1.fly();
		airPlane1.land();
		System.out.println("A(z) " + airPlane1.getIdentifier() + ""
				+ " azonosítójú repülőgép üzemanyagmennyisége ( replülés után)" + airPlane1.getFuelLevel());

		// Code challenge
		// Feladat01: W2279 azonosítóval és 8 egység üzemanyaggal hozzunk létre
		// repülőgépet mielőtt tankolunk szálljunk vele fel
		// kiséreljük meg a felszállást
		System.out.println(" AirPlane2 ...");
		Airplane airPlane2 = new Airplane("W2279", 8);
		System.out.println("A(z) " + airPlane2.getIdentifier() + " azonositójú repülőgép üzemanyagmennyisége: "
				+ airPlane2.getFuelLevel());
		airPlane2.completePreFlightCheck();
		airPlane2.takeOff();
		// Feladat02: Hozzunk létre egy külön interfacet a következő viselkedésekkel:
		// mérnök kiválasztása
		// motor ellenőrzése
		// gumik ellenőrzése
		// fékek ellenőrzése
		// adminisztráció elvégzése
		// Implementáljuk ezt az interfacet az airplane

	}

}
