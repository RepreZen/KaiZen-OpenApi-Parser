package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.ovl3.SecurityParameterImpl;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.jsonoverlay.PropertiesOverlay;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.Map;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.IJsonOverlay;

public class SecurityRequirementImpl extends PropertiesOverlay<SecurityRequirement> implements SecurityRequirement {

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecurityRequirementImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecurityRequirementImpl(SecurityRequirement securityRequirement, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(securityRequirement, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<SecurityParameter> requirements;

    // Requirement
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, SecurityParameter> getRequirements() {
        return requirements.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, SecurityParameter> getRequirements(boolean elaborate) {
        return requirements.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasRequirement(String name) {
        return requirements.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecurityParameter getRequirement(String name) {
        return requirements.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setRequirements(Map<String, SecurityParameter> requirements) {
        this.requirements.set(requirements);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setRequirement(String name, SecurityParameter requirement) {
        requirements.set(name, requirement);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeRequirement(String name) {
        requirements.remove(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    protected void elaborateChildren() {
        requirements = createChildMap("", this, SecurityParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<SecurityRequirement> factory = new OverlayFactory<SecurityRequirement>() {

        @Override
        protected Class<? extends IJsonOverlay<? super SecurityRequirement>> getOverlayClass() {
            return SecurityRequirementImpl.class;
        }

        @Override
        public JsonOverlay<SecurityRequirement> _create(SecurityRequirement securityRequirement, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            Class<? extends SecurityRequirement> subtype = getSubtypeOf(securityRequirement);
            IJsonOverlay<?> overlay;
            if (subtype == null || subtype == SecurityRequirement.class) {
                overlay = new SecurityRequirementImpl(securityRequirement, parent, refReg);
            } else {
                switch(subtype.getSimpleName()) {
                    default:
                        overlay = null;
                }
            }
            @SuppressWarnings("unchecked") JsonOverlay<SecurityRequirement> castOverlay = (JsonOverlay<SecurityRequirement>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<SecurityRequirement> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            Class<? extends SecurityRequirement> subtype = getSubtypeOf(json);
            IJsonOverlay<?> overlay;
            if (subtype == null || subtype == SecurityRequirement.class) {
                overlay = new SecurityRequirementImpl(json, parent, refReg);
            } else {
                switch(subtype.getSimpleName()) {
                    default:
                        overlay = null;
                }
            }
            @SuppressWarnings("unchecked") JsonOverlay<SecurityRequirement> castOverlay = (JsonOverlay<SecurityRequirement>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends SecurityRequirement> getSubtypeOf(SecurityRequirement securityRequirement) {
        return SecurityRequirement.class;
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends SecurityRequirement> getSubtypeOf(JsonNode json) {
        return SecurityRequirement.class;
    }
}
