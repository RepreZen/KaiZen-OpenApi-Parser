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
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.Resources;
import com.reprezen.kaizen.oasparser.OpenApiParser;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;

public class ExampleTest {

    private static OpenApi3 model;
    private Map<String, Object> exampleFixture = ImmutableMap.<String, Object> of( //
            "foo", "bar", //
            "person", ImmutableMap.<String, Object> of( //
                    "name", "Paul"));

    @BeforeClass
    public static void beforeClass() {
        model = (OpenApi3) new OpenApiParser().parse(Resources.getResource("models/examplesTest.yaml"), false);
    }

    @Test
    public void testExample() {
        Object example = model.getPath("/v2") //
                .getOperation("get") //
                .getResponse("203") //
                .getContentMediaType("application/json") //
                .getExample();

        assertEquals(exampleFixture, example);
    }

    @Test
    public void testExamples() {
        Map<String, ? extends Example> examples = model.getPath("/v2") //
                .getOperation("get") //
                .getResponse("200") //
                .getContentMediaType("application/json") //
                .getExamples();

        assertEquals(1, examples.size());
        assertTrue(examples.containsKey("foo"));

        Example example = examples.get("foo");

        assertEquals(exampleFixture, example.getValue());
        assertEquals("First Example", example.getSummary());
        assertEquals("An Example", example.getDescription());
    }
}
