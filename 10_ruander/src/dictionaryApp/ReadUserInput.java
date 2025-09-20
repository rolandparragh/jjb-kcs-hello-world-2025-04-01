package dictionaryApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInput {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
}
