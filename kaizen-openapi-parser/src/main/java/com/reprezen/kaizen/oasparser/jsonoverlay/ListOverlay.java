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
	private List<OV> overlays = Lists.newLinkedList();

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
	}

	@Override
	protected Collection<V> fromJson(JsonNode json) {
		overlays.clear();
		for (JsonNode element : iterable(json.elements())) {
			overlays.add(itemFactory.create(element, refReg));
		}
		return getItems();
	}

	@Override
	public JsonNode toJson() {
		ArrayNode array = jsonArray();
		for (OV overlay : overlays) {
			array.add(overlay.toJson());
		}
		return array;
	}

	private Function<OV, V> itemGetter = new Function<OV, V>() {
		@Override
		public V apply(OV overlay) {
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
