package ruanderhw05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task05 {
	private static BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
	public static void main(String[] args) {
		//Kérjük be a felhasználótól gyümölcsneveket, 
		//majd tároljuk le egy tömbbe. 
		//Fűzzük össze az egyes elemeket pontosvessző 
		//karakterrel egy darab string típusú változóba, majd írjuk ki!


	} 
	private static void printMessage( String message) {
		System.out.println(message);
	}
	private static int getAmountOfFruitsInTheArray(){
		int amountofFruitsInTheArray= 0;
		printMessage("Kérem adja meg hány gyümölcsnevet szeretne tárolni? ");
		try {
			amountofFruitsInTheArray = Integer.parseInt(br.readLine());
		
		if (amountofFruitsInTheArray ==0 ) {
            throw new IllegalArgumentException("A bemenet nem lehet üres!");
        }
		}
		catch (NumberFormatException e) {
			System.err.println("A megadott érték nem megfelelő ");
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.err.println("IO hiba történt...");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Általános hiba történt");
		}
		return amountofFruitsInTheArray;
		
	} // getAmountofFruitsInTheArray
	private static String[] createFruitArrayAndFillWithInput() {
		int arraySize = getAmountOfFruitsInTheArray();
		String[] fruitsArray = new String[arraySize];
		for (int i = 0; i < fruitsArray.length; i++) {
			
		}
	}
}
