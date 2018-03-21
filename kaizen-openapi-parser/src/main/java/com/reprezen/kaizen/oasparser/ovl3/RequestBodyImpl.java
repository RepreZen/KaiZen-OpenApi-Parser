package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.ovl3.MediaTypeImpl;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.ChildOverlay;

public class RequestBodyImpl extends PropertiesOverlay<RequestBody> implements RequestBody {

    @Generated("com.reprezen.gen.CodeGenerator")
    public RequestBodyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public RequestBodyImpl(RequestBody requestBody, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(requestBody, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<String> description;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<MediaType> contentMediaTypes;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<Boolean> required;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<Object> extensions;

    // Description
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getDescription() {
        return description.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getDescription(boolean elaborate) {
        return description.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setDescription(String description) {
        this.description.set(description);
    }

    // ContentMediaType
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, MediaType> getContentMediaTypes() {
        return contentMediaTypes.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, MediaType> getContentMediaTypes(boolean elaborate) {
        return contentMediaTypes.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasContentMediaType(String name) {
        return contentMediaTypes.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public MediaType getContentMediaType(String name) {
        return contentMediaTypes.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setContentMediaTypes(Map<String, MediaType> contentMediaTypes) {
        this.contentMediaTypes.set(contentMediaTypes);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setContentMediaType(String name, MediaType contentMediaType) {
        contentMediaTypes.set(name, contentMediaType);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeContentMediaType(String name) {
        contentMediaTypes.remove(name);
    }

    // Required
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Boolean getRequired() {
        return required.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Boolean getRequired(boolean elaborate) {
        return required.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean isRequired() {
        return required.get() != null ? required.get() : false;
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setRequired(Boolean required) {
        this.required.set(required);
    }

    // Extension
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Object> getExtensions(boolean elaborate) {
        return extensions.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    protected void elaborateChildren() {
        super.elaborateChildren();
        description = createChild("description", this, StringOverlay.factory);
        contentMediaTypes = createChildMap("content", this, MediaTypeImpl.factory, null);
        required = createChild("required", this, BooleanOverlay.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public static OverlayFactory<RequestBody> factory = new OverlayFactory<RequestBody>() {

        @Override
        protected Class<? extends IJsonOverlay<? super RequestBody>> getOverlayClass() {
            return RequestBodyImpl.class;
        }

        @Override
        public JsonOverlay<RequestBody> _create(RequestBody requestBody, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new RequestBodyImpl(requestBody, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<RequestBody> castOverlay = (JsonOverlay<RequestBody>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<RequestBody> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new RequestBodyImpl(json, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<RequestBody> castOverlay = (JsonOverlay<RequestBody>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends RequestBody> getSubtypeOf(RequestBody requestBody) {
        return RequestBody.class;
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends RequestBody> getSubtypeOf(JsonNode json) {
        return RequestBody.class;
    }
}
