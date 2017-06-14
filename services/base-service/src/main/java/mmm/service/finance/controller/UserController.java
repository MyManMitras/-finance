package mmm.service.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mmm.service.finance.model.Address;
import mmm.service.finance.model.Person;
import mmm.service.finance.model.Role;
import mmm.service.finance.model.User;
import mmm.service.finance.repository.PersonRepository;
import mmm.service.finance.repository.UserRepository;
import mmm.service.finance.service.MasterService;

@Controller
@RequestMapping(value="/finance/v1/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 

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
		person.setPassword("abcd1234");
		Address address = new Address();
		
		Role role = masterService.getRoleByName("Admin");
		person.setRole(role);
		address.setCity("mandya");
		person.setRole(role);
		person.setAddress(address);
		personRepository.save(person);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	};
	
	@RequestMapping(value="/sample", method=RequestMethod.GET)
	public ResponseEntity<User> sampleUserDetails(){
		User user = new User();
		user.setName("Prashanth");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	};

}
