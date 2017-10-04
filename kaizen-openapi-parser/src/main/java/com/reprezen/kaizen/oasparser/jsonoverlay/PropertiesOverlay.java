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

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.tuple.Pair;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public abstract class PropertiesOverlay<V extends IPropertiesOverlay<V>> extends JsonOverlay<V> {

	protected Map<String, ChildOverlay<?, ?>> children = Maps.newLinkedHashMap();
	private PropertyAccessors accessors = new PropertyAccessors();

	@Override
	public JsonNode toJson() {
		ObjectNode obj = jsonObject();
		for (ChildOverlay<?, ?> child : children.values()) {
			child.getPath().setNode(obj, child.getOverlay().toJson());
		}
		return obj;
	}

	protected PropertiesOverlay(JsonNode json, ReferenceRegistry refReg) {
		super(json, refReg);
	}

	public PropertiesOverlay(String key, JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, refReg);
	}

	@Override
	public V fromJson(JsonNode json) {
		// this is never needed - the constructor of any class derived from
		// ObjectOverlay is expected to consume its JSON object explicitly, so by the
		// time this is called, this overlay already houses any JSON provided at time fo
		// instantiation
		@SuppressWarnings("unchecked")
		V result = (V) this;
		return result;
	}

	@Override
	public void set(V value) {
		super.set(value);
	}

	protected abstract void installPropertyAccessors(PropertyAccessors accessors);

	@Override
	public IJsonOverlay<?> find(JsonPointer path) {
		if (path.matches()) {
			return this;
		} else {
			Pair<PropertyAccessor, JsonPointer> result = accessors.find(path);
			if (result.getLeft() != null) {
				return result.getLeft().get().find(result.getRight());
			} else {
				return null;
			}
		}
	}

	protected static class PropertyAccessors {
		private JsonPointerTrie<PropertyAccessor> accessorsTrie = new JsonPointerTrie<>();
		private List<PropertyAccessor> accessors = Lists.newArrayList();

		public void add(String path, String keyPattern, OverlayGetter getter) {
			Pattern pattern = keyPattern != null ? Pattern.compile("^" + keyPattern + "$") : null;
			JsonPointer pointer = JsonPointer.compile(path.isEmpty() ? "" : "/" + path);
			PropertyAccessor accessor = new PropertyAccessor(pointer, pattern, getter);
			accessorsTrie.add(pointer, pattern, accessor);
			accessors.add(accessor);
		}

		public Pair<PropertyAccessor, JsonPointer> find(JsonPointer path) {
			return accessorsTrie.find(path);
		}

		public List<PropertyAccessor> getPropertyAccessors() {
			return accessors;
		}
	}

	protected static class PropertyAccessor {
		private JsonPointer path;
		private Pattern keyPattern;
		private OverlayGetter getter;

		public PropertyAccessor(JsonPointer path, Pattern keyPattern, OverlayGetter getter) {
			super();
			this.path = path;
			this.keyPattern = keyPattern;
			this.getter = getter;
		}

		public JsonPointer getPath() {
			return path;
		}

		public Pattern getKeyPattern() {
			return keyPattern;
		}

		public JsonOverlay<?> get() {
			return getter.get();
		}
	}

	protected interface OverlayGetter {
		public JsonOverlay<?> get();
	}
}
