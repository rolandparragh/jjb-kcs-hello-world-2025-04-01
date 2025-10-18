package streamApiDescription;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
	public static void main(String[] args) {
		/********************************************************/
		/************ I. Stream létrehozásának lehetőségei *****/
		/******************************************************/
		
		// 1. Stream létrehozása kollekcióból
		System.out.println("1. Stream létrehozása listából: ");
		List<String> fruits = List.of("apple", "banana", "orange", "pear");
		Stream<String> fruitsStreamFromList = fruits.stream();
		System.out.println("Elemek a listában (stream-en belül): ");
		fruitsStreamFromList.forEach(System.out::println);
		System.out.println();
		
		// 2. Stream létrehozása tömbből
		System.out.println("2. Stream létrehozása tömbből: ");
		Stream<String> names = Arrays.stream(new String[] {
				"John",
				"Jane",
				"Jonnie"
		});
		System.out.println("Elemek a tömbből (stream-en belül): ");
		// itt a collect - terminal operator
		String result = names.collect(Collectors.joining(" "));
		System.out.println(result);
		System.out.println();
		
		// 3. Stream létrehozása szöveges fájlból
		System.out.println("3. Stream létrehozása szöveges fájlból: ");
		try {
			Stream<String> streamFromFile = Files.lines(Path.of("data/input.txt"));
			streamFromFile.forEach(System.out::println);
			streamFromFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		System.out.println();
		
		/******************************************************************************************/
		/******************* II. Intermediate operations - köztes műveletek - legfontosabbak *****/
		/****************************************************************************************/
		
        // 1. map(): egy köztes művelet, amely segítségével a stream elemeit egy másik formába tudom alakítani
        // minden egyes elemre szeretnénk ugyanazt a műveletet meghívni
        // funkcionális interface-t, lambda kifejezést kaphat paraméterként
        System.out.println("II. Intermediate operations (köztes műveletek)");
        System.out.println("1. map():");
        List<Integer> numbers = Arrays.asList(2, 5, 10, 8);
        List<Integer> squaredNumbers = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        squaredNumbers.forEach(System.out::println);
        System.out.println();
		
        // 2. filter(): szűrést hajt végre feltétel alapján
        System.out.println("2. filter():");
        List<String> userNames = Arrays.asList("johndoe", "janeDoe", "jonnie");

        int minLength = 7;
        // Milyen paramétert vár a filter()? Predicate?
        // userName helyett írhatok x-et? Igen.
        List<String> filteredUserNames = userNames.stream()
                .filter(userName -> userName.length() >= minLength)
                .collect(Collectors.toList());
        
        System.out.println("Felhasználónevek legalább 7 karakter: ");
        System.out.println(filteredUserNames); //[johndoe janeDoe]
        System.out.println();
        
        // 3. limit(): a kimeneti szekvencia méretét csökkenti
        System.out.println("3. limit():");
        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);
        System.out.println();

        // 4. sorted(): szekvencia rendezése
        System.out.println("4. sorted() - rendezés csökkenő/növekvő");
        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
        System.out.println("Rendezett szekvencia (növekvő sorrend) : ");
        list.stream().sorted().forEach(System.out::println); //pipeline - csővezeték

        //Hogyan lehet elérni az elemek csökkenő sorrendjét? 
        System.out.println("Rendezett szekvencia (csökkenő sorrend) : ");
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println();
        
        
        // 5. distinct()
        // Mi lesz a kimenete?
        System.out.println("5. distinct() - elemek egyedi csoportja");
        List<String> emails = Arrays.asList("johndoe@test.com", "janedoe@test.com", "johndoe@test.com");

        System.out.println("Egyedi emailek:");
        emails.stream().distinct().forEach(System.out::println);
        System.out.println();
        
        //6. skip() - első n elem kihagyása
        // Mi lesz a kimenete?
        System.out.println("7. skip() - elemek kihagyása");
        Stream.of(55, 68, 98, 2, 47, 6, 39, 90, 100)
                .filter(i -> i % 2 == 0)
                .skip(2)
                .forEach(i -> System.out.print(i + " ")); //2 6 90 100
        System.out.println();
        
        // Code Challange:
        // 1. Feladat: Hozzunk létre egy listát a követkető elemekkel: 3,14,5,8
        // Kérjük be a felhasználótól melyik hatványra szeretné emelni, majd streamApi
        // segítségével írjuk ki az eredményt!
        
        
        // 2. Feladat: Kérjünk be a felhasználótól 5 keresztnevet (angolul), tároljuk egy adatszerkezetben!
        // StreamApi segítségével jelenítsük meg ABC növekvő és csökkenő sorrendben!

	}

}
