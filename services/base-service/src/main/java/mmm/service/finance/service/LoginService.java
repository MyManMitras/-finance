package mmm.service.finance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mmm.service.finance.model.Login;
import mmm.service.finance.model.Person;
import mmm.service.finance.repository.PersonRepository;

@Component
public class LoginService {
	@Autowired
	private PersonRepository personRepository;

	public Person login(Login login) {
		Person person = personRepository.findByLoginID(login.getLogin());
		List<String> list = new ArrayList<>();
		list.add("Prashanth");
		return person;
	} 

}
