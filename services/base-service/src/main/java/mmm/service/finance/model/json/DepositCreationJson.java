package mmm.service.finance.model.json;

import mmm.service.finance.model.Deposit;

import java.util.List;

import mmm.service.finance.model.Collection;

public class DepositCreationJson {
	
	private long id;
	private String depositer;
	private String creator;
	private String approver;
	
	private Long creation;
	private int principle;
	private float rate;
	
	private String collectionFrequency;
	private String compoundingFrequency;
	
	private int tenure;
	private String status;
	private String remark;
	
	private List<Collection> collections;
	
	public DepositCreationJson() {}
	public DepositCreationJson(Deposit deposit) {
		this.id = deposit.getId();
		this.depositer = deposit.getDepositer().getLoginID();
		this.creator = deposit.getCreator().getLoginID();
		this.approver = deposit.getApprover() == null ? null : deposit.getApprover().getLoginID();
		
		this.creation = deposit.getCreation().getTime();
		this.principle = deposit.getPrinciple();
		this.rate = deposit.getRate();
		
		this.collectionFrequency = deposit.getCollectionFrequency().getName();
		this.compoundingFrequency = deposit.getCompoundingFrequency().getName();
		this.tenure = deposit.getTenure();
		this.status = deposit.getStatus().getName();
		this.remark = deposit.getRemark();
		this.collections = deposit.getCollections();
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
	public Long getCreation() {
		return creation;
	}
	public void setCreation(Long creation) {
		this.creation = creation;
	}
	public String getDepositer() {
		return depositer;
	}
	public void setDepositer(String depositer) {
		this.depositer = depositer;
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
	public String getCompoundingFrequency() {
		return compoundingFrequency;
	}
	public void setCompoundingFrequency(String compoundingFrequency) {
		this.compoundingFrequency = compoundingFrequency;
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
