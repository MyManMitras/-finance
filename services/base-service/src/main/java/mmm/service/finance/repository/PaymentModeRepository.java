package mmm.service.finance.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import mmm.service.finance.model.PaymentMode;

public interface PaymentModeRepository extends CrudRepository<PaymentMode, Serializable> {
	public PaymentMode findByName(String name);
}
