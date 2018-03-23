package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;

public class OAuthFlowImpl extends PropertiesOverlay<OAuthFlow> implements OAuthFlow {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlowImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlowImpl(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(oAuthFlow, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> authorizationUrl;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> tokenUrl;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> refreshUrl;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<String> scopes;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> scopesExtensions;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// AuthorizationUrl
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getAuthorizationUrl() {
		return authorizationUrl._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAuthorizationUrl(String authorizationUrl) {
		this.authorizationUrl._set(authorizationUrl);
	}

	// TokenUrl
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getTokenUrl() {
		return tokenUrl._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl._set(tokenUrl);
	}

	// RefreshUrl
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getRefreshUrl() {
		return refreshUrl._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setRefreshUrl(String refreshUrl) {
		this.refreshUrl._set(refreshUrl);
	}

	// Scope
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, String> getScopes() {
		return scopes._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasScope(String name) {
		return scopes.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getScope(String name) {
		return scopes._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setScopes(Map<String, String> scopes) {
		this.scopes._set(scopes);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setScope(String name, String scope) {
		scopes._set(name, scope);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeScope(String name) {
		scopes._remove(name);
	}

	// ScopesExtension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getScopesExtensions() {
		return scopesExtensions._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasScopesExtension(String name) {
		return scopesExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getScopesExtension(String name) {
		return scopesExtensions._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setScopesExtensions(Map<String, Object> scopesExtensions) {
		this.scopesExtensions._set(scopesExtensions);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setScopesExtension(String name, Object scopesExtension) {
		scopesExtensions._set(name, scopesExtension);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeScopesExtension(String name) {
		scopesExtensions._remove(name);
	}

	// Extension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions._set(extensions);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions._set(name, extension);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions._remove(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void elaborateChildren() {
		super.elaborateChildren();
		authorizationUrl = createChild("authorizationUrl", this, StringOverlay.factory);
		tokenUrl = createChild("tokenUrl", this, StringOverlay.factory);
		refreshUrl = createChild("refreshUrl", this, StringOverlay.factory);
		scopes = createChildMap("scopes", this, StringOverlay.factory, "(?!x-).*");
		scopesExtensions = createChildMap("scopes", this, ObjectOverlay.factory, "x-.+");
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<OAuthFlow> factory = new OverlayFactory<OAuthFlow>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super OAuthFlow>> getOverlayClass() {
			return OAuthFlowImpl.class;
		}

		@Override
		public JsonOverlay<OAuthFlow> _create(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new OAuthFlowImpl(oAuthFlow, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<OAuthFlow> castOverlay = (JsonOverlay<OAuthFlow>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<OAuthFlow> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new OAuthFlowImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<OAuthFlow> castOverlay = (JsonOverlay<OAuthFlow>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends OAuthFlow> getSubtypeOf(OAuthFlow oAuthFlow) {
		return OAuthFlow.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends OAuthFlow> getSubtypeOf(JsonNode json) {
		return OAuthFlow.class;
	}
}
