package mmm.service.finance.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Person;

public interface PersonRepository extends CrudRepository<Person, Serializable>{
	
	Person findByLoginID(String loginId);
	List<Person> findAllByRoleNameAndFirmIsNull(String roleName);
	List<Person> findAllByFirmFirmId(String firmId);
}