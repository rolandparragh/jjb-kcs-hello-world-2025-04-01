package breakContinueExample;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App appObj = new App();
		appObj.printBreak();
		appObj.printContinue(); 
	}

	private void printBreak() {

		System.out.println("Break - példa");

		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println("I értéke: " + i);
		}
	}
	
	private void printContinue() {
		System.out.println("Continue-példa");
		for (int i = 0; i < 10; i++) {
			if (i==2) {
				continue;
			}
			System.out.println("i értéke: "+i);
		}
		//a 2őt kihagyja, de csak a for ig ugrik , és folyatja a 3 mal 
		
	}

}


// a Cikluson kivülre ugrik a break hátására 