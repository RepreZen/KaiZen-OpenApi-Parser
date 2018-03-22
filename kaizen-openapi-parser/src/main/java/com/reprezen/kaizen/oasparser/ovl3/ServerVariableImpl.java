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
import com.reprezen.jsonoverlay.PrimitiveOverlay;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;

public class ServerVariableImpl extends PropertiesOverlay<ServerVariable> implements ServerVariable {

	@Generated("com.reprezen.gen.CodeGenerator")
	public ServerVariableImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public ServerVariableImpl(ServerVariable serverVariable, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(serverVariable, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<Object> enumValues;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Object> defaultValue;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// EnumValue
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Object> getEnumValues() {
		return enumValues._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Object> getEnumValues(boolean elaborate) {
		return enumValues._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasEnumValues() {
		return enumValues._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getEnumValue(int index) {
		return enumValues._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setEnumValues(Collection<Object> enumValues) {
		this.enumValues._set(enumValues);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setEnumValue(int index, Object enumValue) {
		enumValues._set(index, enumValue);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addEnumValue(Object enumValue) {
		enumValues._add(enumValue);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertEnumValue(int index, Object enumValue) {
		enumValues._insert(index, enumValue);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeEnumValue(int index) {
		enumValues._remove(index);
	}

	// Default
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getDefault() {
		return defaultValue._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getDefault(boolean elaborate) {
		return defaultValue._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setDefault(Object defaultValue) {
		this.defaultValue._set(defaultValue);
	}

	// Description
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getDescription() {
		return description._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getDescription(boolean elaborate) {
		return description._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setDescription(String description) {
		this.description._set(description);
	}

	// Extension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return extensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions._set(extensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions._set(name, extension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions._remove(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	protected void elaborateChildren() {
		super.elaborateChildren();
		enumValues = createChildList("enum", this, PrimitiveOverlay.factory);
		defaultValue = createChild("default", this, PrimitiveOverlay.factory);
		description = createChild("description", this, StringOverlay.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<ServerVariable> factory = new OverlayFactory<ServerVariable>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super ServerVariable>> getOverlayClass() {
			return ServerVariableImpl.class;
		}

		@Override
		public JsonOverlay<ServerVariable> _create(ServerVariable serverVariable, JsonOverlay<?> parent,
				ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new ServerVariableImpl(serverVariable, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<ServerVariable> castOverlay = (JsonOverlay<ServerVariable>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<ServerVariable> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new ServerVariableImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<ServerVariable> castOverlay = (JsonOverlay<ServerVariable>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends ServerVariable> getSubtypeOf(ServerVariable serverVariable) {
		return ServerVariable.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends ServerVariable> getSubtypeOf(JsonNode json) {
		return ServerVariable.class;
	}
}
