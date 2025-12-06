package dogWalkerPlanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		DogWalkService dws = new DogWalkService();
		dws.readFiles();
		dws.printDogData(';');
		dws.printWalksData(',');
		// dws.printWalksData(';');

		System.out.println("1. Új séta rögzítése");
		System.out.println("2. Napi összegzés megtekintése");
		System.out.println("3. Heti összegzés megtekintése");
		System.out.println("4. Adatok mentése");
		System.out.println("5. Adatok betöltése");

		try {
			switch (br.readLine()) {
			case "1":
				System.out.println("1.Új séta rögzítése ");
				break;
			case "2":
				System.out.println("2. Napi összegzés megtekintése");
				break;
			case "3":
				System.out.println("3. Heti összegzés megtekintése");
				break;
			case "4":
				System.out.println("4. Adatok mentése");
				break;
			case "5":
				dws.readFiles();
				System.out.println("Az adatok betöltése sikeres volt");
				break;
			default: 
				System.out.println("A begépelt menü nem vezet eredményhez");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
