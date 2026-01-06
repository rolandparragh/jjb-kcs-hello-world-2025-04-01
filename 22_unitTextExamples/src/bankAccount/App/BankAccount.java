package bankAccount.App;

import bankAccount.customException.BankAccountCustomException;

public class BankAccount {

	private String customerName;
	private double balance;

	public BankAccount(String customerName, double balance) {
		super();
		this.customerName = customerName;
		this.balance = balance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "BankAccount [customerName=" + customerName + ", balance=" + balance + "]";
	}

	public void debit(double amount) {
		
		if(amount>Double.MAX_VALUE) {
			throw new BankAccountCustomException("The amount given is too large!");
		}
		
		if(amount<0) {
			throw new BankAccountCustomException("The amount given cannot be negative!");
		}
		
		if(amount> balance) {
			throw new BankAccountCustomException("The amount given is larger than balance!");
		}

		balance -= amount;

	}

	public void credit(double amount) {
		
		if(amount>Double.MAX_VALUE) {
			throw new BankAccountCustomException("The amount given is too large!");
		}
		
		if(amount<0) {
			throw new BankAccountCustomException("The amount given cannot be negative!");
		}
		
		if(amount == 0) {
			throw new BankAccountCustomException("The amount given cannot be 0!");
		}

		balance += amount;

	}

}
