package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.Callback;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.Response;
import java.util.List;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;

public interface Operation extends IJsonOverlay<Operation>, IModelPart<OpenApi3, Operation> {

    // Tag
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<String> getTags();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<String> getTags(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasTags();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getTag(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setTags(List<String> tags);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setTag(int index, String tag);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addTag(String tag);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertTag(int index, String tag);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeTag(int index);

    // Summary
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getSummary();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setSummary(String summary);

    // Description
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // ExternalDocs
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ExternalDocs getExternalDocs();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ExternalDocs getExternalDocs(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExternalDocs(ExternalDocs externalDocs);

    // OperationId
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getOperationId();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setOperationId(String operationId);

    // Parameter
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<Parameter> getParameters();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<Parameter> getParameters(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasParameters();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Parameter getParameter(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setParameters(List<Parameter> parameters);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setParameter(int index, Parameter parameter);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addParameter(Parameter parameter);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertParameter(int index, Parameter parameter);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeParameter(int index);

    // RequestBody
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    RequestBody getRequestBody();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    RequestBody getRequestBody(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRequestBody(RequestBody requestBody);

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

    // ResponsesExtension
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getResponsesExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getResponsesExtensions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasResponsesExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasResponsesExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getResponsesExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setResponsesExtensions(Map<String, Object> responsesExtensions);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setResponsesExtension(String name, Object responsesExtension);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeResponsesExtension(String name);

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

    // CallbacksExtension
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getCallbacksExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getCallbacksExtensions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasCallbacksExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasCallbacksExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getCallbacksExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setCallbacksExtensions(Map<String, Object> callbacksExtensions);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setCallbacksExtension(String name, Object callbacksExtension);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeCallbacksExtension(String name);

    // Deprecated
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Boolean getDeprecated();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean isDeprecated();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDeprecated(Boolean deprecated);

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
