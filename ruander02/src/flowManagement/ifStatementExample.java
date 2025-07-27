package flowManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ifStatementExample {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		/*****************************************************/
		/*************** Elágazás - Szelekció ***************/
		/***************************************************/

		// Mikor használjuk?
		// Egy vagy több feltételtől függően, különböző irányokba szeretnénk vezérelni
		// a programunkat! A feltétel csak igaz vagy hamis lehet!!!
		// Pld Bejelentkezés
		// Milyen fajtái vannak? Egyirányú, kétirányú és többirányú.

		/********************** 1. Egyirányú elágazás ********************/
		// A feltétel (condition) igaz ágával foglalkozunk csak kizárólag.
		// Általános szintakszis:
//		if (condition) {
//			utasitas;
//		}

		/********************** 2. Kétirányú elágazás ********************/
		// Ha a feltétel hamis, akkor is végez valamit az program, nem csak az igaz
		// ágnál.
		// Általános szintakszis:
//		if (condition) {
//			utasitas1;
//		} else {
//			utasitas2;
//		}

		/********************** 3. Többirányú elágazás ********************/
		// Mikor használjuk? Kettőnél is több irányra van szükség.
		// else if -es akárhányszor szerepelhet
		// else ág (legvégén) nem kötelező része
		// Általános szintakszis:
//		if (condition1) {
//			utasitas1; // condition1 igaz
//		} else if (condition2){
//			utasitas2;// condition2 igaz
//		} else if (conditon3){
//			utasitas3;// condition3 igaz
//		} else { //egyik sem igaz
//			utasitas4;
//		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Feladat01: Kérjük be a felhasználótól, hogy hírlevélre feliratkozik -e vagy
		// nem.
		// Amennyiben igaz a változó értéke, akkor írjuk ki, hogy hírlevél küldés
		// folyamatban!
		// hibakezelés egyelőre nem kell
		System.out.println(" Feladat01 : Hírlevél feliratkozás");

		System.out.print(" Kérem adja meg, hogy feliratokzik -e a hírlevélre (1-igen, 0-nem)");
		int response = Integer.parseInt(br.readLine());
		Boolean isNewsletterSubscribed = false;

		if (response == 1) {
			isNewsletterSubscribed = true;

		}
		if (isNewsletterSubscribed) {
			System.out.println(" Hírlevél küldés folyamatban!...");
		}
		System.out.println();
		// Feladat02: Kérjük be a termék raktármennyiségét, majd ha 0-nál nagyobb, akkor
		// állítsuk át az elérhetőségét igazra!
		// Logikai tipus false kezdőértékkel, csak akkor állítjuk át igazra, ha megfelel
		// egy feltételnek. Végül írjuk ki szövegesen, hogy "Elérhető" vagy "Nem
		// elérhető"
		System.out.println(" Feladat02 : Raktármennyiség");
		System.out.print(" Kérem adja meg a raktármennyiségt, egész szám: (0-nál nagyobb, akkor elérhető):");
		int stockAmount = Integer.parseInt(br.readLine());
		boolean isAvailable = false;

		if (stockAmount > 0) {
			isAvailable = true;

		}
		System.out.println(" Elérhető -e a termék( true -igen, false -nem): " + isAvailable);

		if (isAvailable) {
			System.out.println(" Elérhető");
		} else {
			System.out.println("Nem elérhető");

		}

		// Feladat03: Kérjünk be egy pozitiv egész számot, majd döntsük el róla, hogy
		// páros vagy páratlan!

		System.out.println();
		System.out.println(" Feladat 03 páros vagy páratlan ");
		System.out.println(" Kérem adja meg a vizsgálni kívánt számot ami nagyobb mint 1: ");
		int inputInt = Integer.parseInt(br.readLine());

		if (inputInt % 2 == 0) {
			System.out.println(" A megadott szám páros");
		} else {
			System.out.println(" A megadott szám páratlan");
		}

		// Feladat04: Kérjünk be két pozitiv egész számot, majd a szorzatukról döntsük
		// el, hogy 100 felett van -e! A program akkor is adjon választ, ha 100
		// alatti/feletti (egyenlő is lehet)!
		// Hány irányú elágazásra van szükség? Többirányú (háromirányú)
		System.out.println();
		System.out.println(" Feladat 04: Két pozitív egész szám szorzata ");

		System.out.println(" Kérem adja meg az első számot ami nagyobb mint 1:");
		int positiveValue1 = Integer.parseInt(br.readLine());
		System.out.println(" Kérem adja meg a második számot ami nagyobb mint 1:");
		int positiveValue2 = Integer.parseInt(br.readLine());
		int positiveValueTotal = positiveValue1 * positiveValue2;
		int limit = 100;
		if (positiveValueTotal > limit) {
			System.out.println(" A megadott szám szorzata nagyobb mint 100 ");
		} else if (positiveValueTotal == limit) {
			System.out.println(" A megadott szám szorzata 100 ");
		} else {
			System.out.println(" A megadott szám szorzata kisebb mint 100 ");
		}
		// Feladat05: Kérjünk két egész számot, majd döntsük el, melyik kisebb/nagyobb!

		System.out.println();
		System.out.println(" Feladat 05: Melyik szám a nagyobb?  ");

		System.out.println(" Kérem adja meg az első számot ami nagyobb mint 1:");
		int smallerBigger1 = Integer.parseInt(br.readLine());
		System.out.println(" Kérem adja meg a második számot ami nagyobb mint 1:");
		int smallerBigger2 = Integer.parseInt(br.readLine());

		if (smallerBigger1 > smallerBigger2) {
			System.out.println(" Az első szám a nagyobb ");
		} else if (smallerBigger1 == smallerBigger2) {
			System.out.println(" A megadott számok egyenlőek ");
		} else {
			System.out.println(" A második szám a nagyobb. ");
		}

		// Feladat06: Kérjük be felhasználótól, hogy naponta átlagosan mennyi időt tölt
		// a képernyő előtt! A választól függően írjuk ki a következőket:
		// 0-2: Kevés időt tölt a képernyő előtt, nem szükséges szemtorna!
		// 3-5: Mérsékelt a képernyőhasználat, de néha tartsunk pihenőt!
		// 6 és felette: Óránként tartsunk 10 perc szünetet vagy végezzünk szemtornát!

		System.out.println();
		System.out.println(" Feladat 06: Képernyőidő?  ");

		System.out.println(
				" Kérem adja meg átlagosan hány órát tölt naponta a számítógép előtt? Használjon egész pozitív számot, ha nem használ számítógépet írjon 0-t:");
		int screenTime = Integer.parseInt(br.readLine());

		if (screenTime >= 0 && screenTime <= 2) {
			System.out.println("Kevés időt tölt a képernyő előtt, nem szükséges szemtorna!");
		} else if (screenTime >= 3 && screenTime <= 5) {
			System.out.println("Mérsékelt a képernyőhasználat, de néha tartsunk pihenőt! ");
		} else if (screenTime >= 6 && screenTime <= 24) {
			System.out.println("Óránként tartsunk 10 perc szünetet vagy végezzünk szemtornát!");
		} else {
			System.out.println(" Hibás érték, az érték nagyobb mint 24... ");
		}

		// Feladat09: Kérjük be a nap sorszámát (1-7), majd határozzuk meg, hogy
		// hétköznap vagy hétvége az adott nap: 1-5 hétköznappal tér vissza, 6,7 -
		// hétvége!
		System.out.println();
		System.out.println(" Feladat 09: napok sorszáma  ");
		System.out.println("Kérjük adja meg a napot sorszámát ( 1től 7ig ahol az 1 a hétfő a 7 a vasárnap)");
		int daysOfWeek = Integer.parseInt(br.readLine());

		if (daysOfWeek >= 1 && daysOfWeek <= 5) {
			System.out.println(" Hétköznap");
		} else if (daysOfWeek == 6 || daysOfWeek == 7) {
			System.out.println(" Hétvége");
		} else {
			System.err.println(" A megadott adat nem felel meg a követelményeknek..");
		}
		
		
		

		br.close();
	}

}
