package mmm.service.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mmm.service.finance.exception.FinanceException;
import mmm.service.finance.model.json.FirmCreationJson;
import mmm.service.finance.service.FirmService;

@Controller
@RequestMapping(value="/finance/v1/firm")
public class FirmController {
	
	@Autowired
	private FirmService firmService;

	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<FirmCreationJson> createFirm(@RequestBody FirmCreationJson firmCreationJson){
		ResponseEntity<FirmCreationJson> response = null;
		
		try {
			firmService.createFirm(firmCreationJson);
			firmCreationJson.setMessage("Firm Created Sucessfully");
			response = new ResponseEntity<FirmCreationJson>(firmCreationJson, HttpStatus.OK);
		}catch(FinanceException financeException){
			financeException.printStackTrace();
			String errorMsg = "Error while creating firm"; 
			response = new ResponseEntity<FirmCreationJson>(new FirmCreationJson(errorMsg), HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	}
	
	@RequestMapping(value="/{firmId}", method=RequestMethod.GET)
	public ResponseEntity<FirmCreationJson> getFirmDetails(@PathVariable String firmId){
		FirmCreationJson firmCreationJson = firmService.getFirmByIdForResponse(firmId);
		return new ResponseEntity<FirmCreationJson>(firmCreationJson, HttpStatus.OK);
	}
	
	@RequestMapping(value="/search/{text}", method=RequestMethod.GET)
	public ResponseEntity<List<FirmCreationJson>> getFirms(@PathVariable String text){
		List<FirmCreationJson> firms = firmService.getFirmsForSearch(text);
		return new ResponseEntity<List<FirmCreationJson>>(firms, HttpStatus.OK);
	}
	
	@RequestMapping(value="/creation/details", method=RequestMethod.GET)
	public ResponseEntity<Map<String, List<?>>> getPersonCreationDetails(){
		Map<String, List<?>> details = new HashMap<>();
		details = firmService.getFirmCreationDetails();
		return new ResponseEntity<Map<String, List<?>>>(details, HttpStatus.OK);
	}
}
