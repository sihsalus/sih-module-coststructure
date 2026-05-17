package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Concept;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cost_structure")
public class CostStructure extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cost_structure_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = true)
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "concept_id")
	private Concept procedure;
	
	public Concept getProcedure() {
		return procedure;
	}
	
	public void setProcedure(Concept procedure) {
		this.procedure = procedure;
	}
	
	@OneToOne(mappedBy = "costStructure", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private AnualServiceCost anualServiceCost;
	
	@OneToMany(mappedBy = "costStructure", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<HumanResourceCost> humanResourceCosts;
	
	@OneToMany(mappedBy = "costStructure", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<EquipmentCost> equipmentCosts;
	
	@OneToMany(mappedBy = "costStructure", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<InfrastructureCost> infrastructureCosts;
	
	@OneToMany(mappedBy = "costStructure", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<SupplyCost> supplyCosts;
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer integer) {
		this.id = integer;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	@Override
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public AnualServiceCost getAnualServiceCost() {
		return anualServiceCost;
	}
	
	public void setAnualServiceCost(AnualServiceCost anualServiceCost) {
		this.anualServiceCost = anualServiceCost;
	}
	
	public List<HumanResourceCost> getHumanResourceCosts() {
		return humanResourceCosts;
	}
	
	public void setHumanResourceCosts(List<HumanResourceCost> humanResourceCosts) {
		this.humanResourceCosts = humanResourceCosts;
	}
	
	public List<EquipmentCost> getEquipmentCosts() {
		return equipmentCosts;
	}
	
	public void setEquipmentCosts(List<EquipmentCost> equipmentCosts) {
		this.equipmentCosts = equipmentCosts;
	}
	
	public List<InfrastructureCost> getInfrastructureCosts() {
		return infrastructureCosts;
	}
	
	public void setInfrastructureCosts(List<InfrastructureCost> infrastructureCosts) {
		this.infrastructureCosts = infrastructureCosts;
	}
	
	public List<SupplyCost> getSupplyCosts() {
		return supplyCosts;
	}
	
	public void setSupplyCosts(List<SupplyCost> supplyCosts) {
		this.supplyCosts = supplyCosts;
	}
	
	public void addHumanResourceCost(HumanResourceCost hrCost) {
        if (this.humanResourceCosts == null) {
            this.humanResourceCosts = new ArrayList<>();
        }
        this.humanResourceCosts.add(hrCost);
        hrCost.setCostStructure(this);
    }
	
	public void addInfrastructureCost(InfrastructureCost infraCost) {
        if (this.infrastructureCosts == null) {
            this.infrastructureCosts = new ArrayList<>();
        }
        this.infrastructureCosts.add(infraCost);
        infraCost.setCostStructure(this);
    }
	
	public void addEquipmentCost(EquipmentCost equipmentCost) {
        if (this.equipmentCosts == null) {
         this.equipmentCosts = new ArrayList<>();
         }
        this.equipmentCosts.add(equipmentCost);
        equipmentCost.setCostStructure(this);
    }
	
	public void addSupplyCost(SupplyCost supplyCost) {
        if (this.supplyCosts == null) {
            this.supplyCosts = new ArrayList<>();
        }
        this.supplyCosts.add(supplyCost);
        supplyCost.setCostStructure(this);
    }
}
