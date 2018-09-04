package com.reprezen.kaizen.oasparser.ovl3;

import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.Builder;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.model3.Server;

public class OperationImpl extends PropertiesOverlay<Operation> implements Operation {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OperationImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OperationImpl(Operation operation, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(operation, parent, factory, refMgr);
	}

	// Tag
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<String> getTags() {
		return _getList("tags", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<String> getTags(boolean elaborate) {
		return _getList("tags", elaborate, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasTags() {
		return _isPresent("tags");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getTag(int index) {
		return _get("tags", index, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setTags(List<String> tags) {
		_setList("tags", tags, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setTag(int index, String tag) {
		_set("tags", index, tag, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addTag(String tag) {
		_add("tags", tag, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertTag(int index, String tag) {
		_insert("tags", index, tag, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeTag(int index) {
		_remove("tags", index, String.class);
	}

	// Summary
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getSummary() {
		return _get("summary", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setSummary(String summary) {
		_setScalar("summary", summary, String.class);
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

	// ExternalDocs
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ExternalDocs getExternalDocs() {
		return _get("externalDocs", ExternalDocs.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ExternalDocs getExternalDocs(boolean elaborate) {
		return _get("externalDocs", elaborate, ExternalDocs.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExternalDocs(ExternalDocs externalDocs) {
		_setScalar("externalDocs", externalDocs, ExternalDocs.class);
	}

	// OperationId
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getOperationId() {
		return _get("operationId", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOperationId(String operationId) {
		_setScalar("operationId", operationId, String.class);
	}

	// Parameter
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Parameter> getParameters() {
		return _getList("parameters", Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Parameter> getParameters(boolean elaborate) {
		return _getList("parameters", elaborate, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasParameters() {
		return _isPresent("parameters");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Parameter getParameter(int index) {
		return _get("parameters", index, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setParameters(List<Parameter> parameters) {
		_setList("parameters", parameters, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setParameter(int index, Parameter parameter) {
		_set("parameters", index, parameter, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addParameter(Parameter parameter) {
		_add("parameters", parameter, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertParameter(int index, Parameter parameter) {
		_insert("parameters", index, parameter, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeParameter(int index) {
		_remove("parameters", index, Parameter.class);
	}

	// RequestBody
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public RequestBody getRequestBody() {
		return _get("requestBody", RequestBody.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public RequestBody getRequestBody(boolean elaborate) {
		return _get("requestBody", elaborate, RequestBody.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setRequestBody(RequestBody requestBody) {
		_setScalar("requestBody", requestBody, RequestBody.class);
	}

	// Response
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Response> getResponses() {
		return _getMap("responses", Response.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Response> getResponses(boolean elaborate) {
		return _getMap("responses", elaborate, Response.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasResponses() {
		return _isPresent("responses");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasResponse(String name) {
		return _getMap("responses", Response.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Response getResponse(String name) {
		return _get("responses", name, Response.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setResponses(Map<String, Response> responses) {
		_setMap("responses", responses, Response.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setResponse(String name, Response response) {
		_set("responses", name, response, Response.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeResponse(String name) {
		_remove("responses", name, Response.class);
	}

	// ResponsesExtension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getResponsesExtensions() {
		return _getMap("responsesExtensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getResponsesExtensions(boolean elaborate) {
		return _getMap("responsesExtensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasResponsesExtensions() {
		return _isPresent("responsesExtensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasResponsesExtension(String name) {
		return _getMap("responsesExtensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getResponsesExtension(String name) {
		return _get("responsesExtensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setResponsesExtensions(Map<String, Object> responsesExtensions) {
		_setMap("responsesExtensions", responsesExtensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setResponsesExtension(String name, Object responsesExtension) {
		_set("responsesExtensions", name, responsesExtension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeResponsesExtension(String name) {
		_remove("responsesExtensions", name, Object.class);
	}

	// Callback
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Callback> getCallbacks() {
		return _getMap("callbacks", Callback.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Callback> getCallbacks(boolean elaborate) {
		return _getMap("callbacks", elaborate, Callback.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasCallbacks() {
		return _isPresent("callbacks");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasCallback(String name) {
		return _getMap("callbacks", Callback.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Callback getCallback(String name) {
		return _get("callbacks", name, Callback.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setCallbacks(Map<String, Callback> callbacks) {
		_setMap("callbacks", callbacks, Callback.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setCallback(String name, Callback callback) {
		_set("callbacks", name, callback, Callback.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeCallback(String name) {
		_remove("callbacks", name, Callback.class);
	}

	// CallbacksExtension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getCallbacksExtensions() {
		return _getMap("callbacksExtensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getCallbacksExtensions(boolean elaborate) {
		return _getMap("callbacksExtensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasCallbacksExtensions() {
		return _isPresent("callbacksExtensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasCallbacksExtension(String name) {
		return _getMap("callbacksExtensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getCallbacksExtension(String name) {
		return _get("callbacksExtensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setCallbacksExtensions(Map<String, Object> callbacksExtensions) {
		_setMap("callbacksExtensions", callbacksExtensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setCallbacksExtension(String name, Object callbacksExtension) {
		_set("callbacksExtensions", name, callbacksExtension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeCallbacksExtension(String name) {
		_remove("callbacksExtensions", name, Object.class);
	}

	// Deprecated
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getDeprecated() {
		return _get("deprecated", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isDeprecated() {
		Boolean bool = _get("deprecated", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDeprecated(Boolean deprecated) {
		_setScalar("deprecated", deprecated, Boolean.class);
	}

	// SecurityRequirement
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<SecurityRequirement> getSecurityRequirements() {
		return _getList("securityRequirements", SecurityRequirement.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<SecurityRequirement> getSecurityRequirements(boolean elaborate) {
		return _getList("securityRequirements", elaborate, SecurityRequirement.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasSecurityRequirements() {
		return _isPresent("securityRequirements");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public SecurityRequirement getSecurityRequirement(int index) {
		return _get("securityRequirements", index, SecurityRequirement.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setSecurityRequirements(List<SecurityRequirement> securityRequirements) {
		_setList("securityRequirements", securityRequirements, SecurityRequirement.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setSecurityRequirement(int index, SecurityRequirement securityRequirement) {
		_set("securityRequirements", index, securityRequirement, SecurityRequirement.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addSecurityRequirement(SecurityRequirement securityRequirement) {
		_add("securityRequirements", securityRequirement, SecurityRequirement.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertSecurityRequirement(int index, SecurityRequirement securityRequirement) {
		_insert("securityRequirements", index, securityRequirement, SecurityRequirement.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeSecurityRequirement(int index) {
		_remove("securityRequirements", index, SecurityRequirement.class);
	}

	// Server
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Server> getServers() {
		return _getList("servers", Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Server> getServers(boolean elaborate) {
		return _getList("servers", elaborate, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasServers() {
		return _isPresent("servers");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Server getServer(int index) {
		return _get("servers", index, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setServers(List<Server> servers) {
		_setList("servers", servers, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setServer(int index, Server server) {
		_set("servers", index, server, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addServer(Server server) {
		_add("servers", server, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertServer(int index, Server server) {
		_insert("servers", index, server, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeServer(int index) {
		_remove("servers", index, Server.class);
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
	public static final String F_tags = "tags";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_summary = "summary";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_description = "description";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_externalDocs = "externalDocs";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_operationId = "operationId";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_parameters = "parameters";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_requestBody = "requestBody";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_responses = "responses";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_responsesExtensions = "responsesExtensions";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_callbacks = "callbacks";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_callbacksExtensions = "callbacksExtensions";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_deprecated = "deprecated";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_securityRequirements = "securityRequirements";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_servers = "servers";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createList("tags", "tags", StringOverlay.factory);
		_createScalar("summary", "summary", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("externalDocs", "externalDocs", ExternalDocsImpl.factory);
		_createScalar("operationId", "operationId", StringOverlay.factory);
		_createList("parameters", "parameters", ParameterImpl.factory);
		_createScalar("requestBody", "requestBody", RequestBodyImpl.factory);
		_createMap("responses", "responses", ResponseImpl.factory, "default|(\\d[0-9X]{2})");
		_createMap("responsesExtensions", "responses", ObjectOverlay.factory, "x-.+");
		_createMap("callbacks", "callbacks", CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		_createMap("callbacksExtensions", "callbacks", ObjectOverlay.factory, "x-.+");
		_createScalar("deprecated", "deprecated", BooleanOverlay.factory);
		_createList("securityRequirements", "security", SecurityRequirementImpl.factory);
		_createList("servers", "servers", ServerImpl.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Operation> factory = new OverlayFactory<Operation>() {

		@Override
		protected Class<? extends JsonOverlay<? super Operation>> getOverlayClass() {
			return OperationImpl.class;
		}

		@Override
		public JsonOverlay<Operation> _create(Operation operation, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OperationImpl(operation, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Operation> castOverlay = (JsonOverlay<Operation>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Operation> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OperationImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Operation> castOverlay = (JsonOverlay<Operation>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Operation> getSubtypeOf(Operation operation) {
		return Operation.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Operation> getSubtypeOf(JsonNode json) {
		return Operation.class;
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
	public static <OV extends IJsonOverlay<?>> Builder<Operation> builder(OV modelMember) {
		return new Builder<Operation>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Operation create(OV modelMember) {
		return (Operation) builder(modelMember).build();
	}
}
