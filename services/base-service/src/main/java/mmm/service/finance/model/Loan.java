package mmm.service.finance.model;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOAN")
public class Loan {

	@Id
	@SequenceGenerator(name = "LOAN_ID", sequenceName = "LOAN_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOAN_ID")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "CREATOR_ID", insertable = true, updatable = true)
	private Person creator;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "BORROWER_ID", insertable = true, updatable = true)
	private Person borrower;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "APPROVER_ID", insertable = true, updatable = true)
	private Person approver;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "GURANTEER_ID", insertable = true, updatable = true)
	private Person guranteer;
	
	@Column(name = "PLEDGE_DOC")
	private File pledgeDoc;
	
	@Column(name = "CREATION")
	private Timestamp creation;
	
	@Column(name = "PRINCIPLE")
	private int principle;
	
	@Column(name = "RATE")
	private float rate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "COLLECTION_FREQUENCY_ID", insertable = true, updatable = true)
	private CollectionFrequency collectionFrequency;
	
	@Column(name = "TENURE")
	private int tenure;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "STATUS_ID", insertable = true, updatable = true)
	private Status status;
	
	@Column(name = "REMARK")
	private String remark;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "COLLECTION_ID", insertable = true, updatable = true)
	private List<Collection> collections;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getCreator() {
		return creator;
	}

	public void setCreator(Person creator) {
		this.creator = creator;
	}

	public Person getBorrower() {
		return borrower;
	}

	public void setBorrower(Person borrower) {
		this.borrower = borrower;
	}

	public Person getApprover() {
		return approver;
	}

	public void setApprover(Person approver) {
		this.approver = approver;
	}

	public Person getGuranteer() {
		return guranteer;
	}

	public void setGuranteer(Person guranteer) {
		this.guranteer = guranteer;
	}

	public File getPledgeDoc() {
		return pledgeDoc;
	}

	public void setPledgeDoc(File pledgeDoc) {
		this.pledgeDoc = pledgeDoc;
	}

	public Timestamp getCreation() {
		return creation;
	}

	public void setCreation(Timestamp creation) {
		this.creation = creation;
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

	public CollectionFrequency getCollectionFrequency() {
		return collectionFrequency;
	}

	public void setCollectionFrequency(CollectionFrequency collectionFrequency) {
		this.collectionFrequency = collectionFrequency;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	
}
