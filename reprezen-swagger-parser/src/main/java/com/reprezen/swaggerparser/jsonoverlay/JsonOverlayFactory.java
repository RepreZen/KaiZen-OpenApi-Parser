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
package com.reprezen.swaggerparser.jsonoverlay;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;

public abstract class JsonOverlayFactory<OV extends JsonOverlay<?>> {

    public abstract OV create(String key, JsonNode json, JsonOverlay<?> parent);

    public OV create(String key, JsonOverlay<?> parent) {
        return create(key, parent.getJson(key), parent);
    }

    public OV create(String key, Object value, JsonOverlay<?> parent) {
        OV dummy = create(null, MissingNode.getInstance(), null);
        Class<?> valClass = value != null ? value.getClass() : Void.class;
        throw new OverlayException(String.format("Cannot create overlay of type %s from value of type %s",
                dummy.getClass().getName(), valClass.getName()));
    };
}
