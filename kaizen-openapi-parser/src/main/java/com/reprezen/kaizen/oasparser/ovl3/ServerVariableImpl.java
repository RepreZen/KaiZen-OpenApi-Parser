package com.reprezen.kaizen.oasparser.ovl3;

import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.Builder;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;

public class ServerVariableImpl extends PropertiesOverlay<ServerVariable> implements ServerVariable {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ServerVariableImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ServerVariableImpl(ServerVariable serverVariable, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(serverVariable, parent, factory, refMgr);
	}

	// EnumValue
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<String> getEnumValues() {
		return _getList("enumValues", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<String> getEnumValues(boolean elaborate) {
		return _getList("enumValues", elaborate, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasEnumValues() {
		return _isPresent("enumValues");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getEnumValue(int index) {
		return _get("enumValues", index, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setEnumValues(List<String> enumValues) {
		_setList("enumValues", enumValues, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setEnumValue(int index, String enumValue) {
		_set("enumValues", index, enumValue, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addEnumValue(String enumValue) {
		_add("enumValues", enumValue, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertEnumValue(int index, String enumValue) {
		_insert("enumValues", index, enumValue, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeEnumValue(int index) {
		_remove("enumValues", index, String.class);
	}

	// Default
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getDefault() {
		return _get("defaultValue", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDefault(String defaultValue) {
		_setScalar("defaultValue", defaultValue, String.class);
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
	public static final String F_enumValues = "enumValues";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_defaultValue = "defaultValue";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_description = "description";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createList("enumValues", "enum", StringOverlay.factory);
		_createScalar("defaultValue", "default", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<ServerVariable> factory = new OverlayFactory<ServerVariable>() {

		@Override
		protected Class<? extends JsonOverlay<? super ServerVariable>> getOverlayClass() {
			return ServerVariableImpl.class;
		}

		@Override
		public JsonOverlay<ServerVariable> _create(ServerVariable serverVariable, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ServerVariableImpl(serverVariable, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ServerVariable> castOverlay = (JsonOverlay<ServerVariable>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<ServerVariable> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ServerVariableImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ServerVariable> castOverlay = (JsonOverlay<ServerVariable>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ServerVariable> getSubtypeOf(ServerVariable serverVariable) {
		return ServerVariable.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ServerVariable> getSubtypeOf(JsonNode json) {
		return ServerVariable.class;
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
	public static <OV extends IJsonOverlay<?>> Builder<ServerVariable> builder(OV modelMember) {
		return new Builder<ServerVariable>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> ServerVariable create(OV modelMember) {
		return (ServerVariable) builder(modelMember).build();
	}
}
