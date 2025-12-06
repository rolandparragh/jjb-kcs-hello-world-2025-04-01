package dogWalkerPlanner;

public class Dog {
	
	private int id;
	private String name;
	private int age;
	private int dailyWalkNeed;
	public Dog(int id, String name, int age, int dailyWalkNeed) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dailyWalkNeed = dailyWalkNeed;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getDailyWalkNeed() {
		return dailyWalkNeed;
	}
	
	
	public String getDogsByDivider(char divider) {
		String result ="";
		result += this.id;
		result += divider;
		result += this.name;
		result += divider;
		result += this.age;
		result += divider;
		result += this.dailyWalkNeed;
		
		return result;
	}
}
