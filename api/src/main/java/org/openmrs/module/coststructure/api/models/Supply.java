package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Concept;
import org.openmrs.module.coststructure.api.enums.SupplyType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "supply")
public class Supply extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supply_id")
	private Integer id;
	
	@Column(name = "uuid", nullable = false)
	private String uuid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "concept_id")
	private Concept concept;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "supply_type", nullable = false, length = 20)
	private SupplyType supplyType;
	
	@Column(name = "unit_acquisition", nullable = false, length = 100)
	private String unitAcquisition;
	
	@Column(name = "unit_consumption", nullable = false, length = 100)
	private String unitConsumption;
	
	@Column(name = "equivalence", nullable = false)
	private Integer equivalence;
	
	@OneToMany(mappedBy = "supply", fetch = FetchType.LAZY)
	private List<SupplyCost> supplyCosts;
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer integer) {
		this.id = integer;
	}
	
	@Override
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Concept getConcept() {
		return concept;
	}
	
	public void setConcept(Concept concept) {
		this.concept = concept;
	}
	
	public SupplyType getSupplyType() {
		return supplyType;
	}
	
	public void setSupplyType(SupplyType supplyType) {
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
