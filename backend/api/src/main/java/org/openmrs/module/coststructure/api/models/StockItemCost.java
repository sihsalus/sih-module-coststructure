package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Concept;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class StockItemCost extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_item_cost_id")
	private Integer id;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "time_minutes", nullable = true)
	private Integer timeMinutes; //only when the item is "No fungible"
	
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
