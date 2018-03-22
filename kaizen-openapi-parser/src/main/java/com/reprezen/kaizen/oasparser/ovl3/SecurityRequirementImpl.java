package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;

public class SecurityRequirementImpl extends PropertiesOverlay<SecurityRequirement> implements SecurityRequirement {

	@Generated("com.reprezen.gen.CodeGenerator")
	public SecurityRequirementImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public SecurityRequirementImpl(SecurityRequirement securityRequirement, JsonOverlay<?> parent,
			ReferenceRegistry refReg) {
		super(securityRequirement, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<SecurityParameter> requirements;

	// Requirement
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, SecurityParameter> getRequirements() {
		return requirements._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, SecurityParameter> getRequirements(boolean elaborate) {
		return requirements._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasRequirement(String name) {
		return requirements.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public SecurityParameter getRequirement(String name) {
		return requirements._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setRequirements(Map<String, SecurityParameter> requirements) {
		this.requirements._set(requirements);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setRequirement(String name, SecurityParameter requirement) {
		requirements._set(name, requirement);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeRequirement(String name) {
		requirements._remove(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	protected void elaborateChildren() {
		super.elaborateChildren();
		requirements = createChildMap("", this, SecurityParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<SecurityRequirement> factory = new OverlayFactory<SecurityRequirement>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super SecurityRequirement>> getOverlayClass() {
			return SecurityRequirementImpl.class;
		}

		@Override
		public JsonOverlay<SecurityRequirement> _create(SecurityRequirement securityRequirement, JsonOverlay<?> parent,
				ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new SecurityRequirementImpl(securityRequirement, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityRequirement> castOverlay = (JsonOverlay<SecurityRequirement>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<SecurityRequirement> _create(JsonNode json, JsonOverlay<?> parent,
				ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new SecurityRequirementImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityRequirement> castOverlay = (JsonOverlay<SecurityRequirement>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends SecurityRequirement> getSubtypeOf(SecurityRequirement securityRequirement) {
		return SecurityRequirement.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends SecurityRequirement> getSubtypeOf(JsonNode json) {
		return SecurityRequirement.class;
	}
}
