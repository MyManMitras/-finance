package mmm.service.finance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STATUS")
public class Status {
	
	@Id
	@SequenceGenerator(name = "STATUS_ID", sequenceName = "STATUS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_ID")
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
		Status status = (Status)obj;
		if(this.name.equals(status.getName()))
			return true;
		return false;
	}
}
