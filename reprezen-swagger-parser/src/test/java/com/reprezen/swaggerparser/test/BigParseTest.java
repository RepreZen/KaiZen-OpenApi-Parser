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
import com.reprezen.swaggerparser.SwaggerParser;
import com.reprezen.swaggerparser.impl3.Swagger3Impl;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.CollectionOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.CollectionStore;
import com.reprezen.swaggerparser.jsonoverlay.coll.ListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.MapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ObjectOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValMapOverlay;
import com.reprezen.swaggerparser.model3.Swagger3;
import com.reprezen.swaggerparser.test.JsonTreeWalker.PathKey;
import com.reprezen.swaggerparser.test.JsonTreeWalker.WalkMethod;

/**
 * Tests basic parser operation by loading a swagger spec and then verifying that all values can be obtained reliably
 * from the model
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
        final Swagger3 model = (Swagger3) SwaggerParser.parse(modelUrl, false);
        Predicate<JsonNode> valueNodePredicate = new Predicate<JsonNode>() {
            @Override
            public boolean apply(JsonNode node) {
                return node.isValueNode();
            }
        };
        WalkMethod valueChecker = new WalkMethod() {
            @Override
            public void run(JsonNode node, Collection<PathKey> path) {
                System.out.println(StringUtils.join(path, "."));
                Object fromModel = getFromModelObject((Swagger3Impl) model, Queues.newArrayDeque(path));
                Object fromJson = getValue(node);
                assertEquals(fromJson, fromModel);
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

    private Object getFromModelObject(JsonOverlay<?> modelObj, Deque<PathKey> path) {
        if (modelObj == null) {
            throw new NullPointerException("Attempt to get value of a null overlay");
        } else if (path.isEmpty()) {
            return modelObj.get();
        } else {
            PathKey key = path.remove();
            if (modelObj instanceof CollectionOverlay<?>) {
                JsonOverlay<?> item = getFromCollectionOverlay((CollectionOverlay<?>) modelObj, key);
                return getFromModelObject(item, path);
            } else if (modelObj instanceof ObjectOverlay<?>) {
                path.addFirst(key);
                ArrayDeque<PathKey> origPath = Queues.newArrayDeque(path);
                Optional<? extends JsonOverlay<?>> field;
                try {
                    field = getField((ObjectOverlay<?>) modelObj, path);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException("Cannot access object overlay field value", e);
                }
                if (field.isPresent()) {
                    return getFromModelObject(field.get(), path);
                } else {
                    throw new IllegalArgumentException("Path does not identify an object overlay field: " + origPath);
                }

            } else {
                throw new UnsupportedOperationException("Attempt to get a component from a primitive overlay");
            }
        }
    }

    private JsonOverlay<?> getFromCollectionOverlay(CollectionOverlay<?> modelObj, PathKey key) {
        CollectionStore<?> store = modelObj.getStore();
        if (key.isString()) {
            if (modelObj instanceof ListOverlay<?> || modelObj instanceof ValListOverlay<?, ?>) {
                throw new UnsupportedOperationException("Attempt to use string key for list overlay");
            }
            return store.getOverlay(key.getString());
        } else {
            if (modelObj instanceof MapOverlay<?> || modelObj instanceof ValMapOverlay<?, ?>) {
                throw new UnsupportedOperationException("Attempt to use index for map overlay");
            }
            return store.get(key.getIndex());
        }
    }

    private Optional<? extends JsonOverlay<?>> getField(ObjectOverlay<?> modelObj, Deque<PathKey> path)
            throws IllegalArgumentException, IllegalAccessException {
        String key = "";
        boolean first = true;
        Optional<? extends JsonOverlay<?>> value = Optional.absent();
        if (path.peek() != null && path.peek().isIndex()) {
            // next path item is an index, so our only shot is to get a list overlay bound directly to this object's
            // json node
            value = modelObj.getFieldValue("");
            if (value.isPresent() && (value.get() instanceof ListOverlay || value.get() instanceof ValListOverlay)) {
                return value;
            }
        }
        while (!value.isPresent()) {
            if (path.peek() == null || path.peek().isIndex()) {
                break;
            }
            String next = path.remove().getString();
            key = first ? next : key + ":" + next;
            value = modelObj.getFieldValue(key);
            first = false;
        }
        return value;
    }
}
