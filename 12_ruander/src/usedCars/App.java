package usedCars;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarUtils carUtils = new CarUtils();
		carUtils.readFile();
		System.out.println(carUtils.cars.size());
		carUtils.formattedOutput(';');
	}

}
