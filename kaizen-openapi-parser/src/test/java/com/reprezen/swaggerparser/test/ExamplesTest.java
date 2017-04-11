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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.reprezen.kaizen.oasparser.OpenApiParser;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.val.ValidationResults.ValidationItem;

@RunWith(Parameterized.class)
public class ExamplesTest extends Assert {

    private static final String SPEC_REPO = "OAI/OpenAPI-Specification";
    private static final String EXAMPLES_BRANCH = "dm/examples";
    private static final String EXAMPLES_ROOT = "examples/v3.0";

    private static ObjectMapper mapper = new ObjectMapper();

    @Parameters
    public static Collection<URL> findExamples() throws IOException {
        Collection<URL> examples = Lists.newArrayList();
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
                    examples.add(new URL(downloadUrl));
                }
            }
        }
        return examples;
    }

    @Parameter
    public URL exampleUrl;

    @Test
    public void exampleCanBeParsed() throws IOException {
        OpenApi3 model = (OpenApi3) new OpenApiParser().parse(exampleUrl);
        System.out.println(model.isValid());
        System.out.println(IOUtils.toString(exampleUrl, Charsets.UTF_8));
        for (ValidationItem item : model.getValidationItems()) {
            System.out.println(item);
        }
        assertTrue(model.isValid());
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
