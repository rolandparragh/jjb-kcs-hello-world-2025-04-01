package productOOP;

import java.util.Random;

public class TaskSolution {
	private static Random r = new Random();
	private static final int MAX_PRICE = 1_000_000;
	private static final int MAX_STOCK = 1_000;

	// Min. 2 darab objektumpéldányt tölts fel tetszőleges (emelt szint  random)
	// adatokkal.
	public Product createProduct(String productName) {
		int netPrice = r.nextInt(MAX_PRICE) + 1;
		int stockAmount = r.nextInt(MAX_STOCK) + 1;
		boolean isAvailable = r.nextBoolean();

		Product productCreation = new Product(productName, netPrice, stockAmount, isAvailable);
		return productCreation;

	}

	public void printMoreExpensiveProduct(Product product1, Product product2) {

		if (product1.getNetPrice() > product2.getNetPrice()) {
			System.out.println("A drágább termék: " + product1);
		} else if (product1.getNetPrice() == product2.getNetPrice()) {
			System.out.println("A két termék ára megegyezik.");
			System.out.println(product1);
			System.out.println(product2);
		} else {
			System.out.println("A drágább termék: " + product2);
		}
	}

}
