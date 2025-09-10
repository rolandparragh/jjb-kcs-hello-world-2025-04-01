package programmingThesis;

public class Summary {

	public static void main(String[] args) {
		/*összegzés tétele: 
		 * egy számsorozat elemeinek összegét határozza meg
		 * pl heti összbevétel 
		 */
		
		int[] numbers = {3,6,9,23};
		System.out.println("A tömb elemei:");
		ArrayHandling.printArrayToConsole(numbers);
		
		System.out.println();
		System.out.print(" A tömb elemeinek összege: ");
		System.out.println(calculateNumberArraySum(numbers));
		
		//átlagszámítás
		System.out.print("A tömb elemeinek átlagal: ");
		System.out.println((double) calculateNumberArraySum(numbers)/numbers.length);
	}//main 
	
	
	private static int calculateNumberArraySum(int[] numberArray) {
		int sum = 0;
		for (int i = 0; i < numberArray.length; i++) {
			sum += numberArray[i];
		}
		return sum;
		
	}

}
