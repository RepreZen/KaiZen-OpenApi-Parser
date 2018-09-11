package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.Builder;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;

public class SecuritySchemeImpl extends PropertiesOverlay<SecurityScheme> implements SecurityScheme {

	private Overlay<SecurityScheme> overlay = Overlay.of(this);

	@Override
	public String getKey() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public SecuritySchemeImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public SecuritySchemeImpl(SecurityScheme securityScheme, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(securityScheme, parent, factory, refMgr);
	}

	// Type
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getType() {
		return _get("type", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setType(String type) {
		_setScalar("type", type, String.class);
	}

	// Description
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getDescription() {
		return _get("description", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDescription(String description) {
		_setScalar("description", description, String.class);
	}

	// Name
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getName() {
		return _get("name", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setName(String name) {
		_setScalar("name", name, String.class);
	}

	// In
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getIn() {
		return _get("in", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setIn(String in) {
		_setScalar("in", in, String.class);
	}

	// Scheme
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getScheme() {
		return _get("scheme", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setScheme(String scheme) {
		_setScalar("scheme", scheme, String.class);
	}

	// BearerFormat
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getBearerFormat() {
		return _get("bearerFormat", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setBearerFormat(String bearerFormat) {
		_setScalar("bearerFormat", bearerFormat, String.class);
	}

	// ImplicitOAuthFlow
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getImplicitOAuthFlow() {
		return _get("implicitOAuthFlow", OAuthFlow.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getImplicitOAuthFlow(boolean elaborate) {
		return _get("implicitOAuthFlow", elaborate, OAuthFlow.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow) {
		_setScalar("implicitOAuthFlow", implicitOAuthFlow, OAuthFlow.class);
	}

	// PasswordOAuthFlow
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getPasswordOAuthFlow() {
		return _get("passwordOAuthFlow", OAuthFlow.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getPasswordOAuthFlow(boolean elaborate) {
		return _get("passwordOAuthFlow", elaborate, OAuthFlow.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow) {
		_setScalar("passwordOAuthFlow", passwordOAuthFlow, OAuthFlow.class);
	}

	// ClientCredentialsOAuthFlow
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getClientCredentialsOAuthFlow() {
		return _get("clientCredentialsOAuthFlow", OAuthFlow.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getClientCredentialsOAuthFlow(boolean elaborate) {
		return _get("clientCredentialsOAuthFlow", elaborate, OAuthFlow.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow) {
		_setScalar("clientCredentialsOAuthFlow", clientCredentialsOAuthFlow, OAuthFlow.class);
	}

	// AuthorizationCodeOAuthFlow
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getAuthorizationCodeOAuthFlow() {
		return _get("authorizationCodeOAuthFlow", OAuthFlow.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getAuthorizationCodeOAuthFlow(boolean elaborate) {
		return _get("authorizationCodeOAuthFlow", elaborate, OAuthFlow.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow) {
		_setScalar("authorizationCodeOAuthFlow", authorizationCodeOAuthFlow, OAuthFlow.class);
	}

	// OAuthFlowsExtension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getOAuthFlowsExtensions() {
		return _getMap("oAuthFlowsExtensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getOAuthFlowsExtensions(boolean elaborate) {
		return _getMap("oAuthFlowsExtensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasOAuthFlowsExtensions() {
		return _isPresent("oAuthFlowsExtensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasOAuthFlowsExtension(String name) {
		return _getMap("oAuthFlowsExtensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getOAuthFlowsExtension(String name) {
		return _get("oAuthFlowsExtensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions) {
		_setMap("oAuthFlowsExtensions", oAuthFlowsExtensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension) {
		_set("oAuthFlowsExtensions", name, oAuthFlowsExtension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeOAuthFlowsExtension(String name) {
		_remove("oAuthFlowsExtensions", name, Object.class);
	}

	// OpenIdConnectUrl
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getOpenIdConnectUrl() {
		return _get("openIdConnectUrl", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOpenIdConnectUrl(String openIdConnectUrl) {
		_setScalar("openIdConnectUrl", openIdConnectUrl, String.class);
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
	public static final String F_type = "type";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_description = "description";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_name = "name";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_in = "in";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_scheme = "scheme";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_bearerFormat = "bearerFormat";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_implicitOAuthFlow = "implicitOAuthFlow";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_passwordOAuthFlow = "passwordOAuthFlow";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_clientCredentialsOAuthFlow = "clientCredentialsOAuthFlow";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_authorizationCodeOAuthFlow = "authorizationCodeOAuthFlow";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_oAuthFlowsExtensions = "oAuthFlowsExtensions";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_openIdConnectUrl = "openIdConnectUrl";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("type", "type", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("name", "name", StringOverlay.factory);
		_createScalar("in", "in", StringOverlay.factory);
		_createScalar("scheme", "scheme", StringOverlay.factory);
		_createScalar("bearerFormat", "bearerFormat", StringOverlay.factory);
		_createScalar("implicitOAuthFlow", "flow/implicit", OAuthFlowImpl.factory);
		_createScalar("passwordOAuthFlow", "flow/password", OAuthFlowImpl.factory);
		_createScalar("clientCredentialsOAuthFlow", "flow/clientCredentials", OAuthFlowImpl.factory);
		_createScalar("authorizationCodeOAuthFlow", "flow/authorizationCode", OAuthFlowImpl.factory);
		_createMap("oAuthFlowsExtensions", "flow", ObjectOverlay.factory, "x-.+");
		_createScalar("openIdConnectUrl", "openIdConnectUrl", StringOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<SecurityScheme> factory = new OverlayFactory<SecurityScheme>() {

		@Override
		protected Class<? extends JsonOverlay<? super SecurityScheme>> getOverlayClass() {
			return SecuritySchemeImpl.class;
		}

		@Override
		public JsonOverlay<SecurityScheme> _create(SecurityScheme securityScheme, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SecuritySchemeImpl(securityScheme, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityScheme> castOverlay = (JsonOverlay<SecurityScheme>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<SecurityScheme> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SecuritySchemeImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityScheme> castOverlay = (JsonOverlay<SecurityScheme>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends SecurityScheme> getSubtypeOf(SecurityScheme securityScheme) {
		return SecurityScheme.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends SecurityScheme> getSubtypeOf(JsonNode json) {
		return SecurityScheme.class;
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
	public static <OV extends IJsonOverlay<?>> Builder<SecurityScheme> builder(OV modelMember) {
		return new Builder<SecurityScheme>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> SecurityScheme create(OV modelMember) {
		return (SecurityScheme) builder(modelMember).build();
	}
}
