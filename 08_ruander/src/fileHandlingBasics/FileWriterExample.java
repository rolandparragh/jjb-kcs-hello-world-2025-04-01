package fileHandlingBasics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileWriterExample {

	public static void main(String[] args) {
		
		// relatív elérési út - projekt mappa
		// abszolut elérési út @C:/temp/data_fruits/fruits.txt
		
		// léteznie kell egy ilyen mappának!!!
		File filePath = new File("data_fruits/fruits.txt");

		// String fileNameTxt = "data_fruits/fruits.txt";
		
		// Relatív vs. abszolut elérés
		// fentiek - relatív: aktuális mappától indul ki, ez a projektmappa gyökere
		// C gyökérben készítsünk egy temp nevű mappát és abban hozzunk létre egy data_fruits
		// Ha megvan a mappaszerkezet, akkor tudjuk futtatni, léteznie kell a mappaszerkezetnek:
		// C:\\temp\\data_fruits
		
		// dupla perjel - eszképelés:  
		// abszolut elérési út megadással
		//String filePathTxt = "C:\\temp\\data_fruits\\fruits.txt";
		// speciális karakterek eszképelés @&\/*_ - regexes feladatoknál is előjön
		
		// abszolut elérési út megadással hozzuk létre a fájlt az Asztalon:
		// String filePathDesktopTxt = "C:\\Users\\Tuf\\Desktop"; //hozzáférés megtagadva
		
		// Javaslat: relatív útvonal használata.
		
		try {
			// Java11 óta lehet ennyi féle paramétere a konstruktornak
			// append kapcsoló: true - hozzáfűzés, a meglévő tartalom után fűzi az új tartalmat
			// false-nál felülírja a tartalmat (ha már van ilyen nevű fájl)
			// Ha nincs ilyen nevű fájl, akkor létrehozza
			// EOF-ból az append honnan, kell folytatni
			// fw - író adatfolyam neve
			// túlterhelhető a FileWriter
			// FileWriter fw = new FileWriter(filePath); // UTF-8-at hozott létre, jók az ékezetek
			// FileWriter fw = new FileWriter(filePath, Charset.forName("UTF-8"));
			// FileWriter fw = new FileWriter(filePath, Charset.forName("UTF-8"), true);
			FileWriter fw = new FileWriter(filePath, Charset.forName("UTF-8"), false);
			//FileWriter fw = new FileWriter(fileNameTxt, Charset.forName("UTF-8"), false);
			fw.write("alma\r\n");
			fw.write("körte\r\n");
			fw.write("szilva\r\n");
			fw.close(); //nagyon fontos része, ha kimarad 0 byte mérettél jön létre a fájl
			System.out.println("Létrejött a fájl...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
//Írásnál lépések sorrendje:
//1. Író adatfolyam létrehozása
//2. Fájlbaírás
//3. Író adatfolyam bezárása (nagyon fontos része, ha kimarad, akkor létrejön a fájl, de nem kerül bele semmi)
