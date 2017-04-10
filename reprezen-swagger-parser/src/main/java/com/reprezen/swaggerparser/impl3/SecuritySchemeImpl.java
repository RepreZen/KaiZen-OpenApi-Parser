/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.impl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.impl3.OAuthFlowImpl;
import com.reprezen.swaggerparser.impl3.SwaggerObjectImpl;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValMapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.AnyObjectOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.StringOverlay;
import com.reprezen.swaggerparser.model3.OAuthFlow;
import com.reprezen.swaggerparser.model3.SecurityScheme;
import java.util.Map;
import javax.annotation.Generated;

public class SecuritySchemeImpl extends SwaggerObjectImpl implements SecurityScheme {

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public SecuritySchemeImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public SecuritySchemeImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay type = registerField("type", "type", null, new StringOverlay("type", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay description = registerField("description", "description", null, new StringOverlay("description", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay name = registerField("name", "name", null, new StringOverlay("name", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay in = registerField("in", "in", null, new StringOverlay("in", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay scheme = registerField("scheme", "scheme", null, new StringOverlay("scheme", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay bearerFormat = registerField("bearerFormat", "bearerFormat", null, new StringOverlay("bearerFormat", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private OAuthFlowImpl implicitOAuthFlow = registerField("flow/implicit", "implicitOAuthFlow", null, OAuthFlowImpl.factory.create("flow/implicit", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private OAuthFlowImpl passwordOAuthFlow = registerField("flow/password", "passwordOAuthFlow", null, OAuthFlowImpl.factory.create("flow/password", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private OAuthFlowImpl clientCredentialsOAuthFlow = registerField("flow/clientCredentials", "clientCredentialsOAuthFlow", null, OAuthFlowImpl.factory.create("flow/clientCredentials", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private OAuthFlowImpl authorizationCodeOAuthFlow = registerField("flow/authorizationCode", "authorizationCodeOAuthFlow", null, OAuthFlowImpl.factory.create("flow/authorizationCode", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object,AnyObjectOverlay> oAuthFlowsExtensions = registerField("flow", "oAuthFlowsExtensions", "x-.*", new ValMapOverlay<Object, AnyObjectOverlay>("flow", this, AnyObjectOverlay.factory, "x-.*"));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay openIdConnectUrl = registerField("openIdConnectUrl", "openIdConnectUrl", null, new StringOverlay("openIdConnectUrl", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object,AnyObjectOverlay> extensions = registerField("", "extensions", "x-.*", new ValMapOverlay<Object, AnyObjectOverlay>("", this, AnyObjectOverlay.factory, "x-.*"));

    // Type
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getType() {
        return type.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setType(String type) {
        this.type.set(type);
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

    // Name
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getName() {
        return name.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setName(String name) {
        this.name.set(name);
    }

    // In
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getIn() {
        return in.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setIn(String in) {
        this.in.set(in);
    }

    // Scheme
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getScheme() {
        return scheme.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setScheme(String scheme) {
        this.scheme.set(scheme);
    }

    // BearerFormat
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getBearerFormat() {
        return bearerFormat.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setBearerFormat(String bearerFormat) {
        this.bearerFormat.set(bearerFormat);
    }

    // ImplicitOAuthFlow
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public OAuthFlow getImplicitOAuthFlow() {
        return implicitOAuthFlow;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow) {
        this.implicitOAuthFlow.set((OAuthFlowImpl) implicitOAuthFlow);
    }

    // PasswordOAuthFlow
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public OAuthFlow getPasswordOAuthFlow() {
        return passwordOAuthFlow;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow) {
        this.passwordOAuthFlow.set((OAuthFlowImpl) passwordOAuthFlow);
    }

    // ClientCredentialsOAuthFlow
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public OAuthFlow getClientCredentialsOAuthFlow() {
        return clientCredentialsOAuthFlow;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow) {
        this.clientCredentialsOAuthFlow.set((OAuthFlowImpl) clientCredentialsOAuthFlow);
    }

    // AuthorizationCodeOAuthFlow
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public OAuthFlow getAuthorizationCodeOAuthFlow() {
        return authorizationCodeOAuthFlow;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow) {
        this.authorizationCodeOAuthFlow.set((OAuthFlowImpl) authorizationCodeOAuthFlow);
    }

    // OAuthFlowsExtension
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getOAuthFlowsExtensions() {
        return oAuthFlowsExtensions.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasOAuthFlowsExtension(String name) {
        return oAuthFlowsExtensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Object getOAuthFlowsExtension(String name) {
        return oAuthFlowsExtensions.get(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions) {
        this.oAuthFlowsExtensions.set(oAuthFlowsExtensions);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension) {
        oAuthFlowsExtensions.set(name, oAuthFlowsExtension);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeOAuthFlowsExtension(String name) {
        oAuthFlowsExtensions.remove(name);
    }

    // OpenIdConnectUrl
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getOpenIdConnectUrl() {
        return openIdConnectUrl.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setOpenIdConnectUrl(String openIdConnectUrl) {
        this.openIdConnectUrl.set(openIdConnectUrl);
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
    public static JsonOverlayFactory<SecuritySchemeImpl> factory = new JsonOverlayFactory<SecuritySchemeImpl>() {
    @Override
    public SecuritySchemeImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, SecuritySchemeImpl.class) ? null : new SecuritySchemeImpl(key, json, parent);
    }
};

}
