package arrayExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MatrixExample {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * Mátrix: több dimenziós tömb Egy érték tárolása sor és oszlopindex
		 * segítségével történik sorindex i oszlopindex j
		 * 
		 */

		System.out.println(" Mátrix feltöltése megadott egész számokkal");
		int[][] matrix1 = { { 1, 44, 66, 88 }, { 77, 49, 93, 11 }, { 2, 52, 17, 5 }

		};
		System.out.println("mátrix[2][1] értéke " + matrix1[2][1]); // 52
		System.out.println("mátrix [1][3] érték" + matrix1[1][3]); // 11

		// matrix elemeinek kiírása -sorszintű bejárással
		// eleme kiírása formázottan- tabulatorral
		// külső for ciklus a sorokat lépteti i változó
		// belső for ciklus a soron belüli oszlopelemeket lépteti j változóval

		System.out.println(" Mátrix elemeinek kiírása:");

		for (int i = 0; i < matrix1.length; i++) { // a sorban!!!
			for (int j = 0; j < matrix1[i].length; j++) { // bejárja az oszlopokat!!! 
				System.out.print(matrix1[i][j] + "[" + i + j + "]" + "\t"); // kiírja az sor index oszlop index tagját 
			}
			 System.out.println();// ide tesz egy sortörést ha az oszlop összes értékén végigment 
		}
		System.out.println();

		// feladat 2 5x6 sor oszlop mátrix feltöltése véletlen számokkal 1-100 között ,
		// formázzuk
		int[][] matrix2 = new int[5][6]; // vagy méret vagy elemek
		Random r = new Random();

		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[i].length; j++) {
				matrix2[i][j] = r.nextInt(100) + 1;
				// System.out.print(matrix2[i][j] + "["+i+j+"]"+"\t"); metódusokkal cc szegése
				// van, mert két dolgot csinál
			}
			 System.out.println();

		}

		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[i].length; j++) {

				System.out.print(matrix2[i][j] + "[" + i + j + "]" + "\t");
			}
			 System.out.println();

		}
		
		// Feladat03: 2X3-as mátrix feltöltése (sorszintű) a felhasználótól érkező egész számokkal.
		// Írjuk ki a feltöltött mátrixot formázottan! A sor és oszlopindexet beolvasáskor is
		// jelenítsük meg!
		System.out.println("Feladat03: 2X3-as mátrix feltöltése (sorszintű) "
		+ "a felhasználótól érkező egész számokkal");
		int[][] matrix3 = new int[2][3];
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		for (int i = 0; i < matrix3.length; i++) {
			for (int j = 0; j < matrix3[i].length; j++) {
				System.out.print("Kérem a(z) [" + i + "][" + j + "] helyre az értéket: ");
				matrix3[i][j] = Integer.parseInt(br.readLine());
		}
				
		}
		System.out.println(" Kiírás:");
		for (int i = 0; i < matrix3.length; i++) {
			for (int j = 0; j < matrix3[i].length; j++) {

				System.out.print(matrix3[i][j] + "[" + i + "][" + j + "]\t");
			}
			 System.out.println();

		}
				

		//Feladat04: 4X2-es mátrix oszlopszintű feltöltése a felhasználótól érkező karakterekkel!
		//Írjuk ki a feltöltött mátrixot formázottan.
		System.out.println("Feladat04:4X2-es mátrix oszlopszintű feltöltése a felhasználótól érkező karakterekkel! ");
		int rowSize = 4;
		int columnSize = 2;
		char[][] matrix4 = new char[rowSize][columnSize];
		
		//mátrix feltöltése
		char inputChar;
		for (int j = 0; j < columnSize; j++) {
			for (int i = 0; i < rowSize; i++) {
				System.out.print("sorindex: "+i+", oszlopindex: "+j+":");
				inputChar = br.readLine().charAt(0);
				matrix4[i][j] = inputChar;
			}
		}
		
		//mátrix kiírása
		for (int i = 0; i < matrix4.length; i++) {
			for (int j = 0; j < matrix4[i].length; j++) {
				System.out.print(matrix4[i][j] +"\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		//Feladat05: 6X4-es mátrix feltöltése (sorszintű) véletlen számokkal 60-80 között.
		//Írjuk ki a mátrix elemeit! Cseréljük meg az első két sort és írjuk ki újra.
		System.out.println("Feladat05: 6X4-es mátrix feltöltése (sorszintű) véletlen számokkal 60-80 között, "
		+ "első két sor csere");
		System.out.println("Feladat05: 6X4-es mátrix feltöltése (sorszintű) véletlen számokkal 60-80 között, "
				+ "első két sor csere");
		
		int rowSize5 = 6;
		int columnSize5 = 4;
		int[][] matrix5 = new int[rowSize5][columnSize5];
		int lowerLimit = 60;
		int upperLimit = 80;
		
		//mátrix feltöltése
		for (int i = 0; i < matrix5.length; i++) {
			for (int j = 0; j < matrix5[i].length; j++) {
				matrix5[i][j] = r.nextInt((upperLimit-lowerLimit)+1)+lowerLimit;
			}
		}
		
		// mátrix kiírása
		System.out.println("Az eredeti matrix5 elemei: ");
		for (int i = 0; i < matrix5.length; i++) {
			for (int j = 0; j < matrix5[i].length; j++) {
				System.out.print(matrix5[i][j] +"\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
		// Csere algoritmusa (egyszerű csere alg.) - szükség van egy segédváltozóra (azonos tipus)
		for (int j = 0; j < columnSize5; j++) {
			int temp = matrix5[0][j];
			matrix5[0][j] = matrix5[1][j];
			matrix5[1][j] = temp;
		}
		
		System.out.println("Az matrix5 elemei első két sor csere után: ");
		for (int i = 0; i < matrix5.length; i++) {
			for (int j = 0; j < matrix5[i].length; j++) {
				System.out.print(matrix5[i][j] +"\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
		
		

		//Feladat06: 4X3 (4 sor és 3 oszlop) mátrix feltöltése véletlen számokkal
		// 1-100 között. Írjuk ki a számokat formázottan! Soronként mi az elemek összeg?
		System.out.println("Feladat06: 4X3 (4 sor és 3 oszlop) mátrix feltöltése véletlen számokkal, "
				+ ", soronként írjuk ki az elemek összegét:");
		int[][] matrix6 = new int[4][3];
		
		//mátrix feltöltése véletlen számokkal
		for (int i = 0; i < matrix6.length; i++) {
			for (int j = 0; j < matrix6[i].length; j++) {
				matrix6[i][j] = r.nextInt(100)+1;
			}
		}
		
		for (int i = 0; i < matrix6.length; i++) {
			int sum = 0;
			for (int j = 0; j < matrix6[i].length; j++) {
				System.out.print(matrix6[i][j] +"\t");
				sum += matrix6[i][j];
			}
			System.out.print("\t" +"Összeg: "+sum);
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
		br.close();
	}

}
