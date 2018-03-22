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
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;

public class SecuritySchemeImpl extends PropertiesOverlay<SecurityScheme> implements SecurityScheme {

	@Generated("com.reprezen.gen.CodeGenerator")
	public SecuritySchemeImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public SecuritySchemeImpl(SecurityScheme securityScheme, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(securityScheme, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> type;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> name;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> in;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> scheme;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> bearerFormat;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<OAuthFlow> implicitOAuthFlow;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<OAuthFlow> passwordOAuthFlow;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<OAuthFlow> clientCredentialsOAuthFlow;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<OAuthFlow> authorizationCodeOAuthFlow;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> oAuthFlowsExtensions;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> openIdConnectUrl;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Type
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getType() {
		return type._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getType(boolean elaborate) {
		return type._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setType(String type) {
		this.type._set(type);
	}

	// Description
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getDescription() {
		return description._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getDescription(boolean elaborate) {
		return description._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setDescription(String description) {
		this.description._set(description);
	}

	// Name
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getName() {
		return name._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getName(boolean elaborate) {
		return name._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setName(String name) {
		this.name._set(name);
	}

	// In
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getIn() {
		return in._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getIn(boolean elaborate) {
		return in._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setIn(String in) {
		this.in._set(in);
	}

	// Scheme
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getScheme() {
		return scheme._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getScheme(boolean elaborate) {
		return scheme._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setScheme(String scheme) {
		this.scheme._set(scheme);
	}

	// BearerFormat
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getBearerFormat() {
		return bearerFormat._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getBearerFormat(boolean elaborate) {
		return bearerFormat._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setBearerFormat(String bearerFormat) {
		this.bearerFormat._set(bearerFormat);
	}

	// ImplicitOAuthFlow
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public OAuthFlow getImplicitOAuthFlow() {
		return implicitOAuthFlow._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public OAuthFlow getImplicitOAuthFlow(boolean elaborate) {
		return implicitOAuthFlow._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow) {
		this.implicitOAuthFlow._set(implicitOAuthFlow);
	}

	// PasswordOAuthFlow
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public OAuthFlow getPasswordOAuthFlow() {
		return passwordOAuthFlow._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public OAuthFlow getPasswordOAuthFlow(boolean elaborate) {
		return passwordOAuthFlow._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow) {
		this.passwordOAuthFlow._set(passwordOAuthFlow);
	}

	// ClientCredentialsOAuthFlow
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public OAuthFlow getClientCredentialsOAuthFlow() {
		return clientCredentialsOAuthFlow._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public OAuthFlow getClientCredentialsOAuthFlow(boolean elaborate) {
		return clientCredentialsOAuthFlow._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow) {
		this.clientCredentialsOAuthFlow._set(clientCredentialsOAuthFlow);
	}

	// AuthorizationCodeOAuthFlow
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public OAuthFlow getAuthorizationCodeOAuthFlow() {
		return authorizationCodeOAuthFlow._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public OAuthFlow getAuthorizationCodeOAuthFlow(boolean elaborate) {
		return authorizationCodeOAuthFlow._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow) {
		this.authorizationCodeOAuthFlow._set(authorizationCodeOAuthFlow);
	}

	// OAuthFlowsExtension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getOAuthFlowsExtensions() {
		return oAuthFlowsExtensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getOAuthFlowsExtensions(boolean elaborate) {
		return oAuthFlowsExtensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasOAuthFlowsExtension(String name) {
		return oAuthFlowsExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getOAuthFlowsExtension(String name) {
		return oAuthFlowsExtensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions) {
		this.oAuthFlowsExtensions._set(oAuthFlowsExtensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension) {
		oAuthFlowsExtensions._set(name, oAuthFlowsExtension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeOAuthFlowsExtension(String name) {
		oAuthFlowsExtensions._remove(name);
	}

	// OpenIdConnectUrl
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getOpenIdConnectUrl() {
		return openIdConnectUrl._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getOpenIdConnectUrl(boolean elaborate) {
		return openIdConnectUrl._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setOpenIdConnectUrl(String openIdConnectUrl) {
		this.openIdConnectUrl._set(openIdConnectUrl);
	}

	// Extension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return extensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions._set(extensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions._set(name, extension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions._remove(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	protected void elaborateChildren() {
		super.elaborateChildren();
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

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<SecurityScheme> factory = new OverlayFactory<SecurityScheme>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super SecurityScheme>> getOverlayClass() {
			return SecuritySchemeImpl.class;
		}

		@Override
		public JsonOverlay<SecurityScheme> _create(SecurityScheme securityScheme, JsonOverlay<?> parent,
				ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new SecuritySchemeImpl(securityScheme, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityScheme> castOverlay = (JsonOverlay<SecurityScheme>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<SecurityScheme> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new SecuritySchemeImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityScheme> castOverlay = (JsonOverlay<SecurityScheme>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends SecurityScheme> getSubtypeOf(SecurityScheme securityScheme) {
		return SecurityScheme.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends SecurityScheme> getSubtypeOf(JsonNode json) {
		return SecurityScheme.class;
	}
}
