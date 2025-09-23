package dictionaryApp;

public class App {

	public static void main(String[] args) {
		// Feladat: Készítsünk szótár programot! Olvassuk be a dictionary_data mappában
		// lévő
		// dictionary.csv és tároljuk egy olyan adatszerkezetben, hogy a későbbi
		// feladatok
		// megoldhatóak legyenek!
		// Kérjünk be a felhasználótól egy menüpontot 1 vagy 2 (addig kérjuk be amig nem
		// megfelelő):
		// 1-es gomb magyarról angolra
		// 2-es gomb angolról magyarra fordít
		// Be kell kérnünk a fordítandó szót is.
		// Fordítsuk le a megadott szót, ha nincs ilyen a szótárban, adjunk róla
		// tájékoztatást!
		// Betartandó szempontok: Clean Code (CC) és OOP + adatszerkezetek (JCF) +
		// kivételkezelés
		ReadUserInput input = new ReadUserInput();
		int userDecision = input.determineDictionary();
		DictionaryLoader loader = null;

		if (userDecision == 1) {
			loader = new HunToEngLoader();
		} else {
			loader = new EngToHunLoader();
		}

		Dictionary dictionary = loader.load("dictionary_data/dictionary.csv");
		String wordToTranslate = input.getWordFromUser();
		if (dictionary.contains(wordToTranslate)) {
			System.out.println("Fordítás: " + dictionary.translate(wordToTranslate));
		} else {
			System.out.println("A megadott szó nincs a szótárban.");
		}
	}
}
//