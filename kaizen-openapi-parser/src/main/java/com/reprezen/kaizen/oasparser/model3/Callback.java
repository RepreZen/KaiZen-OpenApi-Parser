package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.Path;
import java.util.Map;

public interface Callback extends IPropertiesOverlay<Callback>, IModelPart<OpenApi3, Callback> {

    // CallbackPath
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Path> getCallbackPaths();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Path> getCallbackPaths(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasCallbackPath(String expression);

    @Generated("com.reprezen.gen.CodeGenerator")
    Path getCallbackPath(String expression);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setCallbackPaths(Map<String, Path> callbackPaths);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setCallbackPath(String expression, Path callbackPath);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeCallbackPath(String expression);

    // Extension
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getExtensions(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeExtension(String name);
}
