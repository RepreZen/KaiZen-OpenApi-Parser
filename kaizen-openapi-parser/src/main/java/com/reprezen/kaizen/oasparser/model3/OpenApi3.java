package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import java.util.Collection;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.Link;
import com.reprezen.jsonoverlay.IModelPart;
import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.OpenApi;
import java.util.List;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Tag;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;
import com.reprezen.kaizen.oasparser.model3.Info;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;

public interface OpenApi3 extends IJsonOverlay<OpenApi3>, IModelPart<OpenApi3, OpenApi3>, OpenApi<OpenApi3> {

    public void validate();

    public boolean isValid();

    public ValidationResults getValidationResults();

    public Collection<ValidationResults.ValidationItem> getValidationItems();

    // OpenApi
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getOpenApi();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setOpenApi(String openApi);

    // Info
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Info getInfo();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Info getInfo(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setInfo(Info info);

    // Server
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<Server> getServers();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<Server> getServers(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasServers();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Server getServer(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setServers(List<Server> servers);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setServer(int index, Server server);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addServer(Server server);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertServer(int index, Server server);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeServer(int index);

    // Path
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Path> getPaths();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Path> getPaths(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasPaths();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasPath(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Path getPath(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPaths(Map<String, Path> paths);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPath(String name, Path path);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removePath(String name);

    // PathsExtension
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getPathsExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getPathsExtensions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasPathsExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasPathsExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getPathsExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPathsExtensions(Map<String, Object> pathsExtensions);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPathsExtension(String name, Object pathsExtension);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removePathsExtension(String name);

    // Schema
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Schema> getSchemas();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Schema> getSchemas(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasSchemas();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasSchema(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Schema getSchema(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setSchemas(Map<String, Schema> schemas);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setSchema(String name, Schema schema);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeSchema(String name);

    // Response
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Response> getResponses();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Response> getResponses(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasResponses();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasResponse(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Response getResponse(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setResponses(Map<String, Response> responses);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setResponse(String name, Response response);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeResponse(String name);

    // Parameter
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Parameter> getParameters();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Parameter> getParameters(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasParameters();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasParameter(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Parameter getParameter(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setParameters(Map<String, Parameter> parameters);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setParameter(String name, Parameter parameter);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeParameter(String name);

    // Example
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Example> getExamples();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Example> getExamples(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExamples();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExample(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Example getExample(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExamples(Map<String, Example> examples);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExample(String name, Example example);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeExample(String name);

    // RequestBody
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, RequestBody> getRequestBodies();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, RequestBody> getRequestBodies(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasRequestBodies();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasRequestBody(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    RequestBody getRequestBody(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRequestBodies(Map<String, RequestBody> requestBodies);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRequestBody(String name, RequestBody requestBody);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeRequestBody(String name);

    // Header
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Header> getHeaders();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Header> getHeaders(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasHeaders();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasHeader(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Header getHeader(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setHeaders(Map<String, Header> headers);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setHeader(String name, Header header);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeHeader(String name);

    // SecurityScheme
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, SecurityScheme> getSecuritySchemes();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, SecurityScheme> getSecuritySchemes(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasSecuritySchemes();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasSecurityScheme(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    SecurityScheme getSecurityScheme(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setSecuritySchemes(Map<String, SecurityScheme> securitySchemes);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setSecurityScheme(String name, SecurityScheme securityScheme);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeSecurityScheme(String name);

    // Link
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Link> getLinks();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Link> getLinks(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasLinks();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasLink(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Link getLink(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLinks(Map<String, Link> links);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLink(String name, Link link);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeLink(String name);

    // Callback
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Callback> getCallbacks();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Callback> getCallbacks(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasCallbacks();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasCallback(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Callback getCallback(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setCallbacks(Map<String, Callback> callbacks);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setCallback(String name, Callback callback);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeCallback(String name);

    // ComponentsExtension
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getComponentsExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getComponentsExtensions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasComponentsExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasComponentsExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getComponentsExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setComponentsExtensions(Map<String, Object> componentsExtensions);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setComponentsExtension(String name, Object componentsExtension);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeComponentsExtension(String name);

    // SecurityRequirement
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<SecurityRequirement> getSecurityRequirements();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<SecurityRequirement> getSecurityRequirements(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasSecurityRequirements();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    SecurityRequirement getSecurityRequirement(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setSecurityRequirements(List<SecurityRequirement> securityRequirements);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setSecurityRequirement(int index, SecurityRequirement securityRequirement);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addSecurityRequirement(SecurityRequirement securityRequirement);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertSecurityRequirement(int index, SecurityRequirement securityRequirement);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeSecurityRequirement(int index);

    // Tag
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<Tag> getTags();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<Tag> getTags(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasTags();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Tag getTag(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setTags(List<Tag> tags);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setTag(int index, Tag tag);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addTag(Tag tag);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertTag(int index, Tag tag);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeTag(int index);

    // ExternalDocs
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ExternalDocs getExternalDocs();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ExternalDocs getExternalDocs(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExternalDocs(ExternalDocs externalDocs);

    // Extension
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeExtension(String name);
}
