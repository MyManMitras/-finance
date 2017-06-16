package mmm.service.finance.model.json;

import mmm.service.finance.model.Person;

public class PersonJson {
	
	private String firstName;
	private String lastName;
	private Long phoneNo;
	private String emailId;
	private String gender;
	private FirmJson firm;
	
	public PersonJson(Person person) {
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.phoneNo = person.getPhoneNo();
		this.emailId = person.getEmailId();
		this.gender = person.getGender();
		this.firm = new FirmJson(person.getFirm());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public FirmJson getFirm() {
		return firm;
	}

	public void setFirm(FirmJson firm) {
		this.firm = firm;
	}
	
}
