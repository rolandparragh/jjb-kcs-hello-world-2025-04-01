package sortingAlgorithm;

public class BubbleSort {

	public static void main(String[] args) {
		ArrayHandling arrayHandlingObj = new ArrayHandling();
		int[] numbers = arrayHandlingObj.fillNumberArray(100000, 1, 100);
		System.out.print("Az eredeti tömb elemei: ");
		arrayHandlingObj.printArrayToConsole(numbers);
		System.out.println();
		BubbleSort bubbleSortObj = new BubbleSort();
		bubbleSortObj.bubbleSort(numbers);
		System.out.print("A rendezett tömb elemei: ");
		arrayHandlingObj.printArrayToConsole(numbers);
	}

	private void bubbleSort(int[] numbers) {
		int temp;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length-i-1; j++) {
				if (numbers[j]>numbers[j+1]) {
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
	}
}
// Rendező alg. összehasonlítása
// Milyen hatékonysági szempontok vannak?
// Hány lépésből áll?
// Mennyi idő alatt fut le?
// Hány darab összehasonlítást végez?
// Hány cserét hajt végre?
// Memóriahasználat és erőforrás használat.

// Önálló projekt: Hasonlítsuk össze a rendező alg.-at.
// Nagyméretű adatokon érdemes dolgozni, hogy látszódjon a kulonbség
// cserék száma, összehasonlítások szám,  idő (kutatómunka)
// Legalább 5 alg. Egyszerű cserés rendezés, MinKiválasztás, Buborék, Quick sort (gyors rendezés),
// Beszurásos rendezés
// Gyors rendezés a leghatékonyabb.
// adatszerkezet.sort() - javaban a beépített metódusok a gyorsrendezést használják

// https://www.baeldung.com/java-measure-elapsed-time