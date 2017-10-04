package com.reprezen.kaizen.oasparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import com.reprezen.kaizen.oasparser.ovl3.SecurityParameterImpl;
import java.util.Map;
import javax.annotation.Generated;

public class SecurityRequirementImpl extends OpenApiObjectImpl<SecurityRequirement> implements SecurityRequirement {

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecurityRequirementImpl(JsonNode json, ReferenceRegistry refReg) {
        super(json, refReg);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecurityRequirementImpl(SecurityRequirement securityRequirement, ReferenceRegistry refReg) {
        super(securityRequirement, refReg);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<SecurityParameter, SecurityParameterImpl> requirements = createChildMap("", SecurityParameterImpl.factory, "[a-zA-Z0-9\\._-]+");

    // Requirement
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, SecurityParameter> getRequirements() {
        return requirements.get();
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

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<SecurityRequirement, SecurityRequirementImpl> factory = new OverlayFactory<SecurityRequirement, SecurityRequirementImpl>() {
    @Override
    protected Class<? super SecurityRequirementImpl> getOverlayClass() {
         return SecurityRequirementImpl.class;
    }

    @Override
    public SecurityRequirementImpl _create(SecurityRequirement securityRequirement, ReferenceRegistry refReg) {
        return new SecurityRequirementImpl(securityRequirement, refReg);
    }

    @Override
    public SecurityRequirementImpl _create(JsonNode json, ReferenceRegistry refReg) {
        return new SecurityRequirementImpl(json, refReg);
    }
};

}
