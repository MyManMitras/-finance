package mmm.service.finance.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import mmm.service.finance.model.User;

public interface UserRepository extends CrudRepository<User, Serializable>{
	
	List<User> findById(int id);

}
