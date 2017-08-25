package mmm.service.finance.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mmm.service.finance.email.EmailServiceImpl;
import mmm.service.finance.exception.FinanceException;
import mmm.service.finance.model.CollectionFrequency;
import mmm.service.finance.model.CompoundingFrequency;
import mmm.service.finance.model.Firm;
import mmm.service.finance.model.FirmType;
import mmm.service.finance.model.PaymentMode;
import mmm.service.finance.model.Person;
import mmm.service.finance.model.Service;
import mmm.service.finance.model.Status;
import mmm.service.finance.model.Role;
import mmm.service.finance.properties.CommonConfiguration;
import mmm.service.finance.repository.CollectionFrequencyRepository;
import mmm.service.finance.repository.CompoundingFrequencyRepository;
import mmm.service.finance.repository.FirmTypeRepository;
import mmm.service.finance.repository.PaymentModeRepository;
import mmm.service.finance.repository.RoleRepository;
import mmm.service.finance.repository.ServiceRepository;
import mmm.service.finance.repository.StatusRepository;
import mmm.service.finance.service.MasterService;
import mmm.service.finance.service.PersonService;

@Controller
@RequestMapping(value="/finance/v1/master")
public class MasterContoller {
	@Value(value="${superUser.email}")
	private String superUserMailId;
	
	@Autowired
	private MasterService masterService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private FirmTypeRepository firmTypeRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private PaymentModeRepository paymentModeRepository;
	
	@Autowired
	private CollectionFrequencyRepository collectionFrequencyRepository;
	
	@Autowired
	private CompoundingFrequencyRepository compoundingFrequencyRepository;
	
	@Autowired
	private CommonConfiguration commonConfiguration;
	
	@Autowired
	private EmailServiceImpl emailService;
	
	@Autowired
	private PersonService personService;
	
	private static Role superAdminRole;
	
