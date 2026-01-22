package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Location;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name = "infrastructure")
public class Infrastructure extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "infrastructure_id")
	private Integer id;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@Column(name = "area_m2", nullable = false, precision = 10, scale = 2)
	private BigDecimal areaM2;
	
	@Column(name = "construction_cost", nullable = false, precision = 10, scale = 2)
	private BigDecimal constructionCost;
	
	@OneToMany(mappedBy = "infrastructure", fetch = FetchType.LAZY)
	private List<InfrastructureCost> infrastructureCosts;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", referencedColumnName = "location_id")
	private Location location; //openrms datamodel contains a part of the hospital
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer integer) {
		this.id = integer;
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
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
}
