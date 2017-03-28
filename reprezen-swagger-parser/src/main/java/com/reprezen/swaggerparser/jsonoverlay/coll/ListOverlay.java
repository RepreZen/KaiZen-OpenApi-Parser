package com.reprezen.swaggerparser.jsonoverlay.coll;

import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;

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

    private void reset() {
        super.set(store.getOverlays());
    }

    @Override
    protected Collection<? extends JsonOverlay<?>> getChildren() {
        return store != null ? store.getOverlays() : Collections.<OV> emptyList();
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
    }

    public void clear() {
        store.clear();
        reset();
    }

    public int size() {
        return store.size();
    }

    @Override
    public Collection<OV> fromJson() {
        return store != null ? store.getOverlays() : Collections.<OV> emptyList();
    }

    @Override
    public JsonNode toJson() {
        return store.toJson();
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

    public void set(int index, OV overlay) {
        store.replace(index, overlay);
        reset();
    }

    @Override
    public CollectionStore<OV> getStore() {
        return store;
    }
}
