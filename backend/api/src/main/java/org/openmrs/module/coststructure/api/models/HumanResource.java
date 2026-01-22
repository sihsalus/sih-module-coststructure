package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.module.coststructure.api.models.HumanResourceCost;
import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name = "human_resource")
public class HumanResource extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "human_resource_id")
	private Integer id;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@Column(name = "speciality", length = 200)
	private String speciality;
	
	@OneToMany(mappedBy = "humanResource", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<HumanResourceCost> humanResourceCosts;
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer integer) {
		this.id = integer;
	}
	
	public String getSpeciality() {
		return speciality;
	}
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	@Override
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public List<HumanResourceCost> getHumanResourceCosts() {
		return humanResourceCosts;
	}
	
	public void setHumanResourceCosts(List<HumanResourceCost> humanResourceCosts) {
		this.humanResourceCosts = humanResourceCosts;
	}
}
