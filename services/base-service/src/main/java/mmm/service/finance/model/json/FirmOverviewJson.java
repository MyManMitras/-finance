package mmm.service.finance.model.json;

public class FirmOverviewJson {
	
	private int totalCustomers;
	private Double totalLentAmount;
	private Double totalDeposits;
	private Double cashInFirm;
	public int getTotalCustomers() {
		return totalCustomers;
	}
	public void setTotalCustomers(int totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	public Double getTotalLentAmount() {
		return totalLentAmount;
	}
	public void setTotalLentAmount(Double totalLentAmount) {
		this.totalLentAmount = totalLentAmount;
	}
	public Double getTotalDeposits() {
		return totalDeposits;
	}
	public void setTotalDeposits(Double totalDeposits) {
		this.totalDeposits = totalDeposits;
	}
	public Double getCashInFirm() {
		return cashInFirm;
	}
	public void setCashInFirm(Double cashInFirm) {
		this.cashInFirm = cashInFirm;
	}

}
