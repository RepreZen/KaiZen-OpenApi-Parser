package com.reprezen.swaggerparser.impl3;

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
        return (SwaggerObject) getParentOverlay();
    }

}
