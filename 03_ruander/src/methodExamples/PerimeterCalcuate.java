package methodExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerimeterCalcuate {


		// Metódus fogalma: egy olyan elkülönített kódrészlet, amely segítségével 
		// kiküszöbölhető a kódismétlés: egyszer létrehozom (deklaráció) 
		// és többször meg tudom hívni (call).
		// Egy névvel tudok hivatkozni rá, lehet visszatérése és lehetnek 
		// bemenő paraméterei. 
		
		// Metódus vs függvény vs eljárás vs tagmetódus
		// https://www.w3schools.com/java/java_methods.asp
		
		// Prog. nyelvektől függ, hogy hogyan hivatkozunk egy kódblokkra
		// Eljárás - PASCAL: BEGIN - END 
		// Függvény - van visszatérési értéke
		// Az OOP-s nyelveknél metódusnak/tagmetódusnak hívják
		
		// https://mkyong.com/java8/java-8-function-examples/
		// https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
		
		// Clean Tiszta Kód - Robert C. Martin. 
		// Metódus neve mindig kisbetűvel kezdődik, és camelCase-es
		// Tiszta kód szabályai: fejezze ki a neve azt, amit csinál!
		// Lehet bemenő paramétere, aminek meg kell adni a típusát is
		// Metódus deklaráció (egyszer szerepel a kódban)
		// Metódus szignatúra: metódusnév + bemenő paraméterek tipussal együtt
		// formális paraméterek: metódus deklaráció esetében
		// aktuális paraméter: a metódus hivásnál (method call)
		// return kötelező, ha visszatérési érték (más nyelveknél ez a function (függvényt) pld. JS)
		// void-os ha nincs visszatérése (más nyelveknél eljárás (pld. JS)) 
		// Tiszta kód szabályai alapján 20-30 sornál ne legyen több (minél rövídebb annál jobb), 
		// ne legyen túl sok paramétere (lehetőleg egyse vagy néhány).
		// Ha 10 bemenő adat esetén mi a teendő? Termék id, neve, ár stb. 
		// Product class - objektumot kap paraméterként a metódus
		// Wrapper osztály - csomagoló osztály - metódus paramétereit csökkenthető
		// Metódus - viselkedésforma - ige
		// void (nincs visszatési értéke) kiiró és beállító metódusok ilyenek printProductData(), setPrice()
		// getPrice() - értékkel tér vissza (számmal)
		// get-es kezdetű kötelező return, kötelezően értékkel visszatér
		// isActive() booleannal tér vissza kötelezően
		// getActive() vagy isActive(): getters/setters automatikus generálás (boilerplate)
		
		
		// Így a br bármelyik metódusban használható
		private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//private static Random r = new Random(); // HF: is elöjön- hogy ne ugyanazt a számot generálja ki
		// több metódusban is szükség van a változóra
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			// Feladat01: Kérjük be a felhasználótól a téglalapnak a két oldalát és a megadott adatokkal
			// számítsuk ki a kerületét! A konzolon jelenítsük meg az értéket!
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			System.out.print("Kérem adja meg a téglalap első oldalát: ");
//			int a = Integer.parseInt(br.readLine());
//			System.out.print("Kérem adja meg a téglalap másik oldalát: ");
//			int b = Integer.parseInt(br.readLine());
//			int perimeter = (a+b)*2;
//			System.out.println("A téglalap kerülete: "+perimeter);
			
			// Megjegyzés: Feladat2: 5 téglalap adatait kérjük be és számítsuk ki a kerületet!
			// Ciklus és metódus
			// További feladat:
			// tesztelhető legyen a művelet
			// CC szabályai
			// jobb áttekinthetőség
			
			// method call - metódus hívás
//			//1. hívás
//			System.out.println("1. hívás printRectanglePerimeter: ");
//			printRectanglePerimeter();
//			//2. hívás
//			System.out.println("2. hívás printRectanglePerimeter: ");
//			printRectanglePerimeter();
			
//			for (int i = 0; i < 5; i++) {
//				System.out.println((i+1) +" hívás:");
//				printRectanglePerimeter();
//			}
//			printRectanglePermiterCount(5);
			// 2, 3 aktuális paraméter - method call
			//printPerimeter(2,3);
			
//			int a = getASide();
//			int b = getBSide();
			//printPerimeter(a, b);
			// rövidebb:
			//printPerimeter(getASide(), getBSide());
			printPerimeterToConsole2(getInputNumber("Kérem az egyik oldalt:"), getInputNumber("Kérem a másik oldalt: "));
			printPerimeterToConsole();

		} // main lezárás
		
		// Feladat01: Megoldás01 (bad practise)
		// method declaration - method deklaráció
		// Hibás, mert:
		// 1. neve félrevezető, mert más dolgot is csinál nem csak kiírás
		// 2. egyszerre több dolgot csinál: bekérés és számítás és kiírás
		// 3. Kiírás: Csak a konzolra tudja kiírni az eredmény
		// 4. Leszűkített működés: konzol olvas be és oda ír ki (Bemenet lehet más is: fájl, DB, API,, kimenet is: fájl, DB, stb.)  
		// 5. nem tesztelhető
//		private static void printRectanglePerimeter() throws NumberFormatException, IOException {
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			System.out.print("Kérem adja meg a téglalap első oldalát: ");
//			int a = Integer.parseInt(br.readLine());
//			System.out.print("Kérem adja meg a téglalap másik oldalát: ");
//			int b = Integer.parseInt(br.readLine());
//			int perimeter = (a+b)*2;
//			System.out.println("A téglalap kerülete: "+perimeter);
//		}
		
//		private static void printRectanglePermiterCount(int count) throws NumberFormatException, IOException {
//			for (int i = 0; i < count; i++) {
//				System.out.println((i+1) +" hívás:");
//				printRectanglePerimeter();
//			}
//		}
		
		// DRY: Don't Repeat Yourself
		// Code Challange: Refaktoráljuk 2 metódusból legyen 1: Így nem lesz ismétlődés
		// Eltéréseket felveszed paraméternek
//		private static int getASide() throws NumberFormatException, IOException {
//			System.out.print("Kérem adja meg a téglalap első oldalát: ");
//			int a = Integer.parseInt(br.readLine());
//			return a;
//		}
	//	
//		private static int getBSide() throws NumberFormatException, IOException {
//			System.out.print("Kérem adja meg a téglalap második oldalát: ");
//			int b = Integer.parseInt(br.readLine());
//			return b;
//		}
		private static int getInputNumber(String message) throws NumberFormatException, IOException {
			System.out.print(message);
			return Integer.parseInt(br.readLine());
		}
		
		@SuppressWarnings("unused")
		private static void printPerimeter(int aSide, int bSide) {
			int perimeter = (aSide+bSide)*2;
			System.out.println("Kerület: "+perimeter);
		}
		
		// Formális paraméter: aSide, bSide
		// metódus deklaráció
		private static int calcPerimeter(int aSide, int bSide) {
			return (aSide+bSide)*2;
		}
		
		private static void printPerimeterToConsole() throws NumberFormatException, IOException {
			String message1 = "Kérem az egyik oldalt: ";
			String message2 = "Kérem a másik oldalt: ";
			System.out.println(calcPerimeter(getInputNumber(message1), getInputNumber(message2)));
		}
		
		private static void printPerimeterToConsole2(int a, int b) throws NumberFormatException, IOException {
			System.out.println(calcPerimeter(a, b));
		}
	} //class lezárása