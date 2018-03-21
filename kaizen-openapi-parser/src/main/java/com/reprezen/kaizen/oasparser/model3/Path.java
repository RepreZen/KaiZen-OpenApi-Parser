package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import com.reprezen.kaizen.oasparser.model3.Server;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import java.util.Collection;
import java.util.Map;
import com.reprezen.jsonoverlay.Reference;

public interface Path extends IPropertiesOverlay<Path>, IModelPart<OpenApi3, Path> {

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

    // Operation
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Operation> getOperations();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Operation> getOperations(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasOperation(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getOperation(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setOperations(Map<String, Operation> operations);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setOperation(String name, Operation operation);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeOperation(String name);

    // Get
    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getGet();

    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getGet(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setGet(Operation get);

    // Put
    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getPut();

    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getPut(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setPut(Operation put);

    // Post
    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getPost();

    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getPost(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setPost(Operation post);

    // Delete
    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getDelete();

    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getDelete(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDelete(Operation delete);

    // Options
    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getOptions();

    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getOptions(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setOptions(Operation options);

    // Head
    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getHead();

    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getHead(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setHead(Operation head);

    // Patch
    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getPatch();

    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getPatch(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setPatch(Operation patch);

    // Trace
    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getTrace();

    @Generated("com.reprezen.gen.CodeGenerator")
    Operation getTrace(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setTrace(Operation trace);

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
