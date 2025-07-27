package basics;

public class MathClassExample {

	public static void main(String[] args) {
		//Miért nincs szükség erre?
//		Math mathObj = new Math(); //nem kell példányosítás
		// Math - statikus osztály - nincs szükség példányosításra

		//hatványozás
		System.out.println(Math.pow(2, 3)); //2 alap, 3 kitevő: 8.0
		
		int base = 2;
		int exponent = 4;
		System.out.println(Math.pow(base, exponent)); //16.0
		
		//gyokvonás
		System.out.println(Math.sqrt(25)); //5.0
		
		// pi érték nem 3.14
		System.out.println(Math.PI); //3.141592653589793
		
		//kerekítések
		System.out.println(Math.round(25.5)); //matematika szabályai szerint kerekít: 26 
		System.out.println(Math.floor(26.9)); // lefelé kerekít: 26.0
		System.out.println(Math.ceil(33.1)); //felfelé kerekít: 34.0
		
		//abszolut érték
		System.out.println(Math.abs(-22)); //22
	}
}
