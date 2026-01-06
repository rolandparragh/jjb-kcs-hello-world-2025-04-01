import org.junit.jupiter.api.Test;

import readIntegerFromUser.UserInputHander;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadDataFromConsoleTest {

	

		// Automata tesztelés input adatokra nehézkes lehet. Mockdata-val lehetséges, ami 
		// lehetőség szerint minél jobban hasonlítson a felhasználó által megadotthoz.
		
		// Bad practice: input adatot vár a konzolon és NEM automata teszt, futás idejű hibát dob
		@Test
		public void testGetIntegerFromConsoleWhenStringGiven() {
			UserInputHander userInputHandler = new UserInputHander();
			Exception exception = assertThrows(RuntimeException.class,()->userInputHandler.getIntegerFromConsole());
			String expectedMessage = "For input string";
			String actualMessage = exception.getMessage();
			assertTrue(actualMessage.contains(expectedMessage));
		}
		
		// Mi történik, ha a felhasználó megadja a következő értéket: t44 (tizenegy)
		// Nincs saját metódus ellenőrzés. Java működését ellenőrizzük.
		@Test
		public void testNumberAsStringFormatException() {
			Exception exception = assertThrows(RuntimeException.class, ()-> Integer.parseInt("t44"));
			String expectedMessage = "For input string";
			String actualMessage = exception.getMessage();
			assertTrue(actualMessage.contains(expectedMessage));
		}
	}

	// Code Challange 1: Háromszög szerkeszthetőség ellenőrzése - számítás és tesztelés
	// Code Challange 2: Három egész szám átlagát írjuk ki! - számítás, tesztelés
	// Code Challange 3: Hány magánhangzó van a paraméterül kapott szövegben? Készítsünk teszteket az ellenőrzéshez!
