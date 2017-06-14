package mmm.service.finance.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mmm.service.finance.model.Address;
import mmm.service.finance.model.Login;
import mmm.service.finance.model.Person;
import mmm.service.finance.model.Role;
import mmm.service.finance.model.User;

@Controller
@RequestMapping(value="/finance/v1")
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<List> logIn(@RequestBody Login login){
		List<String> list = new ArrayList<>();
		list.add("Prashanth");
		return new ResponseEntity<List>(list, HttpStatus.OK);
	};
}
