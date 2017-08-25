package mmm.service.finance.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import mmm.service.finance.exception.FinanceException;
import mmm.service.finance.model.Person;
import mmm.service.finance.model.Status;
import mmm.service.finance.model.json.PersonCreationJson;
import mmm.service.finance.repository.PersonRepository;

@Component
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MasterService masterService;
	
	@Autowired
	private FirmService firmService;

	public Person getPersonByLoginId(String loginID) {
		return personRepository.findByLoginID(loginID);
	}

	public void updateOrAddPerson(Person person)  throws FinanceException{
		try {
			personRepository.save(person);
		}catch(Exception e) {
			e.printStackTrace();
			throw new FinanceException("Error while creating the person");
		}
	}

	public void createPerson(PersonCreationJson personCreationJson) throws FinanceException{
		Person person = getPersonFromJson(personCreationJson);
		
		updateOrAddPerson(person);
	}
	
	public PersonCreationJson getPersonByLoginIdForResponse(String loginID) {
		Person person = getPersonByLoginId(loginID);
		
		return new PersonCreationJson(person);
	}

	public Person getPersonFromJson(PersonCreationJson personCreationJson) {
		Person person = new Person();
		
		person.setFirstName(personCreationJson.getFirstName());
		person.setLastName(personCreationJson.getLastName());
		person.setLoginID(personCreationJson.getLoginID());
		person.setPassword(personCreationJson.getPassword());
		
		Timestamp dobDate = new Timestamp(personCreationJson.getDob());
		person.setDob(dobDate);
		
		person.setGender(personCreationJson.getGender());
		person.setEmailId(personCreationJson.getEmailId());
		person.setPhoneNo(personCreationJson.getPhoneNo());
		person.setAddress(personCreationJson.getAddress());
		person.setRole(masterService.getRoleByName(personCreationJson.getRole()));
		person.setFirm(firmService.getFirmById(personCreationJson.getFirmId()));
		return person;
	}
	
	public Person getCurrentPerson() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return getPersonByLoginId(auth.getName());
	}

	public Map<String, List<?>> getPersonCreationDetails() {
		Map<String, List<?>> details = new HashMap<>();
		
		List<String> roles = masterService.getRolesList();
			roles.remove(roles.indexOf("SuperUser"));
		details.put("roles", roles);
		details.put("genders", Arrays.asList("Male","Female","Other"));
		return details;
	}
	
	public List<String> getNonAssignedAdmins() {
		List<Person> admins = personRepository.findAllByRoleNameAndFirmIsNull("Admin");
		Iterator<Person> iterator = admins.iterator();
		List<String> adminNames = new ArrayList<>();
		while(iterator.hasNext()) {
			Person person = iterator.next();
			adminNames.add(person.getFirstName() + "," + person.getLastName() + " - " + person.getLoginID());
		}
		
		return adminNames;
	}
}
