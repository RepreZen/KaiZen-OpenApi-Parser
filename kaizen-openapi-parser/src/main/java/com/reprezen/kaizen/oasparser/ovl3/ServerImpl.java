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
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;

public class ServerImpl extends PropertiesOverlay<Server> implements Server {

	@Generated("com.reprezen.gen.CodeGenerator")
	public ServerImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public ServerImpl(Server server, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(server, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> url;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<ServerVariable> serverVariables;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> variablesExtensions;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Url
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getUrl() {
		return url._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getUrl(boolean elaborate) {
		return url._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setUrl(String url) {
		this.url._set(url);
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

	// ServerVariable
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, ServerVariable> getServerVariables() {
		return serverVariables._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, ServerVariable> getServerVariables(boolean elaborate) {
		return serverVariables._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasServerVariable(String name) {
		return serverVariables.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public ServerVariable getServerVariable(String name) {
		return serverVariables._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setServerVariables(Map<String, ServerVariable> serverVariables) {
		this.serverVariables._set(serverVariables);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setServerVariable(String name, ServerVariable serverVariable) {
		serverVariables._set(name, serverVariable);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeServerVariable(String name) {
		serverVariables._remove(name);
	}

	// VariablesExtension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getVariablesExtensions() {
		return variablesExtensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getVariablesExtensions(boolean elaborate) {
		return variablesExtensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasVariablesExtension(String name) {
		return variablesExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getVariablesExtension(String name) {
		return variablesExtensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setVariablesExtensions(Map<String, Object> variablesExtensions) {
		this.variablesExtensions._set(variablesExtensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setVariablesExtension(String name, Object variablesExtension) {
		variablesExtensions._set(name, variablesExtension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeVariablesExtension(String name) {
		variablesExtensions._remove(name);
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
		url = createChild("url", this, StringOverlay.factory);
		description = createChild("description", this, StringOverlay.factory);
		serverVariables = createChildMap("variables", this, ServerVariableImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		variablesExtensions = createChildMap("variables", this, ObjectOverlay.factory, "x-.+");
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<Server> factory = new OverlayFactory<Server>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super Server>> getOverlayClass() {
			return ServerImpl.class;
		}

		@Override
		public JsonOverlay<Server> _create(Server server, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new ServerImpl(server, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Server> castOverlay = (JsonOverlay<Server>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Server> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new ServerImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Server> castOverlay = (JsonOverlay<Server>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Server> getSubtypeOf(Server server) {
		return Server.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Server> getSubtypeOf(JsonNode json) {
		return Server.class;
	}
}
