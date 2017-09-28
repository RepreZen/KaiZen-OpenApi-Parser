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
import java.util.regex.Pattern;

import org.apache.commons.lang3.tuple.Pair;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;

public abstract class ObjectOverlay<VI, V extends IObjectOverlay<VI>> extends JsonOverlay<VI> {

	private PropertyAccessors accessors = new PropertyAccessors();

	protected ObjectOverlay(String key, JsonNode json, JsonOverlay<?> parent, ReferenceRegistry referenceRegistry) {
		super(key, json, parent, referenceRegistry);
		installPropertyAccessors(this.accessors);
	}

	public ObjectOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
		super(key, json, parent);
		installPropertyAccessors(this.accessors);
	}

	public ObjectOverlay(String key, JsonOverlay<?> parent) {
		this(key, parent.getJson(key), parent);
	}

	@Override
	public boolean isPresent() {
		return super.isPresent() && getJson().isObject();
	}

	public JsonNode _createJson(boolean followRefs) {
		ObjectNode obj = JsonNodeFactory.instance.objectNode();
		List<PropertyAccessor> accessorList = this.accessors.getPropertyAccessors();
		for (PropertyAccessor accessor : accessorList) {
			JsonOverlay<?> value = accessor.get();
			if (value != null && value.isPresent()) {
				JsonPointer path = accessor.getPath();
				JsonNode json = value.createJson(followRefs);
				boolean merge = accessor.getKeyPattern() != null;
				// how to handle property accessors with empty parent path:
				// * an object property that has a key pattern has its values merged into an
				//// accumulating object; typically there will be other such accessors, and/or
				//// other accessors with a non-empty parent path, and the accumulation is the
				//// final created JSON value
				// * any other value (not an object, or an object without a key pattern) is
				//// returned as the overall created JSON value, all by itself. It is an error
				//// for there to be ANY other accessor in this case
				if (path.matches()) {
					if (json.isObject() && merge) {
						obj.setAll((ObjectNode) json);
					} else {
						if (accessorList.size() > 1) {
							throw new IllegalStateException(
									"Whole-value property accessor may not coexist with other accessors");
						}
						return json;
					}
				} else {
					addValueAtPath(obj, json, path, merge);
				}
			}
		}
		return obj.size() > 0 ? obj : MissingNode.getInstance();
	}

	private void addValueAtPath(ObjectNode obj, JsonNode value, JsonPointer path, boolean merge) {
		String key = path.getMatchingProperty();
		if (!obj.has(key)) {
			obj.putObject(key);
		}
		if (path.tail().matches()) {
			if (merge && value.isObject()) {
				((ObjectNode) obj.get(key)).setAll((ObjectNode) value);
			} else {
				obj.set(key, value);
			}
		} else {
			addValueAtPath((ObjectNode) obj.get(key), value, path.tail(), merge);
		}
	}

	@Override
	public VI fromJson() {
		// this is never needed - the constructor of any class derived from
		// ObjectOverlay is expected to consume its JSON object explicitly, so by the
		// time this is called, this overlay already houses any JSON provided at time fo
		// instantiation
		@SuppressWarnings("unchecked")
		VI result = (VI) this;
		return result;
	}

	@Override
	public void set(VI value) {
		super.set(value);
		invalidate();
	}

	protected static <T extends ObjectOverlay<?, ?>> boolean isEmptyRecursive(JsonOverlay<?> obj, Class<T> cls) {
		while (obj != null) {
			if (obj.isPresent()) {
				return false;
			} else if (obj.getClass().equals(cls)) {
				return true;
			}
			obj = (JsonOverlay<?>) obj.getParent();
		}
		return false;
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
