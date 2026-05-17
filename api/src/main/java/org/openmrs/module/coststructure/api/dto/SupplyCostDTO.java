package org.openmrs.module.coststructure.api.dto;

import java.math.BigDecimal;

import org.openmrs.module.coststructure.api.models.SupplyCost;

public class SupplyCostDTO {
	
	private Integer supplyId;
	
	private BigDecimal acquisitionPrice;
	
	private BigDecimal unitCost;
	
	private BigDecimal quantityUsed;
	
	private BigDecimal timeMinutes;
	
	private BigDecimal partialCost;
	
	public SupplyCostDTO() {
	}
	
	public SupplyCostDTO(SupplyCost supplyCost) {
		this.supplyId = supplyCost.getSupply() != null ? supplyCost.getSupply().getId() : null;
		this.acquisitionPrice = supplyCost.getAcquisitionPrice();
		this.unitCost = supplyCost.getUnitCost();
		this.quantityUsed = supplyCost.getQuantityUsed();
		this.timeMinutes = supplyCost.getTimeMinutes();
		this.partialCost = supplyCost.getPartialCost();
	}
	
	public Integer getSupplyId() {
		return supplyId;
	}
	
	public void setSupplyId(Integer supplyId) {
		this.supplyId = supplyId;
	}
	
	public BigDecimal getAcquisitionPrice() {
		return acquisitionPrice;
	}
	
	public void setAcquisitionPrice(BigDecimal acquisitionPrice) {
		this.acquisitionPrice = acquisitionPrice;
	}
	
	public BigDecimal getAdquisitionPrice() {
		return acquisitionPrice;
	}
	
	public void setAdquisitionPrice(BigDecimal acquisitionPrice) {
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
}
