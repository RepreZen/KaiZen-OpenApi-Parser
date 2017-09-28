package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.Info;
import com.reprezen.kaizen.oasparser.model3.Link;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.Tag;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.ValidationResults.Severity;
import com.reprezen.kaizen.oasparser.val.Validator;

public class OpenApi3Impl extends OpenApiObjectImpl<OpenApi3, OpenApi3Impl> implements OpenApi3 {

	private ValidationResults validationResults = null;

	@Inject
	private Validator<OpenApi3> validator;

	@Override
	public void validate() {
		validationResults = validator.validate(this);
	}

	@Override
	public boolean isValid() {
		if (validationResults == null) {
			validate();
		}
		return validationResults.getSeverity().lt(Severity.ERROR);
	}

	@Override
	public ValidationResults getValidationResults() {
		if (validationResults == null) {
			validate();
		}
		return validationResults;
	}

	@Override
	public Collection<ValidationResults.ValidationItem> getValidationItems() {
		return getValidationResults().getItems();
	}

	public OpenApi3Impl(String key, JsonNode json, JsonOverlay<?> parent, ReferenceRegistry referenceRegistry) {
		super(key, json, parent, referenceRegistry);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OpenApi3Impl(String key, JsonNode json, JsonOverlay<?> parent) {
		super(key, json, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OpenApi3Impl(String key, JsonOverlay<?> parent) {
		super(key, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay openApi = new StringOverlay("openapi", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private InfoImpl info = InfoImpl.factory.create("info", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ListOverlay<ServerImpl> servers = new ListOverlay<ServerImpl>("servers", this, ServerImpl.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<PathImpl> paths = new MapOverlay<PathImpl>("paths", this, PathImpl.factory, "/.*");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> pathsExtensions = new ValMapOverlay<Object, AnyObjectOverlay>(
			"paths", this, AnyObjectOverlay.factory, "x-.+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<SchemaImpl> schemas = new MapOverlay<SchemaImpl>("components/schemas", this, SchemaImpl.factory,
			"[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<ResponseImpl> responses = new MapOverlay<ResponseImpl>("components/responses", this,
			ResponseImpl.factory, "[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<ParameterImpl> parameters = new MapOverlay<ParameterImpl>("components/parameters", this,
			ParameterImpl.factory, "[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<ExampleImpl> examples = new MapOverlay<ExampleImpl>("components/examples", this,
			ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<RequestBodyImpl> requestBodies = new MapOverlay<RequestBodyImpl>("components/requestBodies",
			this, RequestBodyImpl.factory, "[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<HeaderImpl> headers = new MapOverlay<HeaderImpl>("components/headers", this, HeaderImpl.factory,
			"[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<SecuritySchemeImpl> securitySchemes = new MapOverlay<SecuritySchemeImpl>(
			"components/securitySchemes", this, SecuritySchemeImpl.factory, "[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<LinkImpl> links = new MapOverlay<LinkImpl>("components/links", this, LinkImpl.factory,
			"[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<CallbackImpl> callbacks = new MapOverlay<CallbackImpl>("components/callbacks", this,
			CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> componentsExtensions = new ValMapOverlay<Object, AnyObjectOverlay>(
			"components", this, AnyObjectOverlay.factory, "x-.+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ListOverlay<SecurityRequirementImpl> securityRequirements = new ListOverlay<SecurityRequirementImpl>(
			"security", this, SecurityRequirementImpl.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ListOverlay<TagImpl> tags = new ListOverlay<TagImpl>("tags", this, TagImpl.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ExternalDocsImpl externalDocs = ExternalDocsImpl.factory.create("externalDocs", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> extensions = new ValMapOverlay<Object, AnyObjectOverlay>("", this,
			AnyObjectOverlay.factory, "x-.+");

	// OpenApi
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getOpenApi() {
		return openApi.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setOpenApi(String openApi) {
		this.openApi.set(openApi);
	}

	// Info
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Info getInfo() {
		return info;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setInfo(Info info) {
		this.info.set((InfoImpl) info);
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

	// Path
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends Path> getPaths() {
		return paths.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasPath(String name) {
		return paths.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Path getPath(String name) {
		return paths.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setPaths(Map<String, ? extends Path> paths) {
		@SuppressWarnings("unchecked")
		Map<String, PathImpl> implPaths = (Map<String, PathImpl>) paths;
		this.paths.set(implPaths);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setPath(String name, Path path) {
		paths.set(name, (PathImpl) path);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removePath(String name) {
		paths.remove(name);
	}

	// PathsExtension
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getPathsExtensions() {
		return pathsExtensions.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasPathsExtension(String name) {
		return pathsExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Object getPathsExtension(String name) {
		return pathsExtensions.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setPathsExtensions(Map<String, Object> pathsExtensions) {
		this.pathsExtensions.set(pathsExtensions);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setPathsExtension(String name, Object pathsExtension) {
		pathsExtensions.set(name, pathsExtension);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removePathsExtension(String name) {
		pathsExtensions.remove(name);
	}

	// Schema
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends Schema> getSchemas() {
		return schemas.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasSchema(String name) {
		return schemas.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Schema getSchema(String name) {
		return schemas.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setSchemas(Map<String, ? extends Schema> schemas) {
		@SuppressWarnings("unchecked")
		Map<String, SchemaImpl> implSchemas = (Map<String, SchemaImpl>) schemas;
		this.schemas.set(implSchemas);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setSchema(String name, Schema schema) {
		schemas.set(name, (SchemaImpl) schema);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeSchema(String name) {
		schemas.remove(name);
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

	// Parameter
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends Parameter> getParameters() {
		return parameters.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasParameter(String name) {
		return parameters.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Parameter getParameter(String name) {
		return parameters.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setParameters(Map<String, ? extends Parameter> parameters) {
		@SuppressWarnings("unchecked")
		Map<String, ParameterImpl> implParameters = (Map<String, ParameterImpl>) parameters;
		this.parameters.set(implParameters);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setParameter(String name, Parameter parameter) {
		parameters.set(name, (ParameterImpl) parameter);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeParameter(String name) {
		parameters.remove(name);
	}

	// Example
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends Example> getExamples() {
		return examples.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasExample(String name) {
		return examples.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Example getExample(String name) {
		return examples.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExamples(Map<String, ? extends Example> examples) {
		@SuppressWarnings("unchecked")
		Map<String, ExampleImpl> implExamples = (Map<String, ExampleImpl>) examples;
		this.examples.set(implExamples);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExample(String name, Example example) {
		examples.set(name, (ExampleImpl) example);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeExample(String name) {
		examples.remove(name);
	}

	// RequestBody
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends RequestBody> getRequestBodies() {
		return requestBodies.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasRequestBody(String name) {
		return requestBodies.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public RequestBody getRequestBody(String name) {
		return requestBodies.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setRequestBodies(Map<String, ? extends RequestBody> requestBodies) {
		@SuppressWarnings("unchecked")
		Map<String, RequestBodyImpl> implRequestBodies = (Map<String, RequestBodyImpl>) requestBodies;
		this.requestBodies.set(implRequestBodies);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setRequestBody(String name, RequestBody requestBody) {
		requestBodies.set(name, (RequestBodyImpl) requestBody);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeRequestBody(String name) {
		requestBodies.remove(name);
	}

	// Header
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends Header> getHeaders() {
		return headers.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasHeader(String name) {
		return headers.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Header getHeader(String name) {
		return headers.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setHeaders(Map<String, ? extends Header> headers) {
		@SuppressWarnings("unchecked")
		Map<String, HeaderImpl> implHeaders = (Map<String, HeaderImpl>) headers;
		this.headers.set(implHeaders);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setHeader(String name, Header header) {
		headers.set(name, (HeaderImpl) header);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeHeader(String name) {
		headers.remove(name);
	}

	// SecurityScheme
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends SecurityScheme> getSecuritySchemes() {
		return securitySchemes.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasSecurityScheme(String name) {
		return securitySchemes.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public SecurityScheme getSecurityScheme(String name) {
		return securitySchemes.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setSecuritySchemes(Map<String, ? extends SecurityScheme> securitySchemes) {
		@SuppressWarnings("unchecked")
		Map<String, SecuritySchemeImpl> implSecuritySchemes = (Map<String, SecuritySchemeImpl>) securitySchemes;
		this.securitySchemes.set(implSecuritySchemes);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setSecurityScheme(String name, SecurityScheme securityScheme) {
		securitySchemes.set(name, (SecuritySchemeImpl) securityScheme);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeSecurityScheme(String name) {
		securitySchemes.remove(name);
	}

	// Link
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends Link> getLinks() {
		return links.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasLink(String name) {
		return links.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Link getLink(String name) {
		return links.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setLinks(Map<String, ? extends Link> links) {
		@SuppressWarnings("unchecked")
		Map<String, LinkImpl> implLinks = (Map<String, LinkImpl>) links;
		this.links.set(implLinks);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setLink(String name, Link link) {
		links.set(name, (LinkImpl) link);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeLink(String name) {
		links.remove(name);
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

	// ComponentsExtension
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getComponentsExtensions() {
		return componentsExtensions.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasComponentsExtension(String name) {
		return componentsExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Object getComponentsExtension(String name) {
		return componentsExtensions.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setComponentsExtensions(Map<String, Object> componentsExtensions) {
		this.componentsExtensions.set(componentsExtensions);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setComponentsExtension(String name, Object componentsExtension) {
		componentsExtensions.set(name, componentsExtension);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeComponentsExtension(String name) {
		componentsExtensions.remove(name);
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

	// Tag
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<? extends Tag> getTags() {
		return tags.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasTags() {
		return tags.isPresent();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Tag getTag(int index) {
		return tags.get(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setTags(Collection<? extends Tag> tags) {
		@SuppressWarnings("unchecked")
		Collection<TagImpl> implTags = (Collection<TagImpl>) tags;
		this.tags.set(implTags);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setTag(int index, Tag tag) {
		tags.set(index, (TagImpl) tag);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addTag(Tag tag) {
		tags.add((TagImpl) tag);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeTag(int index) {
		tags.remove(index);
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
	public static JsonOverlayFactory<OpenApi3Impl> factory = new JsonOverlayFactory<OpenApi3Impl>() {
		@Override
		public OpenApi3Impl create(String key, JsonNode json, JsonOverlay<?> parent) {
			return isEmptyRecursive(parent, OpenApi3Impl.class) ? null : new OpenApi3Impl(key, json, parent);
		}
	};

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	protected void installPropertyAccessors(PropertyAccessors accessors) {
		OverlayGetter getter = null;
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return openApi;
			}
		};
		accessors.add("openapi", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return info;
			}
		};
		accessors.add("info", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return servers;
			}
		};
		accessors.add("servers", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return paths;
			}
		};
		accessors.add("paths", "/.*", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return pathsExtensions;
			}
		};
		accessors.add("paths", "x-.+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return schemas;
			}
		};
		accessors.add("components/schemas", "[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return responses;
			}
		};
		accessors.add("components/responses", "[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return parameters;
			}
		};
		accessors.add("components/parameters", "[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return examples;
			}
		};
		accessors.add("components/examples", "[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return requestBodies;
			}
		};
		accessors.add("components/requestBodies", "[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return headers;
			}
		};
		accessors.add("components/headers", "[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return securitySchemes;
			}
		};
		accessors.add("components/securitySchemes", "[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return links;
			}
		};
		accessors.add("components/links", "[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return callbacks;
			}
		};
		accessors.add("components/callbacks", "(?!x-)[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return componentsExtensions;
			}
		};
		accessors.add("components", "x-.+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return securityRequirements;
			}
		};
		accessors.add("security", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return tags;
			}
		};
		accessors.add("tags", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return externalDocs;
			}
		};
		accessors.add("externalDocs", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return extensions;
			}
		};
		accessors.add("", "x-.+", getter);
	}

}
