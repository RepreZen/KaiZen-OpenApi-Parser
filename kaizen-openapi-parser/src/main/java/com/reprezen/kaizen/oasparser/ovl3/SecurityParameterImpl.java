package com.reprezen.kaizen.oasparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import com.reprezen.kaizen.oasparser.ovl3.ChildListOverlay;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import java.util.Collection;
import javax.annotation.Generated;

public class SecurityParameterImpl extends OpenApiObjectImpl<SecurityParameter> implements SecurityParameter {

    @Override
    protected JsonNode fixJson(JsonNode json) {
        return json.isMissingNode() ? JsonNodeFactory.instance.arrayNode() : json;
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecurityParameterImpl(JsonNode json, ReferenceRegistry refReg) {
        super(json, refReg);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecurityParameterImpl(SecurityParameter securityParameter, ReferenceRegistry refReg) {
        super(securityParameter, refReg);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildListOverlay<String, StringOverlay> parameters = createChildList("", StringOverlay.factory);

    // Parameter
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<String> getParameters() {
        return parameters.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasParameters() {
        return parameters.isPresent();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getParameter(int index) {
        return parameters.get(index);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setParameters(Collection<String> parameters) {
        this.parameters.set((Collection<String>) parameters);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setParameter(int index, String parameter) {
        parameters.set(index, parameter);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void addParameter(String parameter) {
        parameters.add(parameter);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeParameter(int index) {
        parameters.remove(index);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<SecurityParameter, SecurityParameterImpl> factory = new OverlayFactory<SecurityParameter, SecurityParameterImpl>() {
    @Override
    protected Class<? super SecurityParameterImpl> getOverlayClass() {
         return SecurityParameterImpl.class;
    }

    @Override
    public SecurityParameterImpl _create(SecurityParameter securityParameter, ReferenceRegistry refReg) {
        return new SecurityParameterImpl(securityParameter, refReg);
    }

    @Override
    public SecurityParameterImpl _create(JsonNode json, ReferenceRegistry refReg) {
        return new SecurityParameterImpl(json, refReg);
    }
};

}
