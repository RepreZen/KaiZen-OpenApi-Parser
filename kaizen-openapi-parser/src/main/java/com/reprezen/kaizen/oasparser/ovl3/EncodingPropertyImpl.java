package com.reprezen.kaizen.oasparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.BooleanOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.EncodingProperty;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import java.util.Map;
import javax.annotation.Generated;

public class EncodingPropertyImpl extends OpenApiObjectImpl<EncodingProperty> implements EncodingProperty {

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public EncodingPropertyImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public EncodingPropertyImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay contentType = new StringOverlay("contentType", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<String, StringOverlay> headers = new ValMapOverlay<String, StringOverlay>("Headers", this, StringOverlay.factory, null);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay style = new StringOverlay("style", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay explode = new BooleanOverlay("explode", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object, AnyObjectOverlay> extensions = new ValMapOverlay<Object, AnyObjectOverlay>("", this, AnyObjectOverlay.factory, "x-.+");

    // ContentType
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getContentType() {
        return contentType.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setContentType(String contentType) {
        this.contentType.set(contentType);
    }

    // Header
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, String> getHeaders() {
        return headers.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasHeader(String name) {
        return headers.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setHeaders(Map<String, String> headers) {
        this.headers.set(headers);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setHeader(String name, String header) {
        headers.set(name, header);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeHeader(String name) {
        headers.remove(name);
    }

    // Style
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getStyle() {
        return style.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setStyle(String style) {
        this.style.set(style);
    }

    // Explode
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getExplode() {
        return explode.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isExplode() {
        return explode.get() != null ? explode.get() : false;
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setExplode(Boolean explode) {
        this.explode.set(explode);
    }

    // Extension
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public static JsonOverlayFactory<EncodingPropertyImpl> factory = new JsonOverlayFactory<EncodingPropertyImpl>() {
    @Override
    public EncodingPropertyImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, EncodingPropertyImpl.class) ? null : new EncodingPropertyImpl(key, json, parent);
    }
};

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    protected void installPropertyAccessors(PropertyAccessors accessors) {
        OverlayGetter getter = null;
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return contentType;}};
            accessors.add("contentType", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return headers;}};
            accessors.add("Headers", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return style;}};
            accessors.add("style", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return explode;}};
            accessors.add("explode", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return extensions;}};
            accessors.add("", "x-.+", getter);
    }

}
