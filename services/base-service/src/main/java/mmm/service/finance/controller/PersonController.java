package mmm.service.finance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mmm.service.finance.exception.FinanceException;
import mmm.service.finance.model.json.PersonCreationJson;
import mmm.service.finance.service.MasterService;
import mmm.service.finance.service.PersonService;

@Controller
@RequestMapping(value="/finance/v1/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<PersonCreationJson> createPerson(@RequestBody PersonCreationJson personCreationJson){
		ResponseEntity<PersonCreationJson> response = null;
		
		try {
			personService.createPerson(personCreationJson);
			response = new ResponseEntity<PersonCreationJson>(personCreationJson, HttpStatus.OK);
		}catch(FinanceException exception) {
			personCreationJson.setMessage("Error while creating person");
			response = new ResponseEntity<PersonCreationJson>(personCreationJson, HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	}
	
	@RequestMapping(value="/{personId}", method=RequestMethod.GET)
	public ResponseEntity<PersonCreationJson> getPersonDetails(@PathVariable String personId){
		
		PersonCreationJson personCreationJson = personService.getPersonByLoginIdForResponse(personId);
		return new ResponseEntity<PersonCreationJson>(personCreationJson, HttpStatus.OK);
	}
	
	@RequestMapping(value="/creation/details", method=RequestMethod.GET)
	public ResponseEntity<Map<String, List<?>>> getPersonCreationDetails(){
		Map<String, List<?>> details = new HashMap<>();
		details = personService.getPersonCreationDetails();
		return new ResponseEntity<Map<String, List<?>>>(details, HttpStatus.OK);
	}
}
