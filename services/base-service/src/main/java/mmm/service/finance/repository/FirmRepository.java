package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.Firm;

public interface FirmRepository extends CrudRepository<Firm, Serializable> {

}
