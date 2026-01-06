package readIntegerFromUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputHander {

	Number userNumber;

	public void outputForUser(String message) {

		System.out.println(message);

	};

	
	
	public int getIntegerFromConsole() throws NumberFormatException,IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		outputForUser("Please provide a number");
		int userNumber = Integer.parseInt(br.readLine());

		return userNumber;
	}

}
