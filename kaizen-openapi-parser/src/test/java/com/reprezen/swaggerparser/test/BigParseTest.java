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

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.common.base.Predicate;
import com.reprezen.kaizen.oasparser.OpenApiParser;
import com.reprezen.kaizen.oasparser.jsonoverlay.IJsonOverlay;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl;
import com.reprezen.swaggerparser.test.JsonTreeWalker.WalkMethod;

/**
 * Tests basic parser operation by loading a swagger spec and then verifying
 * that all values can be obtained reliably from the model
 * 
 * @author Andy Lowry
 *
 */

@RunWith(Parameterized.class)
public class BigParseTest extends Assert {

	@Parameters
	public static Collection<Object[]> resources() {
		return Arrays.asList(new Object[][] { new URL[] { BigParseTest.class.getResource("/models/parseTest.yaml") } });
	}

	@Parameter
	public URL modelUrl;

	@Test
	public void test() throws JsonProcessingException, IOException {
		Object parsedYaml = new Yaml().load(modelUrl.openStream());
		JsonNode tree = new YAMLMapper().convertValue(parsedYaml, JsonNode.class);
		final OpenApi3 model = (OpenApi3) new OpenApiParser().parse(modelUrl, false);
		Predicate<JsonNode> valueNodePredicate = new Predicate<JsonNode>() {
			@Override
			public boolean apply(JsonNode node) {
				return node.isValueNode();
			}
		};
		WalkMethod valueChecker = new WalkMethod() {
			@Override
			public void run(JsonNode node, JsonPointer path) {
				IJsonOverlay<?> overlay = ((OpenApi3Impl) model).find(path);
				assertNotNull("No overlay object found for path: " + path, overlay);
				Object fromJson = getValue(node);
				String msg = String.format("Wrong overlay value for path '%s': expected '%s', got '%s'", path, fromJson,
						overlay.get());
				assertEquals(msg, fromJson, overlay.get());
			}
		};
		JsonTreeWalker.walkTree(tree, valueNodePredicate, valueChecker);
	}

	private Object getValue(JsonNode node) {
		if (node.isNumber()) {
			return node.numberValue();
		} else if (node.isTextual()) {
			return node.textValue();
		} else if (node.isBoolean()) {
			return node.booleanValue();
		} else if (node.isNull()) {
			return null;
		} else {
			throw new IllegalArgumentException("Non-value JSON node got through value node filter");
		}
	}
}
