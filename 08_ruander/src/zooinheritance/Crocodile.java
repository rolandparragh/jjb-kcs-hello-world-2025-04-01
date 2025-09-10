package zooinheritance;

public class Crocodile extends Animal {

	// no modifier - nincs módosító -az osztályon belül ahol létrehoztuk és package-en belül is elérhető
	// OOP-s szabályokat itt is megszegtünk, mert private adattagoknak kellen lennie
	double weight;


	public Crocodile(String nameOfZoo, double weight) {
		super(nameOfZoo);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Crocodile [weight=" + weight + ", nameOfZoo=" + nameOfZoo + ", getWeight()=" + getWeight()
				+ ", isBirthInPlace()=" + isBirthInPlace() + ", getNameOfZoo()=" + getNameOfZoo()
				+ ", getBirthInPlaceText()=" + getBirthInPlaceText() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	public void eat() {
		this.weight+=5;
		System.out.println("Crocodile osztály (leszármazott osztály) eszik, súlya 5kg-mal gyarapszik...");
	}
	
	public static String getCrocodileDetailsHeaders() {
		return "Crocodile osztály";
	}
}
