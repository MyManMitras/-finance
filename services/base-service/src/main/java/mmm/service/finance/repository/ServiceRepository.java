package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Service;



public interface ServiceRepository extends CrudRepository<Service, Serializable>{
	
	public Service findByName(String name);

}
