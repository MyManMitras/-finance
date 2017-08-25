package mmm.service.finance.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mmm.service.finance.model.Collection;
import mmm.service.finance.model.Deposit;
import mmm.service.finance.model.Loan;
import mmm.service.finance.model.json.DepositCreationJson;
import mmm.service.finance.repository.CollectionRepository;
import mmm.service.finance.repository.DepositRepository;

@Component
public class DepositService {

	
	@Autowired
	private MasterService masterService;
	
	@Autowired 
	private PersonService personService;
	
	@Autowired
	private DepositRepository depositRepositroy;
	
	@Autowired
	private CollectionRepository collectionRepository;

	public DepositCreationJson createDeposit(DepositCreationJson depositCreationJson) {
		Deposit deposit = createDepositFromJson(depositCreationJson);
		depositRepositroy.save(deposit);
		
		return new DepositCreationJson(deposit);
	}

	private Deposit createDepositFromJson(DepositCreationJson depositCreationJson) {
		Deposit deposit = new Deposit();
		
		deposit.setCollectionFrequency(masterService.getCollectionFrequencyByName(depositCreationJson.getCollectionFrequency()));
		deposit.setCompoundingFrequency(masterService.getCompoundingFrequencyByName(depositCreationJson.getCompoundingFrequency()));
		deposit.setCreation(new Timestamp(System.currentTimeMillis()));
		deposit.setCreator(personService.getCurrentPerson());
		deposit.setDepositer(personService.getPersonByLoginId(depositCreationJson.getDepositer()));
		deposit.setPrinciple(depositCreationJson.getPrinciple());
		deposit.setRate(depositCreationJson.getRate());
		deposit.setRemark(depositCreationJson.getRemark());
		deposit.setStatus(masterService.getStatusByName("Created"));
		deposit.setTenure(depositCreationJson.getTenure());
		
		return deposit;
	}

	public DepositCreationJson getDepositJson(long depositId) {
		Deposit deposit = depositRepositroy.findById(depositId);
		return new DepositCreationJson(deposit);
	}

	public DepositCreationJson approveDeposit(Long depositId) {
		Deposit deposit = depositRepositroy.findById(depositId);
		List<Collection> collections = setCollectionsForDeposit(deposit);
		deposit.setCollections(collections);
		deposit.setApprover(personService.getCurrentPerson());
		deposit.setStatus(masterService.getStatusByName("Active"));
		depositRepositroy.save(deposit);
		return new DepositCreationJson(deposit);
	}

	private List<Collection> setCollectionsForDeposit(Deposit deposit) {
		List<Collection> collections = new ArrayList<>();
		
		Timestamp previousCollectionDate = new Timestamp(System.currentTimeMillis());
		for(int index = 0; index < deposit.getTenure(); index++) {
			Collection collection = new Collection();
			collection.setAmount(deposit.getPrinciple());
			Timestamp expectedDate = getCollectionExpectedDate(previousCollectionDate, deposit);
			collection.setExpectedDate(expectedDate);
			previousCollectionDate = expectedDate;
			collections.add(collection);
			collectionRepository.save(collection);
		}
		return collections;
	}
	
	private Timestamp getCollectionExpectedDate(Timestamp previousCollectionDate, Deposit deposit) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(new Date(previousCollectionDate.getTime()));
		gregorianCalendar.add(deposit.getCollectionFrequency().getField(), deposit.getCollectionFrequency().getIncrements());
		return new Timestamp(gregorianCalendar.getTimeInMillis());
	}
}
