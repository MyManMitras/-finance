package mmm.service.finance.exception;

public class FinanceException extends Exception{

	private static final long serialVersionUID = 1L;

	public FinanceException(String message) {
		super(message);
	}
	
	public FinanceException(Exception e) {
		super(e);
	}
	
	@Override
	public String toString() {
		return this.getMessage();
	}
}
