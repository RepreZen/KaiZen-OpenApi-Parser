package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.ChildListOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Server;

public class PathImpl extends PropertiesOverlay<Path> implements Path {

	@Override
	public Operation getGet() {
		return operations._get("get");
	}

	@Override
	public Operation getGet(boolean elaborate) {
		return ((OperationImpl) operations._get("get"))._get(elaborate);
	}

	@Override
	public void setGet(Operation get) {
		operations._set("get", (OperationImpl) get);
	}

	@Override
	public Operation getPut() {
		return operations._get("put");
	}

	@Override
	public Operation getPut(boolean elaborate) {
		return ((OperationImpl) operations._get("put"))._get(elaborate);
	}

	@Override
	public void setPut(Operation put) {
		operations._set("put", (OperationImpl) put);
	}

	@Override
	public Operation getPost() {
		return operations._get("post");
	}

	@Override
	public Operation getPost(boolean elaborate) {
		return ((OperationImpl) operations._get("post"))._get(elaborate);
	}

	@Override
	public void setPost(Operation post) {
		operations._set("post", (OperationImpl) post);
	}

	@Override
	public Operation getDelete() {
		return operations._get("delete");
	}

	@Override
	public Operation getDelete(boolean elaborate) {
		return ((OperationImpl) operations._get("delete"))._get(elaborate);
	}

	@Override
	public void setDelete(Operation delete) {
		operations._set("delete", (OperationImpl) delete);
	}

	@Override
	public Operation getOptions() {
		return operations._get("options");
	}

	@Override
	public Operation getOptions(boolean elaborate) {
		return ((OperationImpl) operations._get("options"))._get(elaborate);
	}

	@Override
	public void setOptions(Operation options) {
		operations._set("options", (OperationImpl) options);
	}

	@Override
	public Operation getHead() {
		return operations._get("head");
	}

	@Override
	public Operation getHead(boolean elaborate) {
		return ((OperationImpl) operations._get("head"))._get(elaborate);
	}

	@Override
	public void setHead(Operation head) {
		operations._set("head", (OperationImpl) head);
	}

	@Override
	public Operation getPatch() {
		return operations._get("patch");
	}

	@Override
	public Operation getPatch(boolean elaborate) {
		return ((OperationImpl) operations._get("patch"))._get(elaborate);
	}

	@Override
	public void setPatch(Operation patch) {
		operations._set("patch", (OperationImpl) patch);
	}

	@Override
	public Operation getTrace() {
		return operations._get("trace");
	}

	@Override
	public Operation getTrace(boolean elaborate) {
		return ((OperationImpl) operations._get("trace"))._get(elaborate);
	}

	@Override
	public void setTrace(Operation trace) {
		operations._set("trace", (OperationImpl) trace);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public PathImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public PathImpl(Path path, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(path, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> summary;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Operation> operations;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildListOverlay<Server> servers;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildListOverlay<Parameter> parameters;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Summary
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getSummary() {
		return summary._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setSummary(String summary) {
		this.summary._set(summary);
	}

	// Description
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getDescription() {
		return description._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDescription(String description) {
		this.description._set(description);
	}

	// Operation
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Operation> getOperations() {
		return operations._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasOperation(String name) {
		return operations.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Operation getOperation(String name) {
		return operations._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOperations(Map<String, Operation> operations) {
		this.operations._set(operations);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOperation(String name, Operation operation) {
		operations._set(name, operation);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeOperation(String name) {
		operations._remove(name);
	}

	// Server
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Collection<Server> getServers() {
		return servers._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasServers() {
		return servers._isPresent();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Server getServer(int index) {
		return servers._get(index);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setServers(Collection<Server> servers) {
		this.servers._set(servers);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setServer(int index, Server server) {
		servers._set(index, server);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addServer(Server server) {
		servers._add(server);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertServer(int index, Server server) {
		servers._insert(index, server);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeServer(int index) {
		servers._remove(index);
	}

	// Parameter
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Collection<Parameter> getParameters() {
		return parameters._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasParameters() {
		return parameters._isPresent();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Parameter getParameter(int index) {
		return parameters._get(index);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setParameters(Collection<Parameter> parameters) {
		this.parameters._set(parameters);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setParameter(int index, Parameter parameter) {
		parameters._set(index, parameter);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addParameter(Parameter parameter) {
		parameters._add(parameter);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertParameter(int index, Parameter parameter) {
		parameters._insert(index, parameter);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeParameter(int index) {
		parameters._remove(index);
	}

	// Extension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions._set(extensions);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions._set(name, extension);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions._remove(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void elaborateChildren() {
		super.elaborateChildren();
		summary = createChild("summary", this, StringOverlay.factory);
		description = createChild("description", this, StringOverlay.factory);
		operations = createChildMap("", this, OperationImpl.factory, "get|put|post|delete|options|head|patch|trace");
		servers = createChildList("servers", this, ServerImpl.factory);
		parameters = createChildList("parameters", this, ParameterImpl.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Path> factory = new OverlayFactory<Path>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super Path>> getOverlayClass() {
			return PathImpl.class;
		}

		@Override
		public JsonOverlay<Path> _create(Path path, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new PathImpl(path, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Path> castOverlay = (JsonOverlay<Path>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Path> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new PathImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Path> castOverlay = (JsonOverlay<Path>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Path> getSubtypeOf(Path path) {
		return Path.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Path> getSubtypeOf(JsonNode json) {
		return Path.class;
	}
}
