package productOOP;

/*
 * POJO osztály: Plain Old Java Object
 * Csak adatszerkezet ábrázolására és adattárolásra való
 * Komolyabb business logic ne szerepeljen benne 
 * T<type> T típus: általunk létrehozott típus
 * Azokat az adatok és viselkedéseket (metódusokat) tárolom egy osztályba, 
 * ameleky között van valamilyen kohézió, kapcsolat
 *Az osztály neve főnév, metódus ige 
 *az osztály felépítése koncencó szerint kötött
 */
public class Product {
	
	/**** I. rész : fields, privát adattagok ****/
	// kizálag az osztályon belül érhetőek el: 
	private String name;
	private double netPrice;
	private int StockAmount;
	private String manufacturer;
	private boolean isAvailable;
	
	/* II. rész Consturcures */
	/* az osztállya azonos nevű általában publikus metódus nagybetűvel
	 * inicalizálja beállítja az az objektumpéldány adatait ( alapérték)
	 * akkor kerül meghívásra amikor a példányositás megtörténik ( new)  
	 * Fontos szabály: komoly üzleti logic nem szerepelhet benne 
	 * ha hibás a konstruktor akkor nem jön létre az objektumpéldány amivel a program többi része dolgozna 
	 * Paraméterrel vagy anélkül deklarálhatjuk 
	 */
	public Product(String name, double netPrice, int stockAmount, String manufacturer, boolean isAvailable) {
		super(); // ősosztály konstruktorára utal
		this.name = name; // mindig az objektumra utal , objektum name tulajdonságát állítja be 
		this.netPrice = netPrice;
		StockAmount = stockAmount;
		this.manufacturer = manufacturer;
		this.isAvailable = isAvailable;
		
	}
	
	

	public String getName() {
		return name;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public int getStockAmount() {
		return StockAmount;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	/* IV. rész saját metódusok */
	//Felülírja az ugyanilyen nevű beépített metódust 
	// debuggolás hibakezelés 

	
	
	public String getAvailabilityText() {
		return isAvailable ? "elérhető" : "nem elérhető";
	}
	public String getStockText() {
		return StockAmount > 0 ? StockAmount + " db van raktáron": "Sajnos nincs raktáron";
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", netPrice=" + netPrice + ", StockAmount=" + getStockText() + ", manufacturer="
				+ manufacturer + ", isAvailable=" + getAvailabilityText() + "]";
	}
	
	
	public void printProductDetailsToConsole() {
		
		System.out.println("Termék neve: "+this.name+", nettó ár: "+this.getNetPrice() + 
				",raktármennyiség: "+this.getStockText() +", gyártó:"+manufacturer +", elérhető-e:" +getAvailabilityText());
	}
	
	public String getProductDetails() {
		String productDetails = "Termék neve: " + name +
				", nettó ár: " + netPrice +
				", raktárkészlet: "+getStockText()+
				", gyártó: " + manufacturer +
				", elérhetőség: "+getAvailabilityText();
				return productDetails;
	}

}
