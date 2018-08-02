package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import java.util.List;
import com.reprezen.jsonoverlay.IJsonOverlay;
import java.util.Map;

public interface ServerVariable extends IJsonOverlay<ServerVariable>, IModelPart<OpenApi3, ServerVariable> {

    // EnumValue
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<Object> getEnumValues();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<Object> getEnumValues(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasEnumValues();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getEnumValue(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setEnumValues(List<Object> enumValues);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setEnumValue(int index, Object enumValue);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addEnumValue(Object enumValue);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertEnumValue(int index, Object enumValue);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeEnumValue(int index);

    // Default
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getDefault();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDefault(Object defaultValue);

    // Description
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

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
