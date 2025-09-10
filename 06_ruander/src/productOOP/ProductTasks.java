package productOOP;

public class ProductTasks {
//04
	public static void findsTheMoreExpensive(Product productA, Product productB) {

		if (productA.getNetPrice() > productB.getNetPrice()) {
			System.out.println("Az Első termék a drágább: " + productA);
		} else if (productA.getNetPrice() == productB.getNetPrice()) {
			System.out.println("A termékek ára egyenlő");
		} else {
			System.out.println("A második termék a drágább: " + productB);
		}

	}

	public static void findTheUnavailableProduct(Product[] products) {

		for (int i = 0; i < products.length; i++) {
			if (!products[i].isAvailable()) {
				System.out.println("A következő termék nem elérhető: " + products[i]);
			}
		}
	}

	public static void printArray(Product[] products) {
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i]);
		}
	}

	
	// nem a legjobb megoldás mert az első után kilép! az orai példa ez volt: 
	public static Product findTheMostOnStock(Product[] products) {
		Product productTmp = products[0];
		for (int i = 0; i < products.length; i++) {
			if (products[i].getStockAmount() > productTmp.getStockAmount()) {
				productTmp = products[i];
			}
		}
		return productTmp;
	}
	/*// CC szerinti megoldás:
	private int getMaxStockAmount(Product[] products) {
		int maxStockAmount = products[0].getStockAmount();
		for (Product product : products) {
			if (product.getStockAmount()>maxStockAmount) {
				maxStockAmount = product.getStockAmount();
			}
		}
		return maxStockAmount;
	}
	
	public void printMaxStockAmountToConsole(Product[] products) {
		int maxStockAmount = getMaxStockAmount(products);
		for (Product product : products) {
			if (product.getStockAmount() == maxStockAmount) {
				System.out.println(product.getProductDetails());
			}
		}
	}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	public static Product findTheCheapest(Product[] products) {
		Product productTmp = products[0];
		for (int i = 0; i < products.length; i++) {
			if (products[i].getNetPrice() < productTmp.getNetPrice()) {
				productTmp = products[i];
			}
		}
		return productTmp;
	}
	public static Product findTheMostExpensive(Product[] products) {
		Product productTmp = products[0];
		for (int i = 0; i < products.length; i++) {
			if (products[i].getNetPrice() > productTmp.getNetPrice()) {
				productTmp = products[i];
			}
		}
		return productTmp;
	}
	public static double CheckTheDifferenceInNetPriceBetweenLowestAndHighest(Product[] products) {
		Product cheapest = findTheCheapest(products);
		Product mostExpensive = findTheMostExpensive(products);
		double netDifference = mostExpensive.getNetPrice()-cheapest.getNetPrice();
		return netDifference;
	}

}
