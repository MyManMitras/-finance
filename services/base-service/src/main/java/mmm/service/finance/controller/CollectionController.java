package mmm.service.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mmm.service.finance.model.Collection;
import mmm.service.finance.model.json.ColletionRequestJson;
import mmm.service.finance.service.CollectionService;

@Controller
@RequestMapping(value="/finance/v1/collection")
public class CollectionController {

	@Autowired
	private CollectionService collectionService;
	
	@RequestMapping(value="/{collectionId}/{amount}", method=RequestMethod.POST)
	public ResponseEntity<Collection> collect(@PathVariable String collectionId, @RequestBody ColletionRequestJson colletionRequestJson) {
		Collection collection = collectionService.collect(new Long(collectionId), colletionRequestJson);
		return new ResponseEntity<Collection>(collection, HttpStatus.OK);
	}
	
	@RequestMapping(value="/approve/{collectionId}", method=RequestMethod.GET)
	public ResponseEntity<Collection> approve(@PathVariable String collectionId) {
		Collection collection = collectionService.approve(new Long(collectionId));
		return new ResponseEntity<Collection>(collection, HttpStatus.OK);
	}
}
