package arrayMethods;

// ctrl + shift + o
import java.util.Arrays;

public class ArrayMethodExample {

	public static void main(String[] args) {
		String[] manufacturers = {"Honda","Toyota","BMW","Jaguar"};
		
		//tömb hossza
		System.out.println("A tömb hossza: "+manufacturers.length);
		
		// tömb másolása - klónozás
		String[] manufacturersCopy = manufacturers.clone();
		manufacturersCopy[2] = "Audi";
		System.out.println("Klónozott tömb elemei: ");
		for (String item: manufacturersCopy) {
			System.out.print(item + " "); //Honda Toyota Audi Jaguar 
		}
		System.out.println();
		System.out.println("Eredeti tömb elemei: ");
		for (String item: manufacturers) {
			System.out.print(item + " "); //Honda Toyota BMW Jaguar 
		}
		System.out.println();
		//Egyenlőségjelnél ugyanarra a referenciára mutat, ha megváltoztatjuk valamelyik értékét, akkor mindkettő változik
		// manufacturers = manufacturerCopy;
	
		// equals() vizsgálat
		System.out.println(manufacturers.equals(manufacturersCopy)); //false
		System.out.println(manufacturers.hashCode()); //527446182
		System.out.println(manufacturersCopy.hashCode()); //1511785794
		
		int[] numbers = {22,44,1,51,5};
		
		// fill() - tömb elemeinek feltöltése
		Arrays.fill(numbers,99);
		for (int i : numbers) {
			System.out.print(i + " "); //99 99 99 99 99 
		}
		System.out.println();
		
		int[] numbers2 = {74,85,95,12,13,2};
		Arrays.sort(numbers2);
		for (int i : numbers2) {
			System.out.print(i + " "); //2 12 13 74 85 95  
		}
		
		// Fordított sorrendbe rendezés -> csak listává alakítva lehet megoldani,
		// vagy for ciklus megfelelő paraméterezésével
	}
}
