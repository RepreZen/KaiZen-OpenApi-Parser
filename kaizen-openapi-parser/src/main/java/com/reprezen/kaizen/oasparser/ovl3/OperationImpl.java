package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.ChildListOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.model3.Server;

public class OperationImpl extends PropertiesOverlay<Operation> implements Operation {

	@Generated("com.reprezen.gen.CodeGenerator")
	public OperationImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public OperationImpl(Operation operation, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(operation, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<String> tags;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> summary;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<ExternalDocs> externalDocs;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> operationId;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<Parameter> parameters;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<RequestBody> requestBody;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Response> responses;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> responsesExtensions;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Callback> callbacks;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> callbacksExtensions;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> deprecated;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<SecurityRequirement> securityRequirements;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<Server> servers;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Tag
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<String> getTags() {
		return tags._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<String> getTags(boolean elaborate) {
		return tags._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasTags() {
		return tags._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getTag(int index) {
		return tags._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setTags(Collection<String> tags) {
		this.tags._set(tags);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setTag(int index, String tag) {
		tags._set(index, tag);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addTag(String tag) {
		tags._add(tag);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertTag(int index, String tag) {
		tags._insert(index, tag);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeTag(int index) {
		tags._remove(index);
	}

	// Summary
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getSummary() {
		return summary._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getSummary(boolean elaborate) {
		return summary._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setSummary(String summary) {
		this.summary._set(summary);
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

	// ExternalDocs
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public ExternalDocs getExternalDocs() {
		return externalDocs._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public ExternalDocs getExternalDocs(boolean elaborate) {
		return externalDocs._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExternalDocs(ExternalDocs externalDocs) {
		this.externalDocs._set(externalDocs);
	}

	// OperationId
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getOperationId() {
		return operationId._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getOperationId(boolean elaborate) {
		return operationId._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setOperationId(String operationId) {
		this.operationId._set(operationId);
	}

	// Parameter
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Parameter> getParameters() {
		return parameters._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Parameter> getParameters(boolean elaborate) {
		return parameters._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasParameters() {
		return parameters._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Parameter getParameter(int index) {
		return parameters._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setParameters(Collection<Parameter> parameters) {
		this.parameters._set(parameters);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setParameter(int index, Parameter parameter) {
		parameters._set(index, parameter);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addParameter(Parameter parameter) {
		parameters._add(parameter);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertParameter(int index, Parameter parameter) {
		parameters._insert(index, parameter);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeParameter(int index) {
		parameters._remove(index);
	}

	// RequestBody
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public RequestBody getRequestBody() {
		return requestBody._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public RequestBody getRequestBody(boolean elaborate) {
		return requestBody._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setRequestBody(RequestBody requestBody) {
		this.requestBody._set(requestBody);
	}

	// Response
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Response> getResponses() {
		return responses._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Response> getResponses(boolean elaborate) {
		return responses._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasResponse(String name) {
		return responses.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Response getResponse(String name) {
		return responses._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setResponses(Map<String, Response> responses) {
		this.responses._set(responses);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setResponse(String name, Response response) {
		responses._set(name, response);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeResponse(String name) {
		responses._remove(name);
	}

	// ResponsesExtension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getResponsesExtensions() {
		return responsesExtensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getResponsesExtensions(boolean elaborate) {
		return responsesExtensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasResponsesExtension(String name) {
		return responsesExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getResponsesExtension(String name) {
		return responsesExtensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setResponsesExtensions(Map<String, Object> responsesExtensions) {
		this.responsesExtensions._set(responsesExtensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setResponsesExtension(String name, Object responsesExtension) {
		responsesExtensions._set(name, responsesExtension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeResponsesExtension(String name) {
		responsesExtensions._remove(name);
	}

	// Callback
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Callback> getCallbacks() {
		return callbacks._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Callback> getCallbacks(boolean elaborate) {
		return callbacks._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasCallback(String name) {
		return callbacks.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Callback getCallback(String name) {
		return callbacks._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setCallbacks(Map<String, Callback> callbacks) {
		this.callbacks._set(callbacks);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setCallback(String name, Callback callback) {
		callbacks._set(name, callback);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeCallback(String name) {
		callbacks._remove(name);
	}

	// CallbacksExtension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getCallbacksExtensions() {
		return callbacksExtensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getCallbacksExtensions(boolean elaborate) {
		return callbacksExtensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasCallbacksExtension(String name) {
		return callbacksExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getCallbacksExtension(String name) {
		return callbacksExtensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setCallbacksExtensions(Map<String, Object> callbacksExtensions) {
		this.callbacksExtensions._set(callbacksExtensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setCallbacksExtension(String name, Object callbacksExtension) {
		callbacksExtensions._set(name, callbacksExtension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeCallbacksExtension(String name) {
		callbacksExtensions._remove(name);
	}

	// Deprecated
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getDeprecated() {
		return deprecated._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getDeprecated(boolean elaborate) {
		return deprecated._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isDeprecated() {
		return deprecated._get() != null ? deprecated._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setDeprecated(Boolean deprecated) {
		this.deprecated._set(deprecated);
	}

	// SecurityRequirement
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<SecurityRequirement> getSecurityRequirements() {
		return securityRequirements._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<SecurityRequirement> getSecurityRequirements(boolean elaborate) {
		return securityRequirements._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasSecurityRequirements() {
		return securityRequirements._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public SecurityRequirement getSecurityRequirement(int index) {
		return securityRequirements._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setSecurityRequirements(Collection<SecurityRequirement> securityRequirements) {
		this.securityRequirements._set(securityRequirements);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setSecurityRequirement(int index, SecurityRequirement securityRequirement) {
		securityRequirements._set(index, securityRequirement);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addSecurityRequirement(SecurityRequirement securityRequirement) {
		securityRequirements._add(securityRequirement);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertSecurityRequirement(int index, SecurityRequirement securityRequirement) {
		securityRequirements._insert(index, securityRequirement);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeSecurityRequirement(int index) {
		securityRequirements._remove(index);
	}

	// Server
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Server> getServers() {
		return servers._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Server> getServers(boolean elaborate) {
		return servers._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasServers() {
		return servers._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Server getServer(int index) {
		return servers._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setServers(Collection<Server> servers) {
		this.servers._set(servers);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setServer(int index, Server server) {
		servers._set(index, server);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addServer(Server server) {
		servers._add(server);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertServer(int index, Server server) {
		servers._insert(index, server);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeServer(int index) {
		servers._remove(index);
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
		tags = createChildList("tags", this, StringOverlay.factory);
		summary = createChild("summary", this, StringOverlay.factory);
		description = createChild("description", this, StringOverlay.factory);
		externalDocs = createChild("externalDocs", this, ExternalDocsImpl.factory);
		operationId = createChild("operationId", this, StringOverlay.factory);
		parameters = createChildList("parameters", this, ParameterImpl.factory);
		requestBody = createChild("requestBody", this, RequestBodyImpl.factory);
		responses = createChildMap("responses", this, ResponseImpl.factory, "default|(\\d\\d\\d)");
		responsesExtensions = createChildMap("responses", this, ObjectOverlay.factory, "x-.+");
		callbacks = createChildMap("callbacks", this, CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		callbacksExtensions = createChildMap("callbacks", this, ObjectOverlay.factory, "x-.+");
		deprecated = createChild("deprecated", this, BooleanOverlay.factory);
		securityRequirements = createChildList("security", this, SecurityRequirementImpl.factory);
		servers = createChildList("servers", this, ServerImpl.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<Operation> factory = new OverlayFactory<Operation>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super Operation>> getOverlayClass() {
			return OperationImpl.class;
		}

		@Override
		public JsonOverlay<Operation> _create(Operation operation, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new OperationImpl(operation, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Operation> castOverlay = (JsonOverlay<Operation>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Operation> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new OperationImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Operation> castOverlay = (JsonOverlay<Operation>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Operation> getSubtypeOf(Operation operation) {
		return Operation.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Operation> getSubtypeOf(JsonNode json) {
		return Operation.class;
	}
}
