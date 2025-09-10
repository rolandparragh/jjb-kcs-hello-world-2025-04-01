package ruanderhw05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Random;


public class task02 {

	
	public static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	public static Random r = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * Kérjünk be egy vezetéknevet és keresztnevet, majd készítsünk felhasználónevet a két adatból a
következők szerint:
a. A keresztnév és vezetéknév is legyen kisbetű!
b. Ékezeteket nem tartalmazhat!
c. A vezetéknév első 3 karaktere után alulvonás keresztnév 3 karakter végül egy 3
jegyű véletlen szám. pld. Megadott név: Horváth Ábel  felhasználónév:
hor_abe541
d. Hozzunk létre egy gmail-es email címet is a felhasználónévvel!
 */
		
		createUsernameBasedOnUserInput();
	}// main
	private static void createUsernameBasedOnUserInput() {
		System.out.println("Kérem adja meg a keresztnevét: ");
			String firstname = errorhandlingFromUserInput();
			System.out.println(firstname);
		System.out.println("Kérem adja meg a vezetéknevét:");
		String lastname = errorhandlingFromUserInput();
		System.out.println(firstname + lastname);
		
		StringBuilder sb = new StringBuilder ("");
		for (int i = 0; i < 3; i++) {
			sb.append(lastname.charAt(i));
			}
		sb.append("_");
		for (int i = 0; i < 3; i++) {
		sb.append(firstname.charAt(i));
		}
		
		sb.append(String.format("%03d",r.nextInt(1000)));
		String userEmail = sb+"@gmail.com";
		System.out.println("Az Ön felhasználó neve: "+sb);
		System.out.println("Az Ön új e-mail címe:: "+userEmail);
	}
	
	
	private static String errorhandlingFromUserInput(){
		String userInput ="";
		try {
			 userInput = br.readLine().toLowerCase().trim();;
		} catch (IOException e) {
			System.out.println("IO issue occured...");
		}catch (Exception e) {
			System.out.println("An issue occured...");
		}
		if(userInput.length() < 3) {
			throw new IllegalArgumentException("A név nem lehet rövidebb mint három karakter");
		}

		if(containsInvalidChars(userInput)){
			throw new IllegalArgumentException("A név nem megfelelő karaktert tartalmaz");
		}
		return userInput;
	}
	
 
	private static boolean containsInvalidChars(String userInput){ 
		String allowedCharacters ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-., ";
		boolean isInvalid = false;
		for (int i = 0; i < userInput.length(); i++) {
			if(!allowedCharacters.contains(String.valueOf(userInput.charAt(i)))) {
				isInvalid = true;;
			}
		}
		return isInvalid;
	}

}
