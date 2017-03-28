package com.reprezen.swaggerparser.jsonoverlay.coll;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;

public class ValListOverlay<V, OV extends JsonOverlay<V>> extends JsonOverlay<Collection<V>>
        implements CollectionOverlay<OV> {

    private JsonOverlayFactory<OV> factory;
    private final CollectionStore<OV> store = new CollectionStore<OV>(this);

    private Map<String, V> values = Maps.newLinkedHashMap();

    private ValListOverlay(String key, JsonOverlayFactory<OV> factory, JsonOverlay<?> parent) {
        // we'd normally put factory at the end for this constructor, but then it'd clash with another
        super(key, (Collection<V>) null, parent);
        this.factory = factory;
    }

    public ValListOverlay(String key, Collection<V> values, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory) {
        this(key, factory, parent);
        store.init(true, null).load(CollectionData.<V, OV> of(values, factory));
        reset();
    }

    public ValListOverlay(String key, JsonNode json, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory) {
        this(key, factory, parent);
        store.init(true, null).load(CollectionData.of(json, parent, factory));
        reset();
    }

    public ValListOverlay(String key, JsonOverlay<?> parent, JsonOverlayFactory<OV> factory) {
        this(key, factory, parent);
        store.init(true, null).load(CollectionData.of(parent.getResolvedJson(key), parent, factory));
        reset();
    }

    @Override
    public boolean isMissing() {
        return super.isMissing() || !getJson().isArray();
    }

    private void reset() {
        values.clear();
        for (OV overlay : store.getOverlays()) {
            values.put(overlay.getKey(), overlay.get());
        }
        super.set(values.values());
    }

    @Override
    protected Collection<? extends JsonOverlay<?>> getChildren() {
        return store != null ? store.getOverlays() : Collections.<OV> emptyList();
    }

    public V get(int index) {
        return store.get(index).get();
    }

    public Collection<OV> getOverlays() {
        return store.getOverlays();
    }

    @Override
    public void set(Collection<V> values) {
        store.clear();
        for (V value : values) {
            store.add(createOverlay(value));
        }
        reset();
    }

    public void set(int index, V value) {
        store.replace(index, createOverlay(value));
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
    public Collection<V> fromJson() {
        return values != null ? values.values() : Collections.<V> emptyList();
    }

    @Override
    public JsonNode toJson() {
        return store.toJson();
    }

    public void add(V value) {
        store.add(createOverlay(value));
        reset();
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

    private OV createOverlay(V value) {
        return factory.create(null, value, this);
    }

    @Override
    public CollectionStore<OV> getStore() {
        return store;
    }
}
