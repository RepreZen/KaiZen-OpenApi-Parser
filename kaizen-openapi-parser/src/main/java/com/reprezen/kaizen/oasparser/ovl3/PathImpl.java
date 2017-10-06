package com.reprezen.kaizen.oasparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import com.reprezen.kaizen.oasparser.ovl3.OperationImpl;
import com.reprezen.kaizen.oasparser.ovl3.ParameterImpl;
import com.reprezen.kaizen.oasparser.ovl3.ServerImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class PathImpl extends OpenApiObjectImpl<Path> implements Path {

    @Override
    public Operation getGet() {
        return operations.get("get");
    }

    @Override
    public void setGet(Operation get) {
        operations.set("get", (OperationImpl) get);
    }

    @Override
    public Operation getPut() {
        return operations.get("put");
    }

    @Override
    public void setPut(Operation put) {
        operations.set("put", (OperationImpl) put);
    }

    @Override
    public Operation getPost() {
        return operations.get("post");
    }

    @Override
    public void setPost(Operation post) {
        operations.set("post", (OperationImpl) post);
    }

    @Override
    public Operation getDelete() {
        return operations.get("delete");
    }

    @Override
    public void setDelete(Operation delete) {
        operations.set("delete", (OperationImpl) delete);
    }

    @Override
    public Operation getOptions() {
        return operations.get("options");
    }

    @Override
    public void setOptions(Operation options) {
        operations.set("options", (OperationImpl) options);
    }

    @Override
    public Operation getHead() {
        return operations.get("head");
    }

    @Override
    public void setHead(Operation head) {
        operations.set("head", (OperationImpl) head);
    }

    @Override
    public Operation getPatch() {
        return operations.get("patch");
    }

    @Override
    public void setPatch(Operation patch) {
        operations.set("patch", (OperationImpl) patch);
    }

    @Override
    public Operation getTrace() {
        return operations.get("trace");
    }

    @Override
    public void setTrace(Operation trace) {
        operations.set("trace", (OperationImpl) trace);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public PathImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public PathImpl(Path path, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(path, parent, refReg);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> summary = createChild("summary", this, StringOverlay.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> description = createChild("description", this, StringOverlay.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Operation, OperationImpl> operations = createChildMap("", this, OperationImpl.factory, "get|put|post|delete|options|head|patch|trace");

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildListOverlay<Server, ServerImpl> servers = createChildList("servers", this, ServerImpl.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildListOverlay<Parameter, ParameterImpl> parameters = createChildList("parameters", this, ParameterImpl.factory);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object, ObjectOverlay> extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");

    // Summary
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getSummary() {
        return summary.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setSummary(String summary) {
        this.summary.set(summary);
    }

    // Description
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getDescription() {
        return description.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setDescription(String description) {
        this.description.set(description);
    }

    // Operation
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Operation> getOperations() {
        return operations.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasOperation(String name) {
        return operations.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Operation getOperation(String name) {
        return operations.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setOperations(Map<String, Operation> operations) {
        this.operations.set(operations);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setOperation(String name, Operation operation) {
        operations.set(name, operation);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeOperation(String name) {
        operations.remove(name);
    }

    // Server
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Server> getServers() {
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
    public void setServers(Collection<Server> servers) {
        this.servers.set((Collection<Server>) servers);
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
    public void removeServer(int index) {
        servers.remove(index);
    }

    // Parameter
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Parameter> getParameters() {
        return parameters.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasParameters() {
        return parameters.isPresent();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Parameter getParameter(int index) {
        return parameters.get(index);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setParameters(Collection<Parameter> parameters) {
        this.parameters.set((Collection<Parameter>) parameters);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setParameter(int index, Parameter parameter) {
        parameters.set(index, parameter);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void addParameter(Parameter parameter) {
        parameters.add(parameter);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeParameter(int index) {
        parameters.remove(index);
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
    public static OverlayFactory<Path, PathImpl> factory = new OverlayFactory<Path, PathImpl>() {
    @Override
    protected Class<? super PathImpl> getOverlayClass() {
         return PathImpl.class;
    }

    @Override
    public PathImpl _create(Path path, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new PathImpl(path, parent, refReg);
    }

    @Override
    public PathImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new PathImpl(json, parent, refReg);
    }
};

}
