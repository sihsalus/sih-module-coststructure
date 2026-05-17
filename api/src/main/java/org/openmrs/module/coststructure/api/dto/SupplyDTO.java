package org.openmrs.module.coststructure.api.dto;

import org.openmrs.ConceptName;
import org.openmrs.module.coststructure.api.models.Supply;

public class SupplyDTO {
	
	private Integer id;
	
	private String uuid;
	
	private String name;
	
	private String supplyType;
	
	private String unitAcquisition;
	
	private String unitConsumption;
	
	private Integer equivalence;
	
	public SupplyDTO() {
	}
	
	public SupplyDTO(Supply supply) {
		this.id = supply.getId();
		this.uuid = supply.getUuid();
		this.supplyType = supply.getSupplyType() != null ? supply.getSupplyType().name() : null;
		this.unitAcquisition = supply.getUnitAcquisition();
		this.unitConsumption = supply.getUnitConsumption();
		this.equivalence = supply.getEquivalence();
		ConceptName conceptName = supply.getConcept() != null ? supply.getConcept().getName() : null;
		this.name = conceptName != null ? conceptName.getName() : null;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSupplyType() {
		return supplyType;
	}
	
	public void setSupplyType(String supplyType) {
		this.supplyType = supplyType;
	}
	
	public String getUnitAcquisition() {
		return unitAcquisition;
	}
	
	public void setUnitAcquisition(String unitAcquisition) {
		this.unitAcquisition = unitAcquisition;
	}
	
	public String getUnitConsumption() {
		return unitConsumption;
	}
	
	public void setUnitConsumption(String unitConsumption) {
		this.unitConsumption = unitConsumption;
	}
	
	public Integer getEquivalence() {
		return equivalence;
	}
	
	public void setEquivalence(Integer equivalence) {
		this.equivalence = equivalence;
	}
}
