package enumerationInterfaceExample;

import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;


public class HashtableExample {

	public static void main(String[] args) {
		// Kulcs-értékpárokban történik az adattárolás
		// Kulcs fontos tulajdonsága, hogy nem ismétlődhet (egyedi)
		// Másik kulcs kaphat azonos értéket
		// 1.7 (elavult - deprecated) - Legacy
		// <K> the type of keys maintained by this map<V> the type of mapped values
		// Kulcs alapján való műveletekre lett kitalálva (törlés, keres).
		// Pld. kulcs értékpár: X = 3, y=3, gps, H-V bevététel
		// APP_VERSION = 6.3.1

		Hashtable<String,String> dictionary = new Hashtable<String, String>(); 
		dictionary.put("apple", "alma"); // apple a kulcs(key), érték a value (érték)
		dictionary.put("banana", "banán");
		dictionary.put("pear", "körte");
		System.out.println(dictionary);//{banana=banán, apple=alma, pear=körte}
		//dictionary.clear(); kitörli az összes kulcs-értékpár
		dictionary.remove("apple"); 
		System.out.println(dictionary); //{banana=banán, pear=körte}
		System.out.println("Van -e apple kulcs: "+dictionary.containsKey("apple")); //false
		System.out.println("Van -e pear kulcs: "+dictionary.containsKey("pear")); //true
		
		dictionary.put("pear", "korte");
		// Mi fog történni: 1. hiba 2. körte 3. korte
		System.out.println(dictionary); //{banana=banán, pear=korte}
		
		if (!dictionary.containsKey("pear")) {
			dictionary.put("pear", "korte");
		} else {
			// saját kivétel osztállyal vagy kiírással
		}
		
		dictionary.put("pear2", "korte");
		System.out.println(dictionary); //{banana=banán, pear2=korte, pear=korte}

		// Feladat: Írjuk ki az elemeket ilyen formátumban (ciklussal):
		// Angolul: banana	Magyarul: banán stb.
		
		List<String> keys = new ArrayList<>(dictionary.keySet());
		for (int i = 0; i < dictionary.size(); i++) {
			
			String key = keys.get(i);
			String value = dictionary.get(key);
			System.out.println("Angolul:" +key+", Magyarul: "+value);
			
		}
	}
}
