package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.BooleanOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.IJsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.PropertiesOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.Reference;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.model3.Server;

public class OperationImpl extends PropertiesOverlay<Operation> implements Operation {

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OperationImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OperationImpl(Operation operation, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(operation, parent, refReg);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildListOverlay<String> tags;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> summary;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<ExternalDocs> externalDocs;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> operationId;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildListOverlay<Parameter> parameters;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<RequestBody> requestBody;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Response> responses;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> responsesExtensions;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Callback> callbacks;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> callbacksExtensions;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<Boolean> deprecated;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildListOverlay<SecurityRequirement> securityRequirements;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildListOverlay<Server> servers;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Tag
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<String> getTags() {
		return tags.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<String> getTags(boolean elaborate) {
		return tags.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasTags() {
		return tags.isPresent();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getTag(int index) {
		return tags.get(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setTags(Collection<String> tags) {
		this.tags.set(tags);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setTag(int index, String tag) {
		tags.set(index, tag);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addTag(String tag) {
		tags.add(tag);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void insertTag(int index, String tag) {
		tags.insert(index, tag);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeTag(int index) {
		tags.remove(index);
	}

	// Summary
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getSummary() {
		return summary.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getSummary(boolean elaborate) {
		return summary.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setSummary(String summary) {
		this.summary.set(summary);
	}

	// Description
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getDescription() {
		return description.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getDescription(boolean elaborate) {
		return description.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setDescription(String description) {
		this.description.set(description);
	}

	// ExternalDocs
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public ExternalDocs getExternalDocs() {
		return externalDocs.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public ExternalDocs getExternalDocs(boolean elaborate) {
		return externalDocs.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExternalDocs(ExternalDocs externalDocs) {
		this.externalDocs.set(externalDocs);
	}

	// OperationId
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getOperationId() {
		return operationId.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getOperationId(boolean elaborate) {
		return operationId.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setOperationId(String operationId) {
		this.operationId.set(operationId);
	}

	// Parameter
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<Parameter> getParameters() {
		return parameters.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<Parameter> getParameters(boolean elaborate) {
		return parameters.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasParameters() {
		return parameters.isPresent();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Parameter getParameter(int index) {
		return parameters.get(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setParameters(Collection<Parameter> parameters) {
		this.parameters.set(parameters);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setParameter(int index, Parameter parameter) {
		parameters.set(index, parameter);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addParameter(Parameter parameter) {
		parameters.add(parameter);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void insertParameter(int index, Parameter parameter) {
		parameters.insert(index, parameter);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeParameter(int index) {
		parameters.remove(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isParameterReference(int index) {
		return parameters.getChild(index).isReference();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getParameterReference(int index) {
		return parameters.getChild(index).getReference();
	}

	// RequestBody
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public RequestBody getRequestBody() {
		return requestBody.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public RequestBody getRequestBody(boolean elaborate) {
		return requestBody.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setRequestBody(RequestBody requestBody) {
		this.requestBody.set(requestBody);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isRequestBodyReference() {
		return requestBody != null ? requestBody.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getRequestBodyReference() {
		return requestBody != null ? requestBody.getReference() : null;
	}

	// Response
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Response> getResponses() {
		return responses.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Response> getResponses(boolean elaborate) {
		return responses.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasResponse(String name) {
		return responses.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Response getResponse(String name) {
		return responses.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setResponses(Map<String, Response> responses) {
		this.responses.set(responses);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setResponse(String name, Response response) {
		responses.set(name, response);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeResponse(String name) {
		responses.remove(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isResponseReference(String name) {
		ChildOverlay<Response> child = responses.getChild(name);
		return child != null ? child.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getResponseReference(String name) {
		ChildOverlay<Response> child = responses.getChild(name);
		return child != null ? child.getReference() : null;
	}

	// ResponsesExtension
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getResponsesExtensions() {
		return responsesExtensions.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getResponsesExtensions(boolean elaborate) {
		return responsesExtensions.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasResponsesExtension(String name) {
		return responsesExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Object getResponsesExtension(String name) {
		return responsesExtensions.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setResponsesExtensions(Map<String, Object> responsesExtensions) {
		this.responsesExtensions.set(responsesExtensions);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setResponsesExtension(String name, Object responsesExtension) {
		responsesExtensions.set(name, responsesExtension);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeResponsesExtension(String name) {
		responsesExtensions.remove(name);
	}

	// Callback
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Callback> getCallbacks() {
		return callbacks.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Callback> getCallbacks(boolean elaborate) {
		return callbacks.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasCallback(String name) {
		return callbacks.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Callback getCallback(String name) {
		return callbacks.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setCallbacks(Map<String, Callback> callbacks) {
		this.callbacks.set(callbacks);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setCallback(String name, Callback callback) {
		callbacks.set(name, callback);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeCallback(String name) {
		callbacks.remove(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isCallbackReference(String name) {
		ChildOverlay<Callback> child = callbacks.getChild(name);
		return child != null ? child.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getCallbackReference(String name) {
		ChildOverlay<Callback> child = callbacks.getChild(name);
		return child != null ? child.getReference() : null;
	}

	// CallbacksExtension
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getCallbacksExtensions() {
		return callbacksExtensions.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getCallbacksExtensions(boolean elaborate) {
		return callbacksExtensions.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasCallbacksExtension(String name) {
		return callbacksExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Object getCallbacksExtension(String name) {
		return callbacksExtensions.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setCallbacksExtensions(Map<String, Object> callbacksExtensions) {
		this.callbacksExtensions.set(callbacksExtensions);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setCallbacksExtension(String name, Object callbacksExtension) {
		callbacksExtensions.set(name, callbacksExtension);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeCallbacksExtension(String name) {
		callbacksExtensions.remove(name);
	}

	// Deprecated
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getDeprecated() {
		return deprecated.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getDeprecated(boolean elaborate) {
		return deprecated.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isDeprecated() {
		return deprecated.get() != null ? deprecated.get() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setDeprecated(Boolean deprecated) {
		this.deprecated.set(deprecated);
	}

	// SecurityRequirement
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<SecurityRequirement> getSecurityRequirements() {
		return securityRequirements.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<SecurityRequirement> getSecurityRequirements(boolean elaborate) {
		return securityRequirements.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasSecurityRequirements() {
		return securityRequirements.isPresent();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public SecurityRequirement getSecurityRequirement(int index) {
		return securityRequirements.get(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setSecurityRequirements(Collection<SecurityRequirement> securityRequirements) {
		this.securityRequirements.set(securityRequirements);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setSecurityRequirement(int index, SecurityRequirement securityRequirement) {
		securityRequirements.set(index, securityRequirement);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addSecurityRequirement(SecurityRequirement securityRequirement) {
		securityRequirements.add(securityRequirement);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void insertSecurityRequirement(int index, SecurityRequirement securityRequirement) {
		securityRequirements.insert(index, securityRequirement);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeSecurityRequirement(int index) {
		securityRequirements.remove(index);
	}

	// Server
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<Server> getServers() {
		return servers.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<Server> getServers(boolean elaborate) {
		return servers.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasServers() {
		return servers.isPresent();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Server getServer(int index) {
		return servers.get(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setServers(Collection<Server> servers) {
		this.servers.set(servers);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setServer(int index, Server server) {
		servers.set(index, server);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addServer(Server server) {
		servers.add(server);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void insertServer(int index, Server server) {
		servers.insert(index, server);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeServer(int index) {
		servers.remove(index);
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
		super.elaborateChildren();
		tags = createChildList("tags", this, StringOverlay.factory);
		summary = createChild("summary", this, StringOverlay.factory);
		description = createChild("description", this, StringOverlay.factory);
		externalDocs = createChild("externalDocs", this, ExternalDocsImpl.factory);
		operationId = createChild("operationId", this, StringOverlay.factory);
		parameters = createChildList("parameters", this, ParameterImpl.factory);
		refables.put("parameters", parameters);
		requestBody = createChild("requestBody", this, RequestBodyImpl.factory);
		refables.put("requestBody", requestBody);
		responses = createChildMap("responses", this, ResponseImpl.factory, "default|(\\d\\d\\d)");
		refables.put("responses", responses);
		responsesExtensions = createChildMap("responses", this, ObjectOverlay.factory, "x-.+");
		callbacks = createChildMap("callbacks", this, CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		refables.put("callbacks", callbacks);
		callbacksExtensions = createChildMap("callbacks", this, ObjectOverlay.factory, "x-.+");
		deprecated = createChild("deprecated", this, BooleanOverlay.factory);
		securityRequirements = createChildList("security", this, SecurityRequirementImpl.factory);
		servers = createChildList("servers", this, ServerImpl.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Operation> factory = new OverlayFactory<Operation>() {

		@Override
		protected Class<? extends IJsonOverlay<? super Operation>> getOverlayClass() {
			return OperationImpl.class;
		}

		@Override
		public JsonOverlay<Operation> _create(Operation operation, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			IJsonOverlay<?> overlay;
			overlay = new OperationImpl(operation, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Operation> castOverlay = (JsonOverlay<Operation>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Operation> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			IJsonOverlay<?> overlay;
			overlay = new OperationImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Operation> castOverlay = (JsonOverlay<Operation>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Operation> getSubtypeOf(Operation operation) {
		return Operation.class;
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Operation> getSubtypeOf(JsonNode json) {
		return Operation.class;
	}
}
