package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.jsonoverlay.PrimitiveOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.List;
import com.reprezen.jsonoverlay.JsonOverlay;
import java.util.Map;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.ListOverlay;
import com.fasterxml.jackson.databind.JsonNode;

public class ServerVariableImpl extends PropertiesOverlay<ServerVariable> implements ServerVariable {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ServerVariableImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ServerVariableImpl(ServerVariable serverVariable, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(serverVariable, parent, factory, refMgr);
    }

    // EnumValue
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<Object> getEnumValues() {
        return _getList("enumValues", Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<Object> getEnumValues(boolean elaborate) {
        return _getList("enumValues", elaborate, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasEnumValues() {
        return _isPresent("enumValues");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Object getEnumValue(int index) {
        return _get("enumValues", index, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setEnumValues(List<Object> enumValues) {
        _setList("enumValues", enumValues, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setEnumValue(int index, Object enumValue) {
        _set("enumValues", index, enumValue, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void addEnumValue(Object enumValue) {
        _add("enumValues", enumValue, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void insertEnumValue(int index, Object enumValue) {
        _insert("enumValues", index, enumValue, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeEnumValue(int index) {
        _remove("enumValues", index, Object.class);
    }

    // Default
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Object getDefault() {
        return (Object) _get("defaultValue", Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setDefault(Object defaultValue) {
        _setScalar("defaultValue", defaultValue, Object.class);
    }

    // Description
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public String getDescription() {
        return (String) _get("description", String.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setDescription(String description) {
        _setScalar("description", description, String.class);
    }

    // Extension
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getExtensions() {
        return _getMap("extensions", Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getExtensions(boolean elaborate) {
        return _getMap("extensions", elaborate, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasExtensions() {
        return _isPresent("extensions");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasExtension(String name) {
        return _getMap("extensions", Object.class).containsKey(name);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Object getExtension(String name) {
        return _get("extensions", name, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setExtensions(Map<String, Object> extensions) {
        _setMap("extensions", extensions, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setExtension(String name, Object extension) {
        _set("extensions", name, extension, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeExtension(String name) {
        _remove("extensions", name, Object.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        _createList("enumValues", "enum", PrimitiveOverlay.factory);
        _createScalar("defaultValue", "default", PrimitiveOverlay.factory);
        _createScalar("description", "description", StringOverlay.factory);
        _createMap("extensions", "", ObjectOverlay.factory, "x-.+");
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ServerVariable> factory = new OverlayFactory<ServerVariable>() {

        @Override
        protected Class<? extends JsonOverlay<? super ServerVariable>> getOverlayClass() {
            return ServerVariableImpl.class;
        }

        @Override
        public JsonOverlay<ServerVariable> _create(ServerVariable serverVariable, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ServerVariableImpl(serverVariable, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ServerVariable> castOverlay = (JsonOverlay<ServerVariable>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<ServerVariable> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ServerVariableImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ServerVariable> castOverlay = (JsonOverlay<ServerVariable>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ServerVariable> getSubtypeOf(ServerVariable serverVariable) {
        return ServerVariable.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ServerVariable> getSubtypeOf(JsonNode json) {
        return ServerVariable.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Class<?> _getModelType() {
        return OpenApi3.class;
    }
}
