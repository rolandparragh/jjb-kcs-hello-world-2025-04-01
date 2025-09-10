package lionOOP;

public class App {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lion simObj = new Lion("Simba",(byte)5,190,(byte)3);
		System.out.println(simObj.getDetails());
		
		simObj.sleep(7*10);
		
		simObj.weekHunt();
	}

}
