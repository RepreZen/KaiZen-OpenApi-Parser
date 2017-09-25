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
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.common.collect.Maps;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;

public class NumberOverlay extends JsonOverlay<Number> {

    public NumberOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    public NumberOverlay(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    public NumberOverlay(String key, Number value, JsonOverlay<?> parent) {
        super(key, value, parent);
    }

    @Override
    public boolean isMissing() {
        return super.isMissing() || !getJson().isNumber();
    }

    @Override
    public Number fromJson() {
        JsonNode json = getJson();
        if (json.isBigDecimal()) {
            return json.decimalValue();
        } else if (json.isBigInteger()) {
            return json.bigIntegerValue();
        }
        // no methods for Byte, even though numberNode(Byte) is provided.
        // experimentations shows that bytes show up as ints. Oh well..
        else if (json.isDouble()) {
            return json.doubleValue();
        } else if (json.isFloat()) {
            return json.floatValue();
        } else if (json.isInt()) {
            return json.intValue();
        } else if (json.isLong()) {
            return json.longValue();
        } else if (json.isShort()) {
            return json.shortValue();
        } else {
            return null;
        }
    }

    @Override
    public JsonNode _createJson() {
        if (value != null) {
            NumberType type = NumberType.of(value);
            if (type == null) {
                throw new IllegalArgumentException(
                        "Numeric class " + value.getClass().getName() + " is not representable as a JsonNode");
            } else {
                switch (type) {
                case BigDecimal:
                    return jsonFactory.numberNode((BigDecimal) value);
                case BigInteger:
                    return jsonFactory.numberNode((BigInteger) value);
                case Byte:
                    return jsonFactory.numberNode((Byte) value);
                case Double:
                    return jsonFactory.numberNode((Double) value);
                case Float:
                    return jsonFactory.numberNode((Float) value);
                case Integer:
                    return jsonFactory.numberNode((Integer) value);
                case Long:
                    return jsonFactory.numberNode((Long) value);
                case Short:
                    return jsonFactory.numberNode((Short) value);
                default:
                    break;
                }
            }
        }
        return MissingNode.getInstance();
    }

    private enum NumberType {
        BigDecimal(BigDecimal.class), //
        BigInteger(BigInteger.class), //
        Byte(Byte.class), //
        Double(Double.class), //
        Float(Float.class), //
        Integer(Integer.class), //
        Long(Long.class), //
        Short(Short.class);

        NumberType(Class<? extends Number> cls) {
            this.cls = cls;
        }

        private Class<? extends Number> cls;
        private static Map<Class<? extends Number>, NumberType> typeMap = null;

        private static <T extends Number> NumberType of(T obj) {
            if (typeMap == null) {
                buildTypeMap();
            }
            return typeMap.get(obj.getClass());
        }

        private static void buildTypeMap() {
        	typeMap = Maps.newHashMap();
            for (NumberType type : NumberType.values()) {
                typeMap.put(type.cls, type);
            }
        }
    }

    public static JsonOverlayFactory<NumberOverlay> factory = new JsonOverlayFactory<NumberOverlay>() {
        @Override
        public NumberOverlay create(String key, JsonNode json, JsonOverlay<?> parent) {
            return new NumberOverlay(key, json, parent);
        }

        @Override
        public NumberOverlay create(String key, Object value, JsonOverlay<?> parent) {
            if (value == null || value instanceof Number) {
                return new NumberOverlay(key, (Number) value, parent);
            } else {
                return super.create(key, value, parent);
            }
        }
    };
}