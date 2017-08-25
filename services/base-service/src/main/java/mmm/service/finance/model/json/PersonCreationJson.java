package mmm.service.finance.model.json;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mmm.service.finance.model.Address;
import mmm.service.finance.model.Gender;
import mmm.service.finance.model.Person;
import mmm.service.finance.model.Role;
import mmm.service.finance.service.FirmService;
import mmm.service.finance.service.MasterService;

@Component
public class PersonCreationJson {
	private String loginID;
	private String password;
	private String firstName;
	private String lastName;
	private Long dob;
	private String gender;
	private String emailId;
	private Long phoneNo;
	private String firmName;
	private String firmId;
	private String role;
	private Address address;
	private String message;
	
	public PersonCreationJson() {}
	public PersonCreationJson(Person person) {
		this.loginID = person.getLoginID();
		this.firmName = person.getFirstName();
		this.lastName = person.getLastName();
		this.dob = person.getDob().getTime();
		this.gender = person.getGender();
		this.emailId = person.getEmailId();
		this.phoneNo = person.getPhoneNo();
		this.firmName = person.getFirm().getName();
		this.firmId = person.getFirm().getFirmId();
		this.role = person.getRole().getName();
		this.address = person.getAddress();
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
		this.password = password;
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
	public Long getDob() {
		return dob;
	}
	public void setDob(Long dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public String getFirmId() {
		return firmId;
	}
	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
