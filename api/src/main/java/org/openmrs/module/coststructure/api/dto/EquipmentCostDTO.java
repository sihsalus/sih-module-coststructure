package org.openmrs.module.coststructure.api.dto;

import org.openmrs.module.coststructure.api.models.EquipmentCost;
import java.math.BigDecimal;

public class EquipmentCostDTO {
	
	private Integer equipmentId;
	
	private BigDecimal price;
	
	private Integer quantity;
	
	private Integer timeMinutes;
	
	private BigDecimal deprecationPerMinute;
	
	public EquipmentCostDTO() {
		
	}
	
	public EquipmentCostDTO(EquipmentCost e) {
		this.equipmentId = e.getEquipment() != null ? e.getEquipment().getId() : null;
		this.price = e.getPrice();
		this.quantity = e.getQuantity();
		this.timeMinutes = e.getTimeMinutes();
		this.deprecationPerMinute = e.getDeprecationPerMinute();
	}
	
	// Getters y Setters
	public Integer getEquipmentId() {
		return equipmentId;
	}
	
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
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
	
	public BigDecimal getDeprecationPerMinute() {
		return deprecationPerMinute;
	}
	
	public void setDeprecationPerMinute(BigDecimal deprecationPerMinute) {
		this.deprecationPerMinute = deprecationPerMinute;
	}
}
