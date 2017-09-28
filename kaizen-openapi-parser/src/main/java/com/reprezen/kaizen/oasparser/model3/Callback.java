package com.reprezen.kaizen.oasparser.model3;

import java.util.Map;

import javax.annotation.Generated;

public interface Callback extends OpenApiObject<Callback> {

	// CallbackPath
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	Map<String, ? extends Path> getCallbackPaths();

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	boolean hasCallbackPath(String expression);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	Path getCallbackPath(String expression);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	void setCallbackPaths(Map<String, ? extends Path> callbackPaths);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	void setCallbackPath(String expression, Path callbackPath);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	void removeCallbackPath(String expression);

	// Extension
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	Map<String, Object> getExtensions();

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	boolean hasExtension(String name);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	Object getExtension(String name);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	void setExtensions(Map<String, Object> extensions);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	void setExtension(String name, Object extension);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	void removeExtension(String name);
}
