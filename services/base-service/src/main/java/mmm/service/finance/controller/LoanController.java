package mmm.service.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mmm.service.finance.model.json.LoanCreationJson;
import mmm.service.finance.model.json.PersonCreationJson;
import mmm.service.finance.service.LoanService;

@Controller
@RequestMapping(value="/finance/v1/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;

	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<LoanCreationJson> createLoan(@RequestBody LoanCreationJson loanCreationJson){
		
		LoanCreationJson loanCreationJsonCreated= loanService.createLoan(loanCreationJson);
		return new ResponseEntity<LoanCreationJson>(loanCreationJsonCreated, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{loanId}", method=RequestMethod.GET)
	public ResponseEntity<LoanCreationJson> getLoanDetails(@PathVariable String loanId){
		LoanCreationJson loanCreationJson = loanService.getLoanByIdForReponse(new Long(loanId));
		return new ResponseEntity<LoanCreationJson>(loanCreationJson, HttpStatus.OK);
	}
	
	@RequestMapping(value="/approve/{loanId}", method=RequestMethod.GET)
	public ResponseEntity<LoanCreationJson> approveLoan(@PathVariable String loanId){
		LoanCreationJson loanCreationJson = loanService.approveLoan(new Long(loanId));
		return new ResponseEntity<LoanCreationJson>(loanCreationJson, HttpStatus.OK);
	}
	
	@RequestMapping(value="/persons", method=RequestMethod.GET)
	public ResponseEntity<List<PersonCreationJson>> getLoanablePersons() {
		List<PersonCreationJson> PersonsCreationJson = loanService.getLoanablePersons();
		return new ResponseEntity<List<PersonCreationJson>>(PersonsCreationJson, HttpStatus.OK);
	}
}
