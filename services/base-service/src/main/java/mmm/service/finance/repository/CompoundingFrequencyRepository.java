package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.CompoundingFrequency;

public interface CompoundingFrequencyRepository  extends CrudRepository<CompoundingFrequency, Serializable>{
	public CompoundingFrequency findByName(String name);
}
