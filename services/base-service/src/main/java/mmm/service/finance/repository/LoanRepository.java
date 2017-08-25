package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Loan;

public interface LoanRepository extends CrudRepository<Loan, Serializable>  {

	public Loan findById(Long loanId);
	
	public Loan findByCollectionsId(Long collectionId);
}
