package basics;

import java.util.Random;

public class RandomNumberExample {

	public static void main(String[] args) {
		// Véletlen számok generálása
		// álvéletlen számok, pszeudó véletlen számok

		// ctrl+shift+o
		// r néven létrejön egy object, aminek a segítségével tudunk véletlen számot
		// generálni
		// Konstruktor hívás - létrehozza és beállítja az objektumpéldányt, r néven
		// new operátor - mem. foglalás
		Random r = new Random();

		// egy darab véletlen szám létrehozása 1-100 között
		int randomNumber = r.nextInt(100) + 1;
		System.out.println("Véletlen szám 1-100 között: " + randomNumber);

		// 1-2 közötti véletlen számot:
		int randomNumber2 = r.nextInt(2) + 1;
		System.out.println("Véletlen szám 1 vagy 2: " + randomNumber2);

		// 5-10 közötti véletlen szám
		int max = 10;
		int min = 5;
		int randomNumber3 = r.nextInt((max - min) + 1) + min;
		System.out.println("Véletlen szám 5 és 10 között: " + randomNumber3);

		// általános képlet, min és max értéke benne van (inclusive):
		// r.nextInt((max-min)+1)+min
	}
}
