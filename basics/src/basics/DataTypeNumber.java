package basics;

public class DataTypeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*************************** Egész számok ***************************/
		// leggyakrabban használt szám tipus : int
		int number1;
		number1 = 100;
		int number2 = 200;
		System.out.println("A Két szám összege: " + number1 + number2); // 100200 concat
		System.out.println("A Két szám összege: " + (number1 + number2)); // 300 összeadás
		int sum = number1 + number2;
		System.out.println("összeg: " + sum); // 300
		/*
		 * byte 8 bit -128 + 127 unsigned byte: nincs negatív tartomány short 16 bit
		 * :-32768 +32767 int 4byte: 2 milliard long: 8 byte float: egyszeres pontossagú
		 * lebegőpontos szám, törtszám double: kétszeres pontosságú lebegőpontos szám
		 * ,törtszám
		 * 
		 */
		System.out.println("A integer maximális értéke: " + Integer.MAX_VALUE);
		System.out.println("A integer maximális értéke: " + Integer.MIN_VALUE);
		System.out.println("A integer maximális értéke: " + (Integer.MAX_VALUE + 5));
		// túlcsordul akkor átvált negatívba és elkezd visszafelé menni

		byte categoryId = 2;
		System.out.println("Kategória id: " + categoryId);

		short cakeSlice = 130;
		System.out.println("Ennyi szeletes torta: " + cakeSlice);

		// suffix: L vagy l (érdemes nagy L)
		long income = 7899856828288256L;
		System.out.println("Ennyi a bevétel: " + income + " Ft");
		double divideResult = 10 / 3;
		System.out.println(divideResult); // 3.0 ; egész számot egész számmal osztunk, visszatérése egész szám

		// Hogyan lehet megoldani, hogy ne legyen adatvesztés?
		// Sehogy, mert lesz adatvesztés - végtelen tizedes.... :)
		// Mérsékeljük az adatvesztést!

		// 1. megoldás
		double divideResult2 = 10 / 3.0;
		System.out.println(divideResult2); // 3.3333333333333335

		// 2. megoldás - rossz megoldás, mert floattá konvertálja
		double divideResult3 = 10 / 3f;
		System.out.println(divideResult3); // 3.3333332538604736

		// 3. megoldás: az eredménye azonos az 1-es megoldással
		double divideResult4 = 10 / 3d;
		System.out.println(divideResult4); // 3.3333333333333335

		// 4. megoldás - javasolt - cast - kasztolás - tipuskényszerítés
		double divideResult5 = (double) 10 / 3;
		System.out.println(divideResult5); // 3.3333333333333335

		// Code Challange:
		// Feladat: Vegyünk fel két egész szám változót és kapjanak 5-ös és 4-es
		// értéket.
		// Számítsük ki és írjuk ki az átlagukat! Figyeljünk az adatvesztésre!
		byte szam1 = 4;
		byte szam2 = 5;
		double osszeg = (double) (szam1 + szam2) / 2;
		System.out.println(osszeg);
		// suffix f
		float temperature = 26.8f;
		System.out.println(temperature);

		/************* Object vs. primitív típus *****************/ //40 percnél nézd vissza 
		// int - primitív típus
		// Integer - Object (referencia típus)
		// int és Integer közötti különbség ua. byte vs. Byte vagy short, Short

		// int age = null; //szintaktikai hiba, nem lehet null
		int agePrimitive = 0;

		// int agePrimitive2 = agePrimitive;

		Integer ageObject = null;
		// Integer ageObject2 = 33; //java11-ben hibát dob, nem jó szintakszis
		// java17-ben OK

		// Integer ageObject2Deprecated = new Integer(12); //deprecated java 9 óta, ne
		// használjuk így
		Integer ageObject2 = Integer.valueOf(33); // javasolt szintakszis, mindkét verzióban OK
		System.out.println("agePrimitive értéke: " + agePrimitive);
		System.out.println("ageObject (referencia) értéke: " + ageObject);
		System.out.println("ageObject2 (referencia) értéke: " + ageObject2);
		System.out.println("ageObject2:" + ageObject2.hashCode());

		int a = 4; // érték szerinti másolás történik (primitív tipusoknál)
		int b = a; // b változóba másolja a 4-es értéket
		System.out.println(b);
		// ugyanez referencia típussal : hashCode másolás
		// referencia tipusúak: Integer, Byte, Short, Array, List, Class + összes
		// adatszerkezet
		// referencia cím szerinti másolás
		// NPE: Null Pointer Exception: Nincs meg a referencia címe egy objektumnak,
		// pld. mert nem jön létre
		// Kotlin megoldja...
	}

}
