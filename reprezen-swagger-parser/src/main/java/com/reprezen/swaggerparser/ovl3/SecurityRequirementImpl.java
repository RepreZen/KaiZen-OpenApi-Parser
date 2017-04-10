/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.swaggerparser.jsonoverlay.coll.MapOverlay;
import com.reprezen.swaggerparser.model3.SecurityParameter;
import com.reprezen.swaggerparser.model3.SecurityRequirement;
import com.reprezen.swaggerparser.ovl3.SecurityParameterImpl;
import com.reprezen.swaggerparser.ovl3.SwaggerObjectImpl;
import java.util.Map;
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
    private MapOverlay<SecurityParameterImpl> requirements = registerField("", "requirements", null, new MapOverlay<SecurityParameterImpl>("", this, SecurityParameterImpl.factory, null));

    // Requirement
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, ? extends SecurityParameter> getRequirements() {
        return requirements.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasRequirement(String name) {
        return requirements.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public SecurityParameter getRequirement(String name) {
        return requirements.get(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setRequirements(Map<String, ? extends SecurityParameter> requirements) {
        @SuppressWarnings("unchecked")
            Map<String,SecurityParameterImpl> implRequirements = (Map<String, SecurityParameterImpl>) requirements;
            this.requirements.set(implRequirements);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setRequirement(String name, SecurityParameter requirement) {
        requirements.set(name, (SecurityParameterImpl) requirement);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeRequirement(String name) {
        requirements.remove(name);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public static JsonOverlayFactory<SecurityRequirementImpl> factory = new JsonOverlayFactory<SecurityRequirementImpl>() {
    @Override
    public SecurityRequirementImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, SecurityRequirementImpl.class) ? null : new SecurityRequirementImpl(key, json, parent);
    }
};

}
