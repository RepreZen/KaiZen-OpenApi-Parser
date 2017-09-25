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

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;

public class PrimitiveOverlay extends JsonOverlay<Object> {

    public PrimitiveOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    public PrimitiveOverlay(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    public PrimitiveOverlay(String key, Object value, JsonOverlay<?> parent) {
        super(key, value, parent);
    }

    @Override
    public boolean isMissing() {
        return super.isMissing() || !getJson().isValueNode();
    }

    @Override
    public Object fromJson() {
        JsonNode json = getJson();
        if (json.isTextual()) {
            return json.textValue();
        } else if (json.isNumber()) {
            return json.numberValue();
        } else if (json.isBoolean()) {
            return json.booleanValue();
        } else {
            return null;
        }
    }

    @Override
    public JsonNode _createJson() {
        if (value instanceof String) {
            return jsonFactory.textNode((String) value);
        } else if (value instanceof BigDecimal) {
            return jsonFactory.numberNode((BigDecimal) value);
        } else if (value instanceof BigInteger) {
            return jsonFactory.numberNode((BigInteger) value);
        } else if (value instanceof Byte) {
            return jsonFactory.numberNode((Byte) value);
        } else if (value instanceof Double) {
            return jsonFactory.numberNode((Double) value);
        } else if (value instanceof Float) {
            return jsonFactory.numberNode((Float) value);
        } else if (value instanceof Integer) {
            return jsonFactory.numberNode((Integer) value);
        } else if (value instanceof Long) {
            return jsonFactory.numberNode((Long) value);
        } else if (value instanceof Short) {
            return jsonFactory.numberNode((Short) value);
        } else {
            return null;
        }
    }

    public static JsonOverlayFactory<PrimitiveOverlay> factory = new JsonOverlayFactory<PrimitiveOverlay>() {
        @Override
        public PrimitiveOverlay create(String key, JsonNode json, JsonOverlay<?> parent) {
            return new PrimitiveOverlay(key, json, parent);
        }

        @Override
        public PrimitiveOverlay create(String key, Object value, JsonOverlay<?> parent) {
            if (value == null || value instanceof String || value instanceof Number || value instanceof Boolean) {
                return new PrimitiveOverlay(key, value, parent);
            } else {
                return super.create(key, value, parent);
            }
        }
    };
}
