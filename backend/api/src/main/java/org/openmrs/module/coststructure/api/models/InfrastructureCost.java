package org.openmrs.module.coststructure.api.models;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsObject;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "infrastructure_cost")
public class InfrastructureCost extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "infrastructure_cost_id")
	private Integer id;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 38)
	private String uuid;
	
	@Column(name = "annual_unit_dep", nullable = false)
	private BigDecimal annualUnitDep;
	
	@Column(name = "performance_time_service")
	private BigDecimal performanceTimeService;
	
	@Column(name = "production_proyected")
	private Integer productionProyected;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "infrastructure_id", referencedColumnName = "infrastructure_id")
	private Infrastructure infrastructure;
	
	// --- Relación Muchos a Uno (M:1) con CostStructure ---
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cost_structure_id", referencedColumnName = "cost_structure_id")
	private CostStructure costStructure;
	
	@OneToOne(mappedBy = "infrastructureCost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BasicServiceInductors basicServiceInductors;
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer integer) {
		this.id = integer;
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
	
	@Override
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Integer getProductionProyected() {
		return productionProyected;
	}
	
	public void setProductionProyected(Integer productionProyected) {
		this.productionProyected = productionProyected;
	}
	
	public Infrastructure getInfrastructure() {
		return infrastructure;
	}
	
	public void setInfrastructure(Infrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}
	
	public CostStructure getCostStructure() {
		return costStructure;
	}
	
	public void setCostStructure(CostStructure costStructure) {
		this.costStructure = costStructure;
	}
	
	public BasicServiceInductors getBasicServiceInductors() {
		return basicServiceInductors;
	}
	
	public void setBasicServiceInductors(BasicServiceInductors basicServiceInductors) {
		this.basicServiceInductors = basicServiceInductors;
	}
}
