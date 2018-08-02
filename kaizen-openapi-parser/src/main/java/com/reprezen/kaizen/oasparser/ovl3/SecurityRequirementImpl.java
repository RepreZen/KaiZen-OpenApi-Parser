package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.jsonoverlay.PropertiesOverlay;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.kaizen.oasparser.ovl3.SecurityParameterImpl;
import com.reprezen.jsonoverlay.JsonOverlay;
import java.util.Map;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.MapOverlay;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.OverlayFactory;

public class SecurityRequirementImpl extends PropertiesOverlay<SecurityRequirement> implements SecurityRequirement {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public SecurityRequirementImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public SecurityRequirementImpl(SecurityRequirement securityRequirement, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(securityRequirement, parent, factory, refMgr);
    }

    // Requirement
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, SecurityParameter> getRequirements() {
        return _getMap("requirements", SecurityParameter.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, SecurityParameter> getRequirements(boolean elaborate) {
        return _getMap("requirements", elaborate, SecurityParameter.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasRequirements() {
        return _isPresent("requirements");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasRequirement(String name) {
        return _getMap("requirements", SecurityParameter.class).containsKey(name);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public SecurityParameter getRequirement(String name) {
        return _get("requirements", name, SecurityParameter.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setRequirements(Map<String, SecurityParameter> requirements) {
        _setMap("requirements", requirements, SecurityParameter.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setRequirement(String name, SecurityParameter requirement) {
        _set("requirements", name, requirement, SecurityParameter.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeRequirement(String name) {
        _remove("requirements", name, SecurityParameter.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        _createMap("requirements", "", SecurityParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<SecurityRequirement> factory = new OverlayFactory<SecurityRequirement>() {

        @Override
        protected Class<? extends JsonOverlay<? super SecurityRequirement>> getOverlayClass() {
            return SecurityRequirementImpl.class;
        }

        @Override
        public JsonOverlay<SecurityRequirement> _create(SecurityRequirement securityRequirement, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new SecurityRequirementImpl(securityRequirement, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<SecurityRequirement> castOverlay = (JsonOverlay<SecurityRequirement>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<SecurityRequirement> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new SecurityRequirementImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<SecurityRequirement> castOverlay = (JsonOverlay<SecurityRequirement>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends SecurityRequirement> getSubtypeOf(SecurityRequirement securityRequirement) {
        return SecurityRequirement.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends SecurityRequirement> getSubtypeOf(JsonNode json) {
        return SecurityRequirement.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Class<?> _getModelType() {
        return OpenApi3.class;
    }
}
