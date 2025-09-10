package programmingThesis;

public class Union {

	public static void main(String[] args) {
		// Unio: Tömbökön belül nincs ismétlődés - halmaz.
		// Két halmaz közül legalább az egyikben szerepelnie kell
		// Kollekciókkal (JCF) ugyanez a feladat - 1 sorban megoldható (metszetnél is)
		// Halmaz típusú adatszerkezettel Set interface-n belüli osztályok

		// 13-sortól 20-ig: OOP szerint ki lehetne szervezni egy SetExampleInitialization
		// osztályba - DRY elv sérül, mert ismétlődik a Section-höz képest
		int[] numberArrayA = ArrayHandling.fillNumberArrayWithUniqueNumbers(10, 1, 20);
		int[] numberArrayB = ArrayHandling.fillNumberArrayWithUniqueNumbers(12, 1, 20);
		System.out.print("A numberArrayA elemei: ");
		ArrayHandling.printArrayToConsole(numberArrayA);
		System.out.println();
		System.out.print("A numberArrayB elemei: ");
		ArrayHandling.printArrayToConsole(numberArrayB);
		System.out.println();
		int[] unionArray = fillUnionArray(numberArrayA, numberArrayB);
		System.out.print("A union tömb elemei: ");
		ArrayHandling.printArrayToConsole(unionArray);
		System.out.println();
		// ArrayHandling.printHello(); // szintaktikai hiba: nem statikus
		//Random r = new Random(); - Objektum létrehozása
		ArrayHandling arrayHandlingObj = new ArrayHandling();
		arrayHandlingObj.printHello(); // Leggyakrabban ezzel szintakszissal dolgozunk, OOP elvek alapján: 
		// Működési elve: Van egy osztály, létrehozunk egy objektumot és azon keresztül meghívjuk a metódust lsd. Random.
	}
	
	private static int[] fillUnionArray(int[] numberArrayA, int[] numberArrayB) {
		int unionArraySize = (numberArrayA.length+numberArrayB.length)
				-ArrayHandling.countMatchArrayValue(numberArrayA, numberArrayB);
		int[] unionArray = new int[unionArraySize];
		
		// 1. lépés: Belepakolunk minden elemet a numberArrayA-ból a unionArray-be
		for (int i = 0; i < numberArrayA.length; i++) {
			unionArray[i] = numberArrayA[i];
		}
		
		// 2. lépés: a numberArrayB-ből csak azokat az elemeket rakjuk bele, ami még nincs benne
		int unionIndex = numberArrayA.length; //10-től kezdi a feltöltést
		for (int i = 0; i < numberArrayB.length; i++) {
			if (!ArrayHandling.containsSearchValue(unionArray, numberArrayB[i])) {
				unionArray[unionIndex] = numberArrayB[i];
				unionIndex++;
			}
		}
		return unionArray;
	}

}
