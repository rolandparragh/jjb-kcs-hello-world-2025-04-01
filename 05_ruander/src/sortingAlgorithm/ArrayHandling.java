package sortingAlgorithm;

import java.util.Random;

public class ArrayHandling {

	public int[] fillNumberArray(int elementNumber, int lowerLimit, int upperLimit) {
		int[] numbers = new int[elementNumber];
		Random r = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = r.nextInt((upperLimit - lowerLimit) + 1) + lowerLimit;
		}
		return numbers;
	}
	
	public void printArrayToConsole(int[] numberArray) {
		for (int item : numberArray) {
			System.out.print(item + " ");
		}
	}
	
}//class