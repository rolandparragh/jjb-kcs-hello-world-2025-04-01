package programmingThesis;

public class Section {

	public static void main(String[] args) {
		// Halmaz: elemek gyűjteménye, melyben az elemek nem ismétlődhetnek (unique)
		// Metszet: azoknak az elemeknek a kiválasztása, amelyek mind a két
		// halmazban megtalálhatóak.
		int[] numberArrayA = ArrayHandling.fillNumberArrayWithUniqueNumbers(10, 1, 20);
		int[] numberArrayB = ArrayHandling.fillNumberArrayWithUniqueNumbers(12, 1, 20);
		System.out.print("A numberArrayA elemei: ");
		ArrayHandling.printArrayToConsole(numberArrayA);
		System.out.println();
		System.out.print("A numberArrayB elemei: ");
		ArrayHandling.printArrayToConsole(numberArrayB);
		System.out.println();
		System.out.println("Egyezőségek száma: "+ArrayHandling.countMatchArrayValue(numberArrayA, numberArrayB));
		int[] sectionArray = fillSectionArray(numberArrayA, numberArrayB);
		System.out.print("A metszet halmaz elmei: ");
		ArrayHandling.printArrayToConsole(sectionArray);
	}

	private static int[] fillSectionArray(int[] numberArrayA, int[] numberArrayB) {
		int[] sectionArray = new int[ArrayHandling.countMatchArrayValue(numberArrayA, numberArrayB)];
		int sectionArrayIndex = 0;
		for (int i = 0; i < numberArrayA.length; i++) {
			if (ArrayHandling.containsSearchValue(numberArrayB, numberArrayA[i])) {
				sectionArray[sectionArrayIndex] = numberArrayA[i];
				sectionArrayIndex++;
			}
		}
		return sectionArray;
	}
}
