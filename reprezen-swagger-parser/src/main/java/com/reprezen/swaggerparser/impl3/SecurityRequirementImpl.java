package com.reprezen.swaggerparser.impl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.impl3.SwaggerObjectImpl;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.StringOverlay;
import com.reprezen.swaggerparser.model3.SecurityRequirement;
import java.util.Collection;
import javax.annotation.Generated;

public class SecurityRequirementImpl extends SwaggerObjectImpl implements SecurityRequirement {

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public SecurityRequirementImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public SecurityRequirementImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValListOverlay<String, StringOverlay> requirements = registerField("", "requirements", null, new ValListOverlay<String, StringOverlay>("", this, StringOverlay.factory));;

    // Requirement
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<String> getRequirements() {
        return requirements.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getRequirement(int index) {
        return requirements.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setRequirements(Collection<String> requirements) {
        this.requirements.set((Collection<String>) requirements);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setRequirement(int index, String requirement) {
        requirements.set(index, requirement);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addRequirement(String requirement) {
        requirements.add(requirement);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeRequirement(int index) {
        requirements.remove(index);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public static JsonOverlayFactory<SecurityRequirementImpl> factory = new JsonOverlayFactory<SecurityRequirementImpl>() {
    @Override
    public SecurityRequirementImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, SecurityRequirementImpl.class) ? null : new SecurityRequirementImpl(key, json, parent);
    }
};

}
