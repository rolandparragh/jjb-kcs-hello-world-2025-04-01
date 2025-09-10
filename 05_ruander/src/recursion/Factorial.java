package recursion;

public class Factorial {
	public static void main(String[] args) {
		// Rekurzió: önmagát meghívó metódus
		// Tömörebb lesz a kód, jobban átlátható, 
		// néhány sorban megoldjuk a problémát, elegáns. 
		// Minden rekurziv algoritmus megoldható ciklussal is. 
		// Fontos része a kilépési pont!!!
		// !5 5 faktoriális
		// 5*4*3*2*1 = 120
		Factorial factorialObj = new Factorial();
		System.out.println("Faktoriális ciklussal: "+factorialObj.factorialCalculateFor(5));
		System.out.println("Faktoriális rekurzióval: "+factorialObj.factorialCalculateRecursion(5));
	}
	
	private long factorialCalculateRecursion(int n) {
		if (n==0) return 1;
		else return (factorialCalculateRecursion(n-1)*n);
	}
	
	private long factorialCalculateFor(int n) {
		long sum = 1;
		for (int i = 1; i <= n; i++) {
			sum*=i; //ua. sum=sum*i;
		}
		return sum;
	}
}