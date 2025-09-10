package ruanderhw05;

public class StringCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String[] stringArray ={"alma","!"," ",""};
		printStateofStringElement(stringArray);
	}//main
	
	
	private static boolean isStringEmptyAtIndex(String[] stringArray, int i) {
	/*	boolean isEmpty = false;
		if (stringArray[i].isEmpty()) {
		isEmpty = true;	
		}
		return isEmpty;*/
		return stringArray[i].isEmpty();
	}
	
	private static void printStateofStringElement(String[] stringArray) {
		
		
		for (int i = 0; i < stringArray.length; i++) {
			System.out.println("index: "+i+ " érték: "+isStringEmptyAtIndex(stringArray, i));
		}
	}

}
