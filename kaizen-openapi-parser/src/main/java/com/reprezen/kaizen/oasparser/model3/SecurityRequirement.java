package com.reprezen.kaizen.oasparser.model3;

import java.util.Map;

import javax.annotation.Generated;

import com.reprezen.kaizen.oasparser.jsonoverlay.IModelPart;
import com.reprezen.kaizen.oasparser.jsonoverlay.IPropertiesOverlay;

public interface SecurityRequirement
		extends IPropertiesOverlay<SecurityRequirement>, IModelPart<OpenApi3, SecurityRequirement> {

	// Requirement
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	Map<String, SecurityParameter> getRequirements();

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	Map<String, SecurityParameter> getRequirements(boolean elaborate);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	boolean hasRequirement(String name);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	SecurityParameter getRequirement(String name);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	void setRequirements(Map<String, SecurityParameter> requirements);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	void setRequirement(String name, SecurityParameter requirement);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	void removeRequirement(String name);
}
