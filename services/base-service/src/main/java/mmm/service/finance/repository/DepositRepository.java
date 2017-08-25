package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Deposit;

public interface DepositRepository extends CrudRepository<Deposit, Serializable>  {

	public Deposit findById(Long depositId);
	public Deposit findByCollectionsId(Long collectionId);
}