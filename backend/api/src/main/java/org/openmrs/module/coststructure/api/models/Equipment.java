package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsObject;

import javax.persistence.*;
import java.util.List;

import java.io.Serializable;

@Entity
@Table(name = "equipment")
public class Equipment extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipment_id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@Column(name = "useful_life_years")
	private Integer usefulLifeYears;
	
	@OneToMany(mappedBy = "equipment")
	private List<EquipmentCost> equipmentCosts;
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer integer) {
		this.id = integer;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Integer getUsefulLifeYears() {
		return usefulLifeYears;
	}
	
	public void setUsefulLifeYears(Integer usefulLifeYears) {
		this.usefulLifeYears = usefulLifeYears;
	}
	
	public List<EquipmentCost> getEquipmentCosts() {
		return equipmentCosts;
	}
	
	public void setEquipmentCosts(List<EquipmentCost> equipmentCosts) {
		this.equipmentCosts = equipmentCosts;
	}
}
