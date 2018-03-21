package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import java.util.Collection;
import java.util.Map;

public interface ServerVariable extends IPropertiesOverlay<ServerVariable>, IModelPart<OpenApi3, ServerVariable> {

    // EnumValue
    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Object> getEnumValues();

    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Object> getEnumValues(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasEnumValues();

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getEnumValue(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setEnumValues(Collection<Object> enumValues);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setEnumValue(int index, Object enumValue);

    @Generated("com.reprezen.gen.CodeGenerator")
    void addEnumValue(Object enumValue);

    @Generated("com.reprezen.gen.CodeGenerator")
    void insertEnumValue(int index, Object enumValue);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeEnumValue(int index);

    // Default
    @Generated("com.reprezen.gen.CodeGenerator")
    Object getDefault();

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getDefault(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDefault(Object defaultValue);

    // Description
    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDescription(String description);

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
