package productOOP;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TaskSolution ts = new TaskSolution();
		Product product1 = ts.createProduct("product1");
		Product product2 = ts.createProduct("product2");
		product1.calculateGrossPrice();
		System.out.println(product1.toString());
		System.out.println(product2.toString());
	}

}
