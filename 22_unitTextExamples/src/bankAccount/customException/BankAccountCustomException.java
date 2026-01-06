package bankAccount.customException;

public class BankAccountCustomException extends RuntimeException {
	
	private static final long serialVersionUID= 4214215126125L;
	
	public BankAccountCustomException(String errorMessage) {
		super(errorMessage);
	}

}
