package org.openmrs.module.coststructure.api.dto;

import org.openmrs.Concept;

public class ProcedureDTO {
	
	private Integer conceptId;
	
	private String name;
	
	public ProcedureDTO() {
		
	}
	
	public ProcedureDTO(Concept c) {
		this.conceptId = c.getConceptId();
		this.name = (c.getName() != null) ? c.getName().getName() : null;
	}
	
	// Getters y Setters
	
	public Integer getConceptId() {
		return conceptId;
	}
	
	public void setConceptId(Integer conceptId) {
		this.conceptId = conceptId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
