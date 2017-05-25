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
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Queues;
import com.reprezen.kaizen.oasparser.OpenApiParser;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.Reference;
import com.reprezen.kaizen.oasparser.jsonoverlay.coll.CollectionOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.coll.CollectionStore;
import com.reprezen.kaizen.oasparser.jsonoverlay.coll.ListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.coll.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.coll.ObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.coll.ValListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.coll.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl;
import com.reprezen.kaizen.oasparser.ovl3.RequestBodyImpl;
import com.reprezen.kaizen.oasparser.ovl3.ResponseImpl;
import com.reprezen.swaggerparser.test.JsonTreeWalker.PathKey;
import com.reprezen.swaggerparser.test.JsonTreeWalker.WalkMethod;

import com.reprezen.kaizen.oasparser.ovl3.SchemaImpl;

/**
 * Basic test based on BigParseTest to test pointer deferencing
 * 
 * @author Francesco Guardiani @slinkydeveloper
 *
 */

public class DerefTest extends Assert {

    @Test
    public void test() throws JsonProcessingException, IOException {
    	URL modelUrl = DerefTest.class.getResource("/models/petstore-expanded.yaml");
        Object parsedYaml = new Yaml().load(modelUrl.openStream());
        JsonNode tree = new YAMLMapper().convertValue(parsedYaml, JsonNode.class);
        Reference.derefAllTree = false;
        final OpenApi3 model = (OpenApi3) new OpenApiParser().parse(modelUrl);
        model.validate();
        JsonNode anotherReallyImportantImpl = ((ResponseImpl)model.getPath("/pets").getPost().getResponse("200")).getDereferencedJsonTree();
        System.out.println(anotherReallyImportantImpl);
    }
}
