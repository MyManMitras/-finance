package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.OrganisationType;

public interface OrganisationTypeRepository extends CrudRepository<OrganisationType, Serializable>{
	
	public OrganisationType findByName(String name);

}
