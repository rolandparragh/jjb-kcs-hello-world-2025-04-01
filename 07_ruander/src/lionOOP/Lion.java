package lionOOP;

import java.util.Random;

public class Lion {

	private String name;
	private byte age;
	private double weight;
	private byte huntPerWeek;

	public Lion(String name, byte age, double weight, byte huntPerWeek) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.huntPerWeek = huntPerWeek;
	}

	public String getName() {
		return name;
	}

	public byte getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}

	public byte getHuntPerWeek() {
		return huntPerWeek;
	}

	@Override
	public String toString() {
		return "Lion [name=" + name + ", age=" + age + ", weight=" + weight + ", huntPerWeek=" + huntPerWeek + "]";
	}

	public String getDetails() {
		return "Oroszlán [név=" + name + ", életkora=" + age + ", súlya=" + weight + " kg, heti vadászatok száma="
				+ huntPerWeek + "]";
	}
	public void sleep(int hour) {
		this.weight -=hour*0.1;
	}
	public void eat() {
		this.weight +=+4.0;
	}
	public void hunt(boolean isSuccessful) {
		if (isSuccessful) {
		    eat();
		} else {
		    this.weight -= 3;
		}
	}
	
	
	public void weekHunt() {
		//1 sikeres 2 sikertelen 
		Random r = new Random();
		int randomNumber;
		for (int i = 0; i < this.huntPerWeek; i++) {
			randomNumber = r.nextInt(2)+1;
			if(randomNumber ==1) {
				this.hunt(true);
			}
			else {
				this.hunt(false);
			}
		}
	}
}
