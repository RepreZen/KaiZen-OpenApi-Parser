package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.BooleanOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.model3.Server;

public class OperationImpl extends OpenApiObjectImpl<Operation, OperationImpl> implements Operation {

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OperationImpl(String key, JsonNode json, JsonOverlay<?> parent) {
		super(key, json, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OperationImpl(String key, JsonOverlay<?> parent) {
		super(key, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValListOverlay<String, StringOverlay> tags = new ValListOverlay<String, StringOverlay>("tags", this,
			StringOverlay.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay summary = new StringOverlay("summary", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay description = new StringOverlay("description", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ExternalDocsImpl externalDocs = ExternalDocsImpl.factory.create("externalDocs", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay operationId = new StringOverlay("operationId", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ListOverlay<ParameterImpl> parameters = new ListOverlay<ParameterImpl>("parameters", this,
			ParameterImpl.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private RequestBodyImpl requestBody = RequestBodyImpl.factory.create("requestBody", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<ResponseImpl> responses = new MapOverlay<ResponseImpl>("responses", this, ResponseImpl.factory,
			"default|(\\d\\d\\d)");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> responsesExtensions = new ValMapOverlay<Object, AnyObjectOverlay>(
			"responses", this, AnyObjectOverlay.factory, "x-.+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<CallbackImpl> callbacks = new MapOverlay<CallbackImpl>("callbacks", this, CallbackImpl.factory,
			"(?!x-)[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> callbacksExtensions = new ValMapOverlay<Object, AnyObjectOverlay>(
			"callbacks", this, AnyObjectOverlay.factory, "x-.+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private BooleanOverlay deprecated = new BooleanOverlay("deprecated", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ListOverlay<SecurityRequirementImpl> securityRequirements = new ListOverlay<SecurityRequirementImpl>(
			"security", this, SecurityRequirementImpl.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ListOverlay<ServerImpl> servers = new ListOverlay<ServerImpl>("servers", this, ServerImpl.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> extensions = new ValMapOverlay<Object, AnyObjectOverlay>("", this,
			AnyObjectOverlay.factory, "x-.+");

	// Tag
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<String> getTags() {
		return tags.get();
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
		this.tags.set((Collection<String>) tags);
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
	public void setDescription(String description) {
		this.description.set(description);
	}

	// ExternalDocs
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public ExternalDocs getExternalDocs() {
		return externalDocs;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExternalDocs(ExternalDocs externalDocs) {
		this.externalDocs.set((ExternalDocsImpl) externalDocs);
	}

	// OperationId
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getOperationId() {
		return operationId.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setOperationId(String operationId) {
		this.operationId.set(operationId);
	}

	// Parameter
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<? extends Parameter> getParameters() {
		return parameters.get();
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
	public void setParameters(Collection<? extends Parameter> parameters) {
		@SuppressWarnings("unchecked")
		Collection<ParameterImpl> implParameters = (Collection<ParameterImpl>) parameters;
		this.parameters.set(implParameters);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setParameter(int index, Parameter parameter) {
		parameters.set(index, (ParameterImpl) parameter);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addParameter(Parameter parameter) {
		parameters.add((ParameterImpl) parameter);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeParameter(int index) {
		parameters.remove(index);
	}

	// RequestBody
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public RequestBody getRequestBody() {
		return requestBody;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setRequestBody(RequestBody requestBody) {
		this.requestBody.set((RequestBodyImpl) requestBody);
	}

	// Response
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends Response> getResponses() {
		return responses.get();
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
	public void setResponses(Map<String, ? extends Response> responses) {
		@SuppressWarnings("unchecked")
		Map<String, ResponseImpl> implResponses = (Map<String, ResponseImpl>) responses;
		this.responses.set(implResponses);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setResponse(String name, Response response) {
		responses.set(name, (ResponseImpl) response);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeResponse(String name) {
		responses.remove(name);
	}

	// ResponsesExtension
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getResponsesExtensions() {
		return responsesExtensions.get();
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
	public Map<String, ? extends Callback> getCallbacks() {
		return callbacks.get();
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
	public void setCallbacks(Map<String, ? extends Callback> callbacks) {
		@SuppressWarnings("unchecked")
		Map<String, CallbackImpl> implCallbacks = (Map<String, CallbackImpl>) callbacks;
		this.callbacks.set(implCallbacks);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setCallback(String name, Callback callback) {
		callbacks.set(name, (CallbackImpl) callback);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeCallback(String name) {
		callbacks.remove(name);
	}

	// CallbacksExtension
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getCallbacksExtensions() {
		return callbacksExtensions.get();
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
	public Collection<? extends SecurityRequirement> getSecurityRequirements() {
		return securityRequirements.get();
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
	public void setSecurityRequirements(Collection<? extends SecurityRequirement> securityRequirements) {
		@SuppressWarnings("unchecked")
		Collection<SecurityRequirementImpl> implSecurityRequirements = (Collection<SecurityRequirementImpl>) securityRequirements;
		this.securityRequirements.set(implSecurityRequirements);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setSecurityRequirement(int index, SecurityRequirement securityRequirement) {
		securityRequirements.set(index, (SecurityRequirementImpl) securityRequirement);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addSecurityRequirement(SecurityRequirement securityRequirement) {
		securityRequirements.add((SecurityRequirementImpl) securityRequirement);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeSecurityRequirement(int index) {
		securityRequirements.remove(index);
	}

	// Server
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<? extends Server> getServers() {
		return servers.get();
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
	public void setServers(Collection<? extends Server> servers) {
		@SuppressWarnings("unchecked")
		Collection<ServerImpl> implServers = (Collection<ServerImpl>) servers;
		this.servers.set(implServers);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setServer(int index, Server server) {
		servers.set(index, (ServerImpl) server);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addServer(Server server) {
		servers.add((ServerImpl) server);
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
	public static JsonOverlayFactory<OperationImpl> factory = new JsonOverlayFactory<OperationImpl>() {
		@Override
		public OperationImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
			return isEmptyRecursive(parent, OperationImpl.class) ? null : new OperationImpl(key, json, parent);
		}
	};

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	protected void installPropertyAccessors(PropertyAccessors accessors) {
		OverlayGetter getter = null;
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return tags;
			}
		};
		accessors.add("tags", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return summary;
			}
		};
		accessors.add("summary", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return description;
			}
		};
		accessors.add("description", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return externalDocs;
			}
		};
		accessors.add("externalDocs", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return operationId;
			}
		};
		accessors.add("operationId", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return parameters;
			}
		};
		accessors.add("parameters", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return requestBody;
			}
		};
		accessors.add("requestBody", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return responses;
			}
		};
		accessors.add("responses", "default|(\\d\\d\\d)", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return responsesExtensions;
			}
		};
		accessors.add("responses", "x-.+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return callbacks;
			}
		};
		accessors.add("callbacks", "(?!x-)[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return callbacksExtensions;
			}
		};
		accessors.add("callbacks", "x-.+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return deprecated;
			}
		};
		accessors.add("deprecated", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return securityRequirements;
			}
		};
		accessors.add("security", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return servers;
			}
		};
		accessors.add("servers", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return extensions;
			}
		};
		accessors.add("", "x-.+", getter);
	}

}
