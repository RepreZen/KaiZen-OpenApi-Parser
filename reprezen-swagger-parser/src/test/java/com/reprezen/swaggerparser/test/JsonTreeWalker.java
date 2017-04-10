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

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Queues;

public class JsonTreeWalker {

    public static void walkTree(JsonNode tree, Predicate<JsonNode> nodeFilter, WalkMethod walkMethod) {
        if (nodeFilter == null) {
            nodeFilter = Predicates.alwaysTrue();
        }
        new JsonTreeWalker(nodeFilter, walkMethod).walk(tree, Queues.<PathKey> newArrayDeque());
    }

    private Predicate<JsonNode> nodeFilter;
    private WalkMethod walkMethod;

    public JsonTreeWalker(Predicate<JsonNode> nodeFilter, WalkMethod walkMethod) {
        this.nodeFilter = nodeFilter;
        this.walkMethod = walkMethod;
    }

    private void walk(JsonNode node, Deque<PathKey> path) {
        if (nodeFilter.apply(node)) {
            visit(node, path);
        }
        walkChildren(node, path);
    }

    private void visit(JsonNode node, Deque<PathKey> path) {
        walkMethod.run(node, Collections.unmodifiableCollection(path));
    }

    private void walkChildren(JsonNode node, Deque<PathKey> path) {
        if (node instanceof ObjectNode) {
            for (Entry<String, JsonNode> field : iterable(node.fields())) {
                path.add(PathKey.of(field.getKey()));
                walk(field.getValue(), path);
                path.removeLast();
            }
        } else if (node instanceof ArrayNode) {
            for (int i = 0; i < node.size(); i++) {
                path.add(PathKey.of(i));
                walk(node.get(i), path);
                path.removeLast();
            }
        }
    }

    public static interface WalkMethod {
        void run(JsonNode node, Collection<PathKey> path);
    }

    private <T> Iterable<T> iterable(final Iterator<T> iterator) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return iterator;
            }
        };
    }

    public static class PathKey {
        private String key = null;
        private Integer index = null;

        public PathKey(String key) {
            this.key = key;
        }

        public static PathKey of(String key) {
            return new PathKey(key);
        }

        public PathKey(int index) {
            this.index = index;
        }

        public static PathKey of(int index) {
            return new PathKey(index);
        }

        public String getString() {
            if (key != null) {
                return key;
            } else {
                throw new UnsupportedOperationException();
            }
        }

        public int getIndex() {
            if (index != null) {
                return index;
            } else {
                throw new UnsupportedOperationException();
            }
        }

        public boolean isString() {
            return key != null;
        }

        public boolean isIndex() {
            return index != null;
        }

        @Override
        public String toString() {
            return key != null ? key : "[" + index + "]";
        }
    }
}
