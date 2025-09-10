package zooinheritance;

public abstract class Animal {
// public class Animal{
	private boolean birthInPlace;
	protected String nameOfZoo;

	public Animal(boolean birthInPlace, String nameOfZoo) {
		super(); // az ős konstruktorára utal
		this.birthInPlace = birthInPlace;
		this.nameOfZoo = nameOfZoo;
	}

	public Animal(String nameOfZoo) {
		this.nameOfZoo = nameOfZoo;
	}
	public boolean isBirthInPlace() {
		return birthInPlace;
	}

	public String getNameOfZoo() {
		return nameOfZoo;
	}

	// publikus setter sérti az OOP szabályait ritkán engedélyezzük
	public void setBirthInPlace(boolean birthInPlace) {
		this.birthInPlace = birthInPlace;
	}

	public void eat() {
		System.out.println("Ősosztály (Animal) - Az állat eszik! ");
	}

	public void sleep(int hour) {
		System.out.println("Ősosztály (Animal) - Az állat " + hour + " órát alszik...");
	}

	public String getBirthInPlaceText() {
		String result=( "Másik állatkertből került ide...");
		if ( this.isBirthInPlace()) {
			result = ("Az állat helyben született: "+this.nameOfZoo);
		}
		return result;
	}

	@Override
	public String toString() {
		return "Animal [birthInPlace=" + birthInPlace + ", nameOfZoo=" + nameOfZoo + "]";
	}

}
