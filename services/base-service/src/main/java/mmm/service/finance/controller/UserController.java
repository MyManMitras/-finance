package mmm.service.finance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mmm.service.finance.model.User;

@Controller
@RequestMapping(value="/finance/v1/user")
public class UserController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<User> getUserDetails(@RequestParam(value="id") int id){
		User user = new User();
		user.setId(id);
		user.setName("Prashanth");
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	};

}
