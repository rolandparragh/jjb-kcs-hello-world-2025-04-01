package cakeFactory;

import java.util.ArrayList;
import java.util.List;

public class CakeUtils {
	
	List<Cake> cakes = new ArrayList<Cake>();
public void readFile() {
FileHandler fileHandler = new FileHandler();
cakes = fileHandler.getCakesFromFile("cake_factory/tortaGyar.csv");
}

public void formattedOutPut(char divider) {
	
	for (int i = 0; i < cakes.size(); i++) {
		Cake cake = cakes.get(i);
		System.out.println(cake);
	}
}

}
