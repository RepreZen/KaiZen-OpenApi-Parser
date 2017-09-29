package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;

public class SecurityRequirementImpl extends OpenApiObjectImpl<SecurityRequirement>
		implements SecurityRequirement {

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public SecurityRequirementImpl(String key, JsonNode json, JsonOverlay<?> parent) {
		super(key, json, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public SecurityRequirementImpl(String key, JsonOverlay<?> parent) {
		super(key, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<SecurityParameterImpl> requirements = new MapOverlay<SecurityParameterImpl>("", this,
			SecurityParameterImpl.factory, "[a-zA-Z0-9\\._-]+");

	// Requirement
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends SecurityParameter> getRequirements() {
		return requirements.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasRequirement(String name) {
		return requirements.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public SecurityParameter getRequirement(String name) {
		return requirements.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setRequirements(Map<String, ? extends SecurityParameter> requirements) {
		@SuppressWarnings("unchecked")
		Map<String, SecurityParameterImpl> implRequirements = (Map<String, SecurityParameterImpl>) requirements;
		this.requirements.set(implRequirements);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setRequirement(String name, SecurityParameter requirement) {
		requirements.set(name, (SecurityParameterImpl) requirement);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeRequirement(String name) {
		requirements.remove(name);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public static JsonOverlayFactory<SecurityRequirementImpl> factory = new JsonOverlayFactory<SecurityRequirementImpl>() {
		@Override
		public SecurityRequirementImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
			return isEmptyRecursive(parent, SecurityRequirementImpl.class) ? null
					: new SecurityRequirementImpl(key, json, parent);
		}
	};

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	protected void installPropertyAccessors(PropertyAccessors accessors) {
		OverlayGetter getter = null;
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return requirements;
			}
		};
		accessors.add("", "[a-zA-Z0-9\\._-]+", getter);
	}

}
