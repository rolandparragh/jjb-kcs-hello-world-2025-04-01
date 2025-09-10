package programmingThesis;

public class Selection {

	public static void main(String[] args) {
		// Kiválasztás (hasonló, mint az eldöntés): 
		// Egy sorozaton belül megkeressük egy adott elemet (indexét).
		// Fontos: tudjuk azt biztosan, hogy benne van a sorozatban.
		// Pszedudó kód: - mondatszerű leírás
		// Eljárás: Kiválasztás
		// i:=1 
		// Ciklus amíg A[i] nem T tulajdonságú
		// 		i:=i+1
		// Ciklus vége
		// Sorszám:i

		int[] numbers = {3,6,9,23,11,55,6,89,1,66,89};
		System.out.print("A tömb elemei: ");
		ArrayHandling.printArrayToConsole(numbers);
		System.out.println();
		// int searchValue = 20;// hibára fut, mert nincs ilyen érték: túlcímezzük a tömböt
		int searchValue = 11;
		System.out.println("Ezen az indexen található a(z) "+searchValue +
				": "+select(numbers, searchValue) + " index");
	}

	
	private static int select(int[] numbers, int searchValue) {
		int i = 0;
		while (numbers[i]!=searchValue) {
			i++;
		}
		return i;
	}
}
