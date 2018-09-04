package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reprezen.jsonoverlay.Builder;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
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
import com.reprezen.kaizen.oasparser.val.ValidationContext;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.ValidationResults.Severity;
import com.reprezen.kaizen.oasparser.val3.OpenApi3Validator;

public class OpenApi3Impl extends PropertiesOverlay<OpenApi3> implements OpenApi3 {

	private ValidationResults validationResults = null;

	@Override
	protected JsonNode _fixJson(JsonNode json) {
		if (json.isMissingNode()) {
			json = _jsonObject();
		}
		if (!json.has("paths")) {
			((ObjectNode) json).putObject("paths");
		}
		return json;
	}

	@Override
	public void validate() {
		try (ValidationContext context = ValidationContext.open()) {
			validationResults = ValidationContext.getValidationResults();
			new OpenApi3Validator().validate(Overlay.of(this));
		}
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

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OpenApi3Impl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public OpenApi3Impl(OpenApi3 openApi3, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(openApi3, parent, factory, refMgr);
	}

	// OpenApi
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getOpenApi() {
		return _get("openApi", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOpenApi(String openApi) {
		_setScalar("openApi", openApi, String.class);
	}

	// Info
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Info getInfo() {
		return _get("info", Info.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Info getInfo(boolean elaborate) {
		return _get("info", elaborate, Info.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setInfo(Info info) {
		_setScalar("info", info, Info.class);
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

	// Path
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Path> getPaths() {
		return _getMap("paths", Path.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Path> getPaths(boolean elaborate) {
		return _getMap("paths", elaborate, Path.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasPaths() {
		return _isPresent("paths");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasPath(String name) {
		return _getMap("paths", Path.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Path getPath(String name) {
		return _get("paths", name, Path.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setPaths(Map<String, Path> paths) {
		_setMap("paths", paths, Path.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setPath(String name, Path path) {
		_set("paths", name, path, Path.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removePath(String name) {
		_remove("paths", name, Path.class);
	}

	// PathsExtension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getPathsExtensions() {
		return _getMap("pathsExtensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getPathsExtensions(boolean elaborate) {
		return _getMap("pathsExtensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasPathsExtensions() {
		return _isPresent("pathsExtensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasPathsExtension(String name) {
		return _getMap("pathsExtensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getPathsExtension(String name) {
		return _get("pathsExtensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setPathsExtensions(Map<String, Object> pathsExtensions) {
		_setMap("pathsExtensions", pathsExtensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setPathsExtension(String name, Object pathsExtension) {
		_set("pathsExtensions", name, pathsExtension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removePathsExtension(String name) {
		_remove("pathsExtensions", name, Object.class);
	}

	// Schema
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Schema> getSchemas() {
		return _getMap("schemas", Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Schema> getSchemas(boolean elaborate) {
		return _getMap("schemas", elaborate, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasSchemas() {
		return _isPresent("schemas");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasSchema(String name) {
		return _getMap("schemas", Schema.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getSchema(String name) {
		return _get("schemas", name, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setSchemas(Map<String, Schema> schemas) {
		_setMap("schemas", schemas, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setSchema(String name, Schema schema) {
		_set("schemas", name, schema, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeSchema(String name) {
		_remove("schemas", name, Schema.class);
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

	// Parameter
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Parameter> getParameters() {
		return _getMap("parameters", Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Parameter> getParameters(boolean elaborate) {
		return _getMap("parameters", elaborate, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasParameters() {
		return _isPresent("parameters");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasParameter(String name) {
		return _getMap("parameters", Parameter.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Parameter getParameter(String name) {
		return _get("parameters", name, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setParameters(Map<String, Parameter> parameters) {
		_setMap("parameters", parameters, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setParameter(String name, Parameter parameter) {
		_set("parameters", name, parameter, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeParameter(String name) {
		_remove("parameters", name, Parameter.class);
	}

	// Example
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Example> getExamples() {
		return _getMap("examples", Example.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Example> getExamples(boolean elaborate) {
		return _getMap("examples", elaborate, Example.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExamples() {
		return _isPresent("examples");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExample(String name) {
		return _getMap("examples", Example.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Example getExample(String name) {
		return _get("examples", name, Example.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExamples(Map<String, Example> examples) {
		_setMap("examples", examples, Example.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExample(String name, Example example) {
		_set("examples", name, example, Example.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExample(String name) {
		_remove("examples", name, Example.class);
	}

	// RequestBody
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, RequestBody> getRequestBodies() {
		return _getMap("requestBodies", RequestBody.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, RequestBody> getRequestBodies(boolean elaborate) {
		return _getMap("requestBodies", elaborate, RequestBody.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasRequestBodies() {
		return _isPresent("requestBodies");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasRequestBody(String name) {
		return _getMap("requestBodies", RequestBody.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public RequestBody getRequestBody(String name) {
		return _get("requestBodies", name, RequestBody.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setRequestBodies(Map<String, RequestBody> requestBodies) {
		_setMap("requestBodies", requestBodies, RequestBody.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setRequestBody(String name, RequestBody requestBody) {
		_set("requestBodies", name, requestBody, RequestBody.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeRequestBody(String name) {
		_remove("requestBodies", name, RequestBody.class);
	}

	// Header
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Header> getHeaders() {
		return _getMap("headers", Header.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Header> getHeaders(boolean elaborate) {
		return _getMap("headers", elaborate, Header.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasHeaders() {
		return _isPresent("headers");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasHeader(String name) {
		return _getMap("headers", Header.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Header getHeader(String name) {
		return _get("headers", name, Header.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setHeaders(Map<String, Header> headers) {
		_setMap("headers", headers, Header.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setHeader(String name, Header header) {
		_set("headers", name, header, Header.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeHeader(String name) {
		_remove("headers", name, Header.class);
	}

	// SecurityScheme
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, SecurityScheme> getSecuritySchemes() {
		return _getMap("securitySchemes", SecurityScheme.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, SecurityScheme> getSecuritySchemes(boolean elaborate) {
		return _getMap("securitySchemes", elaborate, SecurityScheme.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasSecuritySchemes() {
		return _isPresent("securitySchemes");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasSecurityScheme(String name) {
		return _getMap("securitySchemes", SecurityScheme.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public SecurityScheme getSecurityScheme(String name) {
		return _get("securitySchemes", name, SecurityScheme.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setSecuritySchemes(Map<String, SecurityScheme> securitySchemes) {
		_setMap("securitySchemes", securitySchemes, SecurityScheme.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setSecurityScheme(String name, SecurityScheme securityScheme) {
		_set("securitySchemes", name, securityScheme, SecurityScheme.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeSecurityScheme(String name) {
		_remove("securitySchemes", name, SecurityScheme.class);
	}

	// Link
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Link> getLinks() {
		return _getMap("links", Link.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Link> getLinks(boolean elaborate) {
		return _getMap("links", elaborate, Link.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasLinks() {
		return _isPresent("links");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasLink(String name) {
		return _getMap("links", Link.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Link getLink(String name) {
		return _get("links", name, Link.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setLinks(Map<String, Link> links) {
		_setMap("links", links, Link.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setLink(String name, Link link) {
		_set("links", name, link, Link.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeLink(String name) {
		_remove("links", name, Link.class);
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

	// ComponentsExtension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getComponentsExtensions() {
		return _getMap("componentsExtensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getComponentsExtensions(boolean elaborate) {
		return _getMap("componentsExtensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasComponentsExtensions() {
		return _isPresent("componentsExtensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasComponentsExtension(String name) {
		return _getMap("componentsExtensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getComponentsExtension(String name) {
		return _get("componentsExtensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setComponentsExtensions(Map<String, Object> componentsExtensions) {
		_setMap("componentsExtensions", componentsExtensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setComponentsExtension(String name, Object componentsExtension) {
		_set("componentsExtensions", name, componentsExtension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeComponentsExtension(String name) {
		_remove("componentsExtensions", name, Object.class);
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

	// Tag
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Tag> getTags() {
		return _getList("tags", Tag.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Tag> getTags(boolean elaborate) {
		return _getList("tags", elaborate, Tag.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasTags() {
		return _isPresent("tags");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Tag getTag(int index) {
		return _get("tags", index, Tag.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setTags(List<Tag> tags) {
		_setList("tags", tags, Tag.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setTag(int index, Tag tag) {
		_set("tags", index, tag, Tag.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addTag(Tag tag) {
		_add("tags", tag, Tag.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertTag(int index, Tag tag) {
		_insert("tags", index, tag, Tag.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeTag(int index) {
		_remove("tags", index, Tag.class);
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
	public static final String F_openApi = "openApi";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_info = "info";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_servers = "servers";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_paths = "paths";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_pathsExtensions = "pathsExtensions";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_schemas = "schemas";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_responses = "responses";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_parameters = "parameters";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_examples = "examples";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_requestBodies = "requestBodies";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_headers = "headers";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_securitySchemes = "securitySchemes";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_links = "links";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_callbacks = "callbacks";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_componentsExtensions = "componentsExtensions";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_securityRequirements = "securityRequirements";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_tags = "tags";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_externalDocs = "externalDocs";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("openApi", "openapi", StringOverlay.factory);
		_createScalar("info", "info", InfoImpl.factory);
		_createList("servers", "servers", ServerImpl.factory);
		_createMap("paths", "paths", PathImpl.factory, "/.*");
		_createMap("pathsExtensions", "paths", ObjectOverlay.factory, "x-.+");
		_createMap("schemas", "components/schemas", SchemaImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("responses", "components/responses", ResponseImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("parameters", "components/parameters", ParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("examples", "components/examples", ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("requestBodies", "components/requestBodies", RequestBodyImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("headers", "components/headers", HeaderImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("securitySchemes", "components/securitySchemes", SecuritySchemeImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("links", "components/links", LinkImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("callbacks", "components/callbacks", CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		_createMap("componentsExtensions", "components", ObjectOverlay.factory, "x-.+");
		_createList("securityRequirements", "security", SecurityRequirementImpl.factory);
		_createList("tags", "tags", TagImpl.factory);
		_createScalar("externalDocs", "externalDocs", ExternalDocsImpl.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<OpenApi3> factory = new OverlayFactory<OpenApi3>() {

		@Override
		protected Class<? extends JsonOverlay<? super OpenApi3>> getOverlayClass() {
			return OpenApi3Impl.class;
		}

		@Override
		public JsonOverlay<OpenApi3> _create(OpenApi3 openApi3, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OpenApi3Impl(openApi3, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<OpenApi3> castOverlay = (JsonOverlay<OpenApi3>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<OpenApi3> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OpenApi3Impl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<OpenApi3> castOverlay = (JsonOverlay<OpenApi3>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends OpenApi3> getSubtypeOf(OpenApi3 openApi3) {
		return OpenApi3.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends OpenApi3> getSubtypeOf(JsonNode json) {
		return OpenApi3.class;
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
	public static <OV extends IJsonOverlay<?>> Builder<OpenApi3> builder(OV modelMember) {
		return new Builder<OpenApi3>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> OpenApi3 create(OV modelMember) {
		return (OpenApi3) builder(modelMember).build();
	}
}
