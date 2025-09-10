package programmingThesis;



public class Split {

	public static void main(String[] args) {
		// Kiválogatás tétele: egy halmaz(tömb) elemei közül
		// az adott tulajdonságúakat szétválogatjuk.

		// Feladat: 30 elemü tömböt töltsünk fel véletlen számokkal 1-100 között.
		// A párosakat a páros tömbbe, páratlanokat a páratlan tömbbe helyezzük el.
		// Önálló feladat: Listák nélkül oldjuk meg és tömbökkel és metódusokkal!
		// ArrayHandling.fillNumberArray() megfelelő paraméterekkel használható
		// Alg. lépeseit gondoljuk át, mielőtt nekikezdünk.

		// Nem jó megoldás, ha mindkét tömb maximálisan lehetséges mérete kap
		// memória foglalás 2 X 30 X 4byte
		// int[] evenArray = new int[30]; // mindegyik generált szám pár
		// int[] oddArray = new int[30]; // mindegyik generált szám páratlan
		
		// Alg. lépések:
		// 1. Előkészítés: tömbfeltöltés és kiírás (meglévő metódusok ArrayHandlingben - fillNumberArray())
		// 2. Párosakat darabszámát meghatározzuk - megszámlálás tétele
		// 3. A páros és páratlan tömb létrehozása megfelelő méretben (egyelőre üres)
		// 4. Végigmegyünk az eredeti tömbön, a párosakat a páros, páratlanokat a páratlan tömbbe rakjuk
		// 5. Kiírjuk a páros/páratlan tömb elemeit.
		
		int[] numbers = ArrayHandling.fillNumberArray(30, 1, 100);
		System.out.print("A tömb elemei: ");
		ArrayHandling.printArrayToConsole(numbers);
		System.out.println();
		System.out.println();
		int[] evenArray = new int[countEven(numbers)];
		int[] oddArray = new int[numbers.length - evenArray.length];
		splitArray(numbers, evenArray, oddArray);
		System.out.print("A páros tömb elemei: ");
		ArrayHandling.printArrayToConsole(evenArray);
		System.out.println();
		System.out.print("A páratlan tömb elemei: ");
		ArrayHandling.printArrayToConsole(oddArray);
		System.out.println();
	}
	
	private static void splitArray(int[] numberArray, int[] evenNumbers, int[] oddNumbers) {
		int evenIndex = 0;
		int oddIndex = 0;
		for (int i = 0; i < numberArray.length; i++) {
			if (numberArray[i] %2 == 0) {
				//evenNumbers[i] = numberArray[i]; //hibás megoldás
				evenNumbers[evenIndex] = numberArray[i];
				evenIndex++;
			} else {
				//oddNumbers[i] = numberArray[i]; // hibás
				oddNumbers[oddIndex] = numberArray[i];
				// oddNumbers[oddIndex++] = numberArray[i] // rövidebb szintakszis
				oddIndex++;
			}
		}
	}
	
	private static int countEven(int[] numbers) {
		int count = 0;
		for (int number : numbers) {
			if (number%2==0) {
				count++;
			}
		}
		return count;
	}
	
}
