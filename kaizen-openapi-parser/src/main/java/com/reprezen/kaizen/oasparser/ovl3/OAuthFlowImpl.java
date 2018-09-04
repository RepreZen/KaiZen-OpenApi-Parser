package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.Builder;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;

public class OAuthFlowImpl extends PropertiesOverlay<OAuthFlow> implements OAuthFlow {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlowImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlowImpl(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(oAuthFlow, parent, factory, refMgr);
	}

	// AuthorizationUrl
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getAuthorizationUrl() {
		return _get("authorizationUrl", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAuthorizationUrl(String authorizationUrl) {
		_setScalar("authorizationUrl", authorizationUrl, String.class);
	}

	// TokenUrl
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getTokenUrl() {
		return _get("tokenUrl", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setTokenUrl(String tokenUrl) {
		_setScalar("tokenUrl", tokenUrl, String.class);
	}

	// RefreshUrl
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getRefreshUrl() {
		return _get("refreshUrl", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setRefreshUrl(String refreshUrl) {
		_setScalar("refreshUrl", refreshUrl, String.class);
	}

	// Scope
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, String> getScopes() {
		return _getMap("scopes", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, String> getScopes(boolean elaborate) {
		return _getMap("scopes", elaborate, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasScopes() {
		return _isPresent("scopes");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasScope(String name) {
		return _getMap("scopes", String.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getScope(String name) {
		return _get("scopes", name, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setScopes(Map<String, String> scopes) {
		_setMap("scopes", scopes, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setScope(String name, String scope) {
		_set("scopes", name, scope, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeScope(String name) {
		_remove("scopes", name, String.class);
	}

	// ScopesExtension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getScopesExtensions() {
		return _getMap("scopesExtensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getScopesExtensions(boolean elaborate) {
		return _getMap("scopesExtensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasScopesExtensions() {
		return _isPresent("scopesExtensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasScopesExtension(String name) {
		return _getMap("scopesExtensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getScopesExtension(String name) {
		return _get("scopesExtensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setScopesExtensions(Map<String, Object> scopesExtensions) {
		_setMap("scopesExtensions", scopesExtensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setScopesExtension(String name, Object scopesExtension) {
		_set("scopesExtensions", name, scopesExtension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeScopesExtension(String name) {
		_remove("scopesExtensions", name, Object.class);
	}

	// Extension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return _getMap("extensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return _getMap("extensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtensions() {
		return _isPresent("extensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return _getMap("extensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return _get("extensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		_setMap("extensions", extensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		_set("extensions", name, extension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		_remove("extensions", name, Object.class);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_authorizationUrl = "authorizationUrl";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_tokenUrl = "tokenUrl";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_refreshUrl = "refreshUrl";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_scopes = "scopes";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_scopesExtensions = "scopesExtensions";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("authorizationUrl", "authorizationUrl", StringOverlay.factory);
		_createScalar("tokenUrl", "tokenUrl", StringOverlay.factory);
		_createScalar("refreshUrl", "refreshUrl", StringOverlay.factory);
		_createMap("scopes", "scopes", StringOverlay.factory, "(?!x-).*");
		_createMap("scopesExtensions", "scopes", ObjectOverlay.factory, "x-.+");
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<OAuthFlow> factory = new OverlayFactory<OAuthFlow>() {

		@Override
		protected Class<? extends JsonOverlay<? super OAuthFlow>> getOverlayClass() {
			return OAuthFlowImpl.class;
		}

		@Override
		public JsonOverlay<OAuthFlow> _create(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OAuthFlowImpl(oAuthFlow, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<OAuthFlow> castOverlay = (JsonOverlay<OAuthFlow>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<OAuthFlow> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OAuthFlowImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<OAuthFlow> castOverlay = (JsonOverlay<OAuthFlow>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
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

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Builder<OAuthFlow> builder(OV modelMember) {
		return new Builder<OAuthFlow>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> OAuthFlow create(OV modelMember) {
		return (OAuthFlow) builder(modelMember).build();
	}
}
