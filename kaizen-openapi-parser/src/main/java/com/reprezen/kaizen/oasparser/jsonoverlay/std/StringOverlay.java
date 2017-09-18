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

public class StringOverlay extends JsonOverlay<String> {

    public StringOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    public StringOverlay(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    public StringOverlay(String key, String value, JsonOverlay<?> parent) {
        super(key, value, parent);
    }

    @Override
    public boolean isMissing() {
        return super.isMissing() || !getJson().isTextual();
    }

    @Override
    public String fromJson() {
        JsonNode json = getJson();
        return json.isTextual() ? json.textValue() : null;
    }

    @Override
    public JsonNode createJson() {
        return value != null ? jsonFactory.textNode(value) : MissingNode.getInstance();
    }

    public static JsonOverlayFactory<StringOverlay> factory = new JsonOverlayFactory<StringOverlay>() {
        @Override
        public StringOverlay create(String key, JsonNode json, JsonOverlay<?> parent) {
            return new StringOverlay(key, json, parent);
        }

        @Override
        public StringOverlay create(String key, Object value, JsonOverlay<?> parent) {
            if (value == null || value instanceof String) {
                return new StringOverlay(key, (String) value, parent);
            } else {
                return super.create(key, value, parent);
            }
        }
    };
}
