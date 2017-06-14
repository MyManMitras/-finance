package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Role;

public interface RoleRepository extends CrudRepository<Role, Serializable>{
	public Role findByName(String name);
}
