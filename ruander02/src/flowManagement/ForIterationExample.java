package flowManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ForIterationExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// ciklus - iteráció
		// Akkor használjuk amikor egy vagy több utasítást többször szeretnénk
		// ismélteni.

		// for ciklus amikor pontosan tudjuk hányszor kell ismételni
		// milyen részei vannak : kezdőérték, ciklusfeltétel, léptetés, ciklusmag
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// Feladat01 kérjük be a felhasználó nevét és írjuk ki 5x. 
		
		
		System.out.println("Feladat01: Felhasználó név 5x kiírás");
		System.out.println("Kérjük adja meg a teljes nevét: ");
		String fullName = br.readLine();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(fullName);
		}
		
		
// Feladat02 kérjünk be szöveget és ismétlés számot, írjuk ki 
		
		System.out.println("Feladat02: szöveg bekérése és n szer kiírása");
		System.out.println("Kérem a szöveget:  ");
		String inputSentence = br.readLine();
		
		System.out.println("Kérem az ismétlésszámot:  ");
		
		int iterationValue = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < iterationValue; i++) {
		System.out.println((i+1) + inputSentence);
		}
		
		br.close();
	}

}
