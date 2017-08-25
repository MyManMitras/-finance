package mmm.service.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mmm.service.finance.model.Person;
import mmm.service.finance.model.json.Login;
import mmm.service.finance.model.json.PersonJson;
import mmm.service.finance.service.LoginService;

@Controller
@RequestMapping(value="/finance/v12")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<PersonJson> logIn(@RequestBody Login login){
		Person person = loginService.login(login);
		return new ResponseEntity<PersonJson>(new PersonJson(person), HttpStatus.OK);
	};
}
