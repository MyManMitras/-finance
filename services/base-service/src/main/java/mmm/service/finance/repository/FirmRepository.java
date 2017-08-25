package mmm.service.finance.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Firm;

public interface FirmRepository extends CrudRepository<Firm, Serializable> {

	Firm findByFirmId(String firmId);
	//List<Firm> findAllByNameLikeOrAdminFirstNameLike(String searchText);
	List<Firm> findAllByNameLikeOrAdminFirstNameLike(String name, String firstName);
	List<Firm> findAllByNameContainsOrAdminFirstNameContains(String name, String firstName);
	List<Firm> findAll();
}
