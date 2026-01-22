package org.openmrs.module.coststructure.api.dto;

import org.apache.commons.lang.time.DateUtils;
import org.openmrs.Concept;
import org.openmrs.module.coststructure.api.models.*;
import java.util.*;
import java.util.stream.Collectors;

public class CostStructureDTO {
	
	private String uuid;
	
	private Date createdDate;
	
	private Date startDate;
	
	private Date endDate;
	
	private ProcedureDTO procedure;
	
	private AnualServiceCostDTO anualServiceCost;
	
	private List<HumanResourceCostDTO> humanResourceCosts;
	
	private List<EquipmentCostDTO> equipmentCosts;
	
	private List<InfrastructureCostDTO> infrastructureCosts;
	
	public CostStructureDTO() {
		
	}
	
	public CostStructureDTO(CostStructure cs) {
        this.uuid = cs.getUuid();
        this.createdDate = cs.getCreatedDate();
        this.startDate = cs.getStartDate();
        this.endDate = cs.getEndDate();

        if (cs.getProcedure() != null) {
            this.procedure = new ProcedureDTO(cs.getProcedure());
        }

        if (cs.getAnualServiceCost() != null) {
            this.anualServiceCost = new AnualServiceCostDTO(cs.getAnualServiceCost());
        }

        if (cs.getHumanResourceCosts() != null) {
            this.humanResourceCosts = cs.getHumanResourceCosts().stream()
                    .map(HumanResourceCostDTO::new)
                    .collect(Collectors.toList());
        }

        if (cs.getEquipmentCosts() != null) {
            this.equipmentCosts = cs.getEquipmentCosts().stream()
                    .map(EquipmentCostDTO::new)
                    .collect(Collectors.toList());
        }

        if (cs.getInfrastructureCosts() != null) {
            this.infrastructureCosts = cs.getInfrastructureCosts().stream()
                    .map(InfrastructureCostDTO::new)
                    .collect(Collectors.toList());
        }
    }
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public ProcedureDTO getProcedure() {
		return procedure;
	}
	
	public void setProcedure(ProcedureDTO procedure) {
		this.procedure = procedure;
	}
	
	public AnualServiceCostDTO getAnualServiceCost() {
		return anualServiceCost;
	}
	
	public void setAnualServiceCost(AnualServiceCostDTO anualServiceCost) {
		this.anualServiceCost = anualServiceCost;
	}
	
	public List<HumanResourceCostDTO> getHumanResourceCosts() {
		return humanResourceCosts;
	}
	
	public void setHumanResourceCosts(List<HumanResourceCostDTO> humanResourceCosts) {
		this.humanResourceCosts = humanResourceCosts;
	}
	
	public List<EquipmentCostDTO> getEquipmentCosts() {
		return equipmentCosts;
	}
	
	public void setEquipmentCosts(List<EquipmentCostDTO> equipmentCosts) {
		this.equipmentCosts = equipmentCosts;
	}
	
	public List<InfrastructureCostDTO> getInfrastructureCosts() {
		return infrastructureCosts;
	}
	
	public void setInfrastructureCosts(List<InfrastructureCostDTO> infrastructureCosts) {
		this.infrastructureCosts = infrastructureCosts;
	}
	
	public CostStructure TransformToCostStructure(Concept concept) {
		CostStructure costStructure = new CostStructure();
		costStructure.setUuid(UUID.randomUUID().toString());
		costStructure.setCreatedDate(new Date());
		costStructure.setStartDate(this.startDate != null ? this.startDate : new Date());
		costStructure.setEndDate(this.endDate != null ? this.endDate : DateUtils.addMonths(new Date(), 6));
		costStructure.setProcedure(concept);
		if (this.getAnualServiceCost() != null) {
			AnualServiceCost anual = new AnualServiceCost();
			anual.setUuid(UUID.randomUUID().toString());
			anual.setEnergyAnnualCost(this.getAnualServiceCost().getEnergyAnnualCost());
			anual.setGeneralAdminAnnualCost(this.getAnualServiceCost().getGeneralAdminAnnualCost());
			anual.setCostStructure(costStructure);
			costStructure.setAnualServiceCost(anual);
		}
		
		if (this.getHumanResourceCosts() != null && !this.getHumanResourceCosts().isEmpty()) {
			for (HumanResourceCostDTO hrdto : this.getHumanResourceCosts()) {
				HumanResourceCost hr = new HumanResourceCost();
				hr.setUuid(UUID.randomUUID().toString());
				hr.setQuantity(hrdto.getQuantity());
				hr.setTimeMinutes(hrdto.getTimeMinutes());
				hr.setCostMinutes(hrdto.getCostMinutes());
				hr.setPriceMonth(hrdto.getPriceMonth());
				hr.setCostStructure(costStructure);
				costStructure.addHumanResourceCost(hr);
			}
		}
		if (this.getInfrastructureCosts() != null && !this.getInfrastructureCosts().isEmpty()) {
			for (InfrastructureCostDTO idto : this.getInfrastructureCosts()) {
				InfrastructureCost infra = new InfrastructureCost();
				infra.setUuid(UUID.randomUUID().toString());
				infra.setAnnualUnitDep(idto.getAnnualUnitDep());
				infra.setPerformanceTimeService(idto.getPerformanceTimeService());
				infra.setProductionProyected(idto.getProductionProyected());
				infra.setCostStructure(costStructure);
				costStructure.addInfrastructureCost(infra);
			}
		}
		
		return costStructure;
	}
}
