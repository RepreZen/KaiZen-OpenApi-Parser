package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.kaizen.oasparser.jsonoverlay.ObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildListOverlay;
import com.reprezen.kaizen.oasparser.ovl3.OAuthFlowImpl;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import java.util.Collection;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildOverlay;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.jsonoverlay.PropertiesOverlay;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.Map;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.IJsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;

public class SecuritySchemeImpl extends PropertiesOverlay<SecurityScheme> implements SecurityScheme {

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecuritySchemeImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SecuritySchemeImpl(SecurityScheme securityScheme, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(securityScheme, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> type = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> description = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> name = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> in = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> scheme = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> bearerFormat = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<OAuthFlow> implicitOAuthFlow = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<OAuthFlow> passwordOAuthFlow = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<OAuthFlow> clientCredentialsOAuthFlow = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<OAuthFlow> authorizationCodeOAuthFlow = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object> oAuthFlowsExtensions = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> openIdConnectUrl = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object> extensions = null;

    // Type
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getType() {
        return type.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getType(boolean elaborate) {
        return type.get(elaborate);
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
    public String getDescription(boolean elaborate) {
        return description.get(elaborate);
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
    public String getName(boolean elaborate) {
        return name.get(elaborate);
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
    public String getIn(boolean elaborate) {
        return in.get(elaborate);
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
    public String getScheme(boolean elaborate) {
        return scheme.get(elaborate);
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
    public String getBearerFormat(boolean elaborate) {
        return bearerFormat.get(elaborate);
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
    public OAuthFlow getImplicitOAuthFlow(boolean elaborate) {
        return implicitOAuthFlow.get(elaborate);
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
    public OAuthFlow getPasswordOAuthFlow(boolean elaborate) {
        return passwordOAuthFlow.get(elaborate);
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
    public OAuthFlow getClientCredentialsOAuthFlow(boolean elaborate) {
        return clientCredentialsOAuthFlow.get(elaborate);
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
    public OAuthFlow getAuthorizationCodeOAuthFlow(boolean elaborate) {
        return authorizationCodeOAuthFlow.get(elaborate);
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
    public Map<String, Object> getOAuthFlowsExtensions(boolean elaborate) {
        return oAuthFlowsExtensions.get(elaborate);
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
    public String getOpenIdConnectUrl(boolean elaborate) {
        return openIdConnectUrl.get(elaborate);
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
    public Map<String, Object> getExtensions(boolean elaborate) {
        return extensions.get(elaborate);
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

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    protected void elaborateChildren() {
        type = createChild("type", this, StringOverlay.factory);
        description = createChild("description", this, StringOverlay.factory);
        name = createChild("name", this, StringOverlay.factory);
        in = createChild("in", this, StringOverlay.factory);
        scheme = createChild("scheme", this, StringOverlay.factory);
        bearerFormat = createChild("bearerFormat", this, StringOverlay.factory);
        implicitOAuthFlow = createChild("flow/implicit", this, OAuthFlowImpl.factory);
        passwordOAuthFlow = createChild("flow/password", this, OAuthFlowImpl.factory);
        clientCredentialsOAuthFlow = createChild("flow/clientCredentials", this, OAuthFlowImpl.factory);
        authorizationCodeOAuthFlow = createChild("flow/authorizationCode", this, OAuthFlowImpl.factory);
        oAuthFlowsExtensions = createChildMap("flow", this, ObjectOverlay.factory, "x-.+");
        openIdConnectUrl = createChild("openIdConnectUrl", this, StringOverlay.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<SecurityScheme> factory = new OverlayFactory<SecurityScheme>() {

        @Override
        protected Class<? extends IJsonOverlay<? super SecurityScheme>> getOverlayClass() {
            return SecuritySchemeImpl.class;
        }

        @Override
        public JsonOverlay<SecurityScheme> _create(SecurityScheme securityScheme, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            Class<? extends SecurityScheme> subtype = getSubtypeOf(securityScheme);
            IJsonOverlay<?> overlay;
            if (subtype == null || subtype == SecurityScheme.class) {
                overlay = new SecuritySchemeImpl(securityScheme, parent, refReg);
            } else {
                switch(subtype.getSimpleName()) {
                    default:
                        overlay = null;
                }
            }
            @SuppressWarnings("unchecked") JsonOverlay<SecurityScheme> castOverlay = (JsonOverlay<SecurityScheme>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<SecurityScheme> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            Class<? extends SecurityScheme> subtype = getSubtypeOf(json);
            IJsonOverlay<?> overlay;
            if (subtype == null || subtype == SecurityScheme.class) {
                overlay = new SecuritySchemeImpl(json, parent, refReg);
            } else {
                switch(subtype.getSimpleName()) {
                    default:
                        overlay = null;
                }
            }
            @SuppressWarnings("unchecked") JsonOverlay<SecurityScheme> castOverlay = (JsonOverlay<SecurityScheme>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends SecurityScheme> getSubtypeOf(SecurityScheme securityScheme) {
        return SecurityScheme.class;
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends SecurityScheme> getSubtypeOf(JsonNode json) {
        return SecurityScheme.class;
    }
}
