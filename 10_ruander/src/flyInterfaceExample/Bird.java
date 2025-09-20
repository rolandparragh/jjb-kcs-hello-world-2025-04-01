package flyInterfaceExample;

public class Bird extends Animal implements Flyable {

	
	public Bird(String name) {
		super(name);
		
	}

	@Override
	public String toString() {
		return "Bird [getName()=" + getName() + ", isHungry()=" + isHungry() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public void fly() {
		System.out.println("repülés közben fárasztja a szárnyait és megéhezik...");
		this.setHungry(true);
		
	}

	@Override
	public void takeOff() {
		System.out.println("Bárhol ügyesen felszáll...");
		
	}

	@Override
	public void land() {
		System.out.println("Bárhol ügyesen leszáll...");
		
		
	}

}
