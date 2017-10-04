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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class ListOverlay<V, OV extends JsonOverlay<V>> extends JsonOverlay<Collection<V>> {

	private OverlayFactory<V, OV> itemFactory;
	private List<IJsonOverlay<V>> overlays = Lists.newLinkedList();

	public ListOverlay(Collection<V> value, OverlayFactory<V, OV> itemFactory, ReferenceRegistry refReg) {
		super(value, refReg);
		this.itemFactory = itemFactory;
		for (V item : value) {
			overlays.add(itemFactory.create(item, refReg));
		}
	}

	public ListOverlay(JsonNode json, OverlayFactory<V, OV> itemFactory, ReferenceRegistry refReg) {
		super(json, refReg);
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
			overlays.add(new ChildOverlay<V, OV>(null, element, itemFactory, refReg));
		}
		set(getItems());
	}

	@Override
	public JsonNode toJson() {
		ArrayNode array = jsonArray();
		for (IJsonOverlay<V> overlay : overlays) {
			array.add(overlay.toJson());
		}
		return array;
	}

	public V get(int index) {
		IJsonOverlay<V> overlay = overlays.get(index);
		return overlay != null ? overlay.get() : null;
	}

	public void set(int index, V value) {
		overlays.set(index, itemFactory.create(value, refReg));
	}

	public void add(V value) {
		overlays.add(itemFactory.create(value, refReg));
	}

	public void insert(int index, V value) {
		overlays.add(index, itemFactory.create(value, refReg));
	}

	public void remove(int index) {
		overlays.remove(index);
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
		public ListOverlay<V, OV> _create(Collection<V> value, ReferenceRegistry refReg) {
			return new ListOverlay<V, OV>(value, itemFactory, refReg);
		}

		@Override
		public ListOverlay<V, OV> _create(JsonNode json, ReferenceRegistry refReg) {
			return new ListOverlay<V, OV>(json, itemFactory, refReg);
		}
	}
}
