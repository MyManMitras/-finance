package mmm.service.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mmm.service.finance.model.json.DepositCreationJson;
import mmm.service.finance.service.DepositService;

@Controller
@RequestMapping(value="/finance/v1/deposit")
public class DepositController {

	@Autowired
	private DepositService depositService;

	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<DepositCreationJson> createDeposit(@RequestBody DepositCreationJson depositCreationJson){
		DepositCreationJson depositCreationJsonCreated = depositService.createDeposit(depositCreationJson);
		return new ResponseEntity<DepositCreationJson>(depositCreationJsonCreated, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{depositId}", method=RequestMethod.GET)
	public ResponseEntity<DepositCreationJson> getDepositDetails(@PathVariable String depositId){
		DepositCreationJson depositCreationJson = depositService.getDepositJson(new Long(depositId));
		return new ResponseEntity<DepositCreationJson>(depositCreationJson, HttpStatus.OK);
	}
	
	@RequestMapping(value="/approve/{depositId}", method=RequestMethod.GET)
	public ResponseEntity<DepositCreationJson> approveDeposit(@PathVariable String depositId){
		DepositCreationJson depositCreationJson = depositService.approveDeposit(new Long(depositId));
		return new ResponseEntity<DepositCreationJson>(depositCreationJson, HttpStatus.OK);
	}
}
