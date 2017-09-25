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

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;

public class ValMapOverlay<V, OV extends JsonOverlay<V>> extends JsonOverlay<Map<String, V>>
		implements CollectionOverlay<OV> {
	private JsonOverlayFactory<OV> factory;
	private final CollectionStore<OV> store = new CollectionStore<OV>(this);
	private Map<String, V> values = Maps.newLinkedHashMap();

	private ValMapOverlay(String key, JsonOverlayFactory<OV> factory, JsonOverlay<?> parent) {
		super(key, (Map<String, V>) null, parent);
		this.factory = factory;
	}

	public ValMapOverlay(String key, Map<String, V> valueMap, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory,
			String keyPat) {
		this(key, factory, parent);
		store.init(false, keyPat).load(CollectionData.of(valueMap, factory));
		reset();
	}

	public ValMapOverlay(String key, JsonNode json, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory,
			String keyPat) {
		this(key, factory, parent);
		store.init(false, keyPat).load(CollectionData.of(json, parent, factory));
		reset();
	}

	public ValMapOverlay(String key, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory, String keyPat) {
		this(key, factory, parent);
		store.init(false, keyPat).load(CollectionData.of(parent.getResolvedJson(key), parent, factory));
		reset();
	}

	private void reset() {
		super.set(getFromStore());
	}

	@Override
	public boolean isMissing() {
		return super.isMissing() || !getJson().isObject();
	}

	private Map<String, V> getFromStore() {
		values.clear();
		for (Entry<String, OV> entry : store.getOverlayMap().entrySet()) {
			values.put(entry.getKey(), entry.getValue().get());
		}
		return values;
	}

	public Map<String, OV> getOverlayMap() {
		return store.getOverlayMap();
	}

	public Collection<OV> getOverlays() {
		return store.getOverlays();
	}

	public Collection<V> getValues() {
		return values.values();
	}

	public V get(String key) {
		return values.get(key);
	}

	public boolean containsKey(String key) {
		return values.containsKey(key);
	}

	@Override
	public void set(Map<String, V> valueMap) {
		store.clear();
		for (Entry<String, V> entry : valueMap.entrySet()) {
			store.add(entry.getKey(), createOverlay(entry.getValue()));
		}
		reset();
		invalidate();
	}

	public void set(String key, V value) {
		OV overlay = createOverlay(value);
		if (containsKey(key)) {
			store.replace(key, overlay);
		} else {
			store.add(key, overlay);
		}
		invalidate();
	}

	public void set(Collection<OV> overlays) {
		store.set(overlays);
		reset();
		invalidate();
	}

	@Override
	public JsonOverlay<?> find(JsonPointer path) {
		if (path.matches()) {
			return this;
		} else if (path.mayMatchProperty()) {
			String key = path.getMatchingProperty();
			return containsKey(key) ? store.getOverlay(key).find(path.tail()) : null;
		} else {
			return null;
		}
	}

	public void clear() {
		store.clear();
		reset();
		invalidate();
	}

	public int size() {
		return store.size();
	}

	@Override
	public Map<String, V> fromJson() {
		return values != null ? values : Collections.<String, V>emptyMap();
	}

	@Override
	public JsonNode _createJson() {
		return store.createJson();
	}

	public void add(String key, V value) {
		store.add(key, createOverlay(value));
		reset();
		invalidate();
	}

	public void remove(String key) {
		store.remove(key);
		reset();
		invalidate();
	}

	public void remove(int index) {
		store.remove(index);
		reset();
		invalidate();
	}

	public void replace(String key, V value) {
		store.replace(key, createOverlay(value));
		reset();
		invalidate();
	}

	public void replace(int index, V value) {
		store.replace(index, factory.create(null, value, parent));
		reset();
		invalidate();
	}

	private OV createOverlay(V value) {
		return factory.create(null, value, this);
	}

	@Override
	public CollectionStore<OV> getStore() {
		return store;
	}
}
