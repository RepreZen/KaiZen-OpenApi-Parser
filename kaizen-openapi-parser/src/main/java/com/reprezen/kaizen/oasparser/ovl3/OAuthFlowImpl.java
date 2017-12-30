package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.kaizen.oasparser.jsonoverlay.ObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import java.util.Collection;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildOverlay;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import java.util.Map;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;

public class OAuthFlowImpl extends OpenApiObjectImpl<OpenApi3, OAuthFlow> implements OAuthFlow {

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public OAuthFlowImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public OAuthFlowImpl(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(oAuthFlow, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> authorizationUrl = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> tokenUrl = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> refreshUrl = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<String, StringOverlay> scopes = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object, ObjectOverlay> scopesExtensions = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // AuthorizationUrl
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getAuthorizationUrl() {
        return authorizationUrl.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getAuthorizationUrl(boolean elaborate) {
        return authorizationUrl.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl.set(authorizationUrl);
    }

    // TokenUrl
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getTokenUrl() {
        return tokenUrl.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getTokenUrl(boolean elaborate) {
        return tokenUrl.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl.set(tokenUrl);
    }

    // RefreshUrl
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getRefreshUrl() {
        return refreshUrl.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getRefreshUrl(boolean elaborate) {
        return refreshUrl.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl.set(refreshUrl);
    }

    // Scope
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, String> getScopes() {
        return scopes.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, String> getScopes(boolean elaborate) {
        return scopes.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasScope(String name) {
        return scopes.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getScope(String name) {
        return scopes.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setScopes(Map<String, String> scopes) {
        this.scopes.set(scopes);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setScope(String name, String scope) {
        scopes.set(name, scope);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeScope(String name) {
        scopes.remove(name);
    }

    // ScopesExtension
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getScopesExtensions() {
        return scopesExtensions.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getScopesExtensions(boolean elaborate) {
        return scopesExtensions.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasScopesExtension(String name) {
        return scopesExtensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Object getScopesExtension(String name) {
        return scopesExtensions.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setScopesExtensions(Map<String, Object> scopesExtensions) {
        this.scopesExtensions.set(scopesExtensions);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setScopesExtension(String name, Object scopesExtension) {
        scopesExtensions.set(name, scopesExtension);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeScopesExtension(String name) {
        scopesExtensions.remove(name);
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
        authorizationUrl = createChild("authorizationUrl", this, StringOverlay.factory);
        tokenUrl = createChild("tokenUrl", this, StringOverlay.factory);
        refreshUrl = createChild("refreshUrl", this, StringOverlay.factory);
        scopes = createChildMap("scopes", this, StringOverlay.factory, "(?!x-).*");
        scopesExtensions = createChildMap("scopes", this, ObjectOverlay.factory, "x-.+");
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<OAuthFlow, OAuthFlowImpl> factory = new OverlayFactory<OAuthFlow, OAuthFlowImpl>() {

        @Override
        protected Class<? super OAuthFlowImpl> getOverlayClass() {
            return OAuthFlowImpl.class;
        }

        @Override
        public OAuthFlowImpl _create(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new OAuthFlowImpl(oAuthFlow, parent, refReg);
        }

        @Override
        public OAuthFlowImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new OAuthFlowImpl(json, parent, refReg);
        }
    };
}
