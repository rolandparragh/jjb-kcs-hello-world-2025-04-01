package sortingAlgorithm;

public class SimpleChangeSort {

	public static void main(String[] args) {
		ArrayHandling arrayHandlingObj = new ArrayHandling();
		int[] numbers = arrayHandlingObj.fillNumberArray(10, 1, 100);
		// int[] numbers =
		// ArrayHandling.fillNumberArrayByIntervallasAndElementNumber(10, 1, 100);
		// Hibás, mert nem statikus
		System.out.println("Az eredeti tömb elemei: ");
		arrayHandlingObj.printArrayToConsole(numbers);
		SimpleChangeSort simpleChangeSortObj = new SimpleChangeSort();
		simpleChangeSortObj.arraySimpleChangeSort(numbers);
		System.out.println();
		System.out.println("A rendezett tömb elemei: ");
		arrayHandlingObj.printArrayToConsole(numbers);
	}

	private void arraySimpleChangeSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = temp;
				}
			}
		}
	}

}
