package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import java.util.Map;

public interface Example extends IPropertiesOverlay<Example>, IModelPart<OpenApi3, Example> {

    // Summary
    @Generated("com.reprezen.gen.CodeGenerator")
    String getSummary();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getSummary(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setSummary(String summary);

    // Description
    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDescription(String description);

    // Value
    @Generated("com.reprezen.gen.CodeGenerator")
    Object getValue();

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getValue(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setValue(Object value);

    // ExternalValue
    @Generated("com.reprezen.gen.CodeGenerator")
    String getExternalValue();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getExternalValue(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExternalValue(String externalValue);

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
