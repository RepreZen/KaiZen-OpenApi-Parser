package com.reprezen.swaggerparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValMapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.AnyObjectOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.PrimitiveOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.StringOverlay;
import com.reprezen.swaggerparser.model3.ServerVariable;
import com.reprezen.swaggerparser.ovl3.SwaggerObjectImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class ServerVariableImpl extends SwaggerObjectImpl implements ServerVariable {

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public ServerVariableImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public ServerVariableImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValListOverlay<Object, PrimitiveOverlay> enumValues = registerField("enum", "enumValues", null, new ValListOverlay<Object, PrimitiveOverlay>("enum", this, PrimitiveOverlay.factory));;

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private PrimitiveOverlay defaultValue = registerField("default", "defaultValue", null, new PrimitiveOverlay("default", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay description = registerField("description", "description", null, new StringOverlay("description", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object,AnyObjectOverlay> extensions = registerField("", "extensions", "x-.+", new ValMapOverlay<Object, AnyObjectOverlay>("", this, AnyObjectOverlay.factory, "x-.+"));

    // EnumValue
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Object> getEnumValues() {
        return enumValues.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Object getEnumValue(int index) {
        return enumValues.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setEnumValues(Collection<Object> enumValues) {
        this.enumValues.set((Collection<Object>) enumValues);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setEnumValue(int index, Object enumValue) {
        enumValues.set(index, enumValue);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addEnumValue(Object enumValue) {
        enumValues.add(enumValue);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeEnumValue(int index) {
        enumValues.remove(index);
    }

    // Default
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Object getDefault() {
        return defaultValue.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setDefault(Object defaultValue) {
        this.defaultValue.set(defaultValue);
    }

    // Description
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getDescription() {
        return description.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setDescription(String description) {
        this.description.set(description);
    }

    // Extension
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public static JsonOverlayFactory<ServerVariableImpl> factory = new JsonOverlayFactory<ServerVariableImpl>() {
    @Override
    public ServerVariableImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, ServerVariableImpl.class) ? null : new ServerVariableImpl(key, json, parent);
    }
};

}
