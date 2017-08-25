package mmm.service.finance.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mmm.service.finance.model.Address;
import mmm.service.finance.model.BankInfo;
import mmm.service.finance.model.Firm;
import mmm.service.finance.model.FirmType;
import mmm.service.finance.model.Gender;
import mmm.service.finance.model.Person;
import mmm.service.finance.model.Role;
import mmm.service.finance.model.Service;
import mmm.service.finance.model.User;
import mmm.service.finance.properties.CommonConfiguration;
import mmm.service.finance.repository.FirmRepository;
import mmm.service.finance.repository.FirmTypeRepository;
import mmm.service.finance.repository.PersonRepository;
import mmm.service.finance.repository.RoleRepository;
import mmm.service.finance.repository.ServiceRepository;
import mmm.service.finance.repository.UserRepository;
import mmm.service.finance.service.MasterService;
import scala.annotation.meta.setter;

@Controller
@RequestMapping(value="/finance/v1/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private FirmTypeRepository firmTypeRepositroy;
	
	@Autowired
	private FirmRepository firmRepositroy;
	
	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private PersonRepository personRepository; 
	
	
	@Autowired
	private MasterService masterService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<User> getUserDetails(@RequestParam(value="id") int id){
		User user = new User();
		user.setName("Prashanth");
		userRepository.save(user);
		
		Person person = new Person();
		person.setFirstName("Prashanth");
		person.setLoginID("login"+id);
		
		person.setPassword("123456");
		Address address = new Address();
		
		Role role = roleRepository.findByName("Admin");
		person.setRole(role);
		
		address.setCity("mandya");
		person.setAddress(address);
		
		person.setGender(Gender.Male.name());
		
		Firm firm = new Firm();
		firm.setAddress(address);
		firm.setName("MMM");
		firm.setEmailId("dasdsad");
		firm.setFirmId("asfasfas");
		firm.setAdmin(person);
		
		FirmType firmType = firmTypeRepositroy.findByName("Society");
		firm.setFirmType(firmType);
		firm.setServices((List<Service>) serviceRepository.findAll());
		
		BankInfo bankInfo = new BankInfo();
		bankInfo.setAccountNumber(312321653);
		bankInfo.setBankName("asdasdas");
		bankInfo.setBranch("fasdasd");
		bankInfo.setIfscCode("asfsadas");
		
		person.setFirm(firm);
		firm.setBankInfo(bankInfo);
		
		personRepository.save(person);
		firmRepositroy.save(firm);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	};
	
	@RequestMapping(value="/sample", method=RequestMethod.GET)
	public ResponseEntity<List<Person>> sampleUserDetails(){
		List list = new ArrayList<>();
		list.addAll((Collection) personRepository.findAll());
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	};

}
