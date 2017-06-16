package mmm.service.finance.exception;

public class FinanceSecurityException extends FinanceException{

	private static final long serialVersionUID = 1L;

	public FinanceSecurityException(String message) {
		super(message);
	}
	
	public FinanceSecurityException(Exception e) {
		super(e);
	}
}
