/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.coststructure.api.impl;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.openmrs.Concept;
import org.openmrs.ConceptName;
import org.openmrs.api.APIException;
import org.openmrs.api.ConceptService;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.coststructure.Item;
import org.openmrs.module.coststructure.api.dto.*;
import org.openmrs.module.coststructure.api.models.CostStructure;
import org.openmrs.module.coststructure.api.models.Equipment;
import org.openmrs.module.coststructure.api.models.HumanResource;
import org.openmrs.module.coststructure.api.models.Infrastructure;
import org.openmrs.module.coststructure.api.service.CoststructureService;
import org.openmrs.module.coststructure.api.dao.CoststructureDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

public class CoststructureServiceImpl extends BaseOpenmrsService implements CoststructureService {
	
	CoststructureDao dao;
	
	Logger log = Logger.getLogger(CoststructureServiceImpl.class);
	
	public CoststructureServiceImpl() {
	}
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(CoststructureDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public Item getItemByUuid(String uuid) throws APIException {
		return dao.getItemByUuid(uuid);
	}
	
	@Override
	public Item saveItem(Item item) throws APIException {
		if (item.getOwner() == null) {
			item.setOwner(userService.getUser(1));
		}
		
		return dao.saveItem(item);
	}
	
	@Override
	public List<CostStructure> getAllCostStructures() throws APIException {
		return dao.getAllCostStructures();
	}
	
	@Override
	public CostStructure getCostStructureById(Integer id) throws APIException {
		return dao.getCostStructureById(id);
	}
	
	@Override
	public CostStructure getCostStructureByUuid(String uuid) throws APIException {
		return dao.getCostStructureByUuid(uuid);
	}
	
	@Override
	public Integer countAllCostStructures() throws APIException {
		return 0;
	}
	
	@Override
	@Transactional
	public void saveCostStructure(CostStructure dto) throws APIException {
		if (dto.getProcedure() == null || dto.getProcedure().getConceptId() == null)
			throw new APIException("Missing required parameter 'procedure'");
		Concept concept = Context.getConceptService().getConcept(dto.getProcedure().getConceptId());
		if (concept == null)
			throw new APIException("Invalid concept id " + dto.getProcedure().getConceptId());
		
		dao.saveCostStructure(dto);
	}
	
	@Override
	public Long countAll(String query) throws APIException {
		return dao.countAll(query);
	}
	
	@Override
	public List<CostStructure> finAllCostStructures(Long page, Long size, String query) throws APIException {
		return dao.finAll(page, size, query);
	}
	
	@Override
	public List<Map<String, Object>> findProcedures(String query) throws APIException {
		if (query == null || query.trim().isEmpty()) {
			return Collections.emptyList();
		}
		String cleanQuery = query.replaceAll("[%_]", "").trim();
		return dao.findProceduresByName(cleanQuery);
	}
	
	@Override
	public List<?> getInfrastructure() throws APIException {
        List<Infrastructure> infrastructure = dao.getInfrastructure();
        List<InfrastructureDTO> dtos = new ArrayList<>();
        for (Infrastructure infra : infrastructure) {
            String locationName = "";
            if (infra.getLocation() != null)
                locationName = infra.getLocation().getName();

            InfrastructureDTO dto = new InfrastructureDTO(
                    infra.getId(),
                    infra.getUuid(),
                    locationName,
                    infra.getAreaM2(),
                    infra.getConstructionCost()
            );
            dtos.add(dto);
        }
        return dtos;
	}
	
	@Override
    public List<?> getHumanResources() throws APIException{
        List<HumanResource> humanResources = dao.getHumanResources();
        List<HumanResourceDTO> dtos = new ArrayList<>();
        for(HumanResource humanResource : humanResources) {
            HumanResourceDTO dto = new HumanResourceDTO(
                    humanResource.getId(),
                    humanResource.getUuid(),
                    humanResource.getSpeciality()
            );
            dtos.add(dto);
        }
        return dtos;
    }
	
	@Override
    public List<?> getEquipment() throws APIException {
        List<Equipment> equipments = dao.getEquipments();
        List<EquipmentDTO> dtos = new ArrayList<>();
        for (Equipment equipment : equipments) {
            EquipmentDTO dto = new EquipmentDTO(
                    equipment.getUsefulLifeYears(),
                    equipment.getUuid(),
                    equipment.getName(),
                    equipment.getId()
            );
            dtos.add(dto);
        }
        return dtos;
    }
}
