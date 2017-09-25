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
package com.reprezen.kaizen.oasparser.jsonoverlay.std;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;

public class AnyObjectOverlay extends JsonOverlay<Object> {

    public AnyObjectOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    public AnyObjectOverlay(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    public AnyObjectOverlay(String key, Object value, JsonOverlay<?> parent) {
        super(key, value, parent);
    }

    @Override
    public Object fromJson() {
        JsonNode json = getJson();
        return json.isMissingNode() ? null : mapper.convertValue(json, Object.class);
    }

    @Override
    public JsonNode _createJson(boolean followRefs) {
        return value != null ? mapper.convertValue(value, JsonNode.class) : MissingNode.getInstance();
    }

    public static JsonOverlayFactory<AnyObjectOverlay> factory = new JsonOverlayFactory<AnyObjectOverlay>() {
        @Override
        public AnyObjectOverlay create(String key, JsonNode json, JsonOverlay<?> parent) {
            return new AnyObjectOverlay(key, json, parent);
        }

        @Override
        public AnyObjectOverlay create(String key, Object value, JsonOverlay<?> parent) {
            return new AnyObjectOverlay(key, value, parent);
        }
    };
}
