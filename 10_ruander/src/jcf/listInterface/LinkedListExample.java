package jcf.listInterface;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
		/*
		 * LinkedList: láncolt lista jellemzői: 
		 * 		- AbstractList osztályból származik megörökölve annak tulajdonságait
		 * 		- duplikált elemeket tartalmazhat
		 * 		- kezeli a beszúrások sorrendjét
		 * 		- nincs szükség eltolásokra (shiftelésekre) beszúrásnál, törlésnél
		 * 		- pointer mem. használat
		 * 		- hátránya - hátránya lehet még: 
		 * 		 	a láncoltlista megfordítás
		 *  	- lehet ArrayList-ből, stackből vagy queue-ból is létre lehet hozni
		 *  	- real life example: mappaszerkezetek tárolása (almappák kezelése)
		 *  	- időbeli vagy prioritásbeli sorrend van az adatok között
		 *  	- játéknál highScoreList
		 *  	- sokat változik a tartalma a listának
		 *  	- auto műszaki vizsgáztatásnál: queue alkalmasabb, ritkán változik a sorrend
		 * 
		 * Összehasonlítás: ArrayList (AL) vs. LinkedList (LL):
		 * 		 - LL több memóriát foglal, mert pointereket is kell tárolnia
		 * 		 - AL csak az értéket és az indexet tárolja
		 * 		 - Ha sok módosítás, törlés vagy beszúrás van a listában, akkor a LL jobb megoldás
		 */
//		LinkedList<String> metallicaAlbumok = new LinkedList<String>(); // bad practice
		List<String> metallicaAlbum = new LinkedList<String>();
		metallicaAlbum.add("Kill 'Em All");
		metallicaAlbum.add("Ride the Lighting");
		metallicaAlbum.add("Master of Puppets");
		metallicaAlbum.add("... And Justice for All");
		metallicaAlbum.add("Metallica");
		metallicaAlbum.add("Load");
		metallicaAlbum.add("Reload");
		System.out.println(metallicaAlbum);

		// metallicaAlbumok.clear(); kitörli az összes elemet, AL-nél is mukodik
		// removeFirst()
		// remove(index)
		metallicaAlbum.remove("Load");

		System.out.println("Volt -e ilyen, hogy Load album: " + metallicaAlbum.contains("Load"));
		System.out.println("Első album: " + metallicaAlbum.get(0));
		System.out.println("Üres -e a láncolt lista: " + metallicaAlbum.isEmpty()); // false
		System.out.println("A lista mérete: " + metallicaAlbum.size()); // 6
	}
}
