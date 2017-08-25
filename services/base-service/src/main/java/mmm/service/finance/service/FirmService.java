package mmm.service.finance.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mmm.service.finance.exception.FinanceException;
import mmm.service.finance.model.Firm;
import mmm.service.finance.model.Person;
import mmm.service.finance.model.Service;
import mmm.service.finance.model.json.FirmCreationJson;
import mmm.service.finance.repository.FirmRepository;
import mmm.service.finance.repository.PersonRepository;

@Component
public class FirmService {
	
	@Autowired
	private FirmRepository firmRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MasterService masterService;

	@Autowired
	private PersonService personService;
	
	public void createFirm(FirmCreationJson firmCreationJson) throws FinanceException{
		Firm firm = getFirmFromJson(firmCreationJson);
		
		try {
			firmRepository.save(firm);
			Person person = firm.getAdmin();
			person.setFirm(firm);
			personRepository.save(person);
		}catch(Exception e) {
			throw new FinanceException("Could not create the Firm");
		}
	}

	public Firm getFirmById(String firmId) {
		Firm firm = null;
		if(firmId != null)
			firm = firmRepository.findByFirmId(firmId); 
		return firm; 
	}

	public FirmCreationJson getFirmByIdForResponse(String firmId) {
		Firm firm = getFirmById(firmId);
		
		return new FirmCreationJson(firm);
	}

	public Firm getFirmFromJson(FirmCreationJson firmCreationJson) {
		Firm firm = new Firm();
		
		firm.setName(firmCreationJson.getName());
		firm.setLicenseNo(firmCreationJson.getLicenseNo());
		firm.setFirmId(firmCreationJson.getFirmId());
		firm.setEmailId(firmCreationJson.getEmailId());
		firm.setPhone1(firmCreationJson.getPhone1());
		firm.setPhone2(firmCreationJson.getPhone2());
		
		Timestamp estDate = new Timestamp(firmCreationJson.getEstablishmentDate());
		firm.setEstablishmentDate(estDate);
		
		Timestamp validTillDate = new Timestamp(firmCreationJson.getValidTill());
		firm.setValidTill(validTillDate);
		
		firm.setAddress(firmCreationJson.getAddress());
		firm.setBankInfo(firmCreationJson.getBankInfo());
		
		firm.setFirmType(masterService.getOwnershipByName(firmCreationJson.getFirmType()));
		
		List<Service> firmServices = new ArrayList<>();
		Iterator<String> iterator = firmCreationJson.getServices().iterator()	;
		while(iterator.hasNext())
			firmServices.add(masterService.getOrganisationTypeByName(iterator.next()));
		firm.setServices(firmServices);
		
		firm.setAdmin(personService.getPersonByLoginId(firmCreationJson.getAdmin()));
		
		return firm;		
	}
	
	public Map<String, List<?>> getFirmCreationDetails() {
		Map<String, List<?>> details = new HashMap<>();
		
		List<String> ownerships = masterService.getOwnershipsList();
		List<String> orgTypes = masterService.getOrganisationTypesList();
		List<String> admins = personService.getNonAssignedAdmins();
		
		details.put("ownerships", ownerships);
		details.put("orgTypes", orgTypes);
		details.put("admins", admins);
		
		return details;
	}

	public List<FirmCreationJson> getFirmsForSearch(String searchText) {
		List<FirmCreationJson> firmsResponse = new ArrayList<>();
		List<Firm> firms = searchText.equalsIgnoreCase("all") ? firmRepository.findAll() :
				firmRepository.findAllByNameContainsOrAdminFirstNameContains(searchText, searchText);
		Iterator<Firm> iterator = firms.iterator();
		while(iterator.hasNext()) {
			firmsResponse.add(new FirmCreationJson(iterator.next()));
		}
		return firmsResponse;
	}
}
