package org.openmrs.module.coststructure.api.dto;

import org.openmrs.module.coststructure.api.models.CostStructure;

public class CostStructureSummaryDTO {
	
	private String uuid;
	
	private Long createdDate;
	
	private Long startDate;
	
	private Long endDate;
	
	private ProcedureDTO procedure;
	
	public CostStructureSummaryDTO() {
	}
	
	public CostStructureSummaryDTO(CostStructure cs) {
		this.uuid = cs.getUuid();
		this.createdDate = (cs.getCreatedDate() != null) ? cs.getCreatedDate().getTime() : null;
		this.startDate = (cs.getStartDate() != null) ? cs.getStartDate().getTime() : null;
		this.endDate = (cs.getEndDate() != null) ? cs.getEndDate().getTime() : null;
		
		if (cs.getProcedure() != null) {
			this.procedure = new ProcedureDTO(cs.getProcedure());
		}
	}
	
	// Getters y setters
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Long getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}
	
	public Long getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}
	
	public Long getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}
	
	public ProcedureDTO getProcedure() {
		return procedure;
	}
	
	public void setProcedure(ProcedureDTO procedure) {
		this.procedure = procedure;
	}
}
