package zooinheritance;

public class Bird extends Animal {
	private String color;
	private int periodOfBreeding;

	public Bird(boolean birthInPlace, String nameOfZoo, String color, int periodOfBreeding) {
		super(birthInPlace, nameOfZoo);
		this.color = color;
		this.periodOfBreeding = periodOfBreeding;
	}

	public String getColor() {
		return color;
	}

	public int getPeriodOfBreeding() {
		return periodOfBreeding;
	}

	public void eat() {
		System.out.println("Bird osztály eszik - csipeget...");

	}

	@Override
	public String toString() {
		return "Bird [color=" + color + ", periodOfBreeding=" + periodOfBreeding + ", nameOfZoo=" + nameOfZoo
				+ ", getColor()=" + getColor() + ", getPeriodOfBreeding()=" + getPeriodOfBreeding()
				+ ", isBirthInPlace()=" + isBirthInPlace() + ", getNameOfZoo()=" + getNameOfZoo()
				+ ", getBirthInPlaceText()=" + getBirthInPlaceText() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	public void setPeriodBreedingMinusDay() {
		this.periodOfBreeding -= 1;
	}

}
