package com.reprezen.swaggerparser.jsonoverlay.std;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;

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
    public Boolean fromJson() {
        JsonNode json = getJson();
        return json.isBoolean() ? json.booleanValue() : null;
    }

    @Override
    public JsonNode toJson() {
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