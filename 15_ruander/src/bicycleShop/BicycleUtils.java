package bicycleShop;

import java.util.ArrayList;
import java.util.List;

public class BicycleUtils {

	List<Bicycle> bicycles = new ArrayList<>();

	public void readFile() {
		FileHandler fileHandler = new FileHandler();
		bicycles = fileHandler.getBicycleFromFile("data_bicycle/bicycles.csv");
	}
	
	public List<Bicycle> readFile(String filePath) {
		FileHandler fileHandler = new FileHandler();
		bicycles = fileHandler.getBicycleFromFile(filePath);
		return bicycles;
	}

	public void outputBicycleList() {
		for (int i = 0; i < bicycles.size(); i++) {
			System.out.println(bicycles.get(i));

		}

	}
	
	
	

}
