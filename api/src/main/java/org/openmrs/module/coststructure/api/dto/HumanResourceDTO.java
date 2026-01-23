package org.openmrs.module.coststructure.api.dto;

public class HumanResourceDTO {
	
	private Integer id;
	
	private String uuid;
	
	private String speciality;
	
	public HumanResourceDTO() {
	}
	
	public HumanResourceDTO(Integer id, String uuid, String speciality) {
		this.id = id;
		this.uuid = uuid;
		this.speciality = speciality;
	}
	
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
	
	public String getSpeciality() {
		return speciality;
	}
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
}
