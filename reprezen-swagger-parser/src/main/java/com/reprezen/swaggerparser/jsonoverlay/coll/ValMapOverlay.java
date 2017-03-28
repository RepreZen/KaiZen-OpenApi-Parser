package com.reprezen.swaggerparser.jsonoverlay.coll;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;

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

    @Override
    protected Collection<? extends JsonOverlay<?>> getChildren() {
        return store != null ? store.getOverlays() : Collections.<OV> emptyList();
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
    }

    public void set(String key, V value) {
        OV overlay = createOverlay(value);
        if (containsKey(key)) {
            store.replace(key, overlay);
        } else {
            store.add(key, overlay);
        }
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
        return store.size();
    }

    @Override
    public Map<String, V> fromJson() {
        return values != null ? values : Collections.<String, V> emptyMap();
    }

    @Override
    public JsonNode toJson() {
        return store.toJson();
    }

    public void add(String key, V value) {
        store.add(key, createOverlay(value));
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

    public void replace(String key, V value) {
        store.replace(key, createOverlay(value));
        reset();
    }

    public void replace(int index, V value) {
        store.replace(index, factory.create(null, value, parent));
        reset();
    }

    private OV createOverlay(V value) {
        return factory.create(null, value, this);
    }

    @Override
    public CollectionStore<OV> getStore() {
        return store;
    }
}
