package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.kaizen.oasparser.jsonoverlay.ObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import java.util.Collection;
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

public class OAuthFlowImpl extends PropertiesOverlay<OAuthFlow> implements OAuthFlow {

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
    private ChildOverlay<String> authorizationUrl;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> tokenUrl;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> refreshUrl;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<String> scopes;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object> scopesExtensions;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object> extensions;

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
    public static OverlayFactory<OAuthFlow> factory = new OverlayFactory<OAuthFlow>() {

        @Override
        protected Class<? extends IJsonOverlay<? super OAuthFlow>> getOverlayClass() {
            return OAuthFlowImpl.class;
        }

        @Override
        public JsonOverlay<OAuthFlow> _create(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            Class<? extends OAuthFlow> subtype = getSubtypeOf(oAuthFlow);
            IJsonOverlay<?> overlay;
            if (subtype == null || subtype == OAuthFlow.class) {
                overlay = new OAuthFlowImpl(oAuthFlow, parent, refReg);
            } else {
                switch(subtype.getSimpleName()) {
                    default:
                        overlay = null;
                }
            }
            @SuppressWarnings("unchecked") JsonOverlay<OAuthFlow> castOverlay = (JsonOverlay<OAuthFlow>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<OAuthFlow> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            Class<? extends OAuthFlow> subtype = getSubtypeOf(json);
            IJsonOverlay<?> overlay;
            if (subtype == null || subtype == OAuthFlow.class) {
                overlay = new OAuthFlowImpl(json, parent, refReg);
            } else {
                switch(subtype.getSimpleName()) {
                    default:
                        overlay = null;
                }
            }
            @SuppressWarnings("unchecked") JsonOverlay<OAuthFlow> castOverlay = (JsonOverlay<OAuthFlow>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends OAuthFlow> getSubtypeOf(OAuthFlow oAuthFlow) {
        return OAuthFlow.class;
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends OAuthFlow> getSubtypeOf(JsonNode json) {
        return OAuthFlow.class;
    }
}
