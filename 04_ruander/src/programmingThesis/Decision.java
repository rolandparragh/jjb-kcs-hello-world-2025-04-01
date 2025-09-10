package programmingThesis;

public class Decision {

	public static void main(String[] args) {
		// ELdöntés 
		//Egy számsorozatban keresünk egy értéket, 
		// visszatérési érték true or false ( ha benne van vagy nincs) 
		// pl lottó , nem szerepelhet kétszer ugyanaz a szám 
		
		int[] numbers = ArrayHandling.fillNumberArray(20,10,30);
		System.out.println("A tömb elemei");
		
		ArrayHandling.printArrayToConsole(numbers);
		System.out.println();
		int searchValue = 15;
		System.out.println(" FOR Benne van e a "+searchValue+"-ös érték: "+decisionFor(numbers, searchValue) );
		System.out.println(" WHILE Benne van e a "+searchValue+"-ös érték: "+decisionWhile(numbers, searchValue) );
		
	}//main
	//best practice 
	//addig futtatjuk a ciklust amíg a tömb végére nem érünk vagy meg nem találjuk a keresett értéket 
	
	private static boolean decisionWhile(int[] numbers, int searchValue) {
		boolean isThere = false;
		int i = 0;
		while( i<numbers.length && numbers[i]!=searchValue) { //amíg kisebb a numbers length és amíg nem a search value az i
			i++; // addig növeli
		}
		if(i<numbers.length) { // ha kilép és az i < mint a numbers length 
			isThere= true; // akkor átbillenti 
		}
		
		return isThere; // és visszatér 
	}
	
	
	//így túl sokáig fut: ( felesleges futásokat tartalmazhat) ami időveszteség
	private static boolean decisionFor(int[] numbers, int searchValue) {
		boolean isThere = false;
		for (int i = 0; i < numbers.length; i++) {
			
			if(numbers[i] == searchValue) {
				isThere= true;
				//return isThere;  early return de nem CC
				// break; kiugrik a metódus utánra
			}
			
		}
		return isThere;
	}

}//class
