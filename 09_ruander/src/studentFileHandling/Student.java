package studentFileHandling;

//Pojo
public class Student {
	private String name;
	private int height;
	private int weight;

	public Student(String name, int height, int weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}

	public String getStudentDetails() {
		return "Név: " + name + ", magasság: " + height + "cm, súly: " + weight + "kg.";
	}
}
