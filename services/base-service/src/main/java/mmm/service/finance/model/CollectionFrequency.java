package mmm.service.finance.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COLLECTION_FREQUENCY")
public class CollectionFrequency implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "COLLECTION_FREQUENCY_ID", sequenceName = "COLLECTION_FREQUENCY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLLECTION_FREQUENCY_ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "FRACTION_OF_A_YEAR")
	private int faractionOfAYear;
	
	@Column(name = "INCREMENTS")
	private int increments;
	
	@Column(name = "FIELD")
	private int field;

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
		return faractionOfAYear;
	}

	public void setFaractionOfAYear(int faractionOfAYear) {
		this.faractionOfAYear = faractionOfAYear;
	}
	
	public int getIncrements() {
		return increments;
	}

	public void setIncrements(int increments) {
		this.increments = increments;
	}

	public int getField() {
		return field;
	}

	public void setField(int field) {
		this.field = field;
	}

	@Override
	public boolean equals(Object obj) {
		CollectionFrequency objCollectionFrequency = (CollectionFrequency)obj;
		if(this.name.equals(objCollectionFrequency.getName()))
			return true;
		return false;
	}

}
