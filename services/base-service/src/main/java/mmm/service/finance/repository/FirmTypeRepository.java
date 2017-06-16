package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.FirmType;

public interface FirmTypeRepository extends CrudRepository<FirmType, Serializable>{

	public FirmType findByName(String name);
}
