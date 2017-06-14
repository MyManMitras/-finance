package mmm.service.finance.model;

import java.io.File;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORGANISATION")
public class Organisation {
	
	@Id
	@SequenceGenerator(name = "ORGANISATION_ID", sequenceName = "ORGANISATION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORGANISATION_ID")
	private Long id;
	
	@Column(name = "NAME")	
	private String name;
	
	@Column(name = "ORGANISATION")
	private String organisationId;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "PHONE1")
	private Long phone1;
	
	@Column(name = "PHONE2")
	private Long phone2;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ID", insertable = true, updatable = true)
	private Person poc;
	
	@Column(name = "ESTABLISHMENT_DATE")
	private Timestamp establishmentDate;
	
	@Column(name = "LICENSE_NO")
	private String licenseNo;
	
	@Column(name = "VALID_TILL")
	private String validTill;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ID", insertable = true, updatable = true)
	private Address address;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "OWNERSHIP_ID", insertable = true, updatable = true)
	private Ownership ownership;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ORGANISATION_TYPE_ID", insertable = true, updatable = true)
	private OrganisationType organisationType;
	
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

	public String getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(String organisationId) {
		this.organisationId = organisationId;
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

	public Person getPoc() {
		return poc;
	}

	public void setPoc(Person poc) {
		this.poc = poc;
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

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public File getDocuments() {
		return documents;
	}

	public void setDocuments(File documents) {
		this.documents = documents;
	}
	
	
}
