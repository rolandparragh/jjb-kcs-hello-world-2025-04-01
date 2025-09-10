package ruanderhw05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Task03 {

	private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private final static Random r = new Random();
	private final static	String abc = "abcdefghijklmnopqrstuvwxyz";
	private final static String abcUpper = abc.toUpperCase();
	private final static String numbers = "0123456789";
	private final static char specialChar= '_';

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * Készítsünk jelszógeneráló alkalmazást! Kérjük be, hogy milyen hosszú jelszót
		 * szeretnénk! Csak az angol ABC betűit és számokat tartalmazhat! Speciális
		 * karakterek közül csak alulvonás szerepelhet benne! Kötelezően min. 2 szám,
		 * legalább 1 nagybetű és 1 speciális karakter legyen benne!
		 * 
		 */
		//char[] requiredCharacters =generateRequiredChars();
		char[] generatedPassword =createPassword();
		shufflePassword(generatedPassword);
	}

	private static char[] generateRequiredChars() {
		char[] generatedChars = new char[4];
		for (int i = 0; i < generatedChars.length-2; i++) {
			generatedChars[i] = numbers.charAt(r.nextInt(numbers.length()));
		}
		
		generatedChars[2] = abcUpper.charAt(r.nextInt(abcUpper.length()));
		generatedChars[3] = specialChar;
		
		return generatedChars;

	}
	
	private static char[] createPassword() {
		int passLength = userDefinedPasswordlength();
		char[] password = new char[passLength];
		char[] requiredChars = generateRequiredChars();
		String allpossibleChars = abc+abcUpper+numbers+specialChar;
		for (int i = 0; i < requiredChars.length; i++) {
			password[i] = requiredChars[i];
		}
		for (int i = 0+requiredChars.length; i < password.length; i++) {
			password[i] = allpossibleChars.charAt(r.nextInt(allpossibleChars.length()));
		}
		System.out.println(Arrays.toString(password));
		return password;
		
		
	}
	private static int userDefinedPasswordlength() {
		System.out.println("Kérem adja meg milyen hosszú jelszót szeretne generálni (min 4 )");
		int passLength = 0;
		
		try {
			passLength = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passLength;
	}
	// Fisher-Yates https://www.geeksforgeeks.org/java/how-to-shuffle-the-elements-of-array-in-java/
	private static void shufflePassword(char[] password) {
		char temp = ' ';
		for (int i = password.length-1; i >0 ; i--) {
			int j = r.nextInt(i+1);
			 temp = password[i];
			 password[i] = password[j];
			 password[j] = temp;
		}
		System.out.println(Arrays.toString(password));
	}

}
