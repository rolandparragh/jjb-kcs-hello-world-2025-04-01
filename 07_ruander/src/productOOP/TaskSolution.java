package productOOP;

import java.util.Random;

public class TaskSolution {
	private static Random r = new Random();
	
	
	
	public Product createProduct( String productName) {
		int netPrice = r.nextInt(1000000)+1;
		int stockAmount = r.nextInt(1000)+1;
		boolean isAvailable = r.nextBoolean();
		
		Product productCreation = new Product(productName,netPrice,stockAmount,isAvailable); 
		return productCreation; 
		
	}
}
