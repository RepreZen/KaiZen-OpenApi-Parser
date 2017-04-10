/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.jsonoverlay;

import java.util.Collections;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Optional;

public abstract class JsonOverlay<V> {

    protected final static JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
    protected final static ObjectMapper mapper = new ObjectMapper();

    protected String key;
    private JsonNode json; // need to prevent subclasses from direct access due to reference management
    private JsonNode resolvedJson = null;
    protected JsonOverlay<?> parent;
    protected JsonOverlay<?> root;
    protected Reference ref = null;
    protected V value;

    public JsonOverlay(String key, V value, JsonOverlay<?> parent) {
        this(key, Optional.fromNullable(value), Optional.<JsonNode> absent(), parent);
    }

    public JsonOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
        this(key, Optional.<V> absent(), Optional.fromNullable(json), parent);
    }

    public JsonOverlay(String key, JsonOverlay<?> parent) {
        this(key, Optional.<V> absent(), Optional.<JsonNode> absent(), parent);
    }

    private JsonOverlay(String key, Optional<V> value, Optional<JsonNode> json, JsonOverlay<?> parent) {
        this.key = key;
        this.parent = parent;
        if (parent == null) {
            root = this;
        } else {
            root = parent.getRoot();
        }
        if (json.isPresent()) {
            this.json = json.get();
            processReference();
            this.value = fromJson();
        } else if (value.isPresent()) {
            this.value = value.get();
            this.json = toJson();
        } else if (parent != null) {
            this.json = parent.getJson(key);
            processReference();
            this.value = fromJson();
        } else {
            this.json = MissingNode.getInstance();
            this.value = null;
        }
    }

    public V get() {
        return value;
    }

    public void set(V value) {
        this.value = value;
    }

    public JsonNode getJson() {
        if (ref != null) {
            return resolvedJson;
        } else {
            return json;
        }
    }

    public JsonNode getJson(String key) {
        JsonNode json = getJson();
        if (key.isEmpty()) {
            return json;
        } else if (key.indexOf('/') < 0) {
            return json.path(key);
        } else {
            return json.at("/" + key);
        }
    }

    public JsonNode getResolvedJson(String key) {
        JsonNode json = getJson(key);
        if (isReferenceNode(json)) {
            return Reference.get(json.get("key").asText()).getJson();
        } else {
            return json;
        }
    }

    public JsonNode getOriginalJson() {
        return json;
    }

    public abstract V fromJson();

    public abstract JsonNode toJson();

    protected Iterable<? extends JsonOverlay<?>> getChildren() {
        return Collections.emptyList();
    }

    protected void processReference() {
        if (isReferenceNode()) {
            ref = Reference.get(json.get("key").asText());
            resolvedJson = ref.getJson();
        }
    }

    protected boolean isReferenceNode() {
        return isReferenceNode(json);
    }

    protected boolean isReferenceNode(JsonNode json) {
        // If the $ref property isn't a string, that's an issue for validation.
        return json instanceof ObjectNode && json.has("$ref");
    }

    public boolean isReference() {
        return ref != null;
    }

    public Reference getReference() {
        return ref;
    }

    public JsonOverlay<?> getParentOverlay() {
        return parent;
    }

    public JsonOverlay<?> getRoot() {
        return root != null ? root : this;
    }

    public String getKey() {
        return key;
    }

    public void reparent(JsonOverlay<?> parent, String key) {
        this.parent = parent;
        this.root = parent.root;
        this.key = key;
    }

    public void deparent() {
        this.parent = null;
        this.root = null;
        this.key = null;
    }

    public boolean isMissing() {
        return json.isMissingNode();
    }

    public static <T> Iterable<T> iterable(final Iterator<T> iterator) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return iterator;
            }
        };
    }
}