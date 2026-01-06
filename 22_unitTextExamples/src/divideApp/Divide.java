package divideApp;

public class Divide {

	
	public Double divide(double divident, double divider) {
		if (divider ==0) {
			throw new IllegalArgumentException("Cannot divide by 0"); //implicit hibakezelés 
			
			
		}
		return divident/divider;
	}
	
}
