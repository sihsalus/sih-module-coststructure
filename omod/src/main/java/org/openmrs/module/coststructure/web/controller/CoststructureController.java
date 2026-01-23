/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.coststructure.web.controller;

import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.module.coststructure.api.dto.CostStructureDTO;
import org.openmrs.module.coststructure.api.dto.CostStructureSummaryDTO;
import org.openmrs.module.coststructure.api.models.CostStructure;
import org.openmrs.module.coststructure.api.models.Infrastructure;
import org.openmrs.module.coststructure.api.service.CoststructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/coststructure/coststructureLink.form'.
 */
@Controller
@RequestMapping(value = "/module/coststructure")
public class CoststructureController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CoststructureService coststructureService;
	
	/** Success form view name */
	private final String VIEW = "/module/coststructure/coststructure";
	
	/**
	 * Initially called after the getUsers method to get the landing form name
	 * 
	 * @return String form view name
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String onGet() {
		return VIEW;
	}
	
	/**
	 * All the parameters are optional based on the necessity
	 * 
	 * @param httpSession
	 * @param anyRequestObject
	 * @param errors
	 * @return
	 */
	
	/**
	 * This class returns the form backing object. This can be a string, a boolean, or a normal java
	 * pojo. The bean name defined in the ModelAttribute annotation and the type can be just defined
	 * by the return type of this method
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getCostStructures() {
		List<CostStructure> costStructures = coststructureService.getAllCostStructures();
		List<CostStructureSummaryDTO> dtos = new ArrayList<>();

		for (CostStructure costStructure : costStructures) {
			dtos.add(new  CostStructureSummaryDTO(costStructure));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getCostStructuresPagination(@RequestParam(value = "page", defaultValue = "0") Long page,
	        @RequestParam(value = "size", defaultValue = "10") Long size,
	        @RequestParam(value = "query", defaultValue = "") String query) {
        List<CostStructure> costStructures = coststructureService.finAllCostStructures(page, size, query);
		Long total = coststructureService.countAll(query);
        List<CostStructureSummaryDTO> dtos = new ArrayList<>();
        for (CostStructure costStructure : costStructures) {
            dtos.add(new  CostStructureSummaryDTO(costStructure));
        }
        Map<String,Object> response = new HashMap<>();
        response.put("total", total);
        response.put("page", page);
        response.put("size", size);
        response.put("content", dtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/lst",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getCostStructuresByUUID(@RequestParam(value = "uuid") String uuid ){
        CostStructure cst = coststructureService.getCostStructureByUuid(uuid);
        if(cst == null)
            return new ResponseEntity<>("Estructura de costos no encontrada con id: "+ uuid, HttpStatus.NOT_FOUND);
        CostStructureDTO dto = new CostStructureDTO(cst);
        return new ResponseEntity<CostStructureDTO>(dto, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/id/{id}",method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getCostStructureById(@PathVariable("id") Integer id) {
		CostStructure cst = coststructureService.getCostStructureById(id);
        if(cst == null)
            return new ResponseEntity<>("Estructura de costos no encontrada con id: "+ id, HttpStatus.NOT_FOUND);
		CostStructureDTO dto = new CostStructureDTO(cst);
        log.info("GET: CostStructure id: "+ id + "founded");
		return new ResponseEntity<CostStructureDTO>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createCostStructure(@RequestBody CostStructureDTO costStructureDTO) {
        if (costStructureDTO == null || costStructureDTO.getProcedure() == null || costStructureDTO.getProcedure().getConceptId() == null) {
            return new ResponseEntity<>("Faltan datos de la estructura de costos o el Concept ID del procedimiento", HttpStatus.BAD_REQUEST);
        }
		try {
            Integer conceptId = costStructureDTO.getProcedure().getConceptId();
            Concept concept = Context.getConceptService().getConcept(conceptId);

            if (concept == null) {
                return new ResponseEntity<>("Concepto no encontrado con ID: " + conceptId, HttpStatus.NOT_FOUND);
            }

            // 2. Transformar el DTO a la entidad (Model)
            CostStructure cs = costStructureDTO.TransformToCostStructure(concept);

            // 3. Guardar la entidad (este método debe ser transaccional)
            coststructureService.saveCostStructure(cs);

            return new ResponseEntity<>("Cost Structure creada exitosamente", HttpStatus.CREATED);
		}
		catch (APIException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/procedures",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getProcedures(@RequestParam(value = "query")  String query) {
        return new ResponseEntity<>(coststructureService.findProcedures(query), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/infrastructure",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getInfrastructure(){
        return new ResponseEntity<>(coststructureService.getInfrastructure(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/humanresource",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getHumanResources(){
        return new ResponseEntity<>(coststructureService.getHumanResources(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/equipment",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getEquipment(){
        return new ResponseEntity<>(coststructureService.getEquipment(), HttpStatus.OK);
    }
}
