package org.openmrs.module.coststructure.api.dto;

import org.openmrs.module.coststructure.api.models.EquipmentCost;

public class EquipmentCostDTO {
	
	private Integer quantity;
	
	private Integer timeMinutes;
	
	public EquipmentCostDTO() {
		
	}
	
	public EquipmentCostDTO(EquipmentCost e) {
		this.quantity = e.getQuantity();
		this.timeMinutes = e.getTimeMinutes();
	}
	
	// Getters y Setters
	
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
}
