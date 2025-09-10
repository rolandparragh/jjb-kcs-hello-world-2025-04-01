package programmingThesis;

public class SelectMinValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// egy számsorozaton belül keresi a legkisebb értékű elemet
		int[] numbers = ArrayHandling.fillNumberArray(15, 10, 50);
		System.out.print("A tömb elemei ");
		ArrayHandling.printArrayToConsole(numbers);
		System.out.println();
		
		System.out.println("A tömbben a legkisebb érték: " +getMinValue(numbers));
	}
	
	private static int getMinValue(int[] numbers) {
		int minValue = numbers[0];
		for (int number : numbers) {
			if(number < minValue) {
				minValue = number;
			}
			
		}
		
		return minValue;
	}

}
