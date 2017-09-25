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
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

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
	public void serializeExample() throws IOException, JSONException {
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(exampleUrl);
		String serialized = mapper.writeValueAsString(((OpenApi3Impl) model).createJson());
		String expected = mapper.writeValueAsString(yamlMapper.readTree(exampleUrl));
		JSONAssert.assertEquals(expected, serialized, JSONCompareMode.STRICT);
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
