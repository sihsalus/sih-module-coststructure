package org.openmrs.module.coststructure.api.dto;

import java.math.BigDecimal;

public class InfrastructureDTO {
	
	private Integer id;
	
	private String uuid;
	
	private String locationName;
	
	private BigDecimal areaM2;
	
	private BigDecimal constructionCost;
	
	public InfrastructureDTO() {
	}
	
	public InfrastructureDTO(Integer id, String uuid, String locationName, BigDecimal areaM2, BigDecimal constructionCost) {
		this.id = id;
		this.uuid = uuid;
		this.locationName = locationName;
		this.areaM2 = areaM2;
		this.constructionCost = constructionCost;
	}
	
	// Getters y setters
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public BigDecimal getAreaM2() {
		return areaM2;
	}
	
	public void setAreaM2(BigDecimal areaM2) {
		this.areaM2 = areaM2;
	}
	
	public BigDecimal getConstructionCost() {
		return constructionCost;
	}
	
	public void setConstructionCost(BigDecimal constructionCost) {
		this.constructionCost = constructionCost;
	}
}
