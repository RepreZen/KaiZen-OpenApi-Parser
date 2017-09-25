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
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.reprezen.kaizen.oasparser.OpenApiParser;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl;

@RunWith(Parameterized.class)
public class SimpleSerializationTest extends Assert {

	private static final String SPEC_REPO = "RepreZen/KaiZen-OpenAPI-Editor";
	private static final String EXAMPLES_BRANCH = "master";
	private static final String EXAMPLES_ROOT = "com.reprezen.swagedit.openapi3.tests/resources/spec_examples/v3.0";

	private static ObjectMapper mapper = new ObjectMapper();
	private static ObjectMapper yamlMapper = new YAMLMapper();

	@Parameters(name = "{index}: {1}")
	public static Collection<Object[]> findExamples() throws IOException {
		Collection<Object[]> examples = Lists.newArrayList();
		Deque<URL> dirs = Queues.newArrayDeque();
		String auth = System.getenv("GITHUB_AUTH") != null ? System.getenv("GITHUB_AUTH") + "@" : "";
		String request = String.format("https://%sapi.github.com/repos/%s/contents/%s?ref=%s", auth, SPEC_REPO,
				EXAMPLES_ROOT, EXAMPLES_BRANCH);
		dirs.add(new URL(request));
		while (!dirs.isEmpty()) {
			URL url = dirs.remove();
			String json = IOUtils.toString(url, Charsets.UTF_8);
			JsonNode tree = mapper.readTree(json);
			for (JsonNode result : iterable(tree.elements())) {
				String type = result.get("type").asText();
				String path = result.get("path").asText();
				String resultUrl = result.get("url").asText();
				if (type.equals("dir")) {
					dirs.add(new URL(resultUrl));
				} else if (type.equals("file") && (path.endsWith(".yaml") || path.endsWith(".json"))) {
					String downloadUrl = result.get("download_url").asText();
					examples.add(new Object[] { new URL(downloadUrl), result.get("name").asText() });
				}
			}
		}
		return examples;
	}

	@Parameter
	public URL exampleUrl;

	@Parameter(1)
	public String fileName;

	@Test
	public void serializeExample() throws IOException {
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(exampleUrl);
		JsonNode serialized = ((OpenApi3Impl) model).createJson();
		JsonNode expected = yamlMapper.readTree(exampleUrl);
		assertTrue(treeEquals(expected, serialized, "[root]"));
	}

	private boolean treeEquals(JsonNode x, JsonNode y, String path) throws JsonProcessingException {
		if ((x == null || x.isMissingNode()) != (y == null || y.isMissingNode())) {
			return false;
		} else if (x.getClass() != y.getClass()) {
			return false;
		} else {
			switch (x.getNodeType()) {
			case ARRAY:
				if (x.size() != y.size()) {
					return false;
				}
				for (int i = 0; i < x.size(); i++) {
					if (!treeEquals(x.get(i), y.get(i), path + "/" + i)) {
						System.out.printf("Trees differed at path %s/%s\n%s\n%s\n", path, i, mapper.writeValueAsString(x), mapper.writeValueAsString(y));
						return false;
					}
				}
				return true;
			case BOOLEAN:
				return x.asBoolean() == y.asBoolean();
			case NULL:
				return true;
			case NUMBER:
				Number xn = null, yn = null;
				if (x.isDouble()) {
					xn = x.doubleValue();
					yn = y.doubleValue();
				} else if (x.isFloat()) {
					xn = x.floatValue();
					yn = y.floatValue();
				} else if (x.isInt()) {
					xn = x.intValue();
					yn = y.intValue();
				} else if (x.isLong()) {
					xn = x.longValue();
					yn = y.longValue();
				} else if (x.isShort()) {
					xn = x.shortValue();
					yn = y.shortValue();
				}
				return xn.equals(yn);
			case OBJECT:
				if (x.size() != y.size()) {
					return false;
				}
				for (Iterator<String> iter = x.fieldNames(); iter.hasNext();) {
					String propName = iter.next();
					if (!treeEquals(x.get(propName), y.get(propName), path + "/" + propName)) {
						System.out.printf("Trees differed at path %s/%s\n%s\n%s\n", path, propName, mapper.writeValueAsString(x), mapper.writeValueAsString(y));
						return false;
					}
				}
				return true;
			case STRING:
				return x.asText().equals(y.asText());
			default:
				return false;
			}
		}
	}

	private static <T> Iterable<T> iterable(final Iterator<T> iterator) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return iterator;
			}
		};
	}
}
