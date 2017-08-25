package mmm.service.finance.model.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

import mmm.service.finance.model.Address;
import mmm.service.finance.model.BankInfo;
import mmm.service.finance.model.Firm;
import mmm.service.finance.model.Service;
import mmm.service.finance.service.MasterService;

public class FirmCreationJson {
	private String name;
	private String firmId;
	private String emailId;
	private Long phone1;
	private Long phone2;
	private String admin;
	private Long establishmentDate;
	private String licenseNo;
	private Long validTill;
	private Address address;
	private BankInfo bankInfo;
	private String firmType;
	private List<String> services;
	private String message;
	
	@Autowired
	private MasterService masterService;
	
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

	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Long getEstablishmentDate() {
		return establishmentDate;
	}
	public void setEstablishmentDate(Long establishmentDate) {
		this.establishmentDate = establishmentDate;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public Long getValidTill() {
		return validTill;
	}
	public void setValidTill(Long validTill) {
		this.validTill = validTill;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public BankInfo getBankInfo() {
		return bankInfo;
	}
	public void setBankInfo(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}
	public String getFirmType() {
		return firmType;
	}
	public void setFirmType(String firmType) {
		this.firmType = firmType;
	}
	public List<String> getServices() {
		return services;
	}
	public void setServices(List<String> services) {
		this.services = services;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public  FirmCreationJson(Firm firm) {
		
		this.setName(firm.getName());
		this.setLicenseNo(firm.getLicenseNo());
		this.setAddress(firm.getAddress());
		this.setFirmId(firm.getFirmId());
		this.setEmailId(firm.getEmailId());
		this.setPhone1(firm.getPhone1());
		this.setPhone2(firm.getPhone2());
		this.setEstablishmentDate(firm.getEstablishmentDate().getTime());
		this.setValidTill(firm.getValidTill().getTime());
		this.setAddress(firm.getAddress());
		this.setBankInfo(firm.getBankInfo());
		this.setFirmType(firm.getFirmType() != null? firm.getFirmType().getName(): null);
		this.setAdmin(firm.getAdmin().getFirstName()+ " - "+ firm.getAdmin().getLastName());
		List<Service> firmServices = firm.getServices();
		Iterator<Service> iterator = firmServices.iterator();
		List<String> services = new ArrayList<>();
		while(iterator.hasNext())
			services.add(iterator.next().getName());
		
		this.setServices(services);
	}
	
	public FirmCreationJson() {}
	
	
	public FirmCreationJson(String messsage) {
		this.message = messsage;
	}
	
}
