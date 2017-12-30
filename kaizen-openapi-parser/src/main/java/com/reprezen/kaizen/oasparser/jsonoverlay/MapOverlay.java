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

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import com.reprezen.kaizen.oasparser.jsonoverlay.SerializationOptions.Option;

public class MapOverlay<V, OV extends JsonOverlay<V>> extends JsonOverlay<Map<String, V>> {
	private Map<String, IJsonOverlay<V>> overlays = Maps.newLinkedHashMap();
	private OverlayFactory<V, OV> valueFactory;
	private Pattern keyPattern;

	public MapOverlay(Map<String, V> value, JsonOverlay<?> parent, OverlayFactory<V, OV> valueFactory,
			Pattern keyPattern, ReferenceRegistry refReg) {
		super(value, parent, refReg);
		this.valueFactory = valueFactory;
		this.keyPattern = keyPattern;
		fillWithValues();
	}

	public MapOverlay(JsonNode json, JsonOverlay<?> parent, OverlayFactory<V, OV> valueFactory, Pattern keyPattern,
			ReferenceRegistry refReg) {
		super(json, parent, refReg);
		this.valueFactory = valueFactory;
		this.keyPattern = keyPattern;
		fillWithJson();
	}

	private void fillWithValues() {
		overlays.clear();
		if (value != null) {
			for (Entry<String, V> entry : value.entrySet()) {
				overlays.put(entry.getKey(),
						new ChildOverlay<>(entry.getKey(), entry.getValue(), this, valueFactory, refReg));
			}
		}
	}

	private void fillWithJson() {
		value.clear();
		overlays.clear();
		for (Entry<String, JsonNode> field : iterable(json.fields())) {
			String key = field.getKey();
			if (keyPattern == null || keyPattern.matcher(key).matches()) {
				ChildOverlay<V, OV> overlay = new ChildOverlay<V, OV>(key, json.get(key), this, valueFactory, refReg);
				overlay.getOverlay().setPathInParent(key);
				overlays.put(key, overlay);
				value.put(key, overlay.get(false));
			}
		}
	}

	@Override
	public Map<String, V> get(boolean elaborate) {
		return value;
	}

	@Override
	public IJsonOverlay<?> _find(JsonPointer path) {
		String key = path.getMatchingProperty();
		return overlays.containsKey(key) ? overlays.get(key).find(path.tail()) : null;
	}

	@Override
	protected Map<String, V> fromJson(JsonNode json) {
		return Maps.newHashMap();
	}

	@Override
	public JsonNode toJson(SerializationOptions options) {
		ObjectNode obj = jsonObject();
		for (Entry<String, IJsonOverlay<V>> entry : overlays.entrySet()) {
			obj.set(entry.getKey(), entry.getValue().toJson(options.plus(Option.KEEP_ONE_EMPTY)));
		}
		return obj.size() > 0 || options.isKeepThisEmpty() ? obj : jsonMissing();
	}

	public boolean containsKey(String name) {
		return overlays.containsKey(name);
	}

	public V get(String name) {
		IJsonOverlay<V> overlay = overlays.get(name);
		return overlay != null ? overlay.get() : null;
	}

	protected IJsonOverlay<V> getOverlay(String name) {
		return overlays.get(name);
	}
	
	public void set(String name, V value) {
		overlays.put(name, valueFactory.create(value, this, refReg, null));
	}

	public void remove(String name) {
		overlays.remove(name);
	}

	public int size() {
		return overlays.size();
	}

	public Pattern getKeyPattern() {
		return keyPattern;
	}

	public boolean isReference(String key) {
		@SuppressWarnings("unchecked")
		ChildOverlay<V, OV> childOverlay = (ChildOverlay<V, OV>) overlays.get(key);
		return childOverlay.isReference();
	}
	
	public Reference getReference(String key) {
		@SuppressWarnings("unchecked")
		ChildOverlay<V, OV> childOverlay = (ChildOverlay<V, OV>) overlays.get(key);
		return childOverlay.getReference();
	}

	public static <V, OV extends JsonOverlay<V>> OverlayFactory<Map<String, V>, MapOverlay<V, OV>> getFactory(
			OverlayFactory<V, OV> valueFactory, String keyPattern) {
		return new MapOverlayFactory<V, OV>(valueFactory, getWholeMatchPattern(keyPattern));
	}

	private static Pattern getWholeMatchPattern(String pat) {
		return pat != null ? Pattern.compile("^" + pat + "$") : null;
	}

	protected static class MapOverlayFactory<V, OV extends JsonOverlay<V>>
			extends OverlayFactory<Map<String, V>, MapOverlay<V, OV>> {

		private OverlayFactory<V, OV> valueFactory;
		private Pattern keyPattern;

		public MapOverlayFactory(OverlayFactory<V, OV> valueFactory, Pattern keyPattern) {
			this.valueFactory = valueFactory;
			this.keyPattern = keyPattern;
		}

		public Pattern getKeyPattern() {
			return keyPattern;
		}

		@Override
		protected Class<? super MapOverlay<V, OV>> getOverlayClass() {
			return MapOverlay.class;
		}

		@Override
		public MapOverlay<V, OV> _create(Map<String, V> value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			return new MapOverlay<V, OV>(value, parent, valueFactory, keyPattern, refReg);
		}

		@Override
		public MapOverlay<V, OV> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			return new MapOverlay<V, OV>(json, parent, valueFactory, keyPattern, refReg);
		}
	}
}
