package studentFileHandling;

public class App {

	public static void main(String[] args) {
		
		// FONTOS SZABÁLYOK: 
				// 1. OOP és CC szabályait tartsuk be!
				// 2. A meglévő szöveges állományt kell feldolgozni, tartalmát ne szerkesszük, 
				// annak érdekében, hogy az algoritmusunk működjön!
				// 3. Bármilyen méretű, azonos adatszerkezetű szöveges állománynál is működnie kell
				// az egyes algoritmusoknak!
		
		FileHandler fh = new FileHandler();
		Student[] students = fh.getStudentsFromFile();
		System.out.println("students tömb mérete: "+students.length);
		System.out.println(students[0].getStudentDetails());
		System.out.println(students[5].toString());
		// Feladat00 : Refaktorálni a file handlert. 
		// Feladat01: Olvassuk be a student_details.txt (az data_student mappában található) egy 
					// olyan adatszerkezetbe, aminek a segítségével a későbbi feladatok megoldhatóak!
					// Feladat02: Írjuk az összetartozó adatokat egymás mellé tabulátorral elválasztva
					// Egy sorban egy összetartozó adat legyen!!!
					// Feladat03: Mennyi a különbség a legalacsonyabb és legmagasabb tanuló között?
					// Feladat04: Ki a legsoványabb?
					// Feladat05: Mennyi az átlagmagasság?
					// Feladat06: Hozzunk létre egy fájlt bmi.txt néven, amiben rögzítjük a testtömegindexeket!
					// (Mintasor pld. : Teszt Elek - tti: 25.65 - túlsúlyos)
					// Feladat07: Hozzunk létre egy fájlt tall_student.txt néven, majd rakjuk bele azokat a 
					// tanulókat, akik 180cm felett vannak (az eredeti fájllal azonos szerkezetben)
		
		
		
	}

}
