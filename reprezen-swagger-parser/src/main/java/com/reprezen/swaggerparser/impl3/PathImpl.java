/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.impl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.impl3.OperationImpl;
import com.reprezen.swaggerparser.impl3.ParameterImpl;
import com.reprezen.swaggerparser.impl3.ServerImpl;
import com.reprezen.swaggerparser.impl3.SwaggerObjectImpl;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.swaggerparser.jsonoverlay.coll.ListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.MapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValMapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.AnyObjectOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.StringOverlay;
import com.reprezen.swaggerparser.model3.Operation;
import com.reprezen.swaggerparser.model3.Parameter;
import com.reprezen.swaggerparser.model3.Path;
import com.reprezen.swaggerparser.model3.Server;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class PathImpl extends SwaggerObjectImpl implements Path {

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

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public PathImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public PathImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay summary = registerField("summary", "summary", null, new StringOverlay("summary", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay description = registerField("description", "description", null, new StringOverlay("description", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private MapOverlay<OperationImpl> operations = registerField("", "operations", "get|put|post|delete|options|head|patch|trace", new MapOverlay<OperationImpl>("", this, OperationImpl.factory, "get|put|post|delete|options|head|patch|trace"));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ListOverlay<ServerImpl> servers = registerField("servers", "servers", null, new ListOverlay<ServerImpl>("servers", this, ServerImpl.factory));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ListOverlay<ParameterImpl> parameters = registerField("parameters", "parameters", null, new ListOverlay<ParameterImpl>("parameters", this, ParameterImpl.factory));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object,AnyObjectOverlay> extensions = registerField("", "extensions", "x-.*", new ValMapOverlay<Object, AnyObjectOverlay>("", this, AnyObjectOverlay.factory, "x-.*"));

    // Summary
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getSummary() {
        return summary.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setSummary(String summary) {
        this.summary.set(summary);
    }

    // Description
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getDescription() {
        return description.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setDescription(String description) {
        this.description.set(description);
    }

    // Operation
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, ? extends Operation> getOperations() {
        return operations.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasOperation(String name) {
        return operations.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Operation getOperation(String name) {
        return operations.get(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setOperations(Map<String, ? extends Operation> operations) {
        @SuppressWarnings("unchecked")
            Map<String,OperationImpl> implOperations = (Map<String, OperationImpl>) operations;
            this.operations.set(implOperations);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setOperation(String name, Operation operation) {
        operations.set(name, (OperationImpl) operation);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeOperation(String name) {
        operations.remove(name);
    }

    // Server
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<? extends Server> getServers() {
        return servers.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Server getServer(int index) {
        return servers.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setServers(Collection<? extends Server> servers) {
        @SuppressWarnings("unchecked")
            Collection<ServerImpl> implServers = (Collection<ServerImpl>) servers;
            this.servers.set(implServers);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setServer(int index, Server server) {
        servers.set(index, (ServerImpl) server);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addServer(Server server) {
        servers.add((ServerImpl) server);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeServer(int index) {
        servers.remove(index);
    }

    // Parameter
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<? extends Parameter> getParameters() {
        return parameters.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Parameter getParameter(int index) {
        return parameters.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setParameters(Collection<? extends Parameter> parameters) {
        @SuppressWarnings("unchecked")
            Collection<ParameterImpl> implParameters = (Collection<ParameterImpl>) parameters;
            this.parameters.set(implParameters);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setParameter(int index, Parameter parameter) {
        parameters.set(index, (ParameterImpl) parameter);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addParameter(Parameter parameter) {
        parameters.add((ParameterImpl) parameter);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeParameter(int index) {
        parameters.remove(index);
    }

    // Extension
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public static JsonOverlayFactory<PathImpl> factory = new JsonOverlayFactory<PathImpl>() {
    @Override
    public PathImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, PathImpl.class) ? null : new PathImpl(key, json, parent);
    }
};

}
