package setInterface;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {

	public static void main(String[] args) {
		// LinkedHashSet: láncolt lista és Hashtábla tulajdonságait ötvözi
		// 		Jellemzői: egyedi elemeket tartalmazhat, megtartja a
		// 			beszúrási sorrendet, nem szinkronizált
		//			többszálú feldolgozásra nem alkalmas, engedélyezi a NULL-t
		
		//Műszaki vizsga sorrend - rendszám alapján (rendszám nem ismétlődhet) vagy Queue
		Set<String> licencePlates = new LinkedHashSet<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("PCA-180");
                add("PCA-180"); // nem hajtja végre
                add("DEF-456");
                add("GHI-789");
                add("JKL012");
                add("ABC123");
                add(null); 
			}
		};
		
		// Megtartja a sorrendet (az ArrayList is ilyen), 
		// ArrayListnél lehet duplikáció
		// PCA-180-at csak 1X rakta bele
		System.out.print(licencePlates); // [PCA-180, DEF-456, GHI-789, JKL012, ABC123, null]
		System.out.println();
		
		licencePlates.add("FGT-111");
		System.out.print(licencePlates); //[PCA-180, DEF-456, GHI-789, JKL012, ABC123, null, FGT-111]
		System.out.println();
		
		//licencePlates.clear();
		System.out.println("Tartalmazás vizsgálat (contains): "+licencePlates.contains("PCA-150")); //false
		System.out.println("Üres -e a licencePlates: "+licencePlates.isEmpty()); //false
		
		licencePlates.remove("FGT-111");
		System.out.println(licencePlates); //[PCA-180, DEF-456, GHI-789, JKL012, ABC123, null]
		
		//Adatszerkezet bejárása foreach szerkezettel és iteratorral 
		for (String licencePlate : licencePlates) {
			System.out.println(licencePlate);
		}
		
		Iterator<String> itr = licencePlates.iterator();
		System.out.println("iterator-os bejárás: ");
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");  //PCA-180 DEF-456 GHI-789 JKL012 ABC123 null 
		}
	}
}
