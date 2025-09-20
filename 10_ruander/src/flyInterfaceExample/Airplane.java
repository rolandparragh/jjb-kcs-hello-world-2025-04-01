package flyInterfaceExample;

public class Airplane extends Machine implements Flyable, PreFlightCheck {

	public Airplane(String identifier, double fuelLevel) {
		super(identifier, fuelLevel);
		
	}

	@Override
	public void fly() {
		System.out.println("Repül és fogy az üzemanyag...");
		//minden repülés alkalmával 20 egységgel csökken az üzemanyag 
		setFuelLevel(getFuelLevel()-20);
		
	}

	@Override
	public void takeOff() {
		System.out.println("Felszállópálya szükséges...");
		if(this.getFuelLevel()<20) {
			System.out.println("nem szállhat fel, mert kevés az üzemanyag");
		}
		
	}

	@Override
	public void land() {
		System.out.println("Leszállópálya kell neki...");
		
	}

	@Override
	public void selectMechanic() {
		System.out.println("Mérnök kiválasztása rendben...");
		
	}

	@Override
	public void checkEngine() {
		System.out.println("Motor rendben...");
		
	}

	@Override
	public void checkTires() {
		System.out.println("Gumik rendben...");
		
	}

	@Override
	public void checkBrakes() {
		System.out.println("Fékek rendben...");
		
	}

	@Override
	public void completeAdministration() {
		System.out.println("Adminisztráció elvégezve, felszállás engedélyezve...");
		
	}
	
	//nem tudod kötelezni hogy mi legyen benne 
	public void completePreFlightCheck() {
		
		selectMechanic();
		checkEngine();
		checkTires();
		checkBrakes();
		completeAdministration();
		
	}

}
