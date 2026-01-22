package org.openmrs.module.coststructure.api.dto;

public class EquipmentDTO {
	
	private Integer id;
	
	private String name;
	
	private String uuid;
	
	private Integer usefulLifeYears;
	
	public EquipmentDTO() {
	}
	
	public EquipmentDTO(Integer usefulLifeYears, String uuid, String name, Integer id) {
		this.usefulLifeYears = usefulLifeYears;
		this.uuid = uuid;
		this.name = name;
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Integer getUsefulLifeYears() {
		return usefulLifeYears;
	}
	
	public void setUsefulLifeYears(Integer usefulLifeYears) {
		this.usefulLifeYears = usefulLifeYears;
	}
}
