package com.reprezen.kaizen.oasparser.model3;

import java.util.Collection;

import javax.annotation.Generated;

import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.IModelPart;

public interface SecurityParameter extends IJsonOverlay<SecurityParameter>, IModelPart<OpenApi3, SecurityParameter> {

	// Parameter
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Collection<String> getParameters();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasParameters();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getParameter(int index);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setParameters(Collection<String> parameters);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setParameter(int index, String parameter);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void addParameter(String parameter);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void insertParameter(int index, String parameter);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeParameter(int index);
}
