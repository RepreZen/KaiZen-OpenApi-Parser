/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.common.io.Resources;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.OpenApiParser;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;
import com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl;
import com.reprezen.kaizen.oasparser.ovl3.SecurityRequirementImpl;
import com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl;

public class SecurityTest {

	private static ObjectMapper mapper = new ObjectMapper();
	private static ObjectMapper yamlMapper = new YAMLMapper();
	
	@Test
	public void testParse() throws Exception {
		
		URL exampleUrl = Resources.getResource("models/securityRequirementsTest.yaml");
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(exampleUrl, false);
		
		// Security scheme
		SecuritySchemeImpl scheme = (SecuritySchemeImpl) model.getSecurityScheme("oauthSchemeWithEmptyScopes");
		assertNotNull(scheme);
		OAuthFlow flow = scheme.getImplicitOAuthFlow();
		assertNotNull(flow);
		Map<String, String> scopeDefinitions = flow.getScopes();
		assertNotNull(scopeDefinitions);
		assertEquals(0, scopeDefinitions.size());

		// Top-level Security Requirements
		assertEquals(3, model.getSecurityRequirements().size());
		
		assertNotNull(model.getSecurityRequirement(0));
		assertEquals(SecurityRequirementImpl.class, model.getSecurityRequirement(0).getClass());
		
		assertEquals(SecurityRequirementImpl.class, model.getSecurityRequirement(2).getClass());
		Map<String, SecurityParameter> secReq3 = model.getSecurityRequirement(2).getRequirements();
		assertEquals(1, secReq3.size());
		SecurityParameter scopes = secReq3.get("oauthSchemeWithEmptyScopes");
		assertNotNull(scopes);
		assertNotNull(scopes.getParameters());
		assertEquals(0, scopes.getParameters().size());
		
		// Operation-level Security Requirements Override to Empty Array
		List<SecurityRequirement> secReqOperation = model.getPath("/widgets").getGet().getSecurityRequirements();
		assertNotNull(secReqOperation);
		assertEquals(0, secReqOperation.size());	

	}
	
	@Test
	public void testSerialize() throws Exception {
		URL exampleUrl = Resources.getResource("models/securityRequirementsTest.yaml");
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(exampleUrl, false);
		JsonNode serialized = Overlay.toJson((OpenApi3Impl) model);
//		String yamlString = new YAMLMapper().writerWithDefaultPrettyPrinter().writeValueAsString(serialized);
//		System.out.print(yamlString);
		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(serialized);
		System.out.print(jsonString);
		JsonNode expected = yamlMapper.readTree(exampleUrl);
		JSONAssert.assertEquals(mapper.writeValueAsString(expected), mapper.writeValueAsString(serialized),
				JSONCompareMode.STRICT);
		
	}
}
