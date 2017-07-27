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
package com.reprezen.kaizen.oasparser.jsonoverlay;

import java.net.URL;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;

public class Resolver {

    private Set<ResolutionBase> resolvedBases = Sets.newHashSet();
    private final ReferenceRegistry referenceRegistry;
    private final ResolutionBaseRegistry resolutionBaseRegistry;
    
    public Resolver(ReferenceRegistry referenceRegistry, ResolutionBaseRegistry resolutionBaseRegistry) {
       this.referenceRegistry = referenceRegistry;
       this.resolutionBaseRegistry = resolutionBaseRegistry;
    }

    public void preresolve(String... baseUrls) {
        for (String url : baseUrls) {
            preresolve(resolutionBaseRegistry.of(url, true));
        }
    }

    public void preresolve(URL... baseUrls) {
        for (URL url : baseUrls) {
            preresolve(resolutionBaseRegistry.of(url, true));
        }
    }

    public void preresolve(ResolutionBase base) {
        Queue<ResolutionBase> toResolve = Queues.newArrayDeque();
        toResolve.add(base);
        while (!toResolve.isEmpty()) {
            toResolve.addAll(preresolveBase(toResolve.remove()));
        }
    }

    private Collection<ResolutionBase> preresolveBase(ResolutionBase base) {
        List<ResolutionBase> discoveredBases = Lists.newArrayList();
        if (!resolvedBases.contains(base)) {
            resolvedBases.add(base);
            if (base.isValid()) {
                for (JsonNode refNode : findReferenceNodes(base.getJson())) {
                    JsonNode refString = refNode.get("$ref");
                    String key = referenceRegistry.register(refString, base, true);
                    ((ObjectNode) refNode).put("key", key);
                    Reference ref = referenceRegistry.get(key);
                    if (ref.isValid() && !resolvedBases.contains(ref.getBase())) {
                        discoveredBases.add(ref.getBase());
                    }
                }
            }
        }
        return discoveredBases;
    }

    private final Predicate<JsonNode> refNodeFilter = new Predicate<JsonNode>() {
        @Override
        public boolean apply(JsonNode node) {
            // accepting nodes with non-text $ref properties will mean we'll get Reference objects marked as invalid, as
            // desired
            return node.isObject() && node.has("$ref");
        }
    };

    private Iterable<JsonNode> findReferenceNodes(JsonNode tree) {
        return Iterables.filter(treeWalk(tree), refNodeFilter);
    }

    private Iterable<JsonNode> treeWalk(JsonNode tree) {
        final ArrayDeque<JsonNode> toVisit = Queues.newArrayDeque();
        toVisit.add(tree);
        return new Iterable<JsonNode>() {
            @Override
            public Iterator<JsonNode> iterator() {
                return new Iterator<JsonNode>() {
                    @Override
                    public boolean hasNext() {
                        return !toVisit.isEmpty();
                    }

                    @Override
                    public JsonNode next() {
                        if (hasNext()) {
                            JsonNode next = toVisit.remove();
                            queueChildren(next);
                            return next;
                        } else {
                            throw new NoSuchElementException();
                        }
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    private void queueChildren(JsonNode node) {
                        if (node.isArray()) {
                            for (Iterator<JsonNode> iter = node.elements(); iter.hasNext();) {
                                toVisit.addFirst(iter.next());
                            }
                        } else if (node.isObject()) {
                            for (Iterator<Entry<String, JsonNode>> iter = node.fields(); iter.hasNext();) {
                                toVisit.addFirst(iter.next().getValue());
                            }
                        }
                    }
                };
            }
        };
    }
}
