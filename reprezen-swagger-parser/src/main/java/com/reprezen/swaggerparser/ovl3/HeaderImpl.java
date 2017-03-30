package com.reprezen.swaggerparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.swaggerparser.model3.Header;
import com.reprezen.swaggerparser.ovl3.SwaggerObjectImpl;
import javax.annotation.Generated;

public class HeaderImpl extends ParameterImpl implements Header {

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public HeaderImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public HeaderImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public static JsonOverlayFactory<HeaderImpl> factory = new JsonOverlayFactory<HeaderImpl>() {
    @Override
    public HeaderImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, HeaderImpl.class) ? null : new HeaderImpl(key, json, parent);
    }
};

}
