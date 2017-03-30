package com.reprezen.swaggerparser.jsonoverlay.coll;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;

public class MapOverlay<OV extends JsonOverlay<?>> extends JsonOverlay<Map<String, OV>>
        implements CollectionOverlay<OV> {

    private final CollectionStore<OV> store = new CollectionStore<OV>(this);

    private MapOverlay(String key, JsonOverlay<?> parent) {
        super(key, (Map<String, OV>) null, parent);
    }

    public MapOverlay(String key, Collection<OV> overlays, JsonOverlay<?> parent, String keyPat) {
        this(key, parent);
        store.init(false, keyPat).load(CollectionData.of(overlays));
        reset();
    }

    public MapOverlay(String key, Map<String, OV> overlayMap, JsonOverlay<?> parent, String keyPat) {
        this(key, parent);
        store.init(false, keyPat).load(CollectionData.of(overlayMap));
        reset();
    }

    public MapOverlay(String key, JsonNode json, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory, String keyPat) {
        this(key, parent);
        store.init(false, keyPat).load(CollectionData.of(json, parent, factory));
        reset();
    }

    public MapOverlay(String key, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory, String keyPat) {
        this(key, parent);
        store.init(false, keyPat).load(CollectionData.of(parent.getResolvedJson(key), parent, factory));
        reset();
    }

    @Override
    public boolean isMissing() {
        return super.isMissing() || !getJson().isObject();
    }

    private void reset() {
        super.set(store.getOverlayMap());
    }

    @Override
    protected Collection<? extends JsonOverlay<?>> getChildren() {
        return store != null ? store.getOverlays() : Collections.<OV> emptyList();
    }

    public OV get(String key) {
        return value.get(key);
    }

    public boolean containsKey(String key) {
        return value.containsKey(key);
    }

    public Collection<OV> getValues() {
        return value.values();
    }

    @Override
    public void set(Map<String, OV> overlayMap) {
        store.set(overlayMap);
        reset();
    }

    public void set(Collection<OV> overlays) {
        store.set(overlays);
        reset();
    }

    public void clear() {
        store.clear();
        reset();
    }

    public int size() {
        return value.size();
    }

    @Override
    public Map<String, OV> fromJson() {
        return store != null ? store.getOverlayMap() : Collections.<String, OV> emptyMap();
    }

    @Override
    public JsonNode toJson() {
        return store.toJson();
    }

    public void set(String key, OV overlay) {
        if (value.containsKey(key)) {
            store.replace(key, overlay);
        } else {
            store.add(key, overlay);
        }
        reset();
    }

    public void add(OV overlay) {
        store.add(overlay);
        reset();
    }

    public void add(String key, OV overlay) {
        store.add(key, overlay);
        reset();
    }

    public void remove(String key) {
        store.remove(key);
        reset();
    }

    public void remove(int index) {
        store.remove(index);
        reset();
    }

    public void replace(String key, OV overlay) {
        store.replace(key, overlay);
        reset();
    }

    public void replace(int index, OV overlay) {
        store.replace(index, overlay);
        reset();
    }

    @Override
    public CollectionStore<OV> getStore() {
        return store;
    }
}
