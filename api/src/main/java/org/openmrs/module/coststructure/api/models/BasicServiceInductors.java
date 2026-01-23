package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsObject;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "basic_service_inductors")
public class BasicServiceInductors extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "basic_service_inductors_id")
	private Integer id;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@Column(name = "energy_consumption")
	private Integer energyConsumption;
	
	@Column(name = "water_consumption")
	private Integer waterConsumption;
	
	@Column(name = "phonenet_consumption")
	private Integer PhoneOrNetConsumption;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "infrastructure_cost_id", referencedColumnName = "infrastructure_cost_id")
	private InfrastructureCost infrastructureCost;
	
	@Transient
	private BigDecimal waterInductor;
	
	@Transient
	private BigDecimal phonenetInductor;
	
	@Transient
	private BigDecimal energyInductor;
	
	public BigDecimal getWaterInductor() {
		return waterInductor;
	}
	
	public void setWaterInductor(BigDecimal waterInductor) {
		this.waterInductor = waterInductor;
	}
	
	public BigDecimal getPhonenetInductor() {
		return phonenetInductor;
	}
	
	public void setPhonenetInductor(BigDecimal phonenetInductor) {
		this.phonenetInductor = phonenetInductor;
	}
	
	public BigDecimal getEnergyInductor() {
		return energyInductor;
	}
	
	public void setEnergyInductor(BigDecimal energyInductor) {
		this.energyInductor = energyInductor;
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer integer) {
		this.id = integer;
	}
	
	public Integer getEnergyConsumption() {
		return energyConsumption;
	}
	
	public void setEnergyConsumption(Integer energyConsumption) {
		this.energyConsumption = energyConsumption;
	}
	
	public Integer getWaterConsumption() {
		return waterConsumption;
	}
	
	public void setWaterConsumption(Integer waterConsumption) {
		this.waterConsumption = waterConsumption;
	}
	
	public Integer getPhoneOrNetConsumption() {
		return PhoneOrNetConsumption;
	}
	
	public void setPhoneOrNetConsumption(Integer phoneOrNetConsumption) {
		PhoneOrNetConsumption = phoneOrNetConsumption;
	}
	
	public InfrastructureCost getInfrastructureCost() {
		return infrastructureCost;
	}
	
	public void setInfrastructureCost(InfrastructureCost infrastructure) {
		this.infrastructureCost = infrastructure;
	}
}
