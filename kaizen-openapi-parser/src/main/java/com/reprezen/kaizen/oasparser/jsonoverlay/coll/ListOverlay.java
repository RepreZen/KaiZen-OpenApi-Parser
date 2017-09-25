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

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;

public class ListOverlay<OV extends JsonOverlay<?>> extends JsonOverlay<Collection<OV>>
		implements CollectionOverlay<OV> {

	private final CollectionStore<OV> store = new CollectionStore<OV>(this);

	private ListOverlay(String key, JsonOverlayFactory<OV> factory, JsonOverlay<?> parent) {
		super(key, (Collection<OV>) null, parent);
	}

	public ListOverlay(String key, Collection<OV> overlays, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory) {
		this(key, factory, parent);
		store.init(true, null).load(CollectionData.of(overlays));
		reset();
	}

	public ListOverlay(String key, JsonNode json, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory) {
		this(key, factory, parent);
		store.init(true, null).load(CollectionData.of(json, parent, factory));
		reset();
	}

	public ListOverlay(String key, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory) {
		this(key, factory, parent);
		store.init(true, null).load(CollectionData.of(parent.getResolvedJson(key), parent, factory));
		reset();
	}

	@Override
	public boolean isMissing() {
		return super.isMissing() || !getJson().isArray();
	}

	private void reset() {
		super.set(store.getOverlays());
	}

	@Override
	public Collection<OV> get() {
		return value;
	}

	public OV get(int index) {
		return store.get(index);
	}

	@Override
	public void set(Collection<OV> overlays) {
		store.set(overlays);
		reset();
		invalidate();
	}

	@Override
	public JsonOverlay<?> find(JsonPointer path) {
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
		store.clear();
		reset();
		invalidate();
	}

	public int size() {
		return store.size();
	}

	@Override
	public Collection<OV> fromJson() {
		return store != null ? store.getOverlays() : Collections.<OV>emptyList();
	}

	@Override
	public JsonNode _createJson(boolean followRefs) {
		return store.createJson(followRefs);
	}

	public void add(OV overlay) {
		store.add(overlay);
		reset();
		invalidate();
	}

	public void add(String key, OV overlay) {
		store.add(key, overlay);
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

	public void replace(String key, OV overlay) {
		store.replace(key, overlay);
		reset();
		invalidate();
	}

	public void set(int index, OV overlay) {
		store.replace(index, overlay);
		reset();
		invalidate();
	}

	@Override
	public CollectionStore<OV> getStore() {
		return store;
	}
}
