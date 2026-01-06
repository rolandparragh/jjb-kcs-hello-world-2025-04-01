package bankAccount.Test;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bankAccount.App.BankAccount;
import bankAccount.customException.BankAccountCustomException;
import divideApp.Divide;

public class BankAccountTest {
	
	
	@Test
	public void testDebit() {
		
		
		BankAccount bankAccount = new BankAccount("John Doe",200.0);
		bankAccount.debit(20.0);
		
		Double actual = bankAccount.getBalance();
		Double expected = 180.0;
		Assert.assertEquals(expected,actual);
		
	}
	
	
	@Test
	public void testCredit() {
		

		BankAccount bankAccount = new BankAccount("John Doe",200.0);
		bankAccount.credit(20.0);
		
		Double actual = bankAccount.getBalance();
		Double expected = 220.0;
		Assert.assertEquals(expected,actual);
		
		
	}
	
	@Test
	public void testDebitAmountOverFlowCreateException() {
		BankAccount bankAccount = new BankAccount("John Doe",100.0);
		Exception exception = assertThrows(BankAccountCustomException.class,()->bankAccount.debit(Double.MAX_VALUE*100));
		String actual = exception.getMessage();
		String expected = "The amount given is too large!";
		assertTrue(actual.contains(expected));
		
	}
	
	
	@Test
	public void testDebitAmountNegativeValueException() {
		BankAccount bankAccount = new BankAccount("John Doe",100.0);
		Exception exception = assertThrows(BankAccountCustomException.class,()->bankAccount.debit(-1));
		String actual = exception.getMessage();
		String expected = "The amount given cannot be negative!";
		assertTrue(actual.contains(expected));
		
	}
	@Test
	public void testDebitAmountBalanceOverflow() {
		BankAccount bankAccount = new BankAccount("John Doe",100.0);
		Exception exception = assertThrows(BankAccountCustomException.class,()->bankAccount.debit(bankAccount.getBalance()+1));
		String actual = exception.getMessage();
		String expected = "The amount given is larger than balance!";
		assertTrue(actual.contains(expected));
		
	}
	
	@Test
	public void testCreditAmountOverFlowCreateException() {
		BankAccount bankAccount = new BankAccount("John Doe",100.0);
		Exception exception = assertThrows(BankAccountCustomException.class,()->bankAccount.credit(Double.MAX_VALUE*100));
		String actual = exception.getMessage();
		String expected = "The amount given is too large!";
		assertTrue(actual.contains(expected));
		
	}
	
	@Test
	public void testCreditAmountNegativeValueException() {
		BankAccount bankAccount = new BankAccount("John Doe",100.0);
		Exception exception = assertThrows(BankAccountCustomException.class,()->bankAccount.credit(-1));
		String actual = exception.getMessage();
		String expected = "The amount given cannot be negative!";
		assertTrue(actual.contains(expected));
		
	}
	@Test
	public void testCreditAmountZeroValueException() {
		BankAccount bankAccount = new BankAccount("John Doe",100.0);
		Exception exception = assertThrows(BankAccountCustomException.class,()->bankAccount.credit(0));
		String actual = exception.getMessage();
		String expected = "The amount given cannot be 0!";
		assertTrue(actual.contains(expected));
		
	}
	
	
	
	

	// Credit
	// 4. Double határain túlmegy az összeg - Saját exception-t dobjon!
	// 5. Van -e értelme a credit(0) - nak? - 0 jóváírásra lehet eset
	// 0-nál kisebb nem lehet!!! Saját exception-t dobjon!
	// Negatív érték nem lehet!!! - Saját exception-t dobjon!
	

}
