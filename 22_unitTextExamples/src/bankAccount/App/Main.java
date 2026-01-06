package bankAccount.App;

public class Main {
	
	
	
	public static void main(String[] args) {
		BankAccount bankAccount1 = new BankAccount("John Doe",200.0);
		bankAccount1.debit(20.0);
		System.out.println("200-as alapegység 20-as terhelés után:"+bankAccount1.getBalance());
		
		BankAccount bankAccount2 = new BankAccount("Jane Doe",200.0);
		bankAccount1.credit(20.0);
		System.out.println("200-as alapegység 20-as jóváírás után:"+bankAccount1.getBalance());
	}

}
