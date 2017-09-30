package mmm.service.finance.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mmm.service.finance.model.Loan;
import mmm.service.finance.model.Collection;
import mmm.service.finance.model.json.LoanCreationJson;
import mmm.service.finance.model.json.PersonCreationJson;
import mmm.service.finance.repository.CollectionRepository;
import mmm.service.finance.repository.LoanRepository;
import mmm.service.finance.repository.PersonRepository;

@Component
public class LoanService {
	
	@Autowired
	private MasterService masterService;
	
	@Autowired 
	private PersonService personService;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private CollectionRepository collectionRepository;

	public LoanCreationJson createLoan(LoanCreationJson loanCreationJson) {
		Loan loan = createLoanFormJson(loanCreationJson);
	
		loanRepository.save(loan);
		
		return new LoanCreationJson(loan);
	}
	
	public Loan getLoanById(Long loanId) {
		return loanRepository.findById(loanId);
	}
	
	public LoanCreationJson getLoanByIdForReponse(Long loanId) {
		Loan loan = getLoanById(loanId);
		
		return new LoanCreationJson(loan);
	}
	
	private Loan createLoanFormJson(LoanCreationJson loanCreationJson) {
		Loan loan = new Loan();
		
		loan.setBorrower(personService.getPersonByLoginId(loanCreationJson.getBorrower()));
		loan.setGuranteer(personService.getPersonByLoginId(loanCreationJson.getGuranteer()));
		loan.setCollectionFrequency(masterService.getCollectionFrequencyByName(loanCreationJson.getCollectionFrequency()));
		loan.setCreation(new Timestamp(System.currentTimeMillis()));
		loan.setCreator(personService.getCurrentPerson());
		loan.setRate(loanCreationJson.getRate());
		loan.setTenure(loanCreationJson.getTenure());
		loan.setPrinciple(loanCreationJson.getPrinciple());
		loan.setStatus(masterService.getStatusByName("Created"));
		loan.setRemark(loanCreationJson.getRemark());
		
		return loan;
	}

	public LoanCreationJson approveLoan(Long loanId) {
		Loan loan = getLoanById(loanId);
		List<Collection> collections = setCollectionsForLoan(loan);
		loan.setCollections(collections);
		loan.setApprover(personService.getCurrentPerson());
		loan.setStatus(masterService.getStatusByName("Active"));
		loanRepository.save(loan);
		return new LoanCreationJson(loan);
	}

	private List<Collection> setCollectionsForLoan(Loan loan) {
		List<Collection> collections = new ArrayList<Collection>();
		double actualRate = loan.getRate() / 100 / loan.getCollectionFrequency().getFaractionOfAYear();
		double totalLoanRatio = Math.pow((1 + actualRate), loan.getTenure());
		double emi = loan.getPrinciple() * actualRate * totalLoanRatio/(totalLoanRatio - 1);
		Timestamp previousCollectionDate = new Timestamp(System.currentTimeMillis());
		for(int index = 0 ; index < loan.getTenure(); index++){
			Collection collection = new Collection();
			collection.setAmount(emi);
			Timestamp expectedTime = getCollectionExpectedDate(previousCollectionDate, loan);
			collection.setExpectedDate(expectedTime);
			previousCollectionDate = expectedTime;
			collections.add(collection);
			collectionRepository.save(collection);
		}
		
		return collections;
	}

	private Timestamp getCollectionExpectedDate(Timestamp previousCollectionDate, Loan loan) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(new Date(previousCollectionDate.getTime()));
		gregorianCalendar.add(loan.getCollectionFrequency().getField(), loan.getCollectionFrequency().getIncrements());
		return new Timestamp(gregorianCalendar.getTimeInMillis());
	}

	public List<PersonCreationJson> getLoanablePersons() {
		return personService.getLoanablePersons();
	}
}
