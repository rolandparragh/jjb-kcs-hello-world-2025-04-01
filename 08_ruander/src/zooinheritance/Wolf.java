package zooinheritance;

public class Wolf extends Animal {

	private String name;
	private double weight;
	private double witherHeight;
	public Wolf(boolean birthInPlace, String nameOfZoo, String name, double weight, double witherHeight) {
		super(birthInPlace, nameOfZoo); // ős konstruktorára utal 
		this.name = name;
		this.weight = weight;
		this.witherHeight = witherHeight;
	}
	public String getName() {
		return name;
	}
	public double getWeight() {
		return weight;
	}
	public double getWitherHeight() {
		return witherHeight;
	}
	@Override
	public String toString() {
		return "Wolf [name=" + name + ", weight=" + weight + ", witherHeight=" + witherHeight + "]";
	}
	
	public void eat() {
		this.weight++;
		System.out.println("Wolf osztály ( leszármazott osztály) - A farkas súlya evés után: "+this.weight+ " kg.");
		
	}
	public String getNameOfZooFormatted() {
		return "A farkas lakhelye: " + this.nameOfZoo;
	}
	// miért érjük el a nameOfZoot? 
	// mert protected, --> elérhető az ősben és a gyermekosztályban is
}
