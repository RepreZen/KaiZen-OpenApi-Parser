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
import com.google.common.base.Function;
import com.google.common.collect.Maps;

public class MapOverlay<V, OV extends JsonOverlay<V>> extends JsonOverlay<Map<String, V>> {
	private Map<String, IJsonOverlay<V>> overlays = Maps.newLinkedHashMap();
	private OverlayFactory<V, OV> valueFactory;
	private Pattern keyPattern;

	public MapOverlay(Map<String, V> value, JsonOverlay<?> parent, OverlayFactory<V, OV> valueFactory,
			Pattern keyPattern, ReferenceRegistry refReg) {
		super(value, parent, refReg);
		this.valueFactory = valueFactory;
		this.keyPattern = keyPattern;
		if (value != null) {
			for (Entry<String, V> entry : value.entrySet()) {
				overlays.put(entry.getKey(),
						new ChildOverlay<V, OV>(entry.getKey(), entry.getValue(), this, valueFactory, refReg));
			}
		}
	}

	public MapOverlay(JsonNode json, JsonOverlay<?> parent, OverlayFactory<V, OV> valueFactory, Pattern keyPattern,
			ReferenceRegistry refReg) {
		super(json, parent, refReg);
		this.valueFactory = valueFactory;
		this.keyPattern = keyPattern;
		setupOverlays(json);
	}

	@Override
	public IJsonOverlay<?> _find(JsonPointer path) {
		String key = path.getMatchingProperty();
		return overlays.containsKey(key) ? overlays.get(key).find(path.tail()) : null;
	}

	@Override
	protected Map<String, V> fromJson(JsonNode json) {
		// can't do this since the call from JsonOverlay constructor happens before our
		// overlays member has been initialized, so we explicitly call it from the json
		// constructor
		return null;
	}

	private void setupOverlays(JsonNode json) {
		overlays.clear();
		for (Entry<String, JsonNode> field : iterable(json.fields())) {
			if (keyPattern == null || keyPattern.matcher(field.getKey()).matches()) {
				IJsonOverlay<V> child = new ChildOverlay<V, OV>(field.getKey(), field.getValue(), this, valueFactory,
						refReg);
				overlays.put(field.getKey(), child);
			}
		}
		set(getValueMap());
	}

	@Override
	public JsonNode toJson(boolean keepEmpty) {
		ObjectNode obj = jsonObject();
		for (Entry<String, IJsonOverlay<V>> entry : overlays.entrySet()) {
			obj.set(entry.getKey(), entry.getValue().toJson(true));
		}
		return obj.size() > 0 || keepEmpty ? obj : jsonMissing();
	}

	public boolean containsKey(String name) {
		return overlays.containsKey(name);
	}

	public V get(String name) {
		IJsonOverlay<V> overlay = overlays.get(name);
		return overlay != null ? overlay.get() : null;
	}

	public void set(String name, V value) {
		overlays.put(name, valueFactory.create(value, this, refReg));
	}

	public void remove(String name) {
		overlays.remove(name);
	}

	public int size() {
		return overlays.size();
	}

	private Function<IJsonOverlay<V>, V> valueFunction = new Function<IJsonOverlay<V>, V>() {
		@Override
		public V apply(IJsonOverlay<V> overlay) {
			return overlay.get();
		}
	};

	private Map<String, V> getValueMap() {
		return Maps.transformValues(overlays, valueFunction);
	}

	public Pattern getKeyPattern() {
		return keyPattern;
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
