package mmm.service.finance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COMPOUNDING_FREQUENCY")
public class CompoundingFrequency {
	
	@Id
	@SequenceGenerator(name = "COMPOUNDING_FREQUENCY_ID", sequenceName = "COMPOUNDING_FREQUENCY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPOUNDING_FREQUENCY_ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "FREQUENCY_FACTOR")
	private int frequencyFactor;

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

	public int getFaractionOfAYear() {
		return frequencyFactor;
	}

	public void setFaractionOfAYear(int frequencyFactor) {
		this.frequencyFactor = frequencyFactor;
	}
	
	@Override
	public boolean equals(Object obj) {
		CompoundingFrequency objCompoundingFrequency = (CompoundingFrequency)obj;
		if(this.name.equals(objCompoundingFrequency.getName()))
			return true;
		return false;
	}
}
