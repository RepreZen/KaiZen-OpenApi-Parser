package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
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

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OpenApi3Impl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public OpenApi3Impl(OpenApi3 openApi3, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(openApi3, parent, refReg);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> openApi;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<Info> info;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildListOverlay<Server> servers;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Path> paths;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> pathsExtensions;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Schema> schemas;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Response> responses;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Parameter> parameters;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Example> examples;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<RequestBody> requestBodies;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Header> headers;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<SecurityScheme> securitySchemes;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Link> links;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Callback> callbacks;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> componentsExtensions;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildListOverlay<SecurityRequirement> securityRequirements;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildListOverlay<Tag> tags;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<ExternalDocs> externalDocs;

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// OpenApi
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getOpenApi() {
		return openApi.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getOpenApi(boolean elaborate) {
		return openApi.get(elaborate);
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
		return info.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Info getInfo(boolean elaborate) {
		return info.get(elaborate);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setInfo(Info info) {
		this.info.set(info);
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

	// Path
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Path> getPaths() {
		return paths.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Path> getPaths(boolean elaborate) {
		return paths.get(elaborate);
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
	public void setPaths(Map<String, Path> paths) {
		this.paths.set(paths);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setPath(String name, Path path) {
		paths.set(name, path);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removePath(String name) {
		paths.remove(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isPathReference(String name) {
		ChildOverlay<Path> child = paths.getChild(name);
		return child != null ? child.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getPathReference(String name) {
		ChildOverlay<Path> child = paths.getChild(name);
		return child != null ? child.getReference() : null;
	}

	// PathsExtension
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getPathsExtensions() {
		return pathsExtensions.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getPathsExtensions(boolean elaborate) {
		return pathsExtensions.get(elaborate);
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
	public Map<String, Schema> getSchemas() {
		return schemas.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Schema> getSchemas(boolean elaborate) {
		return schemas.get(elaborate);
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
	public void setSchemas(Map<String, Schema> schemas) {
		this.schemas.set(schemas);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setSchema(String name, Schema schema) {
		schemas.set(name, schema);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeSchema(String name) {
		schemas.remove(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isSchemaReference(String name) {
		ChildOverlay<Schema> child = schemas.getChild(name);
		return child != null ? child.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getSchemaReference(String name) {
		ChildOverlay<Schema> child = schemas.getChild(name);
		return child != null ? child.getReference() : null;
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

	// Parameter
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Parameter> getParameters() {
		return parameters.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Parameter> getParameters(boolean elaborate) {
		return parameters.get(elaborate);
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
	public void setParameters(Map<String, Parameter> parameters) {
		this.parameters.set(parameters);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setParameter(String name, Parameter parameter) {
		parameters.set(name, parameter);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeParameter(String name) {
		parameters.remove(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isParameterReference(String name) {
		ChildOverlay<Parameter> child = parameters.getChild(name);
		return child != null ? child.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getParameterReference(String name) {
		ChildOverlay<Parameter> child = parameters.getChild(name);
		return child != null ? child.getReference() : null;
	}

	// Example
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Example> getExamples() {
		return examples.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Example> getExamples(boolean elaborate) {
		return examples.get(elaborate);
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
	public void setExamples(Map<String, Example> examples) {
		this.examples.set(examples);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExample(String name, Example example) {
		examples.set(name, example);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeExample(String name) {
		examples.remove(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isExampleReference(String name) {
		ChildOverlay<Example> child = examples.getChild(name);
		return child != null ? child.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getExampleReference(String name) {
		ChildOverlay<Example> child = examples.getChild(name);
		return child != null ? child.getReference() : null;
	}

	// RequestBody
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, RequestBody> getRequestBodies() {
		return requestBodies.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, RequestBody> getRequestBodies(boolean elaborate) {
		return requestBodies.get(elaborate);
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
	public void setRequestBodies(Map<String, RequestBody> requestBodies) {
		this.requestBodies.set(requestBodies);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setRequestBody(String name, RequestBody requestBody) {
		requestBodies.set(name, requestBody);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeRequestBody(String name) {
		requestBodies.remove(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isRequestBodyReference(String name) {
		ChildOverlay<RequestBody> child = requestBodies.getChild(name);
		return child != null ? child.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getRequestBodyReference(String name) {
		ChildOverlay<RequestBody> child = requestBodies.getChild(name);
		return child != null ? child.getReference() : null;
	}

	// Header
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Header> getHeaders() {
		return headers.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Header> getHeaders(boolean elaborate) {
		return headers.get(elaborate);
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
	public void setHeaders(Map<String, Header> headers) {
		this.headers.set(headers);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setHeader(String name, Header header) {
		headers.set(name, header);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeHeader(String name) {
		headers.remove(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isHeaderReference(String name) {
		ChildOverlay<Header> child = headers.getChild(name);
		return child != null ? child.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getHeaderReference(String name) {
		ChildOverlay<Header> child = headers.getChild(name);
		return child != null ? child.getReference() : null;
	}

	// SecurityScheme
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, SecurityScheme> getSecuritySchemes() {
		return securitySchemes.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, SecurityScheme> getSecuritySchemes(boolean elaborate) {
		return securitySchemes.get(elaborate);
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
	public void setSecuritySchemes(Map<String, SecurityScheme> securitySchemes) {
		this.securitySchemes.set(securitySchemes);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setSecurityScheme(String name, SecurityScheme securityScheme) {
		securitySchemes.set(name, securityScheme);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeSecurityScheme(String name) {
		securitySchemes.remove(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isSecuritySchemeReference(String name) {
		ChildOverlay<SecurityScheme> child = securitySchemes.getChild(name);
		return child != null ? child.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getSecuritySchemeReference(String name) {
		ChildOverlay<SecurityScheme> child = securitySchemes.getChild(name);
		return child != null ? child.getReference() : null;
	}

	// Link
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Link> getLinks() {
		return links.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Link> getLinks(boolean elaborate) {
		return links.get(elaborate);
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
	public void setLinks(Map<String, Link> links) {
		this.links.set(links);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setLink(String name, Link link) {
		links.set(name, link);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeLink(String name) {
		links.remove(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isLinkReference(String name) {
		ChildOverlay<Link> child = links.getChild(name);
		return child != null ? child.isReference() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Reference getLinkReference(String name) {
		ChildOverlay<Link> child = links.getChild(name);
		return child != null ? child.getReference() : null;
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

	// ComponentsExtension
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getComponentsExtensions() {
		return componentsExtensions.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getComponentsExtensions(boolean elaborate) {
		return componentsExtensions.get(elaborate);
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

	// Tag
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<Tag> getTags() {
		return tags.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<Tag> getTags(boolean elaborate) {
		return tags.get(elaborate);
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
	public void setTags(Collection<Tag> tags) {
		this.tags.set(tags);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setTag(int index, Tag tag) {
		tags.set(index, tag);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addTag(Tag tag) {
		tags.add(tag);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void insertTag(int index, Tag tag) {
		tags.insert(index, tag);
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
		openApi = createChild("openapi", this, StringOverlay.factory);
		info = createChild("info", this, InfoImpl.factory);
		servers = createChildList("servers", this, ServerImpl.factory);
		paths = createChildMap("paths", this, PathImpl.factory, "/.*");
		refables.put("paths", paths);
		pathsExtensions = createChildMap("paths", this, ObjectOverlay.factory, "x-.+");
		schemas = createChildMap("components/schemas", this, SchemaImpl.factory, "[a-zA-Z0-9\\._-]+");
		refables.put("components/schemas", schemas);
		responses = createChildMap("components/responses", this, ResponseImpl.factory, "[a-zA-Z0-9\\._-]+");
		refables.put("components/responses", responses);
		parameters = createChildMap("components/parameters", this, ParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
		refables.put("components/parameters", parameters);
		examples = createChildMap("components/examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		refables.put("components/examples", examples);
		requestBodies = createChildMap("components/requestBodies", this, RequestBodyImpl.factory, "[a-zA-Z0-9\\._-]+");
		refables.put("components/requestBodies", requestBodies);
		headers = createChildMap("components/headers", this, HeaderImpl.factory, "[a-zA-Z0-9\\._-]+");
		refables.put("components/headers", headers);
		securitySchemes = createChildMap("components/securitySchemes", this, SecuritySchemeImpl.factory,
				"[a-zA-Z0-9\\._-]+");
		refables.put("components/securitySchemes", securitySchemes);
		links = createChildMap("components/links", this, LinkImpl.factory, "[a-zA-Z0-9\\._-]+");
		refables.put("components/links", links);
		callbacks = createChildMap("components/callbacks", this, CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		refables.put("components/callbacks", callbacks);
		componentsExtensions = createChildMap("components", this, ObjectOverlay.factory, "x-.+");
		securityRequirements = createChildList("security", this, SecurityRequirementImpl.factory);
		tags = createChildList("tags", this, TagImpl.factory);
		externalDocs = createChild("externalDocs", this, ExternalDocsImpl.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<OpenApi3> factory = new OverlayFactory<OpenApi3>() {

		@Override
		protected Class<? extends IJsonOverlay<? super OpenApi3>> getOverlayClass() {
			return OpenApi3Impl.class;
		}

		@Override
		public JsonOverlay<OpenApi3> _create(OpenApi3 openApi3, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			IJsonOverlay<?> overlay;
			overlay = new OpenApi3Impl(openApi3, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<OpenApi3> castOverlay = (JsonOverlay<OpenApi3>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<OpenApi3> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			IJsonOverlay<?> overlay;
			overlay = new OpenApi3Impl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<OpenApi3> castOverlay = (JsonOverlay<OpenApi3>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends OpenApi3> getSubtypeOf(OpenApi3 openApi3) {
		return OpenApi3.class;
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends OpenApi3> getSubtypeOf(JsonNode json) {
		return OpenApi3.class;
	}
}
