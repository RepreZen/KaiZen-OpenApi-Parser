package com.reprezen.kaizen.oasparser.model3;

import java.util.Map;

import javax.annotation.Generated;

import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.IModelPart;

public interface SecurityRequirement
		extends IJsonOverlay<SecurityRequirement>, IModelPart<OpenApi3, SecurityRequirement> {

	// Requirement
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, SecurityParameter> getRequirements();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasRequirement(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	SecurityParameter getRequirement(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setRequirements(Map<String, SecurityParameter> requirements);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setRequirement(String name, SecurityParameter requirement);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeRequirement(String name);
}
