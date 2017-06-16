package mmm.service.finance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_INFO")
public class BankInfo {
	
	@Id
	@SequenceGenerator(name = "BANK_INFO_ID", sequenceName = "BANK_INFO_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANK_INFO_ID")
	private Long id;
	
	@Column(name = "BANK_NAME")
	private String bankName;
	
	@Column(name = "BRANCH")
	private String branch;
	
	@Column(name = "IFSC_CODE")
	private String ifscCode;
	
	@Column(name = "ACCOUNT_NUMBER")
	private long accountNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	
}
