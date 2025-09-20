package flyInterfaceExample;

public class Animal {

	private String name;
	private boolean hungry;

	public Animal(String name) {
		super();
		this.name = name;
		this.hungry = true;
	}

	public String getName() {
		return name;
	}

	public boolean isHungry() {
		return hungry;
	}

	public void setHungry(boolean hungry) {
		this.hungry = hungry;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", hungry=" + hungry + "]";
	}

	public void eat() {
		this.hungry = false;
		System.out.println("Animal osztály: " + this.name + " eszik.");
	}

}
