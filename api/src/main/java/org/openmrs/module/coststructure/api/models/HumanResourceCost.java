package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsObject;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "human_resource_cost")
public class HumanResourceCost extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "human_resource_cost_id")
	private Integer id;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "time_minutes")
	private Integer timeMinutes;
	
	@Column(name = "cost_minutes", precision = 10, scale = 2)
	private BigDecimal costMinutes;
	
	@Column(name = "price_month", precision = 10, scale = 2)
	private BigDecimal priceMonth;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "human_resource_id", referencedColumnName = "human_resource_id")
	private HumanResource humanResource;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cost_structure_id", referencedColumnName = "cost_structure_id")
	private CostStructure costStructure;
	
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
	
	public BigDecimal getCostMinutes() {
		return costMinutes;
	}
	
	public void setCostMinutes(BigDecimal costMinutes) {
		this.costMinutes = costMinutes;
	}
	
	public BigDecimal getPriceMonth() {
		return priceMonth;
	}
	
	public void setPriceMonth(BigDecimal priceMoth) {
		this.priceMonth = priceMoth;
	}
	
	public HumanResource getHumanResource() {
		return humanResource;
	}
	
	public void setHumanResource(HumanResource humanResource) {
		this.humanResource = humanResource;
	}
	
	public CostStructure getCostStructure() {
		return costStructure;
	}
	
	public void setCostStructure(CostStructure costStructure) {
		this.costStructure = costStructure;
	}
}
