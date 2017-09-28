package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;

public class SecuritySchemeImpl extends OpenApiObjectImpl<SecurityScheme, SecuritySchemeImpl>
		implements SecurityScheme {

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public SecuritySchemeImpl(String key, JsonNode json, JsonOverlay<?> parent) {
		super(key, json, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public SecuritySchemeImpl(String key, JsonOverlay<?> parent) {
		super(key, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay type = new StringOverlay("type", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay description = new StringOverlay("description", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay name = new StringOverlay("name", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay in = new StringOverlay("in", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay scheme = new StringOverlay("scheme", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay bearerFormat = new StringOverlay("bearerFormat", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private OAuthFlowImpl implicitOAuthFlow = OAuthFlowImpl.factory.create("flow/implicit", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private OAuthFlowImpl passwordOAuthFlow = OAuthFlowImpl.factory.create("flow/password", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private OAuthFlowImpl clientCredentialsOAuthFlow = OAuthFlowImpl.factory.create("flow/clientCredentials", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private OAuthFlowImpl authorizationCodeOAuthFlow = OAuthFlowImpl.factory.create("flow/authorizationCode", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> oAuthFlowsExtensions = new ValMapOverlay<Object, AnyObjectOverlay>(
			"flow", this, AnyObjectOverlay.factory, "x-.+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay openIdConnectUrl = new StringOverlay("openIdConnectUrl", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> extensions = new ValMapOverlay<Object, AnyObjectOverlay>("", this,
			AnyObjectOverlay.factory, "x-.+");

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
		return implicitOAuthFlow;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow) {
		this.implicitOAuthFlow.set((OAuthFlowImpl) implicitOAuthFlow);
	}

	// PasswordOAuthFlow
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getPasswordOAuthFlow() {
		return passwordOAuthFlow;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow) {
		this.passwordOAuthFlow.set((OAuthFlowImpl) passwordOAuthFlow);
	}

	// ClientCredentialsOAuthFlow
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getClientCredentialsOAuthFlow() {
		return clientCredentialsOAuthFlow;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow) {
		this.clientCredentialsOAuthFlow.set((OAuthFlowImpl) clientCredentialsOAuthFlow);
	}

	// AuthorizationCodeOAuthFlow
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OAuthFlow getAuthorizationCodeOAuthFlow() {
		return authorizationCodeOAuthFlow;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow) {
		this.authorizationCodeOAuthFlow.set((OAuthFlowImpl) authorizationCodeOAuthFlow);
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
	public static JsonOverlayFactory<SecuritySchemeImpl> factory = new JsonOverlayFactory<SecuritySchemeImpl>() {
		@Override
		public SecuritySchemeImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
			return isEmptyRecursive(parent, SecuritySchemeImpl.class) ? null
					: new SecuritySchemeImpl(key, json, parent);
		}
	};

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	protected void installPropertyAccessors(PropertyAccessors accessors) {
		OverlayGetter getter = null;
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return type;
			}
		};
		accessors.add("type", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return description;
			}
		};
		accessors.add("description", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return name;
			}
		};
		accessors.add("name", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return in;
			}
		};
		accessors.add("in", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return scheme;
			}
		};
		accessors.add("scheme", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return bearerFormat;
			}
		};
		accessors.add("bearerFormat", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return implicitOAuthFlow;
			}
		};
		accessors.add("flow/implicit", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return passwordOAuthFlow;
			}
		};
		accessors.add("flow/password", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return clientCredentialsOAuthFlow;
			}
		};
		accessors.add("flow/clientCredentials", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return authorizationCodeOAuthFlow;
			}
		};
		accessors.add("flow/authorizationCode", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return oAuthFlowsExtensions;
			}
		};
		accessors.add("flow", "x-.+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return openIdConnectUrl;
			}
		};
		accessors.add("openIdConnectUrl", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return extensions;
			}
		};
		accessors.add("", "x-.+", getter);
	}

}
