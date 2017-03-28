package com.reprezen.swaggerparser.jsonoverlay.std;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;

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
    public JsonNode toJson() {
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
