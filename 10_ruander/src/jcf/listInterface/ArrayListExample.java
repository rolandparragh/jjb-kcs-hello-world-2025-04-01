package jcf.listInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {

	// alkalmazás domain (komplexebb alkalmazásoknál szükséges:
	// Package rendszer segítségével elkülöníthetjük az egyes működéseket (ehhez később még modulok)
	// jcf.listInterface.ArrayListExample
	// app.data.Database
	// app.view.template
	
	public static void main(String[] args) {
		/*
		 * List interface jellemzői: 
		 * 		rendezett Collection,
		 * 		duplikált elemeket is tartalmazhat,
		 * 		dinamikusan tudunk elemket hozzáadni, törölni és beszúrni
		 * 		tömb hátrányait küszöböli ki
		 * 		pozició szerinti (index alapján) elérést tudja
		 * 		keresés
		 * 		Bejárás: iterátor alapú szolgáltatások elérhetőek (foreach)
		 *		Részlista képzés: lehetővé teszi a részlista műveleteket 
		 * 
		 * List interface-n belüli osztályok: 
		 * 		ArrayList (leggyakrabban erre lesz szükség)
		 * 		LinkedList (Láncolt lista)
		 * 		Vector (legacy)
		 * 		Stack (legacy)
		 */

		//int[] numbers = new int[10]; 
		
		// bad practice - nem javasolt ez a szintakszis
		// itt a numberList csak ArrayList lehet, nem konvertálható át mássá
		// nem lesz fleximbilis a kód
		// ArrayList<Integer> numberList = new ArrayList<Integer>();
		 
		// best practice - javasolt forma: flexibilisebb kód, bármikor láncolt listává alakítható
		List<Integer> numberList = new ArrayList<Integer>(); // helyesebb CC szerint numbers név lenne
		 
		// Elemek hozzáadása, egymás után (nem kell indexekkel foglalkozni)
		numberList.add(44);
		numberList.add(74);
		numberList.add(9);
		numberList.add(72);
		numberList.add(4);
		numberList.add(9);
		numberList.add(2);
		
		// Feladat: Lista felhasználása nélkül a 6-os indexre szúrjuk be a 11-et (tömbbel)!
		// Adott indexre való beszúrás - add(index,mit)
		numberList.add(6,11);
		 
		// Elemek kiírása - Debugos listakiírása
		// Feladatoknál, az elemek kiírásánál ne ezt módszert válasszuk
		// vizsgálatra, hibakezelésre való ez a kiírás
		System.out.println(numberList); //[44, 74, 9, 72, 4, 9, 11, 2]
		//Console.WriteLine(numberList); // Generic Collection - Csharp
		
		// Adott indexen lévő elem elérése
		// System.out.println(numberList[0]); // javaban szintaktikai hiba, tömbös szintakszis
		// Console.WriteLine(numberList[0]); // csharpban 44-el visszatér
		
		// helyesen: get(index)
		System.out.println("Első elem a listában: "+numberList.get(0)); //44
		
		// Adott indexen lévő elem törlése: remove(index)
		// Feladat: Lista nélkül töröljük az 1-es indexen lévő elemet - tömbbel (nehéz feladat lenne)
		numberList.remove(1);
		System.out.println("Törlés után az 1-es indexen lévő elem: "+numberList.get(1)); //9
		
		// A lista méretének lekérdezése: size() (tömbnél length(), php-ban count(), c-ben len()
		System.out.println("A lista mérete: "+numberList.size());
		
		// A lista bejárása for ciklussal - implementálja az iterable interface-t
		System.out.print("numberList bejárása for ciklussal: ");
		for (int i = 0; i < numberList.size(); i++) {
			// Tömbkezelés használatából eredő megszokás - hibás
			//System.out.println(numberList[i]); // hibás szintakszis
			// Csharp-ban Console.WriteLine(numberList[i]); // 44, 74, 9, 72, 4, 9, 11, 2
            System.out.print(numberList.get(i) + " ");
		}
		System.out.println();
		
		// Lista bejárása foeach szerkezettel - ha nem kell az index
		System.out.print("numberList bejárása foreach szerkezettel: ");
		for (Integer number : numberList) {
			// System.out.print(numberList.get(i) + " "); // nincs i változó
			System.out.print(number + " ");
        }
		System.out.println();
		
		
		// Code Challange
		// Feladat01: Keressük meg és jelenítsük meg a 9-es érték első előfordulását!
		// Feladat02: Keressük meg a 99-es érték első előfordulását (nincs benne)!
		// Feladat03: Keressük meg a 9-es érték utolsó előfordulását!
		// Feladat04: Tartalmazás vizsgálat - 99-es benne van -e?
		// Melyik prog. tétel? Eldöntés
		// Feladat05: Képezzünk részlistát, amiben csak a 72 és a 4-es szerepel (3. és 4. elem)!
		// Feladat06: Képezzünk részlistát, amiben az 1-es indextől az összes többi szerepel! //9 72 4 9 11 2
		
		// Feladat01: Keressük meg és jelenítsük meg a 9-es érték első előfordulását!
		System.out.println("9-es érték első előfordulása: "+numberList.indexOf(9)); //1
		
		// Feladat02: Keressük meg a 99-es érték első előfordulását (nincs benne)!
		System.out.println("9-es érték első előfordulása: "+numberList.indexOf(99)); //-1
		
		// Feladat03: Keressük meg a 9-es érték utolsó előfordulását!
		System.out.println("9-es érték első előfordulása: "+numberList.lastIndexOf(9)); //4
		
		// Feladat04: Tartalmazás vizsgálat - 99-es benne van -e?
		// Melyik prog. tétel? Eldöntés
		int searchValue = 99;
		if (numberList.contains(searchValue)) {
			System.out.println("A listában szerepel a(z) "+searchValue +" érték!!!");
		} else {
			System.out.println("A listában NEM szerepel a(z) "+searchValue +" érték!!!");
		}
		
		// Feladat05: Képezzünk részlistát, amiben csak a 72 és a 4-es szerepel (3. és 4. elem)!
		List<Integer> numberSubList = new ArrayList<Integer>();
		numberSubList = numberList.subList(2,4);
		System.out.println(numberList);
		System.out.println("Részlista: "+numberSubList); //[72, 4]
		//fromIndex low endpoint (inclusive) of the subListtoIndex: még tartalmazza
		//toIndex: high endpoint (exclusive) of the subList: már nincs benne
		
		// Feladat06: Képezzünk részlistát, amiben az 1-es indextől az összes többi szerepel! //9 72 4 9 11 2 
		List<Integer> numberSubList2 = new ArrayList<Integer>();
		numberSubList2 = numberList.subList(1,numberList.size());
		System.out.println("Részlista2: "+numberSubList2); //[9, 72, 4, 9, 11, 2]
		
		// Üres lista létrehozása szöveges adatok tárolására
				List<String> fruits = new ArrayList<String>();
				fruits.add("szilva");
				fruits.add("körte");
				fruits.add("barack");
				System.out.println(fruits);
				System.out.println("fruits lista mérete: "+fruits.size());
				
				String fruitSearch = "narancs";
				if (fruits.contains(fruitSearch)) {
					System.out.println("Tartalmazza a(z) "+fruitSearch + " gyümölcsöt!!!");
				} else {
					System.out.println("NEM tartalmazza a(z) "+fruitSearch + " gyümölcsöt!!!");
				}

				List<String> vegetables = new ArrayList<String>();
				System.out.println("A vegetables lista üres -e: "+vegetables.isEmpty()); //true
				vegetables.add("répa");
				vegetables.add("karalábé");
				vegetables.add("répa");
				System.out.println("A vegetables lista üres -e (feltöltés után): "+vegetables.isEmpty()); //false
				
				// Ternary operator
				String result = vegetables.isEmpty() ? "Üres a zöldség lista" : "NEM üres a zöldség lista";
				System.out.println(result);
				
				Byte resultByte = (byte) (vegetables.isEmpty() ? 0: 1);
				System.out.println(resultByte);
				
				// Lista deklaráció és definició 3 módszere
				// 1. módszer
				List<String> carManufacturers = new ArrayList<String>() {
					{
						add("BMW");
						add("Ford");
						add("Honda");
					}
				};
				System.out.println(carManufacturers);
				
				// 2. módszer
				List<String> cpuManufacturers = new ArrayList<String>(Arrays.asList("Intel", "AMD"));
				System.out.println(cpuManufacturers);
				
				//3. módszer
				List<String> gpuManufacturers = new ArrayList<String>(List.of("Radeon", "Nvidia"));
				System.out.println(gpuManufacturers);
						
				// Miért van tömb?
				// ArrayList vs. Tömb
				// Használhatunk tömböt... 
				// ha kötött a méret, pld. hét vagy hónap napjai, pesti/budai kerületek
				// ha nincs szükség olyan dinamikus mukodésre, mint adott elem törlése, 
				// vagy adott indexre való pld. beszúrás
				// ArraList-et használjunk helyette, ha
				// komplexebb alg. -ra van szükségünk, rendezés, adott elem törlése/beszúrása
				// dinamikus méretkezelés
				// szükség van egy beépített metódusra, ami a listán belül van csak
				// Miért van akkor egyátalán Array?
				// Háttérben az ArrayList egy tömb - java megoldja a dinamikus mukodést
				// sima Array használatának előnyei: mem. használat, sebesség
				// Konklúzió: legtöbb esetben ArrayList-et használunk, ha nem kell dinamikus működés, akkor tömb
				// HF - Code Challange: Kiválogatás (Split) tételének megoldása ArrayList-tel? Hány sorral lett kevesebb?
		
		
		
	}
}
