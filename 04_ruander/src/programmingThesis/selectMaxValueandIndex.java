package programmingThesis;

public class selectMaxValueandIndex {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// egy számsorozaton belül keresi a legnagyobb értékű elemet
		
		//melyik a legnagyobb érték
		// melyik a legnagyobb érték első indexe? 
		int[] numbers = ArrayHandling.fillNumberArray(15, 10, 50);
		System.out.print("A tömb elemei ");
		ArrayHandling.printArrayToConsole(numbers);
		System.out.println();
		System.out.println("A tömb legnagyobb eleme: "+getMaxValue(numbers));
		System.out.println();
		System.out.println("Az indexe:"+getIndex(numbers));
	}
	private static int getMaxValue(int[] numbers) {
		int max = numbers[0];
		for (int number : numbers) {
			if( number > max) {
				max = number;
			}
			
		}
		return max;
	}
	
	private static int getIndex(int[] numbers) {
		int max = numbers[0];
		int index= 0;
		for (int i = 0; i < numbers.length; i++) {
			if( numbers[i] > max) {
				max = numbers[i];
				index = i;
		}
			
		}
		return index;
	}
	
	
}
