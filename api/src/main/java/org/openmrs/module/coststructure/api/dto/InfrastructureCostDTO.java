package org.openmrs.module.coststructure.api.dto;

import org.openmrs.module.coststructure.api.models.InfrastructureCost;
import java.math.BigDecimal;

public class InfrastructureCostDTO {
	
	private BigDecimal annualUnitDep;
	
	private BigDecimal performanceTimeService;
	
	private Integer productionProyected;
	
	public InfrastructureCostDTO() {
		
	}
	
	public InfrastructureCostDTO(InfrastructureCost i) {
		this.annualUnitDep = i.getAnnualUnitDep();
		this.performanceTimeService = i.getPerformanceTimeService();
		this.productionProyected = i.getProductionProyected();
	}
	
	// Getters y Setters
	
	public BigDecimal getAnnualUnitDep() {
		return annualUnitDep;
	}
	
	public void setAnnualUnitDep(BigDecimal annualUnitDep) {
		this.annualUnitDep = annualUnitDep;
	}
	
	public BigDecimal getPerformanceTimeService() {
		return performanceTimeService;
	}
	
	public void setPerformanceTimeService(BigDecimal performanceTimeService) {
		this.performanceTimeService = performanceTimeService;
	}
	
	public Integer getProductionProyected() {
		return productionProyected;
	}
	
	public void setProductionProyected(Integer productionProyected) {
		this.productionProyected = productionProyected;
	}
}
