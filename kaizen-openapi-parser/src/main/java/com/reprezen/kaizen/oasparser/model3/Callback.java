package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.jsonoverlay.IJsonOverlay;
import java.util.Map;

public interface Callback extends IJsonOverlay<Callback>, IModelPart<OpenApi3, Callback> {

    String getName();

    // CallbackPath
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Path> getCallbackPaths();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Path> getCallbackPaths(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasCallbackPaths();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasCallbackPath(String expression);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Path getCallbackPath(String expression);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setCallbackPaths(Map<String, Path> callbackPaths);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setCallbackPath(String expression, Path callbackPath);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeCallbackPath(String expression);

    // Extension
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeExtension(String name);
}
