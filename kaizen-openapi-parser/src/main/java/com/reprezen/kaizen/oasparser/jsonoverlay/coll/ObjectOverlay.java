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
package com.reprezen.kaizen.oasparser.jsonoverlay.coll;

import java.util.regex.Pattern;

import org.apache.commons.lang3.tuple.Pair;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;

public abstract class ObjectOverlay<OO extends ObjectOverlay<OO>> extends JsonOverlay<OO> {

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
	public boolean isMissing() {
		return super.isMissing() || !getJson().isObject();
	}

	public JsonNode createJson() {
		return getJson(); // TODO Fix this
	}

	@Override
	public OO fromJson() {
		// this is never needed - the constructor of any class derived from
		// ObjectOverlay is expected to consume its JSON object explicitly, so by the
		// time this is called, this overlay already houses any JSON provided at time fo
		// instantiation
		@SuppressWarnings("unchecked")
		OO result = (OO) this;
		return result;
	}

	@Override
	public void set(OO value) {
		super.set(value);
		invalidate();
	}

	protected static <T extends ObjectOverlay<?>> boolean isEmptyRecursive(JsonOverlay<?> obj, Class<T> cls) {
		while (obj != null) {
			if (!obj.isMissing()) {
				return false;
			} else if (obj.getClass().equals(cls)) {
				return true;
			}
			obj = obj.getParentOverlay();
		}
		return false;
	}

	protected abstract void installPropertyAccessors(PropertyAccessors accessors);
	
	@Override
	public JsonOverlay<?> find(JsonPointer path) {
		if (path.matches()) {
			return this;
		} else {
			Pair<OverlayGetter, JsonPointer> result = accessors.find(path);
			if (result.getLeft() != null) {
				return result.getLeft().get().find(result.getRight());
			} else {
				return null;
			}
		}
	}

	protected static class PropertyAccessors {
		private JsonPointerTrie<OverlayGetter> accessorsTrie = new JsonPointerTrie<>();

		public void add(String path, String keyPattern, OverlayGetter getter) {
			Pattern pattern = keyPattern != null ? Pattern.compile("^" + keyPattern + "$") : null;
			accessorsTrie.add(JsonPointer.compile(path.isEmpty() ? "" : "/" + path), pattern, getter);
		}
		
		public Pair<OverlayGetter, JsonPointer> find(JsonPointer path) {
			return accessorsTrie.find(path);
		}
	}
	
	protected interface OverlayGetter {
		public JsonOverlay<?> get();
	}
}
