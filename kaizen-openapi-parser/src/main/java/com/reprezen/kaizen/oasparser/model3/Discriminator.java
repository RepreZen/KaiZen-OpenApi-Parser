package com.reprezen.kaizen.oasparser.model3;

import java.util.Map;

import javax.annotation.Generated;

import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.IModelPart;

public interface Discriminator extends IJsonOverlay<Discriminator>, IModelPart<OpenApi3, Discriminator> {

	// PropertyName
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getPropertyName();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setPropertyName(String propertyName);

	// Mapping
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, String> getMappings();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, String> getMappings(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasMappings();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasMapping(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getMapping(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMappings(Map<String, String> mappings);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMapping(String name, String mapping);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeMapping(String name);
}
