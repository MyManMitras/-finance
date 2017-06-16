package mmm.service.finance.properties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import mmm.service.finance.model.CollectionFrequency;
import mmm.service.finance.model.CompoundingFrequency;
import mmm.service.finance.model.FirmType;
import mmm.service.finance.model.PaymentMode;
import mmm.service.finance.model.Role;
import mmm.service.finance.model.Service;
import mmm.service.finance.model.Status;
import mmm.service.finance.repository.RoleRepository;

@Component
@ConfigurationProperties(ignoreUnknownFields = true)
public class CommonConfiguration {
	
	private List<Role> personRoles;
	private List<Service> firmServices;
	private List<FirmType> firmTypes;
	private List<CollectionFrequency> collectionFrequencies;
	private List<Status> loanStatus;
	private List<PaymentMode> paymentModes;
	private List<CompoundingFrequency> comoundingFrequencies;
	
	public List<Role> getPersonRoles() {
		return personRoles;
	}

	public void setPersonRoles(List<Role> personRoles) {
		this.personRoles = personRoles;
	}

	public List<Service> getFirmServices() {
		return firmServices;
	}

	public void setFirmServices(List<Service> firmServices) {
		this.firmServices = firmServices;
	}

	public List<FirmType> getFirmTypes() {
		return firmTypes;
	}

	public void setFirmTypes(List<FirmType> firmTypes) {
		this.firmTypes = firmTypes;
	}

	public List<CollectionFrequency> getCollectionFrequencies() {
		return collectionFrequencies;
	}

	public void setCollectionFrequencies(List<CollectionFrequency> collectionFrequencies) {
		this.collectionFrequencies = collectionFrequencies;
	}

	public List<Status> getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(List<Status> loanStatus) {
		this.loanStatus = loanStatus;
	}

	public List<PaymentMode> getPaymentModes() {
		return paymentModes;
	}

	public void setPaymentModes(List<PaymentMode> paymentModes) {
		this.paymentModes = paymentModes;
	}

	public List<CompoundingFrequency> getComoundingFrequencies() {
		return comoundingFrequencies;
	}

	public void setComoundingFrequencies(List<CompoundingFrequency> comoundingFrequencies) {
		this.comoundingFrequencies = comoundingFrequencies;
	}
	
	
}
