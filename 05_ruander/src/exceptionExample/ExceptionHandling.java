package exceptionExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionHandling {

	public static void main(String[] args) {
		// Kivétel: nem várt esemény, meg kell oldanunk kezelést 
		// Kivételkezelés: fordítótól átvesszük a hibakezelés, 
		// saját hibaüzeneteket tudunk kiírni, mi tudjuk szabályozni, hogy
		// mi történjen pld. 0-val való osztás esetében vagy
		// szám helyett szöveget ad meg.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberInput = 0;
		try {
			// Ebbe a blokkba rakjuk azokat a kódokat, ami hibát dobhat (pld. adatbekérésnél)
			// Olyan kódokat is tartalmazhat, ami nem dobhat hibát
			//br.close();
			System.out.print("Kérem adjon meg egy egész számot: ");
			numberInput = Integer.parseInt(br.readLine());
			System.out.println("A megadott szám ez volt: "+numberInput);
		} catch (NumberFormatException e) {
			// egész szám helyett szöveget, vagy törtszámot (olyan értéket, amit nem tud átalakítani)
			//e.printStackTrace();
			//syserr - prios kiírás a konzolon
			System.err.println("Egész számot kértem!!!");
		} catch (IOException e) {
			// IO hiba történt, pld. korábban bezárjuk a br-t, mint kellene, vagy mem., tárhely nem elérhető
			System.err.println("IO hiba történt :(");
			//e.printStackTrace();
		} catch (Exception e) {
			// catch ágak száma tetszőleges, de
			// Fontos szabály: Legspeciálisabbtól haladunk a legáltalánosabbig
			// Exception: kivételek ősosztálya, minden kivétel ebből származik
			System.err.println("Általános hiba történt :(");
		} finally {
			// Nem kötelező része a try-catch szerkezetnek
			// Amit ebbe a blokkba rakunk az mindenképpen lefut
			// Tisztogatásra, mem. terület felszabadítására használható
			System.out.println("Hibakezeléssel megoldott feladat...");
		}
		System.out.println("Folytatja a program a futását...");
		System.out.println("A megadott szám ez volt: "+numberInput); 
		System.out.println();
		
		int[] numbers = {77,66,5};
		//System.out.println(numbers[3]); //ArrayIndexOutOfBoundsException
		try {
			System.out.println(numbers[3]); 
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Túlcímezted a tömböt, figyeljünk oda, mert 0-tól indexel!!!");
		} catch (Exception e) {
			System.err.println("Általános hiba történt :(");
		}
		System.out.println("Folytatja a program a futását...");
		
		// IOException: ha bezárjuk a br-t, pedig még szükség lenne rá,
		// Fájlkezelés műveleteknél - FileNotFoundException: nem találja a megadott elérési úton a fájlt
		// Saját kivételkezelő osztály is létrehozható - később csinálunk ilyet...
		
		// Feladat: Kérjünk be két egész számot hibakezeléssel, majd osszuk el az elsőt
		// a másodikkal (0-val való osztás), finally blokkban zárjuk be a br-t is!
	
		// try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
		// try with resource
		// Amikor már nincs szükség a br-re automatikusan bezárja
		
		int divident; //osztandó
		int divider; //osztó
		double result = 0.0;
		
		try {
			System.out.print("Kérem adja meg az osztandót(egész szám): ");
			divident = Integer.parseInt(br.readLine());
			System.out.print("Kérem adja meg az osztó(egész szám): ");
			divider = Integer.parseInt(br.readLine());
			//result = divident/divider; // adatvesztés
			result = (double)divident/divider; 
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.err.println("0-val nem osztunk!!!");
		} catch (NumberFormatException e) {
			System.err.println("Egész számot kértem!!");
		} catch (IOException e) {
			System.err.println("IO hiba történt!!!");
		} catch (Exception e) {
			System.err.println("Általános hiba történt!!!");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("IO hiba történt!!!");
			}
		}
		// látja a result változót, mert a definiciós és deklarációs részt szétválasztottuk
		System.out.println("Az eredmény: "+result); //10 és 0-nál Infinity
		//eddig explicit módon kivétel dobása
		
		//implicit módon is kiválthatjuk a kivételt
		int dividerTest = 1;
		int dividentTest = 10;
		if (dividerTest==0) {
			throw new ArithmeticException("Nem osztunk 0-val!!!");
		} else {
			System.out.println("Eredmény: "+(double)dividentTest/dividerTest);
		}
		
		int age = 17;
		if (age<18) {
			//saját kivételkezelő IsAdultException
			throw new ArithmeticException("Nem felnőtt, nem szavazhat...");
		} else {
			System.out.println("Szavazóképes...");
		}
		
		// Két csoportja van a kivételeknek: 
		// Checked (ellenőrzőtt): fordítási időben dobnak hibát: IO műveletek: IOException, SQLException
		// ClassNotFoundException, InterruptedException, InstantiationException, FileNotFoundException

		// Unchecked exception (nem ellenőrzőtt): futási időben dob hibát - pld. 0-val való osztás: 
		// ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException, 
		// ArrayStoreException, IllegalThreadStateException

		// Futási időben dob hibát: implicit módon, minden más explicit módon való hiba dobás
		// implicit: throw new ArithmeticException();
		// explicit: JVM oldja meg, hogy melyiket dobja
		
		// Code Challange - Hw
		//Feladat01: Kérjük be a téglalap két oldalát (egész szám), majd írjuk ki a kerületét, területét!
		//Feladat02: Kérjük be a termék nettó árát (egész szám) és ÁFÁ-ját (lehet törtszám is), 
		// majd írjuk ki a bruttó árát!
		// Feladat03: Hozzunk létre egy tömböt ezekkel az egész számokkal 55,3,6,22,1 , majd kérjünk 
		// be egy indexet, hogy melyik elemre kiváncsi a tömbből!
	}
}
