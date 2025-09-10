package ruanderhw05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task04 {

	
	private static BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
	public static void main(String[] args) {
		/*
		 * Kérjünk be 2 szót és egy határolót, 
		 * majd fűzzük össze a megadott határoló mentén: 
		 * pld. a két megadott szó  mákos és tészta, határoló #  eredmény mákos#tészta
		 */
		printText("Kérem az első szót:");
		String firstWord = takeUserInputWithExceptionHandling();
		printText("Kérem a második szót:");
		String secondWord = takeUserInputWithExceptionHandling();
		printText("Kérem a határolót :");
		String delimiter = takeUserInputDelimiterWithExceptionHandling();
		String joinedWord = String.join(delimiter,firstWord,secondWord);
		printText("Az összefűzött szó:" +joinedWord);
	}
	private static void printText( String printMessage) {
		System.out.println(printMessage);
		
	}
	private static String takeUserInputWithExceptionHandling() {
		String userInput = ""; 
		try {
	          
	            userInput = br.readLine();


	            if (userInput == null || userInput.trim().isEmpty()) {
	                throw new IllegalArgumentException("A bemenet nem lehet üres!");
	            }

	            // szám ellenőrzése
	            if (userInput.matches(".*\\d.*")) {
	                throw new IllegalArgumentException("A bemenet nem tartalmazhat számot!");
	            }
	        } catch (IOException e) {
	            System.out.println("Hiba történt a beolvasás során: " + e.getMessage());
	        } catch (IllegalArgumentException e) {
	            System.out.println("Hibás bemenet: " + e.getMessage());
	        }
		return userInput;
	    }

	    

	private static String takeUserInputDelimiterWithExceptionHandling() {
		String userInput = ""; 
		try {
	           
	            userInput = br.readLine();

	            // üres bemenet ellenőrzése
	            if (userInput == null || userInput.trim().isEmpty()) {
	                throw new IllegalArgumentException("A bemenet nem lehet üres!");
	            }

	        } catch (IOException e) {
	            System.out.println("Hiba történt a beolvasás során: " + e.getMessage());
	        } catch (IllegalArgumentException e) {
	            System.out.println("Hibás bemenet: " + e.getMessage());
	        }
		return userInput;
	    }
}
