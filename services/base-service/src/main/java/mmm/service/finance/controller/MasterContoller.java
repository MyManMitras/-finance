package mmm.service.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mmm.service.finance.model.OrganisationType;
import mmm.service.finance.model.Ownership;
import mmm.service.finance.model.Role;
import mmm.service.finance.service.MasterService;

@Controller
@RequestMapping(value="/finance/v1/master")
public class MasterContoller {
	
	@Autowired
	private MasterService masterService;
	
	@RequestMapping(value="/role", method=RequestMethod.GET)
	public ResponseEntity<List<Role>> getRoles(){
		List<Role> roles = masterService.getRoles();
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
	@RequestMapping(value="/role", method=RequestMethod.POST)
	public ResponseEntity<List<Role>> setRole(@RequestBody Role role){
		List<Role> roles = masterService.setRole(role);
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
	@RequestMapping(value="/role", method=RequestMethod.DELETE)
	public ResponseEntity<List<Role>> deleteRole(@RequestBody Role role){
		List<Role> roles = masterService.deleteRole(role);
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ownership", method=RequestMethod.GET)
	public ResponseEntity<List<Ownership>> getOwnerships(){
		List<Ownership> ownerships = masterService.getOwnerships();
		return new ResponseEntity<List<Ownership>>(ownerships, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ownership", method=RequestMethod.POST)
	public ResponseEntity<List<Ownership>> setOwnership(@RequestBody Ownership ownership){
		List<Ownership> ownerships = masterService.setOwnership(ownership);
		return new ResponseEntity<List<Ownership>>(ownerships, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ownership", method=RequestMethod.DELETE)
	public ResponseEntity<List<Ownership>> deleteOwnership(@RequestBody Ownership ownership){
		List<Ownership> ownerships = masterService.deleteOwnership(ownership);
		return new ResponseEntity<List<Ownership>>(ownerships, HttpStatus.OK);
	}
	
	@RequestMapping(value="/organisationType", method=RequestMethod.GET)
	public ResponseEntity<List<OrganisationType>> getOrganisationTypes(){
		List<OrganisationType> organisationTypes = masterService.getOrganisationTypes();
		return new ResponseEntity<List<OrganisationType>>(organisationTypes, HttpStatus.OK);
	}
	
	@RequestMapping(value="/organisationType", method=RequestMethod.POST)
	public ResponseEntity<List<OrganisationType>> setOrganisationType(@RequestBody OrganisationType organisationType){
		List<OrganisationType> organisationTypes = masterService.setOrganisationType(organisationType);
		return new ResponseEntity<List<OrganisationType>>(organisationTypes, HttpStatus.OK);
	}
	
	@RequestMapping(value="/organisationType", method=RequestMethod.DELETE)
	public ResponseEntity<List<OrganisationType>> deleteOrganisationType(@RequestBody OrganisationType organisationType){
		List<OrganisationType> organisationTypes = masterService.deleteOrganisationType(organisationType);
		return new ResponseEntity<List<OrganisationType>>(organisationTypes, HttpStatus.OK);
	}

}
