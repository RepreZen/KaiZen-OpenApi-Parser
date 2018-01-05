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

import java.util.Map;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay.MapOverlayFactory;

public class ChildMapOverlay<V> extends ChildOverlay<Map<String, V>> {

    private MapOverlay<V> mapOverlay;

    public ChildMapOverlay(String path, JsonNode json, JsonOverlay<?> parent, OverlayFactory<Map<String, V>> factory,
            ReferenceRegistry refReg) {
        super(path, json, parent, factory, refReg);
        this.mapOverlay = (MapOverlay<V>) overlay;
    }

    public ChildMapOverlay(String path, Map<String, V> value, JsonOverlay<?> parent,
            OverlayFactory<Map<String, V>> factory, ReferenceRegistry refReg) {
        super(path, value, parent, factory, refReg);
    }

    @Override
    protected boolean isPartial() {
        return ((MapOverlayFactory<V>) factory).getKeyPattern() != null;
    }

    @Override
    protected boolean matchesPath(JsonPointer path) {
        if (super.matchesPath(path)) {
            String key = super.tailPath(path).getMatchingProperty();
            Pattern keyPattern = mapOverlay.getKeyPattern();
            return keyPattern == null || keyPattern.matcher(key).matches();
        } else {
            return false;
        }
    }

    public boolean containsKey(String name) {
        return mapOverlay.containsKey(name);
    }

    public V get(String name) {
        return mapOverlay.get(name);
    }

    public void set(String name, V value) {
        mapOverlay.set(name, value);
    }

    public void remove(String name) {
        mapOverlay.remove(name);
    }

    public int size() {
        return mapOverlay.size();
    }

    public ChildOverlay<V> getChild(String key) {
        return (ChildOverlay<V>) mapOverlay.getOverlay(key);
    }
}
