package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Collection;

public interface CollectionRepository extends CrudRepository<Collection, Serializable>{

	public Collection findById(Long id);
}
