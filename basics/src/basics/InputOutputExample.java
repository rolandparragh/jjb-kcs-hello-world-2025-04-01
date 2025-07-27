package basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputOutputExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// sc néven létrejön egy objektum példány a Scanner osztályból,
		// ennek segítségével oldjuk meg a beolvasást
		// new - memória foglalása
		// osztálynév: scanner
		// objektumnév: bármi lehet, most sc lett
		// System.in billentyűzet ( alapértelmezett)

		/// ctrl + shift + o : automatikus import: hianyzóakat elhelyezi, feleslegeseket
		/// kiszedi
		Scanner sc = new Scanner(System.in); // konstruktor szintakszis

		System.out.println("Scanner osztály használata:");

		// szöveg beolvasása
		System.out.println("Kérem adja meg a teljes nevét (sc)");
		String fullName = sc.nextLine();
		System.out.println("A megdatott teljes név: " + fullName);

		// Egész szám beolvasása ( int)
		System.out.print("Kérem adja meg az életkorát(sc) (egész szám : pl 33): ");
		int ageInput = Integer.parseInt(sc.nextLine());
		System.out.println("A megadott életkor: " + ageInput);
		// NumberFormatExeption - harminc-inputra (üres inputra is ugyanez)
		// Később Kivételkezeléssel megoldjuk a input validálását, ellenőrzését

		// FONTOS: minden adat, ami a felhasználótól érkezik, az SZÖVEG (STRING)
		// HA ettől eltérő tipusba szeretnénk tárolni, akkor parsolni kell a megfelelő
		// tipusba!

		// NE használjuk az sc.nextInt() metódust, mert csinál egy felesleges beolvasást
		// helyette ez a szintakszis javasolt: Integer.parseInt(sc.nextLine());

		// törtszám beolvasása: a törtszámot javaban ponttal adjuk meg és ponttal is
		// írja ki
		System.out.print("Hány kg almát szeretne (lehet törtszám is, pld. 3.4 (sc): ");
		double appleInputWeight = Double.parseDouble(sc.nextLine());
		System.out.println("A megadott alma súly: " + appleInputWeight + " kg");

		// short beolvasása
		System.out.print("Hány szeletes tortát szeretne (egész számot kérünk) (sc): ");
		short cakeSliceCount = Short.parseShort(sc.nextLine());
		System.out.println("Ennyi szeletes torta: " + cakeSliceCount);
		/**************************************
		 * BufferedRead osztály használata - adatbeolvasás
		 ********************************/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(" BufferedReader osztály használata: ");
		System.out.print("Kérem adja meg a beosztását (br): ");
		String roleInput = br.readLine();
		System.out.println(" A megadott beosztás : " + roleInput);
		System.err.println("Hibaüzenet....");
		
		

		// egész szám beolvasása (parse-olni kell)
		System.out.print("Kérem adja meg a termék árát (Ft) (br), pld. 100: ");
		int productPrice = Integer.parseInt(br.readLine());
		System.out.println("A termék ára: "+productPrice + " Ft");
		
		// törtszám beolvasása (parse-olni kell)
		System.out.print("Kérem adja meg a termék hosszát cm-ben (tört szám is lehet, pld. 13.4) (br): ");
		double productLength = Double.parseDouble(br.readLine());
		System.out.println("A termék hossza: "+productLength + " cm");
		
		
		
		sc.close();
		br.close();
		// Scanner vs BufferedReader VIZSGAKÉRDÉS : buffereader újabb, gyorsabb, kötelez
		// minket a kivételkezelésre , szintakszisa nehezebb, szinkronitált, többszálú
		// és szálbiztos
		//Mikor melyiket használjuk?
		
				// Scanner: régebbi, lassabb a mukodése, nem szálbiztos, szintakszis egyszerűbb
				// BufferedReader (javasolt): újabb, gyorsabb, kötelez minket a kivétekezelésre
				// szinkronizált, többszálú és szálbiztos, szintakszisa nehezebb
			}
	}


