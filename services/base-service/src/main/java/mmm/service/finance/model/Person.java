package mmm.service.finance.model;

import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

@Entity
@Table(name="PERSON")
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PERSON_ID", sequenceName = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_ID")
	private Long id;
	
	@Column(name = "LOGIN_ID")
	private String loginID;
	
    @Column(name = "password")
	private String password;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String LastName;
	
	@Column(name = "DOB")
	private Timestamp dob;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "PHONE_NO")
	private Long phoneNo;
	
	@Column(name = "LAST_LOGIN")
	private Timestamp lastLogin;
	
	@Column(name = "PHOTO")
	private File photo;
	
	@Column(name = "IDENTITY_PROOF")
	private File identityProof;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "FIRM_ID", insertable = true, updatable = true)
	private Firm firm;	
	
	@OneToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "ROLE_ID", insertable = true, updatable = true)
	private Role role;	
	
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ADDRESS_ID", insertable = true, updatable = true)
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("SHA-1");
		this.password = encoder.encodePassword(password, null);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public File getIdentityProof() {
		return identityProof;
	}

	public void setIdentityProof(File identityProof) {
		this.identityProof = identityProof;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}
	
}
