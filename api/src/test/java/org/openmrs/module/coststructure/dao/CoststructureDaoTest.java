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

import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.coststructure.api.service.CoststructureService;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertNotNull;

/**
 * Integration smoke tests that verify the module can load inside the OpenMRS Spring/Hibernate test
 * context. This catches broken application context wiring, liquibase changesets, and missing
 * service/DAO beans before publishing the OMOD.
 */
public class CoststructureDaoTest extends BaseModuleContextSensitiveTest {
	
	@Autowired
	CoststructureDao dao;
	
	@Test
	public void moduleContext_shouldLoadCoststructureBeans() {
		CoststructureService service = Context.getService(CoststructureService.class);
		assertNotNull(service);
		assertNotNull(dao);
		assertNotNull(applicationContext.getBean("coststructure.CoststructureService"));
		assertNotNull(applicationContext.getBean("coststructure.CoststructureDao"));
	}
}
