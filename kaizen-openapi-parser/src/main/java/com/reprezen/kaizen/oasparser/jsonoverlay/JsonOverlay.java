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

import java.util.Iterator;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Optional;

public abstract class JsonOverlay<V> implements IJsonOverlay<V> {

	protected final static JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
	protected final static ObjectMapper mapper = new ObjectMapper();

	private final ReferenceRegistry referenceRegistry;

	protected String key;
	private JsonNode json; // need to prevent subclasses from direct access due to reference management
	private JsonNode resolvedJson = null;
	protected JsonOverlay<?> parent;
	protected JsonOverlay<?> root;
	protected Reference ref = null;
	protected V value;
	protected boolean jsonIsCurrent;

	public JsonOverlay(String key, V value, JsonOverlay<?> parent) {
		this(key, Optional.fromNullable(value), Optional.<JsonNode>absent(), parent);
	}

	public JsonOverlay(String key, JsonNode json, JsonOverlay<?> parent, ReferenceRegistry referenceRegistry) {
		this(key, Optional.<V>absent(), Optional.fromNullable(json), parent, referenceRegistry);
	}

	public JsonOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
		this(key, Optional.<V>absent(), Optional.fromNullable(json), parent);
	}

	public JsonOverlay(String key, JsonOverlay<?> parent) {
		this(key, Optional.<V>absent(), Optional.<JsonNode>absent(), parent);
	}

	private JsonOverlay(String key, Optional<V> value, Optional<JsonNode> json, JsonOverlay<?> parent) {
		this(key, value, json, parent, parent == null ? new ReferenceRegistry() : parent.referenceRegistry);
	}

	private JsonOverlay(String key, Optional<V> value, Optional<JsonNode> json, JsonOverlay<?> parent,
			ReferenceRegistry referenceRegistry) {
		this.key = key;
		this.parent = parent;
		this.referenceRegistry = referenceRegistry;
		if (parent == null) {
			root = this;
		} else {
			root = (JsonOverlay<?>) parent.getRoot();
		}
		if (json.isPresent()) {
			this.json = json.get();
			processReference();
			this.value = fromJson();
			this.jsonIsCurrent = true;
		} else if (value.isPresent()) {
			this.value = value.get();
			this.jsonIsCurrent = false;
			this.json = toJson();
		} else if (parent != null) {
			this.json = parent.getJson(key);
			this.jsonIsCurrent = true;
			processReference();
			this.value = fromJson();
		} else {
			this.json = MissingNode.getInstance();
			this.jsonIsCurrent = true;
			this.value = null;
		}
	}

	@Override
	public V get() {
		return value;
	}

	@Override
	public IJsonOverlay<?> find(JsonPointer path) {
		// this implementation suffices for primitive types, but must be overriden in
		// overlays designed for JSON arrays or objects
		return isPresent() //
				? (path.matches() ? this : null) //
				: null;
	}

	@Override
	public IJsonOverlay<?> find(String path) {
		return find(JsonPointer.compile(path));
	}

	public void set(V value) {
		this.value = value;
		invalidate();
		if (parent != null) {
			parent.addToSerialization(key);
		}
	}

	protected void invalidate() {
		this.jsonIsCurrent = false;
		if (parent != null) {
			parent.invalidate();
		}
	}

	protected JsonNode getJson() {
		if (ref != null) {
			return resolvedJson;
		} else {
			return json;
		}
	}

	protected JsonNode getJson(String key) {
		JsonNode json = getJson();
		if (key.isEmpty()) {
			return json;
		} else if (key.indexOf('/') < 0) {
			return json.path(key);
		} else {
			return json.at("/" + key);
		}
	}

	protected JsonNode getResolvedJson(String key) {
		JsonNode json = getJson(key);
		if (isReferenceNode(json)) {
			return referenceRegistry.get(json.get("key").asText()).getJson();
		} else {
			return json;
		}
	}

	protected JsonNode getOriginalJson() {
		return json;
	}

	protected abstract V fromJson();

	@Override
	public JsonNode toJson() {
		return toJson(false);
	}

	@Override
	public JsonNode toJson(boolean followRefs) {
		if (jsonIsCurrent && !followRefs) {
			return getJson();
		} else {
			JsonNode result = createJson(followRefs);
			if (!followRefs) {
				this.json = result;
				this.jsonIsCurrent = true;
			}
			return result;
		}
	}

	@Override
	public JsonNode createJson() {
		return createJson(false);
	}

	@Override
	public JsonNode createJson(boolean followRefs) {
		if (isReference() && !followRefs) {
			ObjectNode obj = JsonNodeFactory.instance.objectNode();
			obj.put("$ref", json.get("$ref").asText());
			return obj;
		} else {
			return _createJson(followRefs);
		}
	}

	protected abstract JsonNode _createJson(boolean followRefs);

	protected void addToSerialization(String key) {
		// no-op except for ObjectOverlay
	}

	protected void processReference() {
		if (isReferenceNode()) {
			ref = referenceRegistry.get(json.get("key").asText());
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

	@Override
	public boolean isReference() {
		return ref != null;
	}

	@Override
	public Reference getReference() {
		return ref;
	}

	@Override
	public IJsonOverlay<?> getParent() {
		return parent;
	}

	@Override
	public IJsonOverlay<?> getRoot() {
		return root != null ? root : this;
	}

	@Override
	public String getKey() {
		return key;
	}

	protected void reparent(JsonOverlay<?> parent, String key) {
		this.parent = parent;
		this.root = parent.root;
		this.key = key;
	}

	protected void deparent() {
		this.parent = null;
		this.root = null;
		this.key = null;
	}

	@Override
	public boolean isPresent() {
		if (!jsonIsCurrent) {
			this.json = createJson();
		}
		return !json.isMissingNode();
	}

	public static final <T> Iterable<T> iterable(final Iterator<T> iterator) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return iterator;
			}
		};
	}
}