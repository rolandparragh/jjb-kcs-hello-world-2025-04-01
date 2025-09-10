package ruanderhw05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class task01 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		/*
		 * . Kérjünk be a felhasználótól egy angol szöveget (lehet több mondat is),
		 * majd: a. A felesleges szóközöket távolítsuk el az elejéről/végéről! b. Írjuk
		 * ki hány mondatot tartalmaz! Figyeljünk, arra, hogy nem csak pont lehet a
		 * mondathatároló! c. Hány darab kis vagy nagy ’a’ betűt tartalmaz? d. Írjuk ki
		 * a teljes szöveget végig nagybetűsen! e. Írjuk ki a második megadott szót
		 * kisbetűsen! f. Szerepel –e az ’and’ angol szó a megadott szövegben?
		 * Amennyiben benne van, írjuk ki az első előfordulásának indexét! g.
		 * Ellenőrizzük le, hogy az utolsó karakter pont –e? h. Ellenőrizzük le, hogy a
		 * szöveg első karaktere nagybetűs –e? i. Az összes 2019-es évszámot cseréljük
		 * le 2020-ra. A teszteléshez megfelelő bemenetet adjunk meg, melyben többször
		 * is szerepel 2019! j. A betűk hány százaléka mássalhangzó, magánhangzó illetve
		 * egyéb karakter?
		 */
		String userSentence = getUserSentence();
		String trimmedUserSentence = trimUserSentence(userSentence);
		System.out.println(" Task 1/a trimmed user sentence: " + trimmedUserSentence);
		countIndividualSentencesInUserSentence(trimmedUserSentence);
		countLetterAInUserSentence(trimmedUserSentence);
		toUpperCaseUserSentence(trimmedUserSentence);
		String lowerCaseUserSentence = trimmedUserSentence.toLowerCase();
		findAndWordInUserSentence(lowerCaseUserSentence);
		printTheSecondWordOfUserSentence(trimmedUserSentence);
	}// main

	private static String getUserSentence() {
		String userSentence = "";
		System.out.println("Please provide a sentence that I may work with:");
		try {
			userSentence = br.readLine();
			if (userSentence == null || userSentence.trim().isEmpty()) {
				throw new IllegalArgumentException("The input cannot be empty");
			}
		} catch (IOException e) {
			System.out.println("Error occured during the reading...");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("Incorrect input: ");
		}
		return userSentence;
	}

	private static String trimUserSentence(String userSentence) {
		String trimmedUserSentence = userSentence.trim();
		return trimmedUserSentence;
	}

// nincs kész 
	private static void countIndividualSentencesInUserSentence(String userSentence) {
		int counter = 0;
		char[] punctuationmark = {'?','!','.'};
		for (int i = 0; i < userSentence.length(); i++) {

			for (int j = 0; j < punctuationmark.length; j++) {
				if( userSentence.charAt(i) == punctuationmark[j]) {
					j++;
				}
				counter++;
			}

		}
		if (counter == 0) {
			System.out.println("The text contains " + (counter + 1) + " sentences");
		} else {

			System.out.println("The text contains " + counter + " sentences");
		}

	}

	private static void countLetterAInUserSentence(String userSentence) {
		int counterA = 0;
		String lowerUserSentence = userSentence.toLowerCase();
		for (int i = 0; i < lowerUserSentence.length(); i++) {
			if (lowerUserSentence.charAt(i) == 'a') {
				counterA++;
			}
			
		}
		System.out.println(" The text contains " + counterA + "times the letter A.");
	}
	private static void toUpperCaseUserSentence ( String userSentence) {
		String UpperUserSentence = userSentence.toUpperCase();
		System.out.println(UpperUserSentence);
	}
	private static void findAndWordInUserSentence(String userSentence) {
		String and = "and";
		int index =0;
	
			if ( userSentence.contains(and)) {
				index =userSentence.indexOf(and);
				
			}
		System.out.println("The word AND appeares in the text at the  "+(index+1) +".");
		
	}
	//még nem működik 
	private static void printTheSecondWordOfUserSentence( String userSentence) {
		String trimmedUserSentence = trimUserSentence(userSentence);
		int charIndex = 0;
		int charArrayIndex=0;
		//int startIndex;
		while( trimmedUserSentence.charAt(charIndex) != ' ')charIndex++;
		//startIndex = charIndex;

		if(trimmedUserSentence.charAt(charIndex) != ' ') {
			do {

				charIndex++;
			}while(trimmedUserSentence.charAt(charIndex) != ' ');
			
		}
		char[] secondWordArray = new char[charIndex];
		charIndex =0;
		while( trimmedUserSentence.charAt(charIndex) != ' ')charIndex++;
		//startIndex = charIndex

		if(trimmedUserSentence.charAt(charIndex) != ' ') {
			do {
secondWordArray[charArrayIndex] = trimmedUserSentence.charAt(charIndex);
				charIndex++;
				charArrayIndex++;
			}while(trimmedUserSentence.charAt(charIndex) != ' ');
			
		}
		System.out.println(Arrays.toString(secondWordArray));
		}
	}
	

