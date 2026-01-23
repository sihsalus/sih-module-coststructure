package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsObject;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "equipment_cost")
public class EquipmentCost extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipment_cost_id")
	private Integer id;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "time_minutes", nullable = false)
	private Integer timeMinutes;
	
	@Column(name = "deprecation_minute", nullable = true)
	private BigDecimal deprecationPerMinute;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipment_id", referencedColumnName = "equipment_id")
	private Equipment equipment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cost_structure_id", referencedColumnName = "cost_structure_id")
	private CostStructure costStructure;
	
	@Override
	public Integer getId() {
		return id;
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
	
	public Equipment getEquipment() {
		return equipment;
	}
	
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	public CostStructure getCostStructure() {
		return costStructure;
	}
	
	public void setCostStructure(CostStructure costStructure) {
		this.costStructure = costStructure;
	}
	
	@Override
	public void setId(Integer integer) {
		this.id = integer;
	}
}
