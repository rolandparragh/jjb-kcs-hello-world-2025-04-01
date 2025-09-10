package programmingThesis;

import java.util.Random;

/**
 * ArrayHandling - Print array elements, fill array 
 * 
 */
public class ArrayHandling {

	// Nincs main metódus, nem tudjuk futtatni ezt az állományt, 
	// azért public, mert szeretnénk elérni másik osztályban
	// private: csak az adott osztályban érhető el, ahol létrehozod
	// 1X szerepel a kiírás: progromozásnál javasolt megközelítés: 1 funkció 1 helyen - CC
	// static is evil - OOP paradigma alapján (de vannak kivételek)	
	public static void printArrayToConsole(int[] numberArray) {
		for (int item : numberArray) {
			System.out.print(item + " ");
		}
	}
	
	/**
	 * Fill number array by parameters.
	 * @author BL
	 * @param elementNumber size of array
	 * @param lowerLimit pseudo random number min value: inclusive
	 * @param upperLimit pseudo random number max value: inclusive
	 * @return int[]: integer array
	 */
	public static int[] fillNumberArray(int elementNumber, int lowerLimit, int upperLimit) {
		int[] numbers = new int[elementNumber];
		Random r = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = r.nextInt((upperLimit-lowerLimit)+1)+lowerLimit;
		}
		return numbers;
	}
	
	// HF-nál felhasználható: lottós feladatoknál - ahol egyedi értékeket kell generálni 
	// Feladat: Hozzunk létre metódust fillNumberArrayWithUniqueNumbers(), 
	// paraméterként kapja meg az elemek számát, az intervallum határait! Egyedi elemekkel 
	// töltsük fel! Tömbbel térjünk vissza, melyben egyedi elemek szerepelnek!
	public static int[] fillNumberArrayWithUniqueNumbers(int elementNumber, int lowerLimit, int upperLimit) {
		int[] numbers = new int[elementNumber];
		Random r = new Random();
		int randomNumber;
		for (int i = 0; i < numbers.length; i++) {
			do {
				randomNumber = r.nextInt((upperLimit-lowerLimit)+1)+lowerLimit;
			} while (containsSearchValue(numbers,randomNumber)); // addig futtatja a whilet amíg igazat kap!!!!
			numbers[i] = randomNumber; // megfelelő számot generált le, ami még nincs benne a tömbben
//			i--; // lehetőség szerint kerüljük
		}
		return numbers;
	}
	
	
	// metszet, uniohoz szükséges:
	public static boolean containsSearchValue(int[] numbers, int searchValue) {
		boolean contains = false;
		int i = 0;
		do {
			if (numbers[i] == searchValue) { 
				
				contains = true;
			}
			i++;
		} while (i < numbers.length  && !contains); // addig megy amíg nem talál egyezést vagy vége nincs a tömbnek 
		return contains;
	}
	
	// egyezőségek számával tér vissza
	public static int countMatchArrayValue(int[] numberArrayA, int[] numberArrayB) {
		int count = 0;
		for (int i = 0; i < numberArrayA.length; i++) {
			if (containsSearchValue(numberArrayB, numberArrayA[i])) {
				count++;
			}
		}
		return count;
	}
	
	// Random r = new Random();
	// r.nextInt() -- objektumon keresztül hívjuk meg az osztályon belüli metódust
	// Math.pow() -static - nincs példányosítás
	public void printHello() {
		System.out.println("Hello!");
	}
	
}
