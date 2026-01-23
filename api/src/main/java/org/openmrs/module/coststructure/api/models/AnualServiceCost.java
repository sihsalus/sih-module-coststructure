package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.module.coststructure.api.models.CostStructure;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "annual_service_cost")
public class AnualServiceCost extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "annual_service_cost_id")
	private Integer id;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@Column(name = "general_admin_annual_cost", precision = 10, scale = 2)
	private BigDecimal generalAdminAnnualCost;
	
	@Column(name = "general_service_annual_cost", precision = 10, scale = 2)
	private BigDecimal generalServiceAnnualCost;
	
	@Column(name = "energy_annual_cost", precision = 10, scale = 2)
	private BigDecimal energyAnnualCost;
	
	@Column(name = "water_annual_cost", precision = 10, scale = 2)
	private BigDecimal waterAnnualCost;
	
	@Column(name = "phonenet_annual_cost", precision = 10, scale = 2)
	private BigDecimal phoneNetAnnualCost;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cost_structure_id", referencedColumnName = "cost_structure_id")
	private CostStructure costStructure;
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public BigDecimal getGeneralAdminAnnualCost() {
		return generalAdminAnnualCost;
	}
	
	public void setGeneralAdminAnnualCost(BigDecimal generalAdminAnnualCost) {
		this.generalAdminAnnualCost = generalAdminAnnualCost;
	}
	
	public BigDecimal getGeneralServiceAnnualCost() {
		return generalServiceAnnualCost;
	}
	
	public void setGeneralServiceAnnualCost(BigDecimal generalServiceAnnualCost) {
		this.generalServiceAnnualCost = generalServiceAnnualCost;
	}
	
	public BigDecimal getEnergyAnnualCost() {
		return energyAnnualCost;
	}
	
	public void setEnergyAnnualCost(BigDecimal energyAnnualCost) {
		this.energyAnnualCost = energyAnnualCost;
	}
	
	public BigDecimal getWaterAnnualCost() {
		return waterAnnualCost;
	}
	
	public void setWaterAnnualCost(BigDecimal waterAnnualCost) {
		this.waterAnnualCost = waterAnnualCost;
	}
	
	public BigDecimal getPhoneNetAnnualCost() {
		return phoneNetAnnualCost;
	}
	
	public void setPhoneNetAnnualCost(BigDecimal phoneNetAnnualCost) {
		this.phoneNetAnnualCost = phoneNetAnnualCost;
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
