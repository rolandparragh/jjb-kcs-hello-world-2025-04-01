package sortingAlgorithm;

public class MinSelectionSort {

	// Minimum kiválasztásos rendezés:
	// Meghatározzuk a legkisebb értékű elemet és kicseréljuk az első elemmel, 
	// a maradék tömbön ugyanezt ismételjük, addig, amíg a tömb nem egy elem marad.
	
	public static void main(String[] args) {
		ArrayHandling arrayHandlingObj = new ArrayHandling();
		int[] numbers = arrayHandlingObj.fillNumberArray(10, 1, 100);
		System.out.print("Az eredeti tömb elemei: ");
		arrayHandlingObj.printArrayToConsole(numbers);
		System.out.println();
		MinSelectionSort minSelectionSortObj = new MinSelectionSort(); 
		minSelectionSortObj.minSelectionSort(numbers);
		
		System.out.print("A rendezett tömb elemei: ");
		arrayHandlingObj.printArrayToConsole(numbers);
	}
	
	private void minSelectionSort(int[] numbers) {
		int temp;
		int minIndex;
		for (int i = 0; i < numbers.length-1; i++) {
			minIndex = i;
			for (int j = i+1; j < numbers.length; j++) {
				if (numbers[j]<numbers[minIndex]) {
					minIndex = j;
				}
			}
			if (i!=minIndex) {
				temp = numbers[i];
				numbers[i] = numbers[minIndex];
				numbers[minIndex] = temp;
			}
			System.out.print((i+1) + ". futás: ");
			ArrayHandling arrayHandlingObj = new ArrayHandling();
			arrayHandlingObj.printArrayToConsole(numbers);
			System.out.println();
		}
	}

}
