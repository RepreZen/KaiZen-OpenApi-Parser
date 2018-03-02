package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.ovl3.ParameterImpl;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.fasterxml.jackson.core.JsonPointer;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.jsonoverlay.PropertiesOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.PropertiesOverlay.PropertiesOverlayFactory;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import java.util.Map;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.ovl3.ServerImpl;
import com.reprezen.kaizen.oasparser.jsonoverlay.IJsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ObjectOverlay;
import com.reprezen.kaizen.oasparser.ovl3.OperationImpl;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import java.util.Collection;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.jsonoverlay.Reference;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildOverlay;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;

public class PathImpl extends PropertiesOverlay<Path> implements Path {

    @Override
    public Operation getGet() {
        return operations.get("get");
    }

    @Override
    public Operation getGet(boolean elaborate) {
        return operations.get("get").get(elaborate);
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
    public Operation getPut(boolean elaborate) {
        return operations.get("put").get(elaborate);
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
    public Operation getPost(boolean elaborate) {
        return operations.get("post").get(elaborate);
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
    public Operation getDelete(boolean elaborate) {
        return operations.get("delete").get(elaborate);
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
    public Operation getOptions(boolean elaborate) {
        return operations.get("options").get(elaborate);
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
    public Operation getHead(boolean elaborate) {
        return operations.get("head").get(elaborate);
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
    public Operation getPatch(boolean elaborate) {
        return operations.get("patch").get(elaborate);
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
    public Operation getTrace(boolean elaborate) {
        return operations.get("trace").get(elaborate);
    }

    @Override
    public void setTrace(Operation trace) {
        operations.set("trace", (OperationImpl) trace);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public PathImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public PathImpl(Path path, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(path, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> summary;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String> description;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Operation> operations;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildListOverlay<Server> servers;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildListOverlay<Parameter> parameters;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object> extensions;

    // Summary
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getSummary() {
        return summary.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getSummary(boolean elaborate) {
        return summary.get(elaborate);
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
    public String getDescription(boolean elaborate) {
        return description.get(elaborate);
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
    public Map<String, Operation> getOperations(boolean elaborate) {
        return operations.get(elaborate);
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

    // Parameter
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Parameter> getParameters() {
        return parameters.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Parameter> getParameters(boolean elaborate) {
        return parameters.get(elaborate);
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
        this.parameters.set(parameters);
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
    public void insertParameter(int index, Parameter parameter) {
        parameters.insert(index, parameter);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeParameter(int index) {
        parameters.remove(index);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isParameterReference(int index) {
        return parameters.getChild(index).isReference();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Reference getParameterReference(int index) {
        return parameters.getChild(index).getReference();
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
        summary = createChild("summary", this, StringOverlay.factory);
        description = createChild("description", this, StringOverlay.factory);
        operations = createChildMap("", this, OperationImpl.factory, "get|put|post|delete|options|head|patch|trace");
        servers = createChildList("servers", this, ServerImpl.factory);
        parameters = createChildList("parameters", this, ParameterImpl.factory);
        refables.put("parameters", parameters);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    protected void copyChildProperties(JsonOverlay<?> from) {
        super.copyChildProperties(from);
        PathImpl impl = (PathImpl) from;
        this.summary = impl.summary;
        ChildOverlay.reparent(summary, impl, this);
        this.description = impl.description;
        ChildOverlay.reparent(description, impl, this);
        this.operations = impl.operations;
        ChildOverlay.reparent(operations, impl, this);
        this.servers = impl.servers;
        ChildOverlay.reparent(servers, impl, this);
        this.parameters = impl.parameters;
        ChildOverlay.reparent(parameters, impl, this);
        refables.put("parameters", parameters);
        this.extensions = impl.extensions;
        ChildOverlay.reparent(extensions, impl, this);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<Path> factory = new PropertiesOverlayFactory<Path>() {

        @Override
        protected Class<? extends IJsonOverlay<? super Path>> getOverlayClass() {
            return PathImpl.class;
        }

        @Override
        public JsonOverlay<Path> _create(Path path, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new PathImpl(path, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Path> castOverlay = (JsonOverlay<Path>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<Path> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new PathImpl(json, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Path> castOverlay = (JsonOverlay<Path>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends Path> getSubtypeOf(Path path) {
        return Path.class;
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends Path> getSubtypeOf(JsonNode json) {
        return Path.class;
    }
}
