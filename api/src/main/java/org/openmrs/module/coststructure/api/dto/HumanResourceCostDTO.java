package org.openmrs.module.coststructure.api.dto;

import org.openmrs.module.coststructure.api.models.HumanResourceCost;
import java.math.BigDecimal;

public class HumanResourceCostDTO {
	
	private Integer humanResourceId;
	
	private Integer quantity;
	
	private Integer timeMinutes;
	
	private BigDecimal costMinutes;
	
	private BigDecimal priceMonth;
	
	public HumanResourceCostDTO() {
		
	}
	
	public HumanResourceCostDTO(HumanResourceCost h) {
		this.humanResourceId = h.getHumanResource() != null ? h.getHumanResource().getId() : null;
		this.quantity = h.getQuantity();
		this.timeMinutes = h.getTimeMinutes();
		this.costMinutes = h.getCostMinutes();
		this.priceMonth = h.getPriceMonth();
	}
	
	public Integer getHumanResourceId() {
		return humanResourceId;
	}
	
	public void setHumanResourceId(Integer humanResourceId) {
		this.humanResourceId = humanResourceId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Integer getTimeMinutes() {
		return timeMinutes;
	}
	
	public void setTimeMinutes(Integer timeMinutes) {
		this.timeMinutes = timeMinutes;
	}
	
	public BigDecimal getCostMinutes() {
		return costMinutes;
	}
	
	public void setCostMinutes(BigDecimal costMinutes) {
		this.costMinutes = costMinutes;
	}
	
	public BigDecimal getPriceMonth() {
		return priceMonth;
	}
	
	public void setPriceMonth(BigDecimal priceMonth) {
		this.priceMonth = priceMonth;
	}
}
