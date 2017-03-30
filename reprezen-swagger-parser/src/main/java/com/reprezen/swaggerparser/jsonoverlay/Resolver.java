package com.reprezen.swaggerparser.jsonoverlay;

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

    private static Set<ResolutionBase> resolvedBases = Sets.newHashSet();

    public static void preresolve(String... baseUrls) {
        for (String url : baseUrls) {
            preresolve(ResolutionBase.of(url, true));
        }
    }

    public static void preresolve(URL... baseUrls) {
        for (URL url : baseUrls) {
            preresolve(ResolutionBase.of(url, true));
        }
    }

    public static void preresolve(ResolutionBase base) {
        Queue<ResolutionBase> toResolve = Queues.newArrayDeque();
        toResolve.add(base);
        while (!toResolve.isEmpty()) {
            toResolve.addAll(preresolveBase(toResolve.remove()));
        }
    }

    private static Collection<ResolutionBase> preresolveBase(ResolutionBase base) {
        List<ResolutionBase> discoveredBases = Lists.newArrayList();
        if (!resolvedBases.contains(base)) {
            resolvedBases.add(base);
            if (base.isValid()) {
                for (JsonNode refNode : findReferenceNodes(base.getJson())) {
                    JsonNode refString = refNode.get("$ref");
                    String key = Reference.register(refString, base, true);
                    ((ObjectNode) refNode).put("key", key);
                    Reference ref = Reference.get(key);
                    if (ref.isValid() && !resolvedBases.contains(ref.getBase())) {
                        discoveredBases.add(ref.getBase());
                    }
                }
            }
        }
        return discoveredBases;
    }

    private final static Predicate<JsonNode> refNodeFilter = new Predicate<JsonNode>() {
        @Override
        public boolean apply(JsonNode node) {
            // accepting nodes with non-text $ref properties will mean we'll get Reference objects marked as invalid, as
            // desired
            return node.isObject() && node.has("$ref");
        }
    };

    private static Iterable<JsonNode> findReferenceNodes(JsonNode tree) {
        return Iterables.filter(treeWalk(tree), refNodeFilter);
    }

    private static Iterable<JsonNode> treeWalk(JsonNode tree) {
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
