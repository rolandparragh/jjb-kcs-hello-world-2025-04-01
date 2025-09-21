package dictionaryApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInput {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final int HUN_TO_ENG = 1;
	private static final int ENG_TO_HUN = 2;

	public int selectLanguage() {

		int userInput = 0;

		try {
			System.out
					.println("Kérem adja meg melyik nyelvről szeretne fordítani. 1: Magyar- Angol, 2: Angol - Magyar");
			userInput = Integer.parseInt(br.readLine());

		} catch (NumberFormatException e) {
			System.err.println("A megadott érték nem szám");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO hiba történt");
			e.printStackTrace();
		}
		return userInput;
	}

	public String getWordFromUser() {
		String userInput = "";
		System.out.println("Kérem adja meg a fordítani kívánt szót:");
		try {
			userInput = br.readLine().toLowerCase().trim();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userInput;

	}

	public int determineDictionary() {
		int userDecision = 0;
		do {
			System.out.println("A szám nem 1 vagy 2... ");
			userDecision = selectLanguage();
		} while (userDecision != HUN_TO_ENG && userDecision != ENG_TO_HUN);

		return userDecision;
	}
}
