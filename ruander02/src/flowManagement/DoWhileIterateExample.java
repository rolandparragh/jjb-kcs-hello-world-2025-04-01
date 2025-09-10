package flowManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class DoWhileIterateExample {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Do-While ciklus - Hátultesztelős ciklus
		// Mikor használjuk?
		// Itt sem tudjuk, hogy hányszor kell ismételni.
		// 1X biztosan lefut
		// Egyszer mindenképp lefut, majd ellenőrzi a ciklusfeltételt, 
		// ha igaz, akkor újra belemegy a ciklusmagba és végrehajta azt.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Feladat01: Addig kérek be számokat, amig 0-at nem ad meg a felhasználó!
		System.out.println("Feladat01: Addig kérek be számokat, amig 0-at nem ad meg a felhasználó.");
		int numberInput;
		do {
			System.out.print("Kérem adjon meg egy egész számot, 0-ra kilépek: ");
			numberInput = Integer.parseInt(br.readLine());
		} while (numberInput !=0);
		System.out.println("Kiléptem, mert 0-t adtál meg!");
		System.out.println();
		
		// Feladat02: Addig dobok hagyományos 6 oldalu kockával, amig 6-os nem lesz!
		// Jelenítsük meg a dobások eredményét, egymás mellé!
		System.out.println("Feladat02: Addig dobok hagyományos 6 oldalú kockával, amig 6-os nem lesz!");
		Random r = new Random();
		int randomNumber;
		do {
			randomNumber = r.nextInt(6)+1;
			System.out.print(randomNumber + " ");
		} while (randomNumber!=6);
		System.out.println();
		System.out.println();
		// Tipp - Szorgalmi feladat: 2 játékossal kockadobás - pld. kreditek bevezetésével - győztes 50 kredit-et
		// Több fordulós, fordulonként kérdés: "Akar -e következő játékot?"
		
		
		//Feladat03: Addig kérek be számokat, amig nem osztható 5-tel és 6-tal maradék nélkül!
		System.out.println("Feladat03:  Addig kérek be számokat, amig nem osztható 5-tel és 6-tal maradék nélkül!");
		int numberInput3;
		do {
			System.out.print("Kérem adjon meg egy számot (5-tel és 6-tal is m.n osztható, akkor kilép: ");
			numberInput3 = Integer.parseInt(br.readLine());
		} while (numberInput3%5!=0 || numberInput3%6!=0);
		System.out.println("Kiléptem, mert 5-tel és 6-tal is osztható számot adtál meg");
		System.out.println();
		
		//Feladat04: Addig kérek be jelszót, amíg a megadott szó nem a pwd!
		System.out.println("Feladat03:  Addig kérek be jelszót, amíg a megadott szó nem a pwd!");
		String password;
		do {
			System.out.print("Kérem adja meg a jelszót: ");
			password = br.readLine();
		} while (!password.equals("pwd"));
		System.out.println("Kiléptem, mert pwd-t adtál meg :)");
		
		// == nem értékre vonatkozik a javaban (más nyelvekben pld Csharp-ban OK)
	}
}
