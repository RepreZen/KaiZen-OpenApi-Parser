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

import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonPath {

	private final JsonPointer path;
	private final int pathLen;

	public JsonPath(String path) {
		boolean emptyPath = path == null || path.isEmpty();
		this.path = JsonPointer.compile(emptyPath ? "" : "/" + path);
		this.pathLen = emptyPath ? 0 : path.split("/").length;
	}

	protected boolean matchesPath(JsonPointer testPath) {
		JsonPointer ourPath = this.path;
		while (!ourPath.matches()) {
			if (!testPath.matchesProperty(ourPath.getMatchingProperty())) {
				return false;
			} else {
				ourPath = ourPath.tail();
				testPath = testPath.tail();
			}
		}
		return true;
	}

	protected JsonPointer tailPath(JsonPointer path) {
		for (int i = 0; i < pathLen; i++) {
			path = path.tail();
		}
		return path;
	}

	public JsonNode setInPath(JsonNode container, JsonNode value) {
		if (this.path.matches()) {
			if (container.isMissingNode()) {
				return value;
			} else if (canMerge(container, value, null)) {
				return merge(container, value, null);
			} else if (canAdd(container, value)) {
				return add(container, value);
			} else {
				throw badStructure();
			}
		} else if (container.isObject() || container.isMissingNode()) {
			container = container.isMissingNode() ? JsonOverlay.jsonObject() : container;
			setInPath((ObjectNode) container, this.path, value);
			return container;
		} else {
			throw badStructure();
		}
	}

	private void setInPath(ObjectNode obj, JsonPointer path, JsonNode value) {
		String key = path.getMatchingProperty();
		path = path.tail();
		if (path.matches()) {
			if (!obj.has(key)) {
				obj.set(key, value);
			} else if (canMerge(obj, value, key)) {
				merge(obj, value, key);
			} else if (canAdd(obj, value)) {
				add(obj, value);
			} else {
				throw badStructure();
			}
		} else {
			obj = obj.has(key) ? (ObjectNode) obj.get(key) : obj.putObject(key);
			setInPath(obj, path, value);
		}
	}

	private boolean canMerge(JsonNode container, JsonNode value, String key) {
		if (!container.isObject() && !container.isMissingNode()) {
			return false;
		}
		ObjectNode obj = container.isMissingNode() ? JsonOverlay.jsonObject() : (ObjectNode) container;
		if (key != null && obj.has(key) && !obj.get(key).isObject()) {
			return false;
		}
		if (!value.isObject() || value.isMissingNode()) {
			return false;
		}
		return true;
	}

	private JsonNode merge(JsonNode container, JsonNode value, String key) {
		ObjectNode into = container.isMissingNode() ? JsonOverlay.jsonObject() : (ObjectNode) container;
		ObjectNode result = into;
		if (key != null) {
			into = into.has(key) ? (ObjectNode) into.get(key) : into.putObject(key);
		}
		if (!value.isMissingNode()) {
			ObjectNode from = (ObjectNode) value;
			for (Entry<String, JsonNode> field : JsonOverlay.iterable(from.fields())) {
				into.set(field.getKey(), field.getValue());
			}
		}
		return result;
	}

	private boolean canAdd(JsonNode container, JsonNode value) {
		return container.isArray();
	}

	private JsonNode add(JsonNode container, JsonNode value) {
		((ArrayNode) container).add(value);
		return container;
	}

	private IllegalStateException badStructure() {
		return new IllegalStateException("Value is incompatible with existing JSON structure");
	}

	@Override
	public String toString() {
		return path.matches() ? "*" : path.toString();
	}
}
