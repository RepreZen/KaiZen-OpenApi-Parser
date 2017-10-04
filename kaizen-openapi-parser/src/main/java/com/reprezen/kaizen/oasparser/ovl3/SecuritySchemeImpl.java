package com.reprezen.kaizen.oasparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;
import com.reprezen.kaizen.oasparser.ovl3.ChildListOverlay;
import com.reprezen.kaizen.oasparser.ovl3.OAuthFlowImpl;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class SecuritySchemeImpl extends OpenApiObjectImpl<SecurityScheme> implements SecurityScheme {

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecuritySchemeImpl(JsonNode json, ReferenceRegistry refReg) {
        super(json, refReg);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecuritySchemeImpl(SecurityScheme securityScheme, ReferenceRegistry refReg) {
        super(securityScheme, refReg);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> type = createChild("type", StringOverlay.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> description = createChild("description", StringOverlay.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> name = createChild("name", StringOverlay.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> in = createChild("in", StringOverlay.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> scheme = createChild("scheme", StringOverlay.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> bearerFormat = createChild("bearerFormat", StringOverlay.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<OAuthFlow, OAuthFlowImpl> implicitOAuthFlow = createChild("flow/implicit", OAuthFlowImpl.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<OAuthFlow, OAuthFlowImpl> passwordOAuthFlow = createChild("flow/password", OAuthFlowImpl.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<OAuthFlow, OAuthFlowImpl> clientCredentialsOAuthFlow = createChild("flow/clientCredentials", OAuthFlowImpl.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<OAuthFlow, OAuthFlowImpl> authorizationCodeOAuthFlow = createChild("flow/authorizationCode", OAuthFlowImpl.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object, ObjectOverlay> oAuthFlowsExtensions = createChildMap("flow", ObjectOverlay.factory, "x-.+");

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> openIdConnectUrl = createChild("openIdConnectUrl", StringOverlay.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object, ObjectOverlay> extensions = createChildMap("", ObjectOverlay.factory, "x-.+");

    // Type
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getType() {
        return type.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setType(String type) {
        this.type.set(type);
    }

    // Description
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getDescription() {
        return description.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setDescription(String description) {
        this.description.set(description);
    }

    // Name
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getName() {
        return name.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setName(String name) {
        this.name.set(name);
    }

    // In
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getIn() {
        return in.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setIn(String in) {
        this.in.set(in);
    }

    // Scheme
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getScheme() {
        return scheme.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setScheme(String scheme) {
        this.scheme.set(scheme);
    }

    // BearerFormat
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getBearerFormat() {
        return bearerFormat.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setBearerFormat(String bearerFormat) {
        this.bearerFormat.set(bearerFormat);
    }

    // ImplicitOAuthFlow
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public OAuthFlow getImplicitOAuthFlow() {
        return implicitOAuthFlow.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow) {
        this.implicitOAuthFlow.set(implicitOAuthFlow);
    }

    // PasswordOAuthFlow
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public OAuthFlow getPasswordOAuthFlow() {
        return passwordOAuthFlow.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow) {
        this.passwordOAuthFlow.set(passwordOAuthFlow);
    }

    // ClientCredentialsOAuthFlow
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public OAuthFlow getClientCredentialsOAuthFlow() {
        return clientCredentialsOAuthFlow.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow) {
        this.clientCredentialsOAuthFlow.set(clientCredentialsOAuthFlow);
    }

    // AuthorizationCodeOAuthFlow
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public OAuthFlow getAuthorizationCodeOAuthFlow() {
        return authorizationCodeOAuthFlow.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow) {
        this.authorizationCodeOAuthFlow.set(authorizationCodeOAuthFlow);
    }

    // OAuthFlowsExtension
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getOAuthFlowsExtensions() {
        return oAuthFlowsExtensions.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasOAuthFlowsExtension(String name) {
        return oAuthFlowsExtensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Object getOAuthFlowsExtension(String name) {
        return oAuthFlowsExtensions.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions) {
        this.oAuthFlowsExtensions.set(oAuthFlowsExtensions);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension) {
        oAuthFlowsExtensions.set(name, oAuthFlowsExtension);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeOAuthFlowsExtension(String name) {
        oAuthFlowsExtensions.remove(name);
    }

    // OpenIdConnectUrl
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getOpenIdConnectUrl() {
        return openIdConnectUrl.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setOpenIdConnectUrl(String openIdConnectUrl) {
        this.openIdConnectUrl.set(openIdConnectUrl);
    }

    // Extension
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<SecurityScheme, SecuritySchemeImpl> factory = new OverlayFactory<SecurityScheme, SecuritySchemeImpl>() {
    @Override
    protected Class<? super SecuritySchemeImpl> getOverlayClass() {
         return SecuritySchemeImpl.class;
    }

    @Override
    public SecuritySchemeImpl _create(SecurityScheme securityScheme, ReferenceRegistry refReg) {
        return new SecuritySchemeImpl(securityScheme, refReg);
    }

    @Override
    public SecuritySchemeImpl _create(JsonNode json, ReferenceRegistry refReg) {
        return new SecuritySchemeImpl(json, refReg);
    }
};

}
