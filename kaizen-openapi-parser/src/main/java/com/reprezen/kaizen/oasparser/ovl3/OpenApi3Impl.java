package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
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

public class OpenApi3Impl extends PropertiesOverlay<OpenApi3> implements OpenApi3 {

	private ValidationResults validationResults = null;

	@Override
	protected JsonNode fixJson(JsonNode json) {
		if (json.isMissingNode()) {
			json = jsonObject();
		}
		if (!json.has("paths")) {
			((ObjectNode) json).putObject("paths");
		}
		return json;
	}

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

	@Generated("com.reprezen.gen.CodeGenerator")
	public OpenApi3Impl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public OpenApi3Impl(OpenApi3 openApi3, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(openApi3, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> openApi;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Info> info;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<Server> servers;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Path> paths;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> pathsExtensions;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Schema> schemas;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Response> responses;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Parameter> parameters;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Example> examples;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<RequestBody> requestBodies;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Header> headers;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<SecurityScheme> securitySchemes;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Link> links;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Callback> callbacks;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> componentsExtensions;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<SecurityRequirement> securityRequirements;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<Tag> tags;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<ExternalDocs> externalDocs;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// OpenApi
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getOpenApi() {
		return openApi._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getOpenApi(boolean elaborate) {
		return openApi._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setOpenApi(String openApi) {
		this.openApi._set(openApi);
	}

	// Info
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Info getInfo() {
		return info._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Info getInfo(boolean elaborate) {
		return info._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setInfo(Info info) {
		this.info._set(info);
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

	// Path
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Path> getPaths() {
		return paths._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Path> getPaths(boolean elaborate) {
		return paths._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasPath(String name) {
		return paths.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Path getPath(String name) {
		return paths._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setPaths(Map<String, Path> paths) {
		this.paths._set(paths);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setPath(String name, Path path) {
		paths._set(name, path);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removePath(String name) {
		paths._remove(name);
	}

	// PathsExtension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getPathsExtensions() {
		return pathsExtensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getPathsExtensions(boolean elaborate) {
		return pathsExtensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasPathsExtension(String name) {
		return pathsExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getPathsExtension(String name) {
		return pathsExtensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setPathsExtensions(Map<String, Object> pathsExtensions) {
		this.pathsExtensions._set(pathsExtensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setPathsExtension(String name, Object pathsExtension) {
		pathsExtensions._set(name, pathsExtension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removePathsExtension(String name) {
		pathsExtensions._remove(name);
	}

	// Schema
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Schema> getSchemas() {
		return schemas._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Schema> getSchemas(boolean elaborate) {
		return schemas._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasSchema(String name) {
		return schemas.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getSchema(String name) {
		return schemas._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setSchemas(Map<String, Schema> schemas) {
		this.schemas._set(schemas);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setSchema(String name, Schema schema) {
		schemas._set(name, schema);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeSchema(String name) {
		schemas._remove(name);
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

	// Parameter
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Parameter> getParameters() {
		return parameters._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Parameter> getParameters(boolean elaborate) {
		return parameters._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasParameter(String name) {
		return parameters.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Parameter getParameter(String name) {
		return parameters._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setParameters(Map<String, Parameter> parameters) {
		this.parameters._set(parameters);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setParameter(String name, Parameter parameter) {
		parameters._set(name, parameter);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeParameter(String name) {
		parameters._remove(name);
	}

	// Example
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Example> getExamples() {
		return examples._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Example> getExamples(boolean elaborate) {
		return examples._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasExample(String name) {
		return examples.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Example getExample(String name) {
		return examples._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExamples(Map<String, Example> examples) {
		this.examples._set(examples);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExample(String name, Example example) {
		examples._set(name, example);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeExample(String name) {
		examples._remove(name);
	}

	// RequestBody
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, RequestBody> getRequestBodies() {
		return requestBodies._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, RequestBody> getRequestBodies(boolean elaborate) {
		return requestBodies._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasRequestBody(String name) {
		return requestBodies.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public RequestBody getRequestBody(String name) {
		return requestBodies._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setRequestBodies(Map<String, RequestBody> requestBodies) {
		this.requestBodies._set(requestBodies);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setRequestBody(String name, RequestBody requestBody) {
		requestBodies._set(name, requestBody);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeRequestBody(String name) {
		requestBodies._remove(name);
	}

	// Header
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Header> getHeaders() {
		return headers._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Header> getHeaders(boolean elaborate) {
		return headers._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasHeader(String name) {
		return headers.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Header getHeader(String name) {
		return headers._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setHeaders(Map<String, Header> headers) {
		this.headers._set(headers);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setHeader(String name, Header header) {
		headers._set(name, header);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeHeader(String name) {
		headers._remove(name);
	}

	// SecurityScheme
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, SecurityScheme> getSecuritySchemes() {
		return securitySchemes._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, SecurityScheme> getSecuritySchemes(boolean elaborate) {
		return securitySchemes._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasSecurityScheme(String name) {
		return securitySchemes.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public SecurityScheme getSecurityScheme(String name) {
		return securitySchemes._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setSecuritySchemes(Map<String, SecurityScheme> securitySchemes) {
		this.securitySchemes._set(securitySchemes);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setSecurityScheme(String name, SecurityScheme securityScheme) {
		securitySchemes._set(name, securityScheme);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeSecurityScheme(String name) {
		securitySchemes._remove(name);
	}

	// Link
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Link> getLinks() {
		return links._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Link> getLinks(boolean elaborate) {
		return links._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasLink(String name) {
		return links.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Link getLink(String name) {
		return links._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setLinks(Map<String, Link> links) {
		this.links._set(links);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setLink(String name, Link link) {
		links._set(name, link);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeLink(String name) {
		links._remove(name);
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

	// ComponentsExtension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getComponentsExtensions() {
		return componentsExtensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getComponentsExtensions(boolean elaborate) {
		return componentsExtensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasComponentsExtension(String name) {
		return componentsExtensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getComponentsExtension(String name) {
		return componentsExtensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setComponentsExtensions(Map<String, Object> componentsExtensions) {
		this.componentsExtensions._set(componentsExtensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setComponentsExtension(String name, Object componentsExtension) {
		componentsExtensions._set(name, componentsExtension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeComponentsExtension(String name) {
		componentsExtensions._remove(name);
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

	// Tag
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Tag> getTags() {
		return tags._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Tag> getTags(boolean elaborate) {
		return tags._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasTags() {
		return tags._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Tag getTag(int index) {
		return tags._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setTags(Collection<Tag> tags) {
		this.tags._set(tags);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setTag(int index, Tag tag) {
		tags._set(index, tag);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addTag(Tag tag) {
		tags._add(tag);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertTag(int index, Tag tag) {
		tags._insert(index, tag);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeTag(int index) {
		tags._remove(index);
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
		openApi = createChild("openapi", this, StringOverlay.factory);
		info = createChild("info", this, InfoImpl.factory);
		servers = createChildList("servers", this, ServerImpl.factory);
		paths = createChildMap("paths", this, PathImpl.factory, "/.*");
		pathsExtensions = createChildMap("paths", this, ObjectOverlay.factory, "x-.+");
		schemas = createChildMap("components/schemas", this, SchemaImpl.factory, "[a-zA-Z0-9\\._-]+");
		responses = createChildMap("components/responses", this, ResponseImpl.factory, "[a-zA-Z0-9\\._-]+");
		parameters = createChildMap("components/parameters", this, ParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
		examples = createChildMap("components/examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		requestBodies = createChildMap("components/requestBodies", this, RequestBodyImpl.factory, "[a-zA-Z0-9\\._-]+");
		headers = createChildMap("components/headers", this, HeaderImpl.factory, "[a-zA-Z0-9\\._-]+");
		securitySchemes = createChildMap("components/securitySchemes", this, SecuritySchemeImpl.factory,
				"[a-zA-Z0-9\\._-]+");
		links = createChildMap("components/links", this, LinkImpl.factory, "[a-zA-Z0-9\\._-]+");
		callbacks = createChildMap("components/callbacks", this, CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		componentsExtensions = createChildMap("components", this, ObjectOverlay.factory, "x-.+");
		securityRequirements = createChildList("security", this, SecurityRequirementImpl.factory);
		tags = createChildList("tags", this, TagImpl.factory);
		externalDocs = createChild("externalDocs", this, ExternalDocsImpl.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<OpenApi3> factory = new OverlayFactory<OpenApi3>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super OpenApi3>> getOverlayClass() {
			return OpenApi3Impl.class;
		}

		@Override
		public JsonOverlay<OpenApi3> _create(OpenApi3 openApi3, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new OpenApi3Impl(openApi3, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<OpenApi3> castOverlay = (JsonOverlay<OpenApi3>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<OpenApi3> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new OpenApi3Impl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<OpenApi3> castOverlay = (JsonOverlay<OpenApi3>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends OpenApi3> getSubtypeOf(OpenApi3 openApi3) {
		return OpenApi3.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends OpenApi3> getSubtypeOf(JsonNode json) {
		return OpenApi3.class;
	}
}
