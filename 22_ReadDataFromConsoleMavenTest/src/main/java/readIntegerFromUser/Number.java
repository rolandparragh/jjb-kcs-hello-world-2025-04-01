package readIntegerFromUser;

public class Number {
	
	private int number;

	public Number(int number) {
		super();
		this.number = number;
	}


	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Number [number=" + number + "]";
	}
	
	

}
