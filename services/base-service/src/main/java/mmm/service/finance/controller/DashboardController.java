package mmm.service.finance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mmm.service.finance.model.json.FirmOverviewJson;

@Controller
@RequestMapping(value="/finance/v1/dashboard")
public class DashboardController {
	
	@RequestMapping(value="/firmOverview/{firmId}", method=RequestMethod.GET)
	public ResponseEntity<FirmOverviewJson> logIn(@PathVariable String firmId){
		FirmOverviewJson firmOverviewJson = new FirmOverviewJson();
		firmOverviewJson.setCashInFirm(31273.2);
		firmOverviewJson.setTotalCustomers(12312);
		firmOverviewJson.setTotalDeposits(312312.31);
		firmOverviewJson.setTotalLentAmount(31231232.312);
		
		return new ResponseEntity<FirmOverviewJson>(firmOverviewJson, HttpStatus.OK);
	}

}
