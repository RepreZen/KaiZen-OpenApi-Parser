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
package com.reprezen.swaggerparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ObjectOverlay;
import com.reprezen.swaggerparser.model3.Swagger3;
import com.reprezen.swaggerparser.model3.SwaggerObject;

public class SwaggerObjectImpl extends ObjectOverlay<SwaggerObjectImpl> implements SwaggerObject {

    public SwaggerObjectImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    public SwaggerObjectImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Override
    public Swagger3 getModel() {
        return (Swagger3) getRoot();
    }

    @Override
    public SwaggerObject getParent() {
        JsonOverlay<?> parent = getParentOverlay();
        while (parent != null && !(parent instanceof SwaggerObject)) {
            parent = parent.getParentOverlay();
        }
        return (SwaggerObject) parent;
    }
}
