package studentFileHandling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class FileHandler {

	private String fileNamePath = "data_student/student_details.txt";
	private String header = null;

	public Student[] getStudentsFromFile() {
		// ism
		// int[] numbers = new int[10];
		// Student[] students = new Student[6]; // hard code , megszegtük a 3. szabályt

		// 1. lépés: A tömb létrehozásához meghatározzuk a méretét a sorok száma
		// alapján.
		// 2 megoldás: 1. bejárjuk while(br.ready()) counter léptetés
		// 2. megoldás: Path osztály használata (ezt választjuk)
		// 2. lépés cikluson belül beolvasunk 1 teljes sort
		// 3. lépés: split() határoló mentén szétdaraboljuk a sort
		// 4. lépés: studentObj létrehozása a darabolt adatok alapján (1 sor adatai)
		// 5. lépés: students tömbbe mentés
		// 6. lépés: Olvasó adatfolyam bezárása
		int arraySize = getStudentArraySizeBasedOnFile();
		// System.out.println("A tömb mérete: "+arraySize);
		Student[] students = new Student[arraySize];

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileNamePath)));
			br.readLine(); // nincs fejléc mentés, csak beolvasunk 1 sort. 
			for (int i = 0; i < students.length; i++) {
				String row = br.readLine();
				String[] rowData = row.split(";");
				String name = rowData[0];
				int height = Integer.parseInt(rowData[1]);
				int weight = Integer.parseInt(rowData[2]);
				Student newStudent = new Student(name, height, weight);
				students[i] = newStudent;
			}
			br.close(); // ne a cikluson belülre kerüljön
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return students;
	}

	private int getStudentArraySizeBasedOnFile() {
		// Java 11 óta nio package ,fájlkezelés emeltebb szintje , érdemes használni,
		// mert nem kell kétszer bejárni for ciklussal.
		Path filePath = Paths.get(fileNamePath);
		long rowCount;
		int arraySize = 0;
		try {
			rowCount = Files.lines(filePath).count();
			arraySize = (int) rowCount - 1; // Fontos, csak int lehet a tömb mérete ( -1 a fejléc)
			// Hiba lehet a 2mrd146 millió sornál hosszabb fájlok esetében
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arraySize;
	}

}
