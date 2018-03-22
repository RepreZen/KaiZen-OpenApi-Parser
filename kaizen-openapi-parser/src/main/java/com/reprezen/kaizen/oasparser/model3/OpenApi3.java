package com.reprezen.kaizen.oasparser.model3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import com.reprezen.kaizen.oasparser.OpenApi;
import com.reprezen.kaizen.oasparser.val.ValidationResults;

public interface OpenApi3 extends IJsonOverlay<OpenApi3>, IModelPart<OpenApi3, OpenApi3>, OpenApi<OpenApi3> {

	public void validate();

	public boolean isValid();

	public ValidationResults getValidationResults();

	public Collection<ValidationResults.ValidationItem> getValidationItems();

	// OpenApi
	@Generated("com.reprezen.gen.CodeGenerator")
	String getOpenApi();

	@Generated("com.reprezen.gen.CodeGenerator")
	String getOpenApi(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setOpenApi(String openApi);

	// Info
	@Generated("com.reprezen.gen.CodeGenerator")
	Info getInfo();

	@Generated("com.reprezen.gen.CodeGenerator")
	Info getInfo(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setInfo(Info info);

	// Server
	@Generated("com.reprezen.gen.CodeGenerator")
	Collection<Server> getServers();

	@Generated("com.reprezen.gen.CodeGenerator")
	Collection<Server> getServers(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasServers();

	@Generated("com.reprezen.gen.CodeGenerator")
	Server getServer(int index);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setServers(Collection<Server> servers);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setServer(int index, Server server);

	@Generated("com.reprezen.gen.CodeGenerator")
	void addServer(Server server);

	@Generated("com.reprezen.gen.CodeGenerator")
	void insertServer(int index, Server server);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeServer(int index);

	// Path
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Path> getPaths();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Path> getPaths(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasPath(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Path getPath(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setPaths(Map<String, Path> paths);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setPath(String name, Path path);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removePath(String name);

	// PathsExtension
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Object> getPathsExtensions();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Object> getPathsExtensions(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasPathsExtension(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Object getPathsExtension(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setPathsExtensions(Map<String, Object> pathsExtensions);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setPathsExtension(String name, Object pathsExtension);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removePathsExtension(String name);

	// Schema
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Schema> getSchemas();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Schema> getSchemas(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasSchema(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Schema getSchema(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setSchemas(Map<String, Schema> schemas);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setSchema(String name, Schema schema);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeSchema(String name);

	// Response
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Response> getResponses();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Response> getResponses(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasResponse(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Response getResponse(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setResponses(Map<String, Response> responses);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setResponse(String name, Response response);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeResponse(String name);

	// Parameter
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Parameter> getParameters();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Parameter> getParameters(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasParameter(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Parameter getParameter(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setParameters(Map<String, Parameter> parameters);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setParameter(String name, Parameter parameter);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeParameter(String name);

	// Example
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Example> getExamples();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Example> getExamples(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasExample(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Example getExample(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setExamples(Map<String, Example> examples);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setExample(String name, Example example);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeExample(String name);

	// RequestBody
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, RequestBody> getRequestBodies();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, RequestBody> getRequestBodies(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasRequestBody(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	RequestBody getRequestBody(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setRequestBodies(Map<String, RequestBody> requestBodies);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setRequestBody(String name, RequestBody requestBody);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeRequestBody(String name);

	// Header
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Header> getHeaders();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Header> getHeaders(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasHeader(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Header getHeader(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setHeaders(Map<String, Header> headers);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setHeader(String name, Header header);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeHeader(String name);

	// SecurityScheme
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, SecurityScheme> getSecuritySchemes();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, SecurityScheme> getSecuritySchemes(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasSecurityScheme(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	SecurityScheme getSecurityScheme(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setSecuritySchemes(Map<String, SecurityScheme> securitySchemes);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setSecurityScheme(String name, SecurityScheme securityScheme);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeSecurityScheme(String name);

	// Link
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Link> getLinks();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Link> getLinks(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasLink(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Link getLink(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setLinks(Map<String, Link> links);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setLink(String name, Link link);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeLink(String name);

	// Callback
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Callback> getCallbacks();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Callback> getCallbacks(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasCallback(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Callback getCallback(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setCallbacks(Map<String, Callback> callbacks);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setCallback(String name, Callback callback);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeCallback(String name);

	// ComponentsExtension
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Object> getComponentsExtensions();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Object> getComponentsExtensions(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasComponentsExtension(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Object getComponentsExtension(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setComponentsExtensions(Map<String, Object> componentsExtensions);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setComponentsExtension(String name, Object componentsExtension);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeComponentsExtension(String name);

	// SecurityRequirement
	@Generated("com.reprezen.gen.CodeGenerator")
	Collection<SecurityRequirement> getSecurityRequirements();

	@Generated("com.reprezen.gen.CodeGenerator")
	Collection<SecurityRequirement> getSecurityRequirements(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasSecurityRequirements();

	@Generated("com.reprezen.gen.CodeGenerator")
	SecurityRequirement getSecurityRequirement(int index);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setSecurityRequirements(Collection<SecurityRequirement> securityRequirements);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setSecurityRequirement(int index, SecurityRequirement securityRequirement);

	@Generated("com.reprezen.gen.CodeGenerator")
	void addSecurityRequirement(SecurityRequirement securityRequirement);

	@Generated("com.reprezen.gen.CodeGenerator")
	void insertSecurityRequirement(int index, SecurityRequirement securityRequirement);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeSecurityRequirement(int index);

	// Tag
	@Generated("com.reprezen.gen.CodeGenerator")
	Collection<Tag> getTags();

	@Generated("com.reprezen.gen.CodeGenerator")
	Collection<Tag> getTags(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasTags();

	@Generated("com.reprezen.gen.CodeGenerator")
	Tag getTag(int index);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setTags(Collection<Tag> tags);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setTag(int index, Tag tag);

	@Generated("com.reprezen.gen.CodeGenerator")
	void addTag(Tag tag);

	@Generated("com.reprezen.gen.CodeGenerator")
	void insertTag(int index, Tag tag);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeTag(int index);

	// ExternalDocs
	@Generated("com.reprezen.gen.CodeGenerator")
	ExternalDocs getExternalDocs();

	@Generated("com.reprezen.gen.CodeGenerator")
	ExternalDocs getExternalDocs(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setExternalDocs(ExternalDocs externalDocs);

	// Extension
	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Object> getExtensions();

	@Generated("com.reprezen.gen.CodeGenerator")
	Map<String, Object> getExtensions(boolean elaborate);

	@Generated("com.reprezen.gen.CodeGenerator")
	boolean hasExtension(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	Object getExtension(String name);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setExtensions(Map<String, Object> extensions);

	@Generated("com.reprezen.gen.CodeGenerator")
	void setExtension(String name, Object extension);

	@Generated("com.reprezen.gen.CodeGenerator")
	void removeExtension(String name);
}
