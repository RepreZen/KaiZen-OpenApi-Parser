/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.jsonoverlay.std;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;

public class IntegerOverlay extends JsonOverlay<Integer> {

    public IntegerOverlay(String key, Integer value, JsonOverlay<?> parent) {
        super(key, value, parent);
    }

    public IntegerOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    public IntegerOverlay(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Override
    public boolean isMissing() {
        return super.isMissing() || !getJson().isIntegralNumber();
    }

    @Override
    public Integer fromJson() {
        JsonNode json = getJson();
        return json.isInt() ? json.intValue() : null;
    }

    @Override
    public JsonNode toJson() {
        return value != null ? jsonFactory.numberNode(value) : MissingNode.getInstance();
    }

    public static JsonOverlayFactory<IntegerOverlay> factory = new JsonOverlayFactory<IntegerOverlay>() {
        @Override
        public IntegerOverlay create(String key, JsonNode json, JsonOverlay<?> parent) {
            return new IntegerOverlay(key, json, parent);
        }

        @Override
        public IntegerOverlay create(String key, Object value, JsonOverlay<?> parent) {
            if (value == null || value instanceof Integer) {
                return new IntegerOverlay(key, (Integer) value, parent);
            } else {
                return super.create(key, value, parent);
            }
        }
    };
}
