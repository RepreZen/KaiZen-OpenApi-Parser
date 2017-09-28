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

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class CollectionData<OV extends JsonOverlay<?>> {

    private Iterable<Entry<String, OV>> data;

    private CollectionData(Iterable<Entry<String, OV>> data) {
        this.data = data;
    }

    public Iterable<Entry<String, OV>> get() {
        return data;
    }

    public static <OV extends JsonOverlay<?>> CollectionData<OV> of(Collection<OV> data) {
        return new CollectionData<OV>(Iterables.transform(data, new Function<OV, Entry<String, OV>>() {
            @Override
            public Entry<String, OV> apply(OV overlay) {
                return new SimpleEntry<>(overlay.getKey(), overlay);
            }
        }));
    }

    public static <OV extends JsonOverlay<?>> CollectionData<OV> of(Map<String, OV> data) {
        return new CollectionData<OV>(data.entrySet());
    }

    public static <OV extends JsonOverlay<?>> CollectionData<OV> of(JsonNode json, final JsonOverlay<?> parent,
            final JsonOverlayFactory<OV> factory) {
        if (json.isArray()) {
			return new CollectionData<OV>(Iterables.transform(JsonOverlay.iterable(json.elements()),
                    new Function<JsonNode, Entry<String, OV>>() {
                        @Override
                        public Entry<String, OV> apply(JsonNode element) {
                            return new SimpleEntry<>(null, factory.create(null, element, parent));
                        }
                    }));
        } else if (json.isObject()) {
            return new CollectionData<OV>(Iterables.transform(JsonOverlay.iterable(json.fields()),
                    new Function<Entry<String, JsonNode>, Entry<String, OV>>() {

                        @Override
                        public Entry<String, OV> apply(Entry<String, JsonNode> field) {
                            return new SimpleEntry<>(field.getKey(),
                                    factory.create(field.getKey(), field.getValue(), parent));
                        }
                    }));
        } else { // missing or incompatible json
            return new CollectionData<OV>(Collections.<Entry<String, OV>> emptyList());
        }
    }

    public static <V, OV extends JsonOverlay<V>> CollectionData<OV> of(Collection<V> values,
            final JsonOverlayFactory<OV> factory) {
        return new CollectionData<OV>(Iterables.transform(values, new Function<V, Entry<String, OV>>() {
            @Override
            public Entry<String, OV> apply(V value) {
                return new SimpleEntry<>(null, factory.create(null, value, null));
            }
        }));
    }

    public static <V, OV extends JsonOverlay<V>> CollectionData<OV> of(Map<String, V> valueMap,
            final JsonOverlayFactory<OV> factory) {
        return new CollectionData<OV>(
                Iterables.transform(valueMap.entrySet(), new Function<Entry<String, V>, Entry<String, OV>>() {
                    @Override
                    public Entry<String, OV> apply(Entry<String, V> entry) {
                        return new SimpleEntry<>(entry.getKey(), factory.create(null, entry.getValue(), null));
                    }
                }));
    }
}