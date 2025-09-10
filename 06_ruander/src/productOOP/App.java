package productOOP;

public class App {

	public static Product productObj01 = new Product("Asus router -T2345", 84000, 0, "ASUS", false);
	public static Product productObj02 = new Product("TP-Link router T-1234", 95000, 10, "TP-Link", true);
	public static Product productObj03 = new Product("Logitech - egér -T1111", 32000, 15, " Logitech", true);
	public static Product productObj04 = new Product("Lenovo - laptop -T2222", 150000, 3, "Lenovo", true);
	public static Product[] products = { productObj01, productObj02, productObj03,productObj04 };
	public static void main(String[] args) {
		//ProductTasks productTask = new ProductTasks();
		// helyes paraméter számmal és sorrenddel kell meghívni ( és tipusra is figyelni
		// kell)
		ProductTasks.findsTheMoreExpensive(productObj03, productObj04);
		System.out.println("Az első termék objektum példányosítás után");
		System.out.println(App.productObj01.getName());
		System.out.println("Nettó ár: " + productObj01.getNetPrice());

		System.out.println("toString()");
		System.out.println(productObj01.toString());
		productObj01.printProductDetailsToConsole();
		// Product.printProductDetailsToConsole(); --> nem működik mert nem statikus
		productObj02.printProductDetailsToConsole();

		System.out.println(productObj01.getProductDetails());

		// task01 elérhető: false helyett az jelenjeg meg ,hogy elérhető vagy nem
		// elérhető szövegesen
		// task02 : raktármennyiség 0 heylett sajnos nincs raktáron , akkor ennyi van
		// raktáron
		// task03 : ne stringben
		// task04 : hozzunk létre 2 új terméket , melyik a drágább
		// task05: Töltsük fel tetszőleges termékadatokkal egy 3 elemű tömböt , írd ki
		// amelyik nem elérhető --kész
		// task06: konzolon jelentítsük meg a tömböt
		ProductTasks.printArray(products);
		// task07: melyikb termékből van a legtöbb
		System.out.println(ProductTasks.findTheMostOnStock(products));
		// task 08 mennyi a különbség a legtöbb és legdrágább között árban
		System.out.println("A különbsége a legdrágább és legolcsóbb között: "+ProductTasks.CheckTheDifferenceInNetPriceBetweenLowestAndHighest(products));
		// task 09 : mennyi az elérhető termékek átlagára
		// task 10 : kérjünk be egy márkanevet majd írjuk ki az ilyen temrékeket ---külön class
		//task 11: Melyik termékből van 5 feletti raktárkészlet? 
		//task12 : kérjuk be ár intevallumnak alsó és felső határát majd írjuk ki ebben az ársávban lévő termékeket
		

	}

}
