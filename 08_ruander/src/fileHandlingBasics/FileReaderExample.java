package fileHandlingBasics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileReaderExample {

	public static void main(String[] args) {
		// Fájlból olvasás lépései
		// 1. Olvasó adatfolyam létrehozása
		// 2. Fájlból olvasás
		// 3. Olvasó adatfolyam bezárása (ha kimarad, akkor mem. leak-keletkezhet)

		// Feladat: names.txt-t hozzuk létre a data_names mappába, tetszőleges egymás
		// alatti nevekkel:
		// Teszt Elek
		// Gipsz Jakab
		// Kukor Ica

		// Megoldása: olvasó adatfolyam létrehozása
		String filePath = "data_names/names.txt";
		// try with resource - erőforráskezeléssel megoldott hibakezelés
		// br bezárása automatikus, amikor már nincs rá szükség végetér a try blokk
//       try (BufferedReader br = new BufferedReader(new FileReader(filePathName))) {
//       } 
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			// A fájlokat a java adatfolyamként kezeli.
			// Mi történik, ha nem jó a fájl elérési útja --> FileNotFoundException
			// Addig olvassuk be a sorokat, amig van következő sor az adatfolyamban
			// (fájlban)
			while (br.ready()) {
				// Beolvas 1 teljes sort a sorvégjelig (CR/LF), ebből tudja, hol van a sorvégjel
				String row = br.readLine();
				System.out.println(row);
			}
			// EOF: End of File: fájl végjel - vezérlő karakterek
			br.close(); // bezárja az olvasó adatfolyamot
			// felszabadítja a br által lefoglalt memória területet
			// ha kimarad ez a lépés memory leak keletkezhet
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.err.println("Hibás karakterkódolás :(");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.err.println("Nem található a fájl a megadott elérési úton.");
		} catch (IOException e) {
			// e.printStackTrace();
			System.err.println("IO hiba történik.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.err.println("Általános hiba történt :(");
		} finally {
			System.out.println("Hibakezeléssel megoldott feladat.");
		}
		System.out.println("Folytatódik a program...");
	}
}