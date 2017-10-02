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

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;

public class ValListOverlay<V, OV extends JsonOverlay<V>> extends JsonOverlay<Collection<V>>
		implements CollectionOverlay<OV> {

	private JsonOverlayFactory<OV> factory;
	private final CollectionStore<OV> store = new CollectionStore<OV>(this);

	private Map<String, V> values = Maps.newLinkedHashMap();

	private ValListOverlay(String key, JsonOverlayFactory<OV> factory, JsonOverlay<?> parent) {
		// we'd normally put factory at the end for this constructor, but then it'd
		// clash with another
		super(key, (Collection<V>) null, parent);
		this.factory = factory;
	}

	public ValListOverlay(String key, Collection<V> values, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory) {
		this(key, factory, parent);
		store.init(true, null).load(CollectionData.<V, OV>of(values, factory));
		reset(false);
	}

	public ValListOverlay(String key, JsonNode json, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory) {
		this(key, factory, parent);
		store.init(true, null).load(CollectionData.of(json, parent, factory));
		reset(false);
	}

	public ValListOverlay(String key, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory) {
		this(key, factory, parent);
		store.init(true, null).load(CollectionData.of(parent.getResolvedJson(key), parent, factory));
		reset(false);
	}

	@Override
	public boolean isPresent() {
		return super.isPresent() && getJson().isArray();
	}

	private void reset(boolean invalidate) {
		values.clear();
		for (OV overlay : store.getOverlays()) {
			values.put(overlay.getKey(), overlay.get());
		}
		super.set(values.values(), invalidate);
	}

	public V get(int index) {
		return store.get(index).get();
	}

	public Collection<OV> getOverlays() {
		return store.getOverlays();
	}

	@Override
	public void set(Collection<V> values, boolean invalidate) {
		store.clear();
		for (V value : values) {
			store.add(createOverlay(value));
		}
		super.set(values, invalidate);
	}

	public void set(int index, V value) {
		store.replace(index, createOverlay(value));
		reset(true);
		invalidate();
	}

	@Override
	public IJsonOverlay<?> find(JsonPointer path) {
		if (path.matches()) {
			return this;
		} else if (path.mayMatchElement()) {
			int index = path.getMatchingIndex();
			return size() > index ? store.get(index).find(path.tail()) : null;
		} else {
			return null;
		}
	}

	public void clear() {
		if (store.size() > 0) {
			store.clear();
			reset(true);
		}
	}

	public int size() {
		return store.size();
	}

	@Override
	public Collection<V> fromJson() {
		return values != null ? values.values() : Collections.<V>emptyList();
	}

	@Override
	public JsonNode _createJson(boolean followRefs) {
		return store.createJson(followRefs);
	}

	public void add(V value) {
		store.add(createOverlay(value));
		reset(true);
	}

	public void add(String key, V value) {
		store.add(key, createOverlay(value));
		reset(true);
	}

	public void remove(String key) {
		store.remove(key);
		reset(true);
	}

	public void remove(int index) {
		store.remove(index);
		reset(true);
	}

	public void replace(String key, V value) {
		store.replace(key, createOverlay(value));
		reset(true);
	}

	private OV createOverlay(V value) {
		return factory.create(null, value, this);
	}

	@Override
	public CollectionStore<OV> getStore() {
		return store;
	}
}
