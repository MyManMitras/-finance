package mmm.service.finance.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mmm.service.finance.model.Collection;
import mmm.service.finance.model.Deposit;
import mmm.service.finance.model.Loan;
import mmm.service.finance.model.json.ColletionRequestJson;
import mmm.service.finance.repository.CollectionRepository;
import mmm.service.finance.repository.LoanRepository;
import mmm.service.finance.repository.DepositRepository;

@Component
public class CollectionService {
	
	@Autowired
	private CollectionRepository collectionRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private DepositRepository depositRepository;

	@Autowired
	private PersonService personService;
	
	public Collection collect(long collectionId, ColletionRequestJson colletionRequestJson) {
		Collection collection = collectionRepository.findById(collectionId);
		collection.setActualDate(new Timestamp(System.currentTimeMillis()));
		collection.setCollector(personService.getCurrentPerson());
		Loan loan = loanRepository.findByCollectionsId(collectionId);
		Deposit deposit = depositRepository.findByCollectionsId(collectionId);
		
		if(loan != null)
			System.out.println("Loan");
		else if(deposit != null)
			System.out.println("Deposit");
		
		collectionRepository.save(collection);
		return collection;
	}

	public Collection approve(Long collectionId) {
		Collection collection = collectionRepository.findById(collectionId);
		collection.setApprover(personService.getCurrentPerson());
		collectionRepository.save(collection);
		return collection;
	}
}
