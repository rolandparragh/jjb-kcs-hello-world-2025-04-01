package flyInterfaceExample;

public interface PreFlightCheck {
	
	// Feladat02: Hozzunk létre egy külön interfacet a következő viselkedésekkel:
			// mérnök kiválasztása
			// motor ellenőrzése
			// gumik ellenőrzése
			// fékek ellenőrzése
			// adminisztráció elvégzése
			// Implementáljuk ezt az interfacet az airplane
	public void selectMechanic();
	public void checkEngine();
	public void checkTires();
	public void checkBrakes();
	public void completeAdministration();

}
