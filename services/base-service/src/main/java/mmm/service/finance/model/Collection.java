package mmm.service.finance.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COLLECTION")
public class Collection implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COLLECTION_ID", sequenceName = "COLLECTION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLLECTION_ID")
	private Long id;
	
	@Column(name = "AMOUNT")
	private double amount;
	
	@Column(name = "EXPECTED_DATE")
	private Timestamp expectedDate;
	
	@Column(name = "ACTUAL_DATE")
	private Timestamp actualDate;
	
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "COLLECTOR_ID", insertable = true, updatable = true)
	private Person collector;
	
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "APPROVER_ID", insertable = true, updatable = true)
	private Person approver;
	
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "PAYMENT_MODE_ID", insertable = true, updatable = true)
	private PaymentMode paymentMode;
	
	@Column(name = "REMARKS")
	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Timestamp expectedDate) {
		this.expectedDate = expectedDate;
	}

	public Timestamp getActualDate() {
		return actualDate;
	}

	public void setActualDate(Timestamp actualDate) {
		this.actualDate = actualDate;
	}

	public Person getCollector() {
		return collector;
	}

	public void setCollector(Person collector) {
		this.collector = collector;
	}

	public Person getApprover() {
		return approver;
	}

	public void setApprover(Person approver) {
		this.approver = approver;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
