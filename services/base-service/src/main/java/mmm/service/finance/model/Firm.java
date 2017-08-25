package mmm.service.finance.model;

import java.io.File;
import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FIRM")
public class Firm implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FIRM_ID", sequenceName = "FIRM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FIRM_ID")
	private Long id;
	
	@Column(name = "NAME")	
	private String name;
	
	@Column(name = "FIRM_ID")
	private String firmId;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "PHONE1")
	private Long phone1;
	
	@Column(name = "PHONE2")
	private Long phone2;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = { CascadeType.PERSIST }, optional = true)
	@JoinColumn(name = "ADMIN_ID", insertable = true, updatable = true)
	private Person admin;
	
	@Column(name = "ESTABLISHMENT_DATE")
	private Timestamp establishmentDate;
	
	@Column(name = "LICENSE_NO")
	private String licenseNo;
	
	@Column(name = "VALID_TILL")
	private Timestamp validTill;
	
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ADDRESS_ID", insertable = true, updatable = true)
	private Address address;
	
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "BANK_INFO_ID", insertable = true, updatable = true)
	private BankInfo bankInfo;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "FIRM_TYPE_ID", insertable = true, updatable = true)
	private FirmType firmType;
	
	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "SERVICE_ID", insertable = true, updatable = true)
	private List<Service> services;
	
	@Column(name = "DOCUMENTS")
	private File documents;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirmId() {
		return firmId;
	}

	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhone1() {
		return phone1;
	}

	public void setPhone1(Long phone1) {
		this.phone1 = phone1;
	}

	public Long getPhone2() {
		return phone2;
	}

	public void setPhone2(Long phone2) {
		this.phone2 = phone2;
	}

	public Person getAdmin() {
		return admin;
	}

	public void setAdmin(Person admin) {
		this.admin = admin;
	}

	public Timestamp getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(Timestamp establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Timestamp getValidTill() {
		return validTill;
	}

	public void setValidTill(Timestamp validTill) {
		this.validTill = validTill;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public FirmType getFirmType() {
		return firmType;
	}

	public void setFirmType(FirmType firmType) {
		this.firmType = firmType;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public File getDocuments() {
		return documents;
	}

	public void setDocuments(File documents) {
		this.documents = documents;
	}

	public BankInfo getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}

	
}
