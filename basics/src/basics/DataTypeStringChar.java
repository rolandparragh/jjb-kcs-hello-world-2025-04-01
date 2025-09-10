package basics;

public class DataTypeStringChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 1óra 10 perc --> fontos kell a házihoz nézd vissza 
		// char: primitív típus: egy karakter tárolására alkalmas
				// String: objektum típus, referencia típus
				// max. karakterek száma: 2.147.483.647
				
//				char firstChar = "R"; // szintaktikai hiba "" miatt, helyesen ''
//				char secondChar = 'cs'; // szintaktikai hiba, 2 betű - string
				
				char firstChar = 'r'; // csak a simpla aposztróf (backtick sem)
				System.out.println(firstChar);
				
				// Mikor használjuk: menüpontok a,b,c stb. Kategóriáknál '1','2','3', Nemeknél 'M' vagy 'F' 'O'

				String firstName; //deklaráció
				firstName = "John"; // definició
				String lastName = "Doe"; //egyben def. és deklaráció
				System.out.println("Üdvözöllek: "+firstName + " "+lastName +"!");
				
				// speciális karakterek : \ iránya!!!!!
				// \n: új sor: new line character
				// \t: tabulátor
				// \b: backspace
				
				String text1 = "Ez egy java \n String";
				System.out.println(text1);
				
				String text2 = "Ez egy\t java String";
				System.out.println(text2);
				
				/********************** NAGYON FONTOS ************************************/
				//1. SZÖVEGEK összehasonlítása
//				if (text1==text2) { -- hibás megoldás, mert a hashCode-ot hasonlítja össze
//				} 
				//helyette helyesen az equals használjuk
//				if (text1.equals(text2)) {
//				}		
				
				String txt = "javaJob";
				System.out.println(txt.equals("javajob")); //true vagy false: false, mert caseSensitive (kisbetű/nagybetű érzékeny)
				System.out.println(txt.equals("javaJob")); // true
				System.out.println(txt.equalsIgnoreCase("javajob")); //true
				
				String fullName1 = "John Doe"; // hashcode: 587f72f
				String fullName2 = "John Doe";
				if (fullName1 == fullName2) { // hashCode-okat hasonlít össze (referencia címeket) 
					System.out.println("1. A két név azonos..."); // Ide megy bele...
				} else {
					System.out.println("2. A két név különböző...");
				} // ebből az következik, hogy a fullName1-nek és fullName2-nek a ref. címe azonos
				
				if (fullName1=="John Doe") { 
					System.out.println("A két név azonos"); //ide megy bele
				} else {
					System.out.println("A két név különböző");
				}
				
				// Hibás működés, ha a szöveg tartalmát szeretnénk összehasonlítani
				String fullNameObj = new String("John Doe"); // konstruktor szintakszis - kap egy másik hashCode-ot
				if (fullName1==fullNameObj) { 
					System.out.println("A két név azonos"); 
				} else {
					System.out.println("A két név különböző");//ide megy bele, mert más lesz a ref. címe
				}
				
				//Ezt a szintakszist használjuk - ez a helyes
				if (fullName1.equals(fullName2)) { 
					System.out.println("A két név azonos"); //ide megy bele
				} else {
					System.out.println("A két név különböző");
				}
				
				// String Pool-ba kerülnek a szövegek, ha azonos a tartalma, akkor 
				// hashcode azonos lesz mindkét változónak
				
				// https://www.baeldung.com/java-string-pool
				// https://www.geeksforgeeks.org/string-constant-pool-in-java/
				
				// 2.String immutable object: nem lehet megváltoztatni a benne lévő karaktereket
				// elérni el lehet, de megváltoztatni nem
				// read-only: csak olvasható
				
				//System.out.println("text2 első karakter: "+text2[0]); // Charp-ban működik, javaban nem (szöveg karakterből álló tömb)
				System.out.println("text2 első karakter: "+text2.charAt(0)); //E
				//text2.charAt(0)= 'e'; //szintaktikai hiba, nem hajtja végre
//				System.out.println("text2 99. indexen lévő karakter (ami nincs): "+text2.charAt(99));  //StringIndexOutOfBoundsException
			
				// Read-only, de szeretnénk felülírni:
				// 1. megoldás: szövegmásolgatások
				// 2. megoldás: String builder (később)
				// 3. megoldás: Stringkezelő metódusok (később)
		
		
		
	}

}
