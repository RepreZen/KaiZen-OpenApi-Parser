package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.ovl3.SecurityParameterImpl;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import java.util.Map;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.fasterxml.jackson.databind.JsonNode;

public class SecurityRequirementImpl extends OpenApiObjectImpl<OpenApi3, SecurityRequirement> implements SecurityRequirement {

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
    private ChildMapOverlay<SecurityParameter, SecurityParameterImpl> requirements = null;

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
    public static OverlayFactory<SecurityRequirement, SecurityRequirementImpl> factory = new OverlayFactory<SecurityRequirement, SecurityRequirementImpl>() {

        @Override
        protected Class<? super SecurityRequirementImpl> getOverlayClass() {
            return SecurityRequirementImpl.class;
        }

        @Override
        public SecurityRequirementImpl _create(SecurityRequirement securityRequirement, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new SecurityRequirementImpl(securityRequirement, parent, refReg);
        }

        @Override
        public SecurityRequirementImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new SecurityRequirementImpl(json, parent, refReg);
        }
    };
}
