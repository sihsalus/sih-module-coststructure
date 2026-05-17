package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsObject;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "supply_cost")
public class SupplyCost extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supply_cost_id")
	private Integer id;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supply_id", nullable = false)
	private Supply supply; // relación con catálogo Supply
	
	@Column(name = "acquisition_price", nullable = false)
	private BigDecimal acquisitionPrice;
	
	@Column(name = "unit_cost", nullable = false)
	private BigDecimal unitCost;
	
	@Column(name = "quantity_used")
	private BigDecimal quantityUsed;
	
	@Column(name = "time_minutes")
	private BigDecimal timeMinutes; // para NO fungibles
	
	@Column(name = "partial_cost", nullable = false)
	private BigDecimal partialCost;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cost_structure_id", referencedColumnName = "cost_structure_id")
	private CostStructure costStructure;
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Supply getSupply() {
		return supply;
	}
	
	public void setSupply(Supply supply) {
		this.supply = supply;
	}
	
	public BigDecimal getAcquisitionPrice() {
		return acquisitionPrice;
	}
	
	public void setAcquisitionPrice(BigDecimal acquisitionPrice) {
		this.acquisitionPrice = acquisitionPrice;
	}
	
	public BigDecimal getUnitCost() {
		return unitCost;
	}
	
	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}
	
	public BigDecimal getQuantityUsed() {
		return quantityUsed;
	}
	
	public void setQuantityUsed(BigDecimal quantityUsed) {
		this.quantityUsed = quantityUsed;
	}
	
	public BigDecimal getTimeMinutes() {
		return timeMinutes;
	}
	
	public void setTimeMinutes(BigDecimal timeMinutes) {
		this.timeMinutes = timeMinutes;
	}
	
	public BigDecimal getPartialCost() {
		return partialCost;
	}
	
	public void setPartialCost(BigDecimal partialCost) {
		this.partialCost = partialCost;
	}
	
	public CostStructure getCostStructure() {
		return costStructure;
	}
	
	public void setCostStructure(CostStructure costStructure) {
		this.costStructure = costStructure;
	}
}
