package mapInterface;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {
		// Map interface: kulcs-értékpárokat tartalmazó adatszerkezet
		// Jellemzői:
		// - duplikált elemeket nem tartalmazhat (kulcsnak egyedinek kell lennie)
		// - kulcs alapu műveletekre van műveletek végezhetőek egyszerűen benne
		// - rendezett formája: SortedMap
		// Map interface-t megvalósító (implementáló) osztályok
		// HashMap, LinkedHashMap
		// Mi a különbség a Hashtable és HashMap között?
		// Hashtable -> java 1.7 óta elvult(deprecated)
		// Hashtable -> többszálú feldolgozásra alkalmas
		// HashMap -> nem szálbiztos, többszálú feldolgozásra nem alkalmas
		// helyette alkalmazható a syncronizedMap, concurrentHashMap
		// HashMap -> iterable interface-en belül van - for vagy foreach használható
		// Hashtable -> Enumeration interface-en belül van - while-al lehet bejárni (vagy a többi módszer)
		// Konkluzió: HashMap-et érdemesebb használni kulcs-értékpár tárolásra, de
		// ha többszálú feldolgozásra van szükség, akkor használjuk syncronizedMap-et
		// vagy concurrentHashMap-et.

		// bad practice - nem rugalmas, nem flexibilis - csak HashMap-ként használható
		// HashMap<String, Integer> fruitprices = new HashMap<String, Integer>();
		// best practice - javasolt forma: rugalmasabb, flexibilis
		Map<String, Integer> fruitPrices = new HashMap<String, Integer>();
		fruitPrices.put("alma", 750);
		fruitPrices.put("szilva", 450);
		fruitPrices.put("barack", 980);
		
		System.out.println(fruitPrices);//{szilva=450, barack=980, alma=750}
		fruitPrices.put("alma", 790);
		System.out.println(fruitPrices);//{szilva=450, barack=980, alma=790}
		
		// HashMap bejárás foreach szerkezettel:
		for (Map.Entry<String,Integer> item : fruitPrices.entrySet()) {
			System.out.println("Kulcs: "+item.getKey() +", érték: "+item.getValue() +" Ft");
		}
		
		//fruitPrices.clear(); // kulcs-értékpárral együtt kitörli az összes adatot
		
		// kulcs tartalmazás vizsgálat (van -e ilyen kulcs):containsKey()
		System.out.println("Van -e alma kulcs: "+fruitPrices.containsKey("alma")); //true
		
		// érték tartalmazás vizsgálat (van -e ilyen érték): containsValue()
		System.out.println("Van -e 450-es ár: "+fruitPrices.containsValue(450)); // true
		System.out.println("Van -e 460-es ár: "+fruitPrices.containsValue(460)); // false
		
		// kulcshoz tartozó érték meghatározása- Mennyibe kerül a szilva?
		System.out.println("A szilva ára: "+fruitPrices.get("szilva") + " Ft");
		
		// Probléma: Érték alapján térjünk vissza a kulccsal: Melyik gyümölcs kerül 450Ft-ba?
		// HashMap - kulcs alapján való működést valósít meg. Érték tartalmazás vizsgálat van lsd 6 sorral feljebb
		// Szótáras feladatnál megoldandó kérdés  -ott megoldjuk...
		
		System.out.println("Üres -e a fruitPrice-s változó: "+fruitPrices.isEmpty()); // false
		
		// kulcs-értékpár törlése kulcs alapján - remove()
		fruitPrices.remove("szilva");
		System.out.println(fruitPrices); //{barack=980, alma=790}
		
		fruitPrices.remove("szőlő"); // nem dob hibát, de nem hajtja végre, mert nincs ilyen kulcs
		System.out.println(fruitPrices); //{barack=980, alma=790}
		
		fruitPrices.replace("szőlő", 1200); // nincs ilyen kulcs, nem hajtja végre
		fruitPrices.replace("barack", 1200);
		System.out.println(fruitPrices); //{barack=1200, alma=790}
		
		// replace vs put azonos kulccsal
		fruitPrices.replace("barack", 980,1300); // régi árának megadása hibás, nem hajtja végre
		System.out.println(fruitPrices); //{barack=1200, alma=790}
		fruitPrices.replace("barack", 1200,1300);
		System.out.println(fruitPrices); // {barack=1300, alma=790}
		
		// mérete - size() - 1 db elem kulcs-értékpárból áll: 2
		System.out.println("fruits mérete: "+fruitPrices.size());
	}

}
