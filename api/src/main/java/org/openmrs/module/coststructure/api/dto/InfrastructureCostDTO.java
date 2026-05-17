package org.openmrs.module.coststructure.api.dto;

import org.openmrs.module.coststructure.api.models.InfrastructureCost;
import java.math.BigDecimal;

public class InfrastructureCostDTO {
	
	private Integer infrastructureId;
	
	private BigDecimal annualUnitDep;
	
	private BigDecimal performanceTimeService;
	
	private Integer productionProyected;
	
	public InfrastructureCostDTO() {
		
	}
	
	public InfrastructureCostDTO(InfrastructureCost i) {
		this.infrastructureId = i.getInfrastructure() != null ? i.getInfrastructure().getId() : null;
		this.annualUnitDep = i.getAnnualUnitDep();
		this.performanceTimeService = i.getPerformanceTimeService();
		this.productionProyected = i.getProductionProyected();
	}
	
	// Getters y Setters
	public Integer getInfrastructureId() {
		return infrastructureId;
	}
	
	public void setInfrastructureId(Integer infrastructureId) {
		this.infrastructureId = infrastructureId;
	}
	
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
