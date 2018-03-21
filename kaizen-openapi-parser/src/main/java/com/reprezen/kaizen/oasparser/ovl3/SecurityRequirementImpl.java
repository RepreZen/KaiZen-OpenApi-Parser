package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.ovl3.SecurityParameterImpl;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;

public class SecurityRequirementImpl extends PropertiesOverlay<SecurityRequirement> implements SecurityRequirement {

    @Generated("com.reprezen.gen.CodeGenerator")
    public SecurityRequirementImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public SecurityRequirementImpl(SecurityRequirement securityRequirement, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(securityRequirement, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<SecurityParameter> requirements;

    // Requirement
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, SecurityParameter> getRequirements() {
        return requirements.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, SecurityParameter> getRequirements(boolean elaborate) {
        return requirements.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasRequirement(String name) {
        return requirements.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public SecurityParameter getRequirement(String name) {
        return requirements.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setRequirements(Map<String, SecurityParameter> requirements) {
        this.requirements.set(requirements);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setRequirement(String name, SecurityParameter requirement) {
        requirements.set(name, requirement);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeRequirement(String name) {
        requirements.remove(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    protected void elaborateChildren() {
        super.elaborateChildren();
        requirements = createChildMap("", this, SecurityParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public static OverlayFactory<SecurityRequirement> factory = new OverlayFactory<SecurityRequirement>() {

        @Override
        protected Class<? extends IJsonOverlay<? super SecurityRequirement>> getOverlayClass() {
            return SecurityRequirementImpl.class;
        }

        @Override
        public JsonOverlay<SecurityRequirement> _create(SecurityRequirement securityRequirement, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new SecurityRequirementImpl(securityRequirement, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<SecurityRequirement> castOverlay = (JsonOverlay<SecurityRequirement>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<SecurityRequirement> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new SecurityRequirementImpl(json, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<SecurityRequirement> castOverlay = (JsonOverlay<SecurityRequirement>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends SecurityRequirement> getSubtypeOf(SecurityRequirement securityRequirement) {
        return SecurityRequirement.class;
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends SecurityRequirement> getSubtypeOf(JsonNode json) {
        return SecurityRequirement.class;
    }
}
