package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.CollectionFrequency;

public interface CollectionFrequencyRepository extends CrudRepository<CollectionFrequency, Serializable>  {

	public CollectionFrequency findByName(String name);
}
