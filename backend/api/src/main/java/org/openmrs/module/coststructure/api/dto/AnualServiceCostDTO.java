package org.openmrs.module.coststructure.api.dto;

import org.openmrs.module.coststructure.api.models.AnualServiceCost;
import java.math.BigDecimal;

public class AnualServiceCostDTO {
	
	private BigDecimal energyAnnualCost;
	
	private BigDecimal generalAdminAnnualCost;
	
	private BigDecimal generalServiceAnnualCost;
	
	private BigDecimal waterAnnualCost;
	
	private BigDecimal phonenetAnnualCost;
	
	public AnualServiceCostDTO() {
		
	}
	
	public AnualServiceCostDTO(AnualServiceCost a) {
		this.energyAnnualCost = a.getEnergyAnnualCost();
		this.generalAdminAnnualCost = a.getGeneralAdminAnnualCost();
		this.generalServiceAnnualCost = a.getGeneralServiceAnnualCost();
		this.waterAnnualCost = a.getWaterAnnualCost();
		this.phonenetAnnualCost = a.getPhoneNetAnnualCost();
	}
	
	public BigDecimal getEnergyAnnualCost() {
		return energyAnnualCost;
	}
	
	public void setEnergyAnnualCost(BigDecimal energyAnnualCost) {
		this.energyAnnualCost = energyAnnualCost;
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
	
	public BigDecimal getWaterAnnualCost() {
		return waterAnnualCost;
	}
	
	public void setWaterAnnualCost(BigDecimal waterAnnualCost) {
		this.waterAnnualCost = waterAnnualCost;
	}
	
	public BigDecimal getPhonenetAnnualCost() {
		return phonenetAnnualCost;
	}
	
	public void setPhonenetAnnualCost(BigDecimal phonenetAnnualCost) {
		this.phonenetAnnualCost = phonenetAnnualCost;
	}
}
