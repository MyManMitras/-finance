package mmm.service.finance.model.json;

import mmm.service.finance.model.Firm;	

public class FirmJson {

	private String name;
	private String licenseNo;
	private String firmId;
	
	public FirmJson(Firm firm) {
		this.name = firm.getName();
		this.licenseNo = firm.getLicenseNo();
		this.firmId = firm.getFirmId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getFirmId() {	
		return firmId;
	}

	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}

}
