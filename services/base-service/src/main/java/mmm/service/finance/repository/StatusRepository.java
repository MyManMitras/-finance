package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Status;

public interface StatusRepository extends CrudRepository<Status, Serializable>{
	public Status findByName(String name);
}
