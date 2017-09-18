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

public class BooleanOverlay extends JsonOverlay<Boolean> {

    public BooleanOverlay(String key, Boolean value, JsonOverlay<?> parent) {
        super(key, value, parent);
    }

    public BooleanOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    public BooleanOverlay(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Override
    public boolean isMissing() {
        return super.isMissing() || !getJson().isBoolean();
    }

    @Override
    public Boolean fromJson() {
        JsonNode json = getJson();
        return json.isBoolean() ? json.booleanValue() : null;
    }

    @Override
    public JsonNode createJson() {
        return value != null ? jsonFactory.booleanNode(value) : MissingNode.getInstance();

    }

    public static JsonOverlayFactory<BooleanOverlay> factory = new JsonOverlayFactory<BooleanOverlay>() {
        @Override
        public BooleanOverlay create(String key, JsonNode json, JsonOverlay<?> parent) {
            return new BooleanOverlay(key, json, parent);
        }

        @Override
        public BooleanOverlay create(String key, Object value, JsonOverlay<?> parent) {
            if (value == null || value instanceof Boolean) {
                return new BooleanOverlay(key, (Boolean) value, parent);
            } else {
                return super.create(key, value, parent);
            }
        }
    };
}