	@RequestMapping(value="/role", method=RequestMethod.GET)
	public ResponseEntity<List<Role>> getRoles(){
		List<Role> roles = masterService.getRoles();
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
	@RequestMapping(value="/role", method=RequestMethod.POST)
	public ResponseEntity<List<Role>> setRole(@RequestBody Role role){
		List<Role> roles = masterService.setRole(role);
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
	@RequestMapping(value="/role", method=RequestMethod.DELETE)
	public ResponseEntity<List<Role>> deleteRole(@RequestBody Role role){
		List<Role> roles = masterService.deleteRole(role);
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
	@RequestMapping(value="/firmtype", method=RequestMethod.GET)
	public ResponseEntity<List<FirmType>> getOwnerships(){
		List<FirmType> ownerships = masterService.getOwnerships();
		return new ResponseEntity<List<FirmType>>(ownerships, HttpStatus.OK);
	}
	
	@RequestMapping(value="/firmtype", method=RequestMethod.POST)
	public ResponseEntity<List<FirmType>> setOwnership(@RequestBody FirmType ownership){
		List<FirmType> ownerships = masterService.setOwnership(ownership);
		return new ResponseEntity<List<FirmType>>(ownerships, HttpStatus.OK);
	}
	
	@RequestMapping(value="/firmtype", method=RequestMethod.DELETE)
	public ResponseEntity<List<FirmType>> deleteOwnership(@RequestBody FirmType ownership){
		List<FirmType> ownerships = masterService.deleteOwnership(ownership);
		return new ResponseEntity<List<FirmType>>(ownerships, HttpStatus.OK);
	}		
	
	@RequestMapping(value="/service", method=RequestMethod.GET)
	public ResponseEntity<List<Service>> getOrganisationTypes(){
		List<Service> organisationTypes = masterService.getOrganisationTypes();
		return new ResponseEntity<List<Service>>(organisationTypes, HttpStatus.OK);
	}
	
	@RequestMapping(value="/service", method=RequestMethod.POST)
	public ResponseEntity<List<Service>> setOrganisationType(@RequestBody Service organisationType){
		List<Service> organisationTypes = masterService.setOrganisationType(organisationType);
		return new ResponseEntity<List<Service>>(organisationTypes, HttpStatus.OK);
	}
	
	@RequestMapping(value="/service", method=RequestMethod.DELETE)
	public ResponseEntity<List<Service>> deleteOrganisationType(@RequestBody Service organisationType){
		List<Service> organisationTypes = masterService.deleteOrganisationType(organisationType);
		return new ResponseEntity<List<Service>>(organisationTypes, HttpStatus.OK);
	}
	
	@PostConstruct
	public void initMasterTables() {
		updatePersonRoles();
		updateFirmServices();
		updateFirmTypes();
		updateCollectionFrequencyTypes();
		updateLoanStatus();
		updatePaymentModes();
		updateCompoundingFrequencyTypes();
		updateSuperUserLogin();
	}
	
	private void updateSuperUserLogin() {
		Person superUser = personService.getPersonByLoginId("SuperUser");
		Integer randomPassword = (int) (Math.random() * 100000);
		randomPassword = 112233;
		if(superUser == null) {
			superUser = new Person();
			Firm firm = new Firm();
			firm.setName("MyManMitras");
			firm.setEmailId("MyManMitras@gmail.com");
			firm.setFirmId("mmm");
			firm.setEstablishmentDate(new Timestamp(System.currentTimeMillis()));
			firm.setValidTill(new Timestamp(System.currentTimeMillis()));
			superUser.setEmailId(superUserMailId);	
			superUser.setFirm(firm);
			superUser.setLoginID("SuperUser");
			superUser.setFirstName("Web Admin");
			superUser.setPassword(randomPassword.toString());
			superUser.setRole(superAdminRole);
			firm.setAdmin(superUser);
		} else {
			superUser.setPassword(randomPassword.toString());
		}
		
		try {
			personService.updateOrAddPerson(superUser);
			StringBuilder builder = new StringBuilder();
			builder.append("Login Id : "+superUser.getLoginID());
			builder.append("\nFirm Id : "+superUser.getFirm().getFirmId());
			builder.append("\nPassword : "+randomPassword);
			
			//emailService.sendSimpleMessage(superUserMailId, "Super User Credentials", builder.toString());
		} catch(FinanceException financeException) {
			financeException.printStackTrace();
		}
	}

	private void updateCompoundingFrequencyTypes() {
		List<CompoundingFrequency> compoundingFrequencysInDatabase = (List<CompoundingFrequency>) compoundingFrequencyRepository.findAll();
		List<CompoundingFrequency> compoundingFrequencysFromProps = commonConfiguration.getComoundingFrequencies();
		for(int index = 0; index < compoundingFrequencysFromProps.size(); index++) {
			CompoundingFrequency compoundingFrequency = compoundingFrequencysFromProps.get(index);
			if(!compoundingFrequencysInDatabase.contains(compoundingFrequency)) {
				compoundingFrequencyRepository.save(compoundingFrequency);
			}
		}
	}

	private void updatePaymentModes() {
		List<PaymentMode> paymentModesInDatabase = (List<PaymentMode>) paymentModeRepository.findAll();
		List<PaymentMode> paymentModesFromProps = commonConfiguration.getPaymentModes();
		for(int index = 0; index < paymentModesFromProps.size(); index++) {
			PaymentMode paymentMode = paymentModesFromProps.get(index);
			if(!paymentModesInDatabase.contains(paymentMode)) {
				paymentModeRepository.save(paymentMode);
			}
		}
		
	}

	private void updateLoanStatus() {
		List<Status> statusInDatabase = (List<Status>) statusRepository.findAll();
		List<Status> statusFromProps = commonConfiguration.getLoanStatus();
		for(int index = 0; index < statusFromProps.size(); index++) {
			Status status = statusFromProps.get(index);
			if(!statusInDatabase.contains(status)) {
				statusRepository.save(status);
			}
		}
	}

	private void updateCollectionFrequencyTypes() {
		List<CollectionFrequency> collectionFrequenciesInDatabase = (List<CollectionFrequency>) collectionFrequencyRepository.findAll();
		List<CollectionFrequency> collectionFrequenciesFromProps = commonConfiguration.getCollectionFrequencies();
		for(int index = 0; index < collectionFrequenciesFromProps.size(); index++) {
			CollectionFrequency collectionFrequency = collectionFrequenciesFromProps.get(index);
			if(!collectionFrequenciesInDatabase.contains(collectionFrequency)) {
				collectionFrequencyRepository.save(collectionFrequency);
			}
		}
		
	}

	private void updateFirmTypes() {
		List<FirmType> firmTypesInDatabase = (List<FirmType>) firmTypeRepository.findAll();
		List<FirmType> firmTypesFromProps = commonConfiguration.getFirmTypes();
		for(int index = 0; index < firmTypesFromProps.size(); index++) {
			FirmType firmType = firmTypesFromProps.get(index);
			if(!firmTypesInDatabase.contains(firmType)) {
				firmTypeRepository.save(firmType);
			}
		}
		
	}

	private void updateFirmServices() {
		List<Service> servicesInDatabase = (List<Service>) serviceRepository.findAll();
		List<Service> servicesFromProps = commonConfiguration.getFirmServices();
		for(int index = 0; index < servicesFromProps.size(); index++) {
			Service service = servicesFromProps.get(index);
			if(!servicesInDatabase.contains(service)) {
				serviceRepository.save(service);
			}
		}
		
	}

	public void updatePersonRoles() {
		List<Role> rolesInDatabase = (List<Role>) roleRepository.findAll();
		List<Role> rolesFromProps = commonConfiguration.getPersonRoles();
		for(int index = 0; index < rolesFromProps.size(); index++) {
			Role role = rolesFromProps.get(index);
			if(!rolesInDatabase.contains(role)) {
				roleRepository.save(role);
			}
			if(role.getName().equals("SuperUser"))
				superAdminRole = role;
		}
	}

}
