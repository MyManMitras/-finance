package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mmm.service.finance.model.Person;

public interface PersonRepository extends CrudRepository<Person, Serializable>{
	
	Person findByLoginID(String loginId);
	
	

}