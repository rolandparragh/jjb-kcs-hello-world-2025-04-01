package setInterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		// TreeSet: fa, hierarchikus szerkezet. Gyors a bejárás, mert az elemeket
		// fa szerkezetben tárolja, de nehézkes az adatbeszúrás. Rendezetten tárolja
		// az adatokat.

		Set<Integer> sortedNumbers = new TreeSet<Integer>();
		sortedNumbers.add(5);
		sortedNumbers.add(13);
		sortedNumbers.add(10);
		sortedNumbers.add(8);
		sortedNumbers.add(2);
		System.out.println(sortedNumbers); // [2, 5, 8, 10, 13]

		Set<String> fruits = new TreeSet<String>();
		fruits.add("szilva");
		fruits.add("barack");
		fruits.add("áfonya");
		fruits.add("alma");
		fruits.add("körte");
		System.out.println(fruits); // [alma, barack, körte, szilva, áfonya]
		// magyar ABC szabályait (ékezettel miatt) nem tartotta be

		Set<Integer> numbersSet = new HashSet<Integer>();
		numbersSet.add(74);
		numbersSet.add(5);
		numbersSet.add(12);
		numbersSet.add(8);

		Set<Integer> numbersSortedTreeSet = new TreeSet<Integer>(numbersSet);
		System.out.print("numbersSet elemei: "); // [5, 8, 74, 12]
		System.out.println(numbersSet);
		System.out.print("numbersSortedTreeSet elemei: ");
		System.out.println(numbersSortedTreeSet); // [5, 8, 12, 74]

		// 1. Deklaráció és definció
		// private static final long serialVersionUID = 8671247584046227888L;
		// serializáció: adatábrázolás: memóriában, DB, fájlban vagy egyéb helyen
		// ehhez szükséges egy azonosítás ennél a típusú változónál
		@SuppressWarnings("serial")
		Set<String> cars = new TreeSet<String>() {
			{
				add("Honda");
				add("BMW");
				add("Ford");
			}
		};

		System.out.println(cars); // [BMW, Ford, Honda]

		// 2. módszer
		Set<String> cpuManufacturers = new TreeSet<String>(Arrays.asList("Intel", "AMD"));
		System.out.println(cpuManufacturers); // [AMD, Intel]

		// 3. módszer
		Set<String> gpuManufacturers = new TreeSet<String>(List.of("Radeon", "Nvidia"));
		System.out.println(gpuManufacturers); // [Nvidia, Radeon]
	}
}
