package com.reprezen.kaizen.oasparser.ovl3;

import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.Builder;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Server;

public class PathImpl extends PropertiesOverlay<Path> implements Path {

	private Overlay<Path> overlay = Overlay.of(this);

	@Override
	public String getPathString() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	@Override
	public Operation getGet() {
		return getOperations().get("get");
	}

	@Override
	public Operation getGet(boolean elaborate) {
		return getOperations(elaborate).get("get");
	}

	@Override
	public void setGet(Operation get) {
		getOperations().put("get", get);
	}

	@Override
	public Operation getPut() {
		return getOperations().get("put");
	}

	@Override
	public Operation getPut(boolean elaborate) {
		return getOperations(elaborate).get("put");
	}

	@Override
	public void setPut(Operation put) {
		getOperations().put("put", put);
	}

	@Override
	public Operation getPost() {
		return getOperations().get("post");
	}

	@Override
	public Operation getPost(boolean elaborate) {
		return getOperations(elaborate).get("post");
	}

	@Override
	public void setPost(Operation post) {
		getOperations().put("post", post);
	}

	@Override
	public Operation getDelete() {
		return getOperations().get("delete");
	}

	@Override
	public Operation getDelete(boolean elaborate) {
		return getOperations(elaborate).get("delete");
	}

	@Override
	public void setDelete(Operation delete) {
		getOperations().put("delete", delete);
	}

	@Override
	public Operation getOptions() {
		return getOperations().get("options");
	}

	@Override
	public Operation getOptions(boolean elaborate) {
		return getOperations(elaborate).get("options");
	}

	@Override
	public void setOptions(Operation options) {
		getOperations().put("options", options);
	}

	@Override
	public Operation getHead() {
		return getOperations().get("head");
	}

	@Override
	public Operation getHead(boolean elaborate) {
		return getOperations(elaborate).get("head");
	}

	@Override
	public void setHead(Operation head) {
		getOperations().put("head", head);
	}

	@Override
	public Operation getPatch() {
		return getOperations().get("patch");
	}

	@Override
	public Operation getPatch(boolean elaborate) {
		return getOperations(elaborate).get("patch");
	}

	@Override
	public void setPatch(Operation patch) {
		getOperations().put("patch", patch);
	}

	@Override
	public Operation getTrace() {
		return getOperations().get("trace");
	}

	@Override
	public Operation getTrace(boolean elaborate) {
		return getOperations(elaborate).get("trace");
	}

	@Override
	public void setTrace(Operation trace) {
		getOperations().put("trace", trace);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public PathImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public PathImpl(Path path, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(path, parent, factory, refMgr);
	}

	// Summary
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getSummary() {
		return _get("summary", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setSummary(String summary) {
		_setScalar("summary", summary, String.class);
	}

	// Description
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getDescription() {
		return _get("description", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDescription(String description) {
		_setScalar("description", description, String.class);
	}

	// Operation
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Operation> getOperations() {
		return _getMap("operations", Operation.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Operation> getOperations(boolean elaborate) {
		return _getMap("operations", elaborate, Operation.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasOperations() {
		return _isPresent("operations");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasOperation(String name) {
		return _getMap("operations", Operation.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Operation getOperation(String name) {
		return _get("operations", name, Operation.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOperations(Map<String, Operation> operations) {
		_setMap("operations", operations, Operation.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOperation(String name, Operation operation) {
		_set("operations", name, operation, Operation.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeOperation(String name) {
		_remove("operations", name, Operation.class);
	}

	// Server
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Server> getServers() {
		return _getList("servers", Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Server> getServers(boolean elaborate) {
		return _getList("servers", elaborate, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasServers() {
		return _isPresent("servers");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Server getServer(int index) {
		return _get("servers", index, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setServers(List<Server> servers) {
		_setList("servers", servers, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setServer(int index, Server server) {
		_set("servers", index, server, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addServer(Server server) {
		_add("servers", server, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertServer(int index, Server server) {
		_insert("servers", index, server, Server.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeServer(int index) {
		_remove("servers", index, Server.class);
	}

	// Parameter
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Parameter> getParameters() {
		return _getList("parameters", Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Parameter> getParameters(boolean elaborate) {
		return _getList("parameters", elaborate, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasParameters() {
		return _isPresent("parameters");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Parameter getParameter(int index) {
		return _get("parameters", index, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setParameters(List<Parameter> parameters) {
		_setList("parameters", parameters, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setParameter(int index, Parameter parameter) {
		_set("parameters", index, parameter, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addParameter(Parameter parameter) {
		_add("parameters", parameter, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertParameter(int index, Parameter parameter) {
		_insert("parameters", index, parameter, Parameter.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeParameter(int index) {
		_remove("parameters", index, Parameter.class);
	}

	// Extension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return _getMap("extensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return _getMap("extensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtensions() {
		return _isPresent("extensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return _getMap("extensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return _get("extensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		_setMap("extensions", extensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		_set("extensions", name, extension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		_remove("extensions", name, Object.class);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_summary = "summary";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_description = "description";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_operations = "operations";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_servers = "servers";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_parameters = "parameters";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("summary", "summary", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createMap("operations", "", OperationImpl.factory, "get|put|post|delete|options|head|patch|trace");
		_createList("servers", "servers", ServerImpl.factory);
		_createList("parameters", "parameters", ParameterImpl.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Path> factory = new OverlayFactory<Path>() {

		@Override
		protected Class<? extends JsonOverlay<? super Path>> getOverlayClass() {
			return PathImpl.class;
		}

		@Override
		public JsonOverlay<Path> _create(Path path, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new PathImpl(path, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Path> castOverlay = (JsonOverlay<Path>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Path> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new PathImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Path> castOverlay = (JsonOverlay<Path>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
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

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Builder<Path> builder(OV modelMember) {
		return new Builder<Path>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Path create(OV modelMember) {
		return (Path) builder(modelMember).build();
	}
}
