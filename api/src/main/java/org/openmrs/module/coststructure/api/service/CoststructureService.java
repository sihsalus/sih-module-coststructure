/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.coststructure.api.service;

import org.openmrs.Concept;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.coststructure.CoststructureConfig;
import org.openmrs.module.coststructure.Item;
import org.openmrs.module.coststructure.api.dto.CostStructureDTO;
import org.openmrs.module.coststructure.api.dto.ProcedureDTO;
import org.openmrs.module.coststructure.api.models.CostStructure;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
public interface CoststructureService extends OpenmrsService {
	
	public Item getItemByUuid(String uuid) throws APIException;
	
	public Item saveItem(Item item) throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	List<CostStructure> getAllCostStructures() throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	CostStructure getCostStructureById(Integer id) throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	CostStructure getCostStructureByUuid(String uuid) throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	Integer countAllCostStructures() throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	void saveCostStructure(CostStructure dto) throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	Long countAll(String query) throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	List<CostStructure> finAllCostStructures(Long page, Long size, String query) throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	List<Map<String, Object>> findProcedures(String query) throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	List<?> getInfrastructure() throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	List<?> getHumanResources() throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	List<?> getEquipment() throws APIException;
	
	@Authorized(CoststructureConfig.MODULE_PRIVILEGE)
	@Transactional
	List<?> getSupplies() throws APIException;
}
