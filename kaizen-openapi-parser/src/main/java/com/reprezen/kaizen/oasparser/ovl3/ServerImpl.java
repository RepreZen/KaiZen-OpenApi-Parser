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
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;

public class ServerImpl extends PropertiesOverlay<Server> implements Server {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ServerImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ServerImpl(Server server, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(server, parent, factory, refMgr);
	}

	// Url
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getUrl() {
		return _get("url", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setUrl(String url) {
		_setScalar("url", url, String.class);
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

	// ServerVariable
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, ServerVariable> getServerVariables() {
		return _getMap("serverVariables", ServerVariable.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, ServerVariable> getServerVariables(boolean elaborate) {
		return _getMap("serverVariables", elaborate, ServerVariable.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasServerVariables() {
		return _isPresent("serverVariables");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasServerVariable(String name) {
		return _getMap("serverVariables", ServerVariable.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ServerVariable getServerVariable(String name) {
		return _get("serverVariables", name, ServerVariable.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setServerVariables(Map<String, ServerVariable> serverVariables) {
		_setMap("serverVariables", serverVariables, ServerVariable.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setServerVariable(String name, ServerVariable serverVariable) {
		_set("serverVariables", name, serverVariable, ServerVariable.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeServerVariable(String name) {
		_remove("serverVariables", name, ServerVariable.class);
	}

	// VariablesExtension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getVariablesExtensions() {
		return _getMap("variablesExtensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getVariablesExtensions(boolean elaborate) {
		return _getMap("variablesExtensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasVariablesExtensions() {
		return _isPresent("variablesExtensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasVariablesExtension(String name) {
		return _getMap("variablesExtensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getVariablesExtension(String name) {
		return _get("variablesExtensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setVariablesExtensions(Map<String, Object> variablesExtensions) {
		_setMap("variablesExtensions", variablesExtensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setVariablesExtension(String name, Object variablesExtension) {
		_set("variablesExtensions", name, variablesExtension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeVariablesExtension(String name) {
		_remove("variablesExtensions", name, Object.class);
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
	public static final String F_url = "url";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_description = "description";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_serverVariables = "serverVariables";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_variablesExtensions = "variablesExtensions";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("url", "url", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createMap("serverVariables", "variables", ServerVariableImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		_createMap("variablesExtensions", "variables", ObjectOverlay.factory, "x-.+");
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Server> factory = new OverlayFactory<Server>() {

		@Override
		protected Class<? extends JsonOverlay<? super Server>> getOverlayClass() {
			return ServerImpl.class;
		}

		@Override
		public JsonOverlay<Server> _create(Server server, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ServerImpl(server, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Server> castOverlay = (JsonOverlay<Server>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Server> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ServerImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Server> castOverlay = (JsonOverlay<Server>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Server> getSubtypeOf(Server server) {
		return Server.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Server> getSubtypeOf(JsonNode json) {
		return Server.class;
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
	public static <OV extends IJsonOverlay<?>> Builder<Server> builder(OV modelMember) {
		return new Builder<Server>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Server create(OV modelMember) {
		return (Server) builder(modelMember).build();
	}
}
