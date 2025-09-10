package recursion;

public class Fibonacci {
	public static void main(String[] args) {
		// Fibonacci: 
		// 1 1 2 3 5 8 13 21 34 55...
		// az aktuális elem a 3.elemtől az előtte lévő két elemnek az összege
		// Természetben előforduló számsorozat - növények formavilága

		// Feladat: Megoldás: Ciklussal és rekurzív alg.
		Fibonacci fibonacciObj = new Fibonacci();
		System.out.println("Fibo ciklussal számol: "+fibonacciObj.fiboCalculateFor(8));
		System.out.println("Fibo rekurzióval számol: "+fibonacciObj.fiboCalculateRecursion(8));
	}

	private int fiboCalculateRecursion(int n) {
		if (n<=2) return 1;
		else return fiboCalculateRecursion(n-1)+fiboCalculateRecursion(n-2);
	}
	
	private int fiboCalculateFor(int n) {
		if (n==1) return 1;
		if (n==2) return 1; 
		
		int f1 = 1;
		int f2 = 1;
		int f3 = 0;
		
		for (int i = 3; i <=n; i++) {
			f3 = f1+f2;
			f1 = f2;
			f2 = f3;
		}
		return f3;
	}
}
