package mmm.service.finance.model.json;

import java.util.List;

import mmm.service.finance.model.Collection;
import mmm.service.finance.model.Loan;

public class LoanCreationJson {
	private long id;
	private String borrower;
	private String guranteer;
	private String creator;
	private String approver;
	private int principle;
	private float rate;
	
	private String collectionFrequency;
	private int tenure;
	private String status;
	private String remark;
	
	private List<Collection> collections;
	
	public LoanCreationJson() {}
	public LoanCreationJson(Loan loan) {
		this.id = loan.getId();
		this.borrower = loan.getBorrower().getLoginID();
		this.guranteer = loan.getGuranteer().getLoginID();
		this.creator = loan.getCreator().getLoginID();
		this.approver = loan.getApprover() == null ? null :loan.getApprover().getLoginID();
		
		this.principle = loan.getPrinciple();
		this.rate = loan.getRate();
		this.collectionFrequency = loan.getCollectionFrequency().getName();
		this.tenure = loan.getTenure();
		this.status = loan.getStatus().getName();
		this.remark = loan.getRemark();
		this.collections = loan.getCollections();
	}
	
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public String getGuranteer() {
		return guranteer;
	}
	public void setGuranteer(String guranteer) {
		this.guranteer = guranteer;
	}
	public int getPrinciple() {
		return principle;
	}
	public void setPrinciple(int principle) {
		this.principle = principle;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getCollectionFrequency() {
		return collectionFrequency;
	}
	public void setCollectionFrequency(String collectionFrequency) {
		this.collectionFrequency = collectionFrequency;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Collection> getCollections() {
		return collections;
	}
	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	
}
