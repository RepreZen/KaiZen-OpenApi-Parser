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
import java.util.List;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class ListOverlay<V, OV extends JsonOverlay<V>> extends JsonOverlay<Collection<V>> {

	private OverlayFactory<V, OV> itemFactory;
	private List<IJsonOverlay<V>> overlays = Lists.newLinkedList();

	public ListOverlay(Collection<V> value, JsonOverlay<?> parent, OverlayFactory<V, OV> itemFactory,
			ReferenceRegistry refReg) {
		super(value, parent, refReg);
		this.itemFactory = itemFactory;
		if (value != null) {
			for (V item : value) {
				overlays.add(itemFactory.create(item, this, refReg));
			}
		}
	}

	public ListOverlay(JsonNode json, JsonOverlay<?> parent, OverlayFactory<V, OV> itemFactory,
			ReferenceRegistry refReg) {
		super(json, parent, refReg);
		this.itemFactory = itemFactory;
		setupOverlays(json);
	}

	@Override
	protected Collection<V> fromJson(JsonNode json) {
		// can't do this now because it's called from super-constructor (JsonOverlay)
		// before our overlays member has been initialized, so we do it explicitly in
		// the json constructor
		return null;
	}

	private void setupOverlays(JsonNode json) {
		overlays.clear();
		for (JsonNode element : iterable(json.elements())) {
			overlays.add(new ChildOverlay<V, OV>(null, element, this, itemFactory, refReg));
		}
		set(getItems());
	}

	@Override
	public IJsonOverlay<?> _find(JsonPointer path) {
		int index = path.getMatchingIndex();
		return overlays.size() > index ? overlays.get(index).find(path.tail()) : null;
	}

	@Override
	public JsonNode toJson(boolean keepEmpty) {
		ArrayNode array = jsonArray();
		for (IJsonOverlay<V> overlay : overlays) {
			array.add(overlay.toJson(keepEmpty));
		}
		return array.size() > 0 || keepEmpty ? array : jsonMissing();
	}

	public V get(int index) {
		IJsonOverlay<V> overlay = overlays.get(index);
		return overlay != null ? overlay.get() : null;
	}

	public void set(int index, V value) {
		overlays.set(index, itemFactory.create(value, this, refReg));
	}

	public void add(V value) {
		overlays.add(itemFactory.create(value, this, refReg));
	}

	public void insert(int index, V value) {
		overlays.add(index, itemFactory.create(value, this, refReg));
	}

	public void remove(int index) {
		overlays.remove(index);
	}

	public int size() {
		return overlays.size();
	}

	private Function<IJsonOverlay<V>, V> itemGetter = new Function<IJsonOverlay<V>, V>() {
		@Override
		public V apply(IJsonOverlay<V> overlay) {
			return overlay.get();
		}
	};

	private Collection<V> getItems() {
		return Collections2.transform(overlays, itemGetter);
	}

	public static <V, OV extends JsonOverlay<V>> OverlayFactory<Collection<V>, ListOverlay<V, OV>> getFactory(
			OverlayFactory<V, OV> itemFactory) {
		return new ListOverlayFactory<V, OV>(itemFactory);
	}

	private static class ListOverlayFactory<V, OV extends JsonOverlay<V>>
			extends OverlayFactory<Collection<V>, ListOverlay<V, OV>> {

		private OverlayFactory<V, OV> itemFactory;

		public ListOverlayFactory(OverlayFactory<V, OV> itemFactory) {
			this.itemFactory = itemFactory;
		}

		@Override
		protected Class<? super ListOverlay<V, OV>> getOverlayClass() {
			return ListOverlay.class;
		}

		@Override
		public ListOverlay<V, OV> _create(Collection<V> value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			return new ListOverlay<V, OV>(value, parent, itemFactory, refReg);
		}

		@Override
		public ListOverlay<V, OV> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			return new ListOverlay<V, OV>(json, parent, itemFactory, refReg);
		}
	}
}
