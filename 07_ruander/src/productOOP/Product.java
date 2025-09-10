package productOOP;

public class Product {

	private String productName;
	private int netPrice;
	private int stockAmount;
	private boolean isAvailable;
	public Product(String productName, int netPrice, int stockAmount, boolean isAvailable) {
		super();
		this.productName = productName;
		this.netPrice = netPrice;
		this.stockAmount = stockAmount;
		this.isAvailable = isAvailable;
	}
	public String getProductName() {
		return productName;
	}
	public int getNetPrice() {
		return netPrice;
	}
	public int getStockAmount() {
		return stockAmount;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", netPrice=" + netPrice + ", stockAmount=" + stockAmount
				+ ", isAvailable=" + isAvailable + "]";
	}
	
	//- c. Készítsünk metódust, ami kiírja az egyes termékek bruttó árát!
	public double calculateGrossPrice() {
		return (double) netPrice*1.27;
	}
	
	
}
