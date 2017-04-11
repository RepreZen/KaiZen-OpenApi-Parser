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
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayException;

public class CollectionStore<OV extends JsonOverlay<?>> {

    private JsonNodeFactory jsonFactory = JsonNodeFactory.instance;

    private Map<String, OV> overlays = Maps.newLinkedHashMap();
    private JsonOverlay<?> collectionOverlay;
    private boolean isList;
    private Pattern keyPat;

    public CollectionStore(JsonOverlay<?> collectionOverlay) {
        this.collectionOverlay = collectionOverlay;
    }

    public CollectionStore(JsonOverlay<?> collectionOverlay, boolean isList, JsonOverlayFactory<OV> factory,
            String keyPat) {
        this.collectionOverlay = collectionOverlay;
        this.keyPat = keyPat != null ? Pattern.compile(keyPat) : null;
    }

    public CollectionStore<OV> init(boolean isList, String keyPat) {
        this.isList = isList;
        this.keyPat = keyPat != null ? Pattern.compile(keyPat) : null;
        return this;
    }

    public void load(CollectionData<OV> data) {
        for (Entry<String, OV> entry : data.get()) {
            if (isList) {
                add(entry.getValue());
            } else {
                add(entry.getKey(), entry.getValue());
            }
        }
    }

    public Collection<OV> getOverlays() {
        return overlays.values();
    }

    public Map<String, OV> getOverlayMap() {
        return overlays;
    }

    public OV getOverlay(String key) {
        return overlays.get(key);
    }

    public OV get(int index) {
        return overlays.get(keyAtIndex(index));
    }

    public void set(Collection<OV> overlays) {
        overlays.clear();
        if (isList) {
            setForList(overlays);
        } else {
            setForMap(overlays);
        }
    }

    public void set(Map<String, OV> overlayMap) {
        setForMap(overlayMap);
    }

    private void setForList(Collection<OV> overlays) {
        for (OV overlay : overlays) {
            String key = allocateListKey();
            add(key, overlay);
        }
    }

    private void setForMap(Collection<OV> overlays) {
        for (OV overlay : overlays) {
            String key = overlay.getKey();
            add(key, overlay);
        }
    }

    private void setForMap(Map<String, OV> overlayMap) {
        for (Entry<String, OV> entry : overlayMap.entrySet()) {
            String key = entry.getKey();
            OV overlay = entry.getValue();
            add(key, overlay);
        }
    }

    public JsonNode toJson() {
        return isList ? toJsonList() : toJsonMap();
    }

    private JsonNode toJsonList() {
        ArrayNode list = jsonFactory.arrayNode();
        for (OV overlay : overlays.values()) {
            list.add(overlay.toJson());
        }
        return list;
    }

    private JsonNode toJsonMap() {
        ObjectNode map = jsonFactory.objectNode();
        for (OV overlay : overlays.values()) {
            map.set(overlay.getKey(), overlay.toJson());
        }
        return map;
    }

    public void clear() {
        for (OV overlay : overlays.values()) {
            overlay.deparent();
        }
        overlays.clear();
    }

    public int size() {
        return overlays.size();
    }

    public String add(OV overlay) {
        String key = isList ? allocateListKey() : overlay.getKey();
        if (key != null) {
            add(key, overlay);
            return key;
        } else {
            throw new OverlayException("Cannot add overlay to non-list collection without a key");
        }
    }

    public void add(String key, OV overlay) {
        if (keyPat == null || (key != null && keyPat.matcher(key).matches())) {
            if (!overlays.containsKey(key)) {
                overlays.put(key, overlay);
                overlay.reparent(collectionOverlay, key);
            } else {
                throw new OverlayException("Duplicate key in collection overlay: " + key);
            }
        }
    }

    public void remove(String key) {
        if (overlays.containsKey(key)) {
            OV overlay = overlays.get(key);
            overlays.remove(key);
            overlay.deparent();
        } else {
            throw new OverlayException("No such key in collection overlay");
        }
    }

    public String remove(int index) {
        String key = keyAtIndex(index);
        remove(key);
        return key;
    }

    public void replace(String key, OV overlay) {
        if (overlays.containsKey(key)) {
            // don't use remove here, since then we'd change order of keys
            OV current = overlays.get(key);
            overlays.put(key, overlay);
            current.deparent();
            overlay.reparent(collectionOverlay, key);
        }
    }

    public String replace(int index, OV overlay) {
        String key = keyAtIndex(index);
        replace(key, overlay);
        return key;
    }

    public boolean isList() {
        return isList;
    }

    private int nextKey = 0;

    private String allocateListKey() {
        return Integer.toString(nextKey++);
    }

    private String keyAtIndex(int index) {
        if (index >= 0 && index < overlays.size()) {
            return Iterables.get(overlays.keySet(), index);
        } else {
            throw new OverlayException("Index out of bound for collection overlay");
        }
    }
}
