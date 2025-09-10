package programmingThesis;

public class Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// egy számsorozaton belül megszámoljuk az adott tulajdonságú elemek darabszámát
		// T tulajdonságú elemek : általunk meghatározott

		int[] numbers = ArrayHandling.fillNumberArray(10, 50, 100);
		System.out.print("A tömb elemei:");
		ArrayHandling.printArrayToConsole(numbers);
		System.out.println();
		System.out.print("Ennyi páros volt: ");
		System.out.println(countEven(numbers));
	}//main
	
	private static int countEven(int[] numbers) {
		int count=0;
		for (int number : numbers) {
			if ( number % 2 ==0)
				count ++;
			
		}
		return count;
	}

}
