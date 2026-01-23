/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.coststructure.api.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Concept;
import org.openmrs.Location;
import org.openmrs.api.ConceptNameType;
import org.openmrs.api.ConceptService;
import org.openmrs.api.LocationService;
import org.openmrs.api.context.Context;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.api.impl.ConceptServiceImpl;
import org.openmrs.api.impl.LocationServiceImpl;
import org.openmrs.logic.op.In;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.coststructure.Item;
import org.openmrs.module.coststructure.api.models.CostStructure;
import org.openmrs.module.coststructure.api.models.Equipment;
import org.openmrs.module.coststructure.api.models.HumanResource;
import org.openmrs.module.coststructure.api.models.Infrastructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("coststructure.CoststructureDao")
public class CoststructureDao {
	
	@Autowired
	private DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<CostStructure> getAllCostStructures() {
		return (List<CostStructure>) getSession().createCriteria(CostStructure.class).list();
	}
	
	public CostStructure saveCostStructure(CostStructure costStructure) {
		DbSession session = getSession();
		session.saveOrUpdate(costStructure);
		return costStructure;
	}
	
	public CostStructure getCostStructureById(Integer id) {
		return (CostStructure) getSession().get(CostStructure.class, id);
	}
	
	public CostStructure getCostStructureByUuid(String uuid) {
		return (CostStructure) getSession().createQuery("FROM CostStructure WHERE uuid = :uuid ").setParameter("uuid", uuid)
		        .uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<CostStructure> finAll(Long page, Long size, String query) {
		boolean searching = query != null && !query.isEmpty();
		String hql = "FROM CostStructure c";
		if (searching) {
			hql += " JOIN FETCH c.procedure.names n WHERE lower(n.name) LIKE :query AND n.localePreferred = true";
		}
		Query q = getSession().createQuery(hql);
		
		if (searching) {
			q.setParameter("query", "%" + query + "%");
		}
		int offset = (int) (page * size);
		int limit = size.intValue();
		q.setFirstResult(offset);
		q.setMaxResults(limit);
		return (List<CostStructure>) q.list();
	}
	
	//query is the name of the cpms
	public Long countAll(String query) {
		boolean countingName = query != null && !query.isEmpty();
		
		String hql = "SELECT count(c) FROM CostStructure c";
		if (countingName) {
			hql += " JOIN c.procedure.names n WHERE lower(n.name) LIKE :query AND n.localePreferred = true";
		}
		Query qR = getSession().createQuery(hql);
		
		if (countingName) {
			qR.setParameter("query", "%" + query + "%");
		}
		return (Long) qR.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findProceduresByName(String query) {
		String hql = "SELECT new map( " + "c.conceptId as conceptId, " + "fullName.name as nameFull, "
		        + "shortName.name as code) " + "FROM Concept c " + "JOIN c.names fullName " + "LEFT JOIN c.names shortName "
		        + "WHERE lower(fullName.name) LIKE :query " + "AND fullName.localePreferred = true "
		        + "AND fullName.conceptNameType = :full " + "AND (shortName.conceptNameType = :short OR shortName IS NULL) "
		        + "AND c.conceptClass.name = 'Procedure'";
		
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("query", "%" + query.toLowerCase() + "%");
		q.setParameter("full", ConceptNameType.FULLY_SPECIFIED);
		q.setParameter("short", ConceptNameType.SHORT);
		
		q.setMaxResults(10);
		
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Infrastructure> getInfrastructure() {
		List<Infrastructure> infrastructures = (List<Infrastructure>) sessionFactory.getCurrentSession()
		        .createCriteria(Infrastructure.class).list();
		
		return infrastructures;
	}
	
	@SuppressWarnings("unchecked")
	public List<HumanResource> getHumanResources() {
		List<HumanResource> humanResources = (List<HumanResource>) sessionFactory.getCurrentSession()
		        .createCriteria(HumanResource.class).list();
		return humanResources;
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipment> getEquipments() {
		return (List<Equipment>) sessionFactory.getCurrentSession().createCriteria(Equipment.class).list();
	}
	
	public Item getItemByUuid(String uuid) {
		return (Item) getSession().createCriteria(Item.class).add(Restrictions.eq("uuid", uuid)).uniqueResult();
	}
	
	public Item saveItem(Item item) {
		getSession().saveOrUpdate(item);
		return item;
	}
	
}
