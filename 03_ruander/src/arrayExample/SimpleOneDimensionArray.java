package arrayExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;



public class SimpleOneDimensionArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * Tömb : összetett adattípus Több azonos típusú elem tárolására alkalmas, egy
		 * névvel lehet rá hivatkoni az egyes értékeket a tömb nevlvek és indexével
		 * érjük el az indexelés 0 tól kezdődik létrehozáskor meg kell adni milyen
		 * típusú elemeket akarunk benne tárolni meg kell adni a méretét vagy az egyes
		 * elemeket egydimenziós tömb: Vector
		 * 
		 * 
		 * 
		 */
		// deklarációja
		int[] firstNumberArray = { 3, 6, 77, 22, 98, 11, 100 };

		System.out.println(" A 2-es indexen lévő elem: " + firstNumberArray[2]);
		System.out.println(" A 3-mas indexen lévő elem: " + firstNumberArray[3]);
		System.out.println(" A 2. elem a tömbben: " + firstNumberArray[1]);

		firstNumberArray[0] = 1; // elveszik a 3mas érték és 1es kerül a helyére
		System.out.println(" A 2. elem a tömbben: " + firstNumberArray[0]); // 1

		System.out.println(firstNumberArray[6]); // 100
		// System.out.println(firstNumberArray[7]);
		// ArrayIndexOutOfBounds - a tömb határán túlmutató indexre hivatkozunk runtime
		// error

		System.out.println("A tömb mérete: " + firstNumberArray.length);

		// írjuk ki a tömb utolsó elemét
		System.out.println(" A tömb utolsó eleme:" + firstNumberArray[firstNumberArray.length - 1]);

		// Hozzuk létre egy egész számok tárolására alkalmas 20 elemű tömböt , majd
		// írjuk ki az elemeit!
		System.out.println();
		System.out.println(
				"Az első feladat: Hozzuk létre egy egész számok tárolására alkalmas 20 elemű tömböt , majd írjuk ki az elemeit! ");

		int[] numbersDefaultValue = new int[20]; // méretét adtuk meg

		for (int i = 0; i < numbersDefaultValue.length; i++) {
			System.out.print(numbersDefaultValue[i]);

		}

		System.out.println();
		System.out.println();
		// Hozzunk létre egy string tárolásra alkalmas 10 elemű tömböt és írjuk ki az
		// elemeit
		System.out.println(" Hozzunk létre egy string tárolásra alkalmas 10 elemű tömböt");
		String[] stringDefaultValue = new String[10];
		for (int i = 0; i < stringDefaultValue.length; i++) {
			System.out.print(numbersDefaultValue[i]);
		}

		// Feladat03 szövegek tárolása tömbben, John, Jane, Jonnie tárolása majd írjuk
		// ki az elemeit
		String[] nameArray = { "John", "Jane", "Jonnie" };
		for (int i = 0; i < nameArray.length; i++) {
			System.out.print(nameArray[i] + " ");
		}

		// hozzunk létre egy karakter tömböt g T e 2 j p p Ö , írjuk ki az elemeket
		// egymás mellé vesszövel ,de az utolsó elem után ne legyen vessző
		char[] chars = { 'g', 'T', 'e', '2', 'j', 'p', 'p', 'Ö' };
		for (int i = 0; i < chars.length; i++) {
			if (i == chars.length - 1) {
				System.out.println(chars[i]);
			} else {
				System.out.println(chars[i] + ", ");
			}
		}

		// 20 elemű tömb feltöltéssel véletlen számokkal 1-100 között írjuk ki a tömb
		// elemeit egymás mellé szóközzel elválasztva
		int[] numbers5 = new int[20];

		Random r = new Random();
		for (int i = 0; i < numbers5.length; i++) {
			numbers5[i] = r.nextInt(100) + 1;

		}
		System.out.println(" A tömb elemei for ciklussal megjelenítve ");
		for (int i = 0; i < numbers5.length; i++) {
			System.out.println(numbers5[i] + " ");

		}
		System.out.println(" A tömb elemei for each -szerkezettel megjelenítve");
		for (int item : numbers5) {
			System.out.println(item + " ");
		
		} 
		//foreach szerkezet: 
		/*
		 * nem foglalkozik az indexeléssel, bejárja az adatszerkezetünket 
		 * item tetszőleges név felveszi az egyes értékeket az adatszerkezeten belül
		 * azoknál a feladatoknál ahol kell az index ott nem érdemes használni, helyette for ciklus 
		 * foreachen belül nincsen  numbers5[i]
		 * leggyakrabban egy adatszerkezet bejására használjuk 
		 * 
		 */
		
		// Feladat06: 5 elemű tömb feltöltése a felhasználótól érkező egész számokkal.
		// Írjuk ki egymás mellé szóközzel elválasztva az elemeket! A feltöltéskor
		// tájékoztassuk a felhasználót arról, hogy melyik sorszámú értéket adja meg.
		// A feltöltés után írjuk ki, melyik indexen vannak a páros elemek?
		// Amennyiben nem volt ilyen, arról is írjunk üzenetet!
		
		//bekérés
		int[] userInput = new int[5];
		boolean foundEven = false;
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		for (int i = 0; i < userInput.length; i++) {
			System.out.println("Kérem a(z) "+(i+1)+". számot: ");
			userInput[i] = Integer.parseInt(br.readLine());
			
		}
			// páros szám
			
		System.out.print("Páros számok indexei: ");
        for (int i = 0; i < userInput.length; i++) {
            if (userInput[i] % 2 == 0) {
                System.out.print(i + " ");
                foundEven = true;
            }
        }

        if (!foundEven) {
            System.out.println("Nem volt páros szám.");
        }
		
	
	// kiírja a számokat: 
		System.out.println(" A beírt számok: ");
		for (int i = 0; i < userInput.length; i++) {
			System.out.print(userInput[i]+" ");
		}
		
		// Feladat07: Töltsünk fel egy 4 elemű tömböt, megadott törtszámokkal:
		// 55.9, 74.1, 89.9, 1.8. Hozzunk létre egy ugyanilyen méretű egész számok tárolására
		// alkalmas adatszerkezetet (tömböt), majd mentsük bele a számokat lefelé kerekítve.
		
		
		double[] doubleUserInput = {55.9, 74.1, 89.9, 1.8};
		int [] intRoundItDown = new int [4];
		
		for (int i = 0; i < intRoundItDown.length; i++) {
			intRoundItDown[i] =(int) Math.floor(doubleUserInput[i]);
			
		}
		System.out.println(" Lefelé kerekített értékek:");
		for (int value : intRoundItDown) {
			System.out.println( value +" ");
		}

		// Feladat08: Kérjük be a felhasználótól mekkora méretű tömböt szeretne létrehozni,
		// majd töltsük fel a következő lehetséges értékekkel véletlenszerűen:
		// répa, karalábé, krumpli, zeller, hagyma

		
		System.out.println("Hány elemű töböt szeretne létrehozni?");
		String [] userDefined = new String[Integer.parseInt(br.readLine())];
		String[] vegetables = {"répa", "karalábé", "krumpli", "zeller", "hagyma"};
		for (int i = 0; i < userDefined.length; i++) {
			userDefined[i] = vegetables[r.nextInt(vegetables.length)];
			
		}
		for (String items : userDefined) {
		    System.out.println(items+ " ");
		}
		br.close();
	}

}
