package mmm.service.finance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_MODE")
public class PaymentMode implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "PAYMENT_MODE_ID", sequenceName = "PAYMENT_MODE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENT_MODE_ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public boolean equals(Object obj) {
		PaymentMode paymentMode = (PaymentMode)obj;
		if(this.name.equals(paymentMode.getName()))
			return true;
		return false;
	}
}
