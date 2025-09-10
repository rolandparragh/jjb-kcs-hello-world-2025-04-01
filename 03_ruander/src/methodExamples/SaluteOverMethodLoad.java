package methodExamples;

public class SaluteOverMethodLoad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		salute();
		salute("Roland"); //method overloading 1 
		salute("Roland", "Parragh"); //method overloading2 
		//metódus szignatúrája alapján találja meg hogy melyiket hívja meg:
		// szignatúra javaban: metódusnév + paraméterek ha van 
		//visszatérése nincs benne --> duplicate method error lesz 
	}//main
	
	
	private static void salute() {
		System.out.println("Üdvözöllek!!");
	}
	private static void salute(String fullName) {
		System.out.println("Üdvözöllek "+fullName+"!");
	}
	
	
	private static void salute(String firstName, String lastName) {
		System.out.println("Üdvözöllek "+lastName+ " "+ firstName+"!");
	}
	

}
