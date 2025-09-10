package fileHandlingBasics;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class OutputStreamWriterExample {

	// Feladat: szöveges fájlba (data_array mappán belül) írjuk ki a tömb adatait egymás mellé szóközzel!
	// A data_array mappát hozzuk létre
	public static void main(String[] args) {
		try {
			FileOutputStream fs = new FileOutputStream("data_array/array.txt", false);
			OutputStreamWriter out = new OutputStreamWriter(fs, "UTF-8");
			int[] numbers = {33,15,19,21,8};
			for (int number : numbers) {
				//out.write(number); // Hibás karakterek kerülnek a fájlba, számok karakterkódjai
				// Megoldás01:
				// out.write(number + " "); // így szöveg lesz
				out.write(String.valueOf(number));
				out.write(" ");
			}
			out.close();
			fs.close(); // mindkettő lezárása és a sorrend is fontos!!!
			System.out.println("Létrejött a fájl...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
// Mi a különbség a FileWriter és FileOutputSream/OutputStreamWriter között?
// 1. FileWriter-nek egyszerűbb a szintakszisa
// 2. Karakterek írására a FileWriter alkalmasabb - szöveges fájlokhoz
// Bájtok írására az OutputStreamWriter-t használjuk

