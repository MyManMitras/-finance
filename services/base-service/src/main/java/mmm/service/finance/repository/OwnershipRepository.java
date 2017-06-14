package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Ownership;

public interface OwnershipRepository extends CrudRepository<Ownership, Serializable>{

	public Ownership findByName(String name);
}
