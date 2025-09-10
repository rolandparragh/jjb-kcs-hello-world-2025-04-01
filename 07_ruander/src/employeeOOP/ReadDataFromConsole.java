package employeeOOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadDataFromConsole {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// Refaktorálás CC szerint
	// Refaktorálás folyamata: műkődő kódot írunk újra, szebbé, átláthatóbbá, jobban bővíthetővé, működő kód legyen a vége
	// Fontos célja: konvenciókat jobban betartsuk (CC és OOP szabályok)
	// Folyamatos finomítás és tesztelés (egyelőre manuális)
//	public Employee[] readEmployeeInputData() {
//		// int[] numbers = new int[5];
//		//int employeeCount = readEmployeCount();
//		Employee[] employees = new Employee[readEmployeCount()];
//		try {
//			for (int i = 0; i < employees.length; i++) {
//				System.out.println("Kérem adja meg a(z) "+(i+1)+". dolgozó adatait: ");
//				System.out.print("Vezetéknév: ");
//				String lastName = br.readLine();
//				System.out.print("Keresztnév: ");
//				String firstName = br.readLine();
//				System.out.print("Beosztás: ");
//				String role = br.readLine();
//				System.out.print("Fizetés: ");
//				int salary = Integer.parseInt(br.readLine());
//				System.out.print("Kivehető szabadság: ");
//				int maxHoliday = Integer.parseInt(br.readLine());
//				System.out.print("Kivett szabadság: ");
//				int holidayTaken = Integer.parseInt(br.readLine());
//				byte activeTemp = -1;
//				do {
//					System.out.print("Aktív - 1, inaktív - 0: ");
//					activeTemp = Byte.parseByte(br.readLine());
//				} while (activeTemp !=1 && activeTemp!=0);
//				boolean active = activeTemp ==1 ? true:false; //ternary operator: rövidített 2irányú elág.
//				Employee newEmployeeObj = new Employee(
//						firstName,
//						lastName,
//						role,
//						salary,
//						maxHoliday,
//						holidayTaken,
//						active);
//				employees[i] = newEmployeeObj;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return employees;
//	}
//	
//	private int readEmployeCount() {
//		int employeeCount = 0;
//		try {
//			System.out.print("Kérem adja meg hány dolgozó adatait szeretné felvinni: ");
//			employeeCount = Integer.parseInt(br.readLine());
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return employeeCount;
//	}
	
	private String readText(String message) {
		System.out.print(message);
		String text = null;
		try {
			text = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	
	private int readInt(String message) {
		System.out.print(message);
		int number = 0;
		try {
			number = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	
	private boolean readBoolean(String message) {
		System.out.print(message);
		byte temp = -1;
		do {
			System.out.print("Aktív - 1, inaktív - 0: ");
			try {
				temp = Byte.parseByte(br.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (temp !=1 && temp!=0);
		boolean active = temp ==1 ? true:false; //ternary operator: rövidített 2 irányú elág.
		// ternary operator (java), Csharp conditional operator
		// php short if
		// kétirányú elágazás
		// feltétel: temp == 1
		// ha igaz akkor true-val tér vissza
		// ha hamis akkor false
		return active;
	}
	
	private Employee getEmployeeObjectFromInput() {
		String lastName = readText("Vezetéknév:");
		String firstName = readText("Keresztnév:");
		String role = readText("Beosztás:");
		int salary = readInt("Fizetés: ");
		int maxHoliday = readInt("Kivehető szabadság: ");
		int holidayTaken = readInt("Kivett szabadság: ");
		boolean active = readBoolean("Aktív - 1, inaktív - 0: ");
		Employee employee = new Employee(firstName, lastName, role, salary, maxHoliday, holidayTaken, active);
		return employee;
	}
	
	public Employee[] fillEmployeesArrayByUserInput() {
		int employeeArrayLength = readInt("Kérem adja meg hány dolgozó adatait szeretné felvinni: ");
		Employee[] employees = new Employee[employeeArrayLength];
		for (int i = 0; i < employees.length; i++) {
			System.out.println("Kérem adja meg a(z) "+(i+1)+". dolgozó adatait: ");
			Employee newEmployee = getEmployeeObjectFromInput();
			employees[i] = newEmployee;
		}
		return employees;
	}
}
