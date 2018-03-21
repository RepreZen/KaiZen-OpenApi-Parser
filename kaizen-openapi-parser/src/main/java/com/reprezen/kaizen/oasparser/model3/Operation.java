package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import java.util.Collection;
import com.reprezen.jsonoverlay.Reference;
import com.reprezen.jsonoverlay.IModelPart;
import com.reprezen.kaizen.oasparser.model3.Callback;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;

public interface Operation extends IPropertiesOverlay<Operation>, IModelPart<OpenApi3, Operation> {

    // Tag
    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<String> getTags();

    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<String> getTags(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasTags();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getTag(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setTags(Collection<String> tags);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setTag(int index, String tag);

    @Generated("com.reprezen.gen.CodeGenerator")
    void addTag(String tag);

    @Generated("com.reprezen.gen.CodeGenerator")
    void insertTag(int index, String tag);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeTag(int index);

    // Summary
    @Generated("com.reprezen.gen.CodeGenerator")
    String getSummary();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getSummary(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setSummary(String summary);

    // Description
    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDescription(String description);

    // ExternalDocs
    @Generated("com.reprezen.gen.CodeGenerator")
    ExternalDocs getExternalDocs();

    @Generated("com.reprezen.gen.CodeGenerator")
    ExternalDocs getExternalDocs(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExternalDocs(ExternalDocs externalDocs);

    // OperationId
    @Generated("com.reprezen.gen.CodeGenerator")
    String getOperationId();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getOperationId(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setOperationId(String operationId);

    // Parameter
    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Parameter> getParameters();

    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Parameter> getParameters(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasParameters();

    @Generated("com.reprezen.gen.CodeGenerator")
    Parameter getParameter(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setParameters(Collection<Parameter> parameters);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setParameter(int index, Parameter parameter);

    @Generated("com.reprezen.gen.CodeGenerator")
    void addParameter(Parameter parameter);

    @Generated("com.reprezen.gen.CodeGenerator")
    void insertParameter(int index, Parameter parameter);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeParameter(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isParameterReference(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getParameterReference(int index);

    // RequestBody
    @Generated("com.reprezen.gen.CodeGenerator")
    RequestBody getRequestBody();

    @Generated("com.reprezen.gen.CodeGenerator")
    RequestBody getRequestBody(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setRequestBody(RequestBody requestBody);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isRequestBodyReference();

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getRequestBodyReference();

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

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isResponseReference(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getResponseReference(String name);

    // ResponsesExtension
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getResponsesExtensions();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getResponsesExtensions(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasResponsesExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getResponsesExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setResponsesExtensions(Map<String, Object> responsesExtensions);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setResponsesExtension(String name, Object responsesExtension);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeResponsesExtension(String name);

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

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isCallbackReference(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getCallbackReference(String name);

    // CallbacksExtension
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getCallbacksExtensions();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getCallbacksExtensions(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasCallbacksExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getCallbacksExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setCallbacksExtensions(Map<String, Object> callbacksExtensions);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setCallbacksExtension(String name, Object callbacksExtension);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeCallbacksExtension(String name);

    // Deprecated
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getDeprecated();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getDeprecated(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isDeprecated();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDeprecated(Boolean deprecated);

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
