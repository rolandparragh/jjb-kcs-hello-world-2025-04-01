package estateOOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadDataFromConsole {
	
	public static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private String readText(String message) {
		
		System.out.println(message);
		String text = null;
		try {
			text = br.readLine().trim();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	
	private int readInt(String message) {
		System.out.println(message);
		int number = 0;
		String text ="";
		try {
			text = br.readLine().trim();
			number = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	
	private int readByte(String message) {
		System.out.println(message);
		byte number = 0;
		String text ="";
		try {
			text= br.readLine();
			number = Byte.parseByte(text);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	
	
	// Kérjük be a felhasználótól egy ingatlan adatait, majd hozzunk létre egy objektumpéldányt az adatokkal!
	public Estate getEstateObjectFromInput(){
		String title = readText("Kérem adja meg az ingatlan megnevezését / Tipusát: ");
		int m2 = readInt("Kérem adja meg az ingatlan méretét m2-ben Egész arab számokat használva: ");
		int postCode = readInt("Kérem adja meg az irányitószámot: ");
		String cityName = readText("Kérem adja meg a várost ahol az ingatlan található: ");
		String address = readText("Kérem adja meg az közterület nevét, jellegét és a házszámot: ");
		byte numberOfRooms = (byte) readByte("Kérem adja meg hány szoba található az ingatlanban, Kérem tekintse a fél szóbát is teljes értékű szobának:");
		Estate estate = new Estate(title, m2, postCode, cityName, address,numberOfRooms);
		return estate;
	}
	
}
