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

import com.fasterxml.jackson.databind.JsonNode;

public abstract class OverlayFactory<V> {

    private final Class<? extends IJsonOverlay<? super V>> overlayClass = getOverlayClass();

    public JsonOverlay<V> create(V value, JsonOverlay<?> parent, ReferenceRegistry refReg, Reference ref) {
        JsonOverlay<V> overlay = _create(value, parent, refReg);
        overlay.setReference(ref);
        return overlay;
    }

    public IJsonOverlay<V> create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg, Reference ref) {
        JsonOverlay<V> overlay = (JsonOverlay<V>) create(json, parent, false, refReg);
        overlay.setReference(ref);
        return overlay;
    }

    protected IJsonOverlay<V> create(JsonNode json, JsonOverlay<?> parent, boolean partial, ReferenceRegistry refReg) {
        if (!partial && refReg.hasOverlay(json) && isCompatible(refReg.getOverlay(json))) {
            @SuppressWarnings("unchecked")
            JsonOverlay<V> overlay = (JsonOverlay<V>) refReg.getOverlay(json);
            if (parent != null) {
                overlay.setParent(parent);
            }
            return overlay;
        } else {
            JsonOverlay<V> overlay = _create(json, parent, refReg);
            if (!partial) {
                refReg.setOverlay(json, overlay);
            }
            overlay.elaborate();
            return overlay;
        }
    }

    public boolean isCompatible(IJsonOverlay<?> overlay) {
        return overlayClass.isAssignableFrom(overlay.getClass());
    }

    protected abstract Class<? extends IJsonOverlay<? super V>> getOverlayClass();

    protected abstract JsonOverlay<V> _create(V value, JsonOverlay<?> parent, ReferenceRegistry refReg);

    protected abstract JsonOverlay<V> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg);
}
