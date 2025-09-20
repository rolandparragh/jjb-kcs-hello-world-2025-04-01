package setInterface;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		// Set interface: speciális collection: nem tartalmazhat azonos elemeket
		// (A duplikáció kiszűrésére a equals() és hashCode() metódusokat használ.)
		//
		// 3 implementációja van:
		// HashSet: az elemeket táblákban tárolja, nem fontos az elemeket bejárása
		// TreeSet: fa, hierarchikus szerkezet. Gyors a bejárás, mert az elemeket
		// fa szerkezetben tárolja, de nehézkes az adatbeszúrás. Rendezetten tárolja
		// az adatokat.
		// LinkedHashSet: láncolt lista és Hashtábla tulajdonságait ötvözi

		int[] numberArray = { 34, 22, 10, 60, 30, 22 };
		Set<Integer> numberSet = new HashSet<Integer>();
		for (int i = 0; i < numberArray.length; i++) {
			numberSet.add(numberArray[i]);
		}

		System.out.println(numberSet); // [34, 22, 10, 60, 30]

		Set<String> uniqueNames = new HashSet<String>();
		uniqueNames.add("John");
		uniqueNames.add("Jane");
		uniqueNames.add("Jonnie");
		uniqueNames.add("John"); // nem dob hibát, de nem hajtja végre
		System.out.println(uniqueNames); // [John, Jane, Jonnie] vagy [Jonnie, John, Jane]
		// Nem rendezi az elemeket, nem megjósolható az elemek sorrendje.

		Iterator<String> itr = uniqueNames.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();

		// törtszámoknál vagy bármelyik más típusnál is hasonlóan működik

		// Objektumoknál mi történik?
		Employee empObj01 = new Employee("Teszt Elek", "programozó");
		Employee empObj02 = new Employee("Teszt Elek", "programozó");
		Employee empObj03 = new Employee("Teszt Elek", "programozó");
		Set<Employee> employees = new HashSet<Employee>();
		// List<Employee> lista
		// Employee[] tömb

		employees.add(empObj01);
		employees.add(empObj02);
		employees.add(empObj03);

		// hashcode-ja különböző a 3 objektumnak és az ellenőrzésnél equals metódussal
		// ezt figyeli
		for (Employee employee : employees) {
			System.out.println("Név: " + employee.getName() + ", beosztás: " + employee.getRole());
		}

		// uniqueNames.clear(); // kitörli az összes elemet
		// tartalmazás vizsgálat: contains (true/false) tér vissza
		System.out.println("Jonnie benne van -e: " + uniqueNames.contains("Jonnie")); // true
		System.out.println("Janet benne van -e: " + uniqueNames.contains("Janet")); // false

		System.out.println("Üres -e a uniqueNames változó: " + uniqueNames.isEmpty()); // false
		uniqueNames.remove("Jonnie");
		System.out.println(uniqueNames);// [John, Jane]
		uniqueNames.remove("Janet"); // nem dob hibát, csak nem hajtja végre, mert nincs ilyen

		// Hamazműveletek: metszet, unió, különbség
		/*
		 * Vegyünk két halmazt s1-et és s2-öt s1.containsAll(s2): részhalmaza s2 az
		 * s1-nek s1.addAll(s2): az s1-be belekerül a két halmaz uniója
		 * s1.retainAll(s2): az s1-be belekerül a két halmaz metszete s1.removeAll(s2):
		 * az s1-be kerül bele a két halmaz különbsége
		 */

		Set<Integer> aSet = new HashSet<Integer>();
		Set<Integer> bSet = new HashSet<Integer>();

		aSet.add(77);
		aSet.add(85);
		aSet.add(13);
		aSet.add(19);
		aSet.add(32);
		bSet.add(77);
		bSet.add(85);
		bSet.add(36);
		bSet.add(29);

//				aSet.retainAll(bSet);
//				System.out.println(aSet); //[85,77] metszet

//				aSet.addAll(bSet);
//				System.out.println(aSet); //[32, 19, 36, 85, 77, 13, 29] unio

//				aSet.removeAll(bSet);
//				System.out.println(aSet); //[32, 19, 13] különbség

//				bSet.removeAll(aSet);
//				System.out.println(bSet); //[36, 29] különbség
	}

}
