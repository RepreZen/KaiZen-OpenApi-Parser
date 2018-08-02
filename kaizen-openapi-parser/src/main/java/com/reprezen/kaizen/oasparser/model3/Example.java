package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.jsonoverlay.IJsonOverlay;
import java.util.Map;

public interface Example extends IJsonOverlay<Example>, IModelPart<OpenApi3, Example> {

    String getName();

    // Summary
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getSummary();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setSummary(String summary);

    // Description
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // Value
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getValue();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setValue(Object value);

    // ExternalValue
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getExternalValue();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExternalValue(String externalValue);

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
