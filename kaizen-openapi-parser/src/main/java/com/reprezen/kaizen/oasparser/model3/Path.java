package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import com.reprezen.kaizen.oasparser.model3.Server;
import javax.annotation.Generated;
import java.util.List;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import java.util.Map;

public interface Path extends IJsonOverlay<Path>, IModelPart<OpenApi3, Path> {

    String getPathString();

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

    // Operation
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Operation> getOperations();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Operation> getOperations(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasOperations();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasOperation(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getOperation(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setOperations(Map<String, Operation> operations);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setOperation(String name, Operation operation);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeOperation(String name);

    // Get
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getGet();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getGet(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setGet(Operation get);

    // Put
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getPut();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getPut(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPut(Operation put);

    // Post
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getPost();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getPost(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPost(Operation post);

    // Delete
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getDelete();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getDelete(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDelete(Operation delete);

    // Options
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getOptions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getOptions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setOptions(Operation options);

    // Head
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getHead();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getHead(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setHead(Operation head);

    // Patch
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getPatch();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getPatch(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPatch(Operation patch);

    // Trace
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getTrace();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Operation getTrace(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setTrace(Operation trace);

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
