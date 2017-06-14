package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Person;

public interface PersonRepository extends CrudRepository<Person, Serializable>{

}