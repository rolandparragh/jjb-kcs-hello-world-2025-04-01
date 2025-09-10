package productOOP;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TaskSolution ts = new TaskSolution();
		Product product1 = ts.createProduct("product1");
		product1.calculateGrossPrice(product1);
		System.out.println(product1.toString());
	}

}
