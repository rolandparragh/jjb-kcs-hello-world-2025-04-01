package usedCars;

import java.util.ArrayList;
import java.util.List;

public class CarUtils {

	List<Car> cars = new ArrayList<Car>();
	
	
	public void readFile() {
		FileHandler fileHandler = new FileHandler();
		cars = fileHandler.getCarsFromFile("used_cars/hasznalt_autok.txt");
	}
	
	
	public void formattedOutput(char divider) {
		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			System.out.println(car.formattedCarString(divider));
		}
	}
	
}
