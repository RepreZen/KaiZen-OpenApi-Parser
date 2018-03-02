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
import com.google.common.collect.Lists;
import com.reprezen.kaizen.oasparser.jsonoverlay.SerializationOptions.Option;

public class ListOverlay<V> extends JsonOverlay<Collection<V>> {

    private OverlayFactory<V> itemFactory;
    private List<IJsonOverlay<V>> overlays = Lists.newLinkedList();

    public ListOverlay(Collection<V> value, JsonOverlay<?> parent, OverlayFactory<V> itemFactory,
            ReferenceRegistry refReg) {
        super(value, parent, refReg);
        this.itemFactory = itemFactory;
        fillWithValues();
    }

    public ListOverlay(JsonNode json, JsonOverlay<?> parent, OverlayFactory<V> itemFactory, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        this.itemFactory = itemFactory;
        fillWithJson();
    }

    private void fillWithValues() {
        overlays.clear();
        if (value != null) {
            for (V item : value) {
                overlays.add(new ChildOverlay<V>(null, item, this, itemFactory, refReg));
            }
        }
    }

    private void fillWithJson() {
        value.clear();
        overlays.clear();
        if (!json.isMissingNode()) {
            for (JsonNode itemJson : iterable(json.elements())) {
                ChildOverlay<V> overlay = new ChildOverlay<>(null, itemJson, this, itemFactory, refReg);
                overlays.add(overlay);
                value.add(overlay.get(false));
            }
        }
    }

    @Override
    public Collection<V> get(boolean elaborate) {
        return value;
    }

    @Override
    protected Collection<V> fromJson(JsonNode json) {
        return Lists.newArrayList();
    }

    @Override
    public IJsonOverlay<?> _find(JsonPointer path) {
        int index = path.getMatchingIndex();
        return overlays.size() > index ? overlays.get(index).find(path.tail()) : null;
    }

    @Override
    public JsonNode toJson(SerializationOptions options) {
        ArrayNode array = jsonArray();
        for (IJsonOverlay<V> overlay : overlays) {
            array.add(overlay.toJson(options.plus(Option.KEEP_ONE_EMPTY)));
        }
        return array.size() > 0 || options.isKeepThisEmpty() ? array : jsonMissing();
    }

    public V get(int index) {
        IJsonOverlay<V> overlay = overlays.get(index);
        return overlay != null ? overlay.get() : null;
    }

    public IJsonOverlay<V> getOverlay(int index) {
        return overlays.get(index);
    }

    public void set(int index, V value) {
        overlays.set(index, itemFactory.create(value, this, refReg, null));
    }

    public void add(V value) {
        overlays.add(itemFactory.create(value, this, refReg, null));
    }

    public void insert(int index, V value) {
        overlays.add(index, itemFactory.create(value, this, refReg, null));
    }

    public void remove(int index) {
        overlays.remove(index);
    }

    public int size() {
        return overlays.size();
    }

    public boolean isReference(int index) {
        ChildOverlay<V> childOverlay = (ChildOverlay<V>) overlays.get(index);
        return childOverlay.isReference();
    }

    public Reference getReference(int index) {
        ChildOverlay<V> childOverlay = (ChildOverlay<V>) overlays.get(index);
        return childOverlay.getReference();
    }

    public static <V> OverlayFactory<Collection<V>> getFactory(OverlayFactory<V> itemFactory) {
        return new ListOverlayFactory<V>(itemFactory);
    }

    
    
    @Override
	public <T extends IJsonOverlay<Collection<V>>> void copyOverlayData(T from) {
		super.copyOverlayData(from);
		ListOverlay<V> impl = (ListOverlay<V>) from;
		this.overlays = impl.overlays;
	}



	private static class ListOverlayFactory<V> extends OverlayFactory<Collection<V>> {

        private OverlayFactory<V> itemFactory;

        public ListOverlayFactory(OverlayFactory<V> itemFactory) {
            this.itemFactory = itemFactory;
        }

        @Override
        protected Class<? extends JsonOverlay<Collection<V>>> getOverlayClass() {
            Class<?> overlayClass = ListOverlay.class;
            @SuppressWarnings("unchecked")
            Class<? extends JsonOverlay<Collection<V>>> castClass = (Class<? extends JsonOverlay<Collection<V>>>) overlayClass;
            return castClass;
        }

        @Override
        public ListOverlay<V> _create(Collection<V> value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new ListOverlay<V>(value, parent, itemFactory, refReg);
        }

        @Override
        public ListOverlay<V> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new ListOverlay<V>(json, parent, itemFactory, refReg);
        }
    }
}
