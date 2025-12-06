package dogWalkerPlanner;

import java.util.ArrayList;
import java.util.List;

public class DogWalkService {
	List<Dog> dogs = new ArrayList();
	List<WalkEntry> walks = new ArrayList();
	private FileHandler fileHandler = new FileHandler();

	public void readFiles() {
		
		dogs = fileHandler.getDogsFromFile("dog_planner/dogs.txt");
		walks = fileHandler.getWalksfromFile("dog_planner/walks.txt");	}

	public void printDogData(char divider) {
		for (Dog dog : dogs) {
			System.out.println(dog.getDogsByDivider(divider));
		}
	}
		public void printWalksData(char divider) {
		for (WalkEntry walkEntry: walks) {

			System.out.println(walkEntry.getWalksByDivider(divider));
			
		}
	}

	/*private String[] readWalkFromUserInput() {
		int[] newWalkEntry = new int[3];
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		System.out.println("Kérem adja meg a kutya id-ját");
		
		if(br.readLine()) {
			
		}
		newWalkEntry =
	}

	*/
		


}